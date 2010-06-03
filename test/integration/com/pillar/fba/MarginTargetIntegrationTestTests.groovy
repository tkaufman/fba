package com.pillar.fba

import grails.test.*

class MarginTargetIntegrationTestTests extends GrailsUnitTestCase {

    def projectName = "Community Health Test Project"
    protected void setUp() {
        super.setUp()

        Resource resource = new Resource(name:"Resource Name",startDate:new Date(), endDate:new Date(), loadedHourlyCost:25).save()
        Client client = new Client(name:"Client Name",abbreviation:"CLIE").save()
        Project projectToSave = new Project(name:projectName,description:"Community Health Portal Project",client:client, projectStatus:"Started").save()
        ProjectResource pr = new ProjectResource(resource:resource,startDate:Calendar.getInstance(), endDate:Calendar.getInstance(), hoursPerWeek:40, project:projectToSave).save()
        projectToSave.resources.add(pr)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testMultipleTargets() {
        assertTrue("Should be at least 1 MarginTarget in database.. cehck data or Bootstrap.groovy", MarginTarget.count() >= 1)
    }

    void test15PercentMarginTargetPresent(){
        assertNotNull("15% MarginTarget not present in database... check data or Bootstrap.groovy", MarginTarget.findWhere("targetPercentage":15))
    }
    void test20PercentMarginTargetPresent(){
        assertNotNull("20% MarginTarget not present in database... check data or Bootstrap.groovy", MarginTarget.findWhere("targetPercentage":20))
    }
    void test25PercentMarginTargetPresent(){
        assertNotNull("25% MarginTarget not present in database... check data or Bootstrap.groovy", MarginTarget.findWhere("targetPercentage":25))
    }
    void testThereAre3MarginTargets(){
        Project project = Project.findWhere("name":projectName)
        def list = project.retrieveAllEstimatesForProject()
        assertTrue(list.get(15) == 235.2941176471)
        assertTrue(list.get(20) == 250.0)
        assertTrue(list.get(25) == 266.6666666667)
    }
}
