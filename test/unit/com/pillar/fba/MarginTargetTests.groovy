package com.pillar.fba

import grails.test.GrailsUnitTestCase

class MarginTargetTests extends GrailsUnitTestCase {

    MarginTarget target10Percent = new MarginTarget(name:"10 Percent", targetPercentage:10)
    MarginTarget target15Percent = new MarginTarget(name:"15 Percent", targetPercentage:15)
    MarginTarget target25Percent = new MarginTarget(name:"25 Percent", targetPercentage:25)
    def project;
    
    protected void setUp() {
        super.setUp()
        project = mockFor(Project)
        project.demand.calculateTotalProjectCost(1..1) {-> return 19000}
        project = project.createMock()

    }

    protected void tearDown() {
        super.tearDown()
    }

    void testProjectEstimateWith10PercentTarget() {
        assertEquals(20900, target10Percent.estimateProject(project))
    }
    void testProjectEstimateWith15PercentTarget() {
        assertEquals(21850, target15Percent.estimateProject(project))
    }
    void testProjectEstimateWith25PercentTarget() {
        assertEquals(23750, target25Percent.estimateProject(project))
    }
}
