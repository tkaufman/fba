package com.pillar.fba

import grails.test.GrailsUnitTestCase

class ProjectTests extends GrailsUnitTestCase {

    protected void setUp() {
        super.setUp()
    }

    private ProjectResource buildProjectResourceFor1Week(Resource resource, int hoursPerWeek, int perDiem){
        Calendar startDate = Calendar.getInstance()
	startDate.set(2010, Calendar.MAY, 3)
        Calendar endDate = Calendar.getInstance()
	endDate.set(2010, Calendar.MAY, 7)
        ProjectResource projectResource = buildProjectResource(startDate, endDate)
        
        projectResource.resource = resource
        projectResource.hoursPerWeek = hoursPerWeek
        projectResource.perDiem = perDiem
        return projectResource
    }

    private ProjectResource buildProjectResourceFor8Weeks(Resource resource, int hoursPerWeek, int perDiem){
        Calendar startDate = Calendar.getInstance()
	startDate.set(2010, Calendar.MAY, 3)
        Calendar endDate = Calendar.getInstance()
	endDate.set(2010, Calendar.JUNE,25)
        ProjectResource projectResource = buildProjectResource(startDate, endDate)

        projectResource.resource = resource
        projectResource.hoursPerWeek = hoursPerWeek
        projectResource.perDiem = perDiem
        return projectResource
    }

    private ProjectResource buildProjectResource(Calendar startDate, Calendar endDate){
        ProjectResource projectResource = new ProjectResource()
        projectResource.startDate = startDate
        projectResource.endDate = endDate
        return projectResource
    }

    private Resource buildZachResource(){
        Resource zach = new Resource(name:"zach")
        zach.startDate = new Date(2010,04,12)
        zach.endDate = new Date(2035,05,15)
        zach.loadedHourlyCost = 50
        return zach
    }

    private Resource buildJohnResource(){
        Resource john = new Resource(name:"john")
        john.startDate = new Date(2010,04,12)
        john.endDate = new Date(2035,05,15)
        john.loadedHourlyCost = 75
        return john
    }

    private ResourcePlaceholder buildSrDevPlaceHolder(){
        ResourcePlaceholder srDev = new ResourcePlaceholder(name:"Sr. Dev", defaultHourlyCost:100)
        return srDev
    }

    private ProjectResourcePlaceholder buildProjectResourcePlaceholderFor1Week(ResourcePlaceholder resource, int hoursPerWeek, int perDiem){
        Calendar startDate = Calendar.getInstance()
	startDate.set(2010, Calendar.MAY, 3)
        Calendar endDate = Calendar.getInstance()
	endDate.set(2010, Calendar.MAY, 7)

        ProjectResourcePlaceholder projectResource = buildProjectResourcePlaceholder(startDate, endDate)

        projectResource.resourcePlaceholder = resource
        projectResource.hoursPerWeek = hoursPerWeek
        projectResource.perDiem = perDiem
        return projectResource
    }

    private ProjectResourcePlaceholder buildProjectResourcePlaceholder(Calendar startDate, Calendar endDate){
        ProjectResourcePlaceholder projectResource = new ProjectResourcePlaceholder()
        projectResource.startDate = startDate
        projectResource.endDate = endDate
        return projectResource
    }

    protected void tearDown() {
        super.tearDown()
    }

    public void testCalculateWith1ProjectResourceFor1Week(){
        Project project = new Project()
        project.resources.add(buildProjectResourceFor1Week(buildZachResource(), 40, 0))
        assertEquals(2000, project.calculateTotalProjectCost())
    }

    public void testCalculateWith2ProjectResourcesFor1Week(){
        Project project = new Project()
        project.resources.add(buildProjectResourceFor1Week(buildZachResource(), 40, 0))
        project.resources.add(buildProjectResourceFor1Week(buildJohnResource(), 40, 0))
        assertEquals(5000, project.calculateTotalProjectCost())
    }

    public void testCalculateWith2ProjectResourcesFor1WeekWithPerDiem(){
        Project project = new Project()
        project.resources.add(buildProjectResourceFor1Week(buildZachResource(), 40, 50))
        project.resources.add(buildProjectResourceFor1Week(buildJohnResource(), 40, 30))
        assertEquals(5400, project.calculateTotalProjectCost())
    }

    public void testCalculateWith2ProjectResourcesFor1WeekWithPerDiemAndDifferentHoursPerWeek(){
        Project project = new Project()
        project.resources.add(buildProjectResourceFor1Week(buildZachResource(), 50, 50))
        project.resources.add(buildProjectResourceFor1Week(buildJohnResource(), 60, 30))
        assertEquals(7400, project.calculateTotalProjectCost())
    }

    public void testCalculateWith2ProjectResourcesForDifferentLengths(){
        Project project = new Project()
        project.resources.add(buildProjectResourceFor8Weeks(buildZachResource(), 40, 0))
        project.resources.add(buildProjectResourceFor1Week(buildJohnResource(), 40, 0))
        assertEquals(19000, project.calculateTotalProjectCost())
    }

    public void testCalculateWithAResourcePlaceholder(){
        Project project = new Project()
        project.resourcePlaceHolders.add(buildProjectResourcePlaceholderFor1Week(buildSrDevPlaceHolder(), 40, 0))
        assertEquals(4000, project.calculateTotalProjectCost())
    }

    public void testCalculateWithAResourcePlaceholderAndAResource(){
        Project project = new Project()
        project.resourcePlaceHolders.add(buildProjectResourcePlaceholderFor1Week(buildSrDevPlaceHolder(), 40, 0))
        project.resources.add(buildProjectResourceFor1Week(buildZachResource(), 40, 0))
        assertEquals(6000, project.calculateTotalProjectCost())
    }

    public void testCalculateProfitMargin(){
        Project project = new Project()
        Resource resource = buildZachResource()
        resource.loadedHourlyCost = 5
        project.resources.add(buildProjectResourceFor1Week(resource, 8, 0))
        project.price = 50
        assertEquals(20, project.calculateProfitMargin())
    }

    public void testCalculateProfitMargin2(){
        Project project = new Project()
        Resource resource = buildZachResource()
        resource.loadedHourlyCost = 5
        project.resources.add(buildProjectResourceFor1Week(resource, 8, 0))
        project.price = 80
        assertEquals(50, project.calculateProfitMargin())
    }
    public void testCalculateProfitMargin3(){
        Project project = new Project()
        Resource resource = buildZachResource()
        resource.loadedHourlyCost = 5
        project.resources.add(buildProjectResourceFor1Week(resource, 8, 0))
        project.price = 100
        assertEquals(60, project.calculateProfitMargin())
    }
}
