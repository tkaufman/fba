package com.pillar.fba

import grails.test.GrailsUnitTestCase

class MarginTargetTests extends GrailsUnitTestCase {

    MarginTarget target10Percent = new MarginTarget(name:"10 Percent", targetPercentage:10)
    MarginTarget target0Percent = new MarginTarget(name:"0 Percent", targetPercentage:0)
    def project;
    
    protected void setUp() {
        super.setUp()
        project = mockFor(Project)
        project.demand.calculateTotalProjectCost(1..1) {-> return 63}
        project = project.createMock()

    }

    protected void tearDown() {
        super.tearDown()
    }

    void testProjectEstimateWith10PercentTarget() {
        assertEquals(70, target10Percent.estimateProject(project))
    }
    void testProjectEstimateWith0PercentTarget() {
        assertEquals(63, target0Percent.estimateProject(project))
    }
    void testMattsKnowledgeOfAMarginTarget() {
        //mt=40%
	//rc=60
	//price=100
        MarginTarget target40Percent = new MarginTarget(name:"40 Percent", targetPercentage:40)
        def mattsProject = mockFor(Project)
        mattsProject.demand.calculateTotalProjectCost(1..1) {-> return 60}
        mattsProject = mattsProject.createMock()
	def answer = target40Percent.estimateProject(mattsProject)
        assertEquals(100,answer)
    }
}
