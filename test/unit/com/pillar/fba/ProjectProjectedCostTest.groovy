package com.pillar.fba

import grails.test.GrailsUnitTestCase

class ProjectProjectedCostTest extends GrailsUnitTestCase {

    protected void setUp() {
        super.setUp()
    }
	
	protected void tearDown() {
        super.tearDown()
    }
	
	private ProjectResource buildProjectResource(Calendar startDate, Calendar endDate){
        ProjectResource projectResource = new ProjectResource()
        projectResource.startDate = startDate
        projectResource.endDate = endDate
        return projectResource
    }
	
	private Resource buildResource(String resourceName, int resourceLoadedHourlyCost){
        Resource resource = new Resource()
        resource.name = resourceName
        resource.loadedHourlyCost = resourceLoadedHourlyCost
        return resource
    }
	
	public void testShouldReturnZeroForMonthlyProjectCostWithoutResource(){
		Project projectTest = new Project()
		Calendar currentMonth = Calendar.getInstance()
		currentMonth.set(2010, Calendar.JUNE, 10)		
		ProjectProjectedCost projectProjectedCost = new ProjectProjectedCost(project:projectTest)		
		println(projectProjectedCost.calculateMonthlyCost(currentMonth))
		
		assertEquals(0, projectProjectedCost.calculateMonthlyCost(currentMonth))
	}
	
	public void testShouldReturnZeroForMonthlyProjectCostWithResourceOnWeekEnd(){
		Project projectTest = new Project()
		
		Calendar start = Calendar.getInstance()
		start.set(2010, Calendar.JUNE, 12)	
		
		Calendar end = Calendar.getInstance()
		end.set(2010, Calendar.JUNE, 13)
		
		ProjectResource projectResource = buildProjectResource(start, end)
		Calendar currentMonth = Calendar.getInstance()
		currentMonth.set(2010, Calendar.JUNE, 10)		
		ProjectProjectedCost projectProjectedCost = new ProjectProjectedCost(project:projectTest)		
		println(projectProjectedCost.calculateMonthlyCost(currentMonth))
		
		assertEquals(0, projectProjectedCost.calculateMonthlyCost(currentMonth))
	}
	
	public void testShouldReturnNonZeroForMonthlyProjectCostWithResourceOnBusinessDays(){
		Project projectTest = new Project()
		
		Calendar start = Calendar.getInstance()
		start.set(2010, Calendar.JUNE, 05)	
		
		Calendar end = Calendar.getInstance()
		end.set(2010, Calendar.JUNE, 13)
		
		ProjectResource projectResource = buildProjectResource(start, end)
		projectResource.resource = buildResource("resource1", 50)
		Calendar currentMonth = Calendar.getInstance()
		currentMonth.set(2010, Calendar.JUNE, 10)		
		ProjectProjectedCost projectProjectedCost = new ProjectProjectedCost(project:projectTest)		
		println(projectProjectedCost.calculateMonthlyCost(currentMonth))
		
		assertEquals(0, projectProjectedCost.calculateMonthlyCost(currentMonth))
	}
}