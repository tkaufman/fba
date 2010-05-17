package com.pillar.fba

import grails.test.GrailsUnitTestCase

class ProjectTests extends GrailsUnitTestCase {
    def Project project;
    def Resource zach;
    def ProjectResource firstSlot;

    protected void setUp() {
        super.setUp()
        zach = new Resource(name:"zach")
        zach.startDate = new Date(2010,04,12)
        zach.endDate = new Date(2035,05,15)
        zach.loadedHourlyCost = 75

        System.out.println("""****************""" + zach.toString())
        firstSlot = new ProjectResource()
        firstSlot.startDate = new Date(2010,01,01)
        firstSlot.endDate = new Date(2010,01,28)
        firstSlot.resource = zach
        firstSlot.hoursPerWeek = 40
        firstSlot.perDiem = 40
        System.out.println("******" + firstSlot.toString())
//        project = new Project()
//          .addToResources (firstSlot)

//        project.resources.add(firstSlot)


    }

    protected void tearDown() {
        super.tearDown()
    }

    void testTotalProjectCost() {
//        assertEquals(12800, project.getTotalProjectCost());
    }
}
