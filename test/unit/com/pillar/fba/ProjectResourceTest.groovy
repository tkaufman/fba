package com.pillar.fba

import grails.test.GrailsUnitTestCase

class ProjectResourceTest extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSomething() {

    }

    void testCalculateTotalBillableHoursFor1Day(){
	//((end date - start date) / 7 * hoursPerWeek
        Calendar startDate = Calendar.getInstance()
	startDate.set(2010, Calendar.MAY, 3)
	Calendar endDate = Calendar.getInstance()
	endDate.set(2010, Calendar.MAY, 3)
	ProjectResource resource = new ProjectResource(startDate:startDate, endDate:endDate, hoursPerWeek:40)
	assertEquals(8, resource.calculateBillableHours())
    }

    void testCalculateTotalBillableHoursFor2Days(){
	//((end date - start date) / 7 * hoursPerWeek
        Calendar startDate = Calendar.getInstance()
	startDate.set(2010, Calendar.MAY, 3)
	Calendar endDate = Calendar.getInstance()
	endDate.set(2010, Calendar.MAY, 4)
	ProjectResource resource = new ProjectResource(startDate:startDate, endDate:endDate, hoursPerWeek:40)
	assertEquals(16, resource.calculateBillableHours())
    }    

    void testCalculateTotalBillableHoursFor7Days(){
	//((end date - start date) / 7 * hoursPerWeek
        Calendar startDate = Calendar.getInstance()
	startDate.set(2010, Calendar.MAY, 2)
	Calendar endDate = Calendar.getInstance()
	endDate.set(2010, Calendar.MAY, 9)
	ProjectResource resource = new ProjectResource(startDate:startDate, endDate:endDate, hoursPerWeek:40)
	assertEquals(40, resource.calculateBillableHours())
    }

    void testCalculateTotalBillableHoursFor8Days(){
	//((end date - start date) / 7 * hoursPerWeek
        Calendar startDate = Calendar.getInstance()
	startDate.set(2010, Calendar.MAY, 2)
	Calendar endDate = Calendar.getInstance()
	endDate.set(2010, Calendar.MAY, 10)
	ProjectResource resource = new ProjectResource(startDate:startDate, endDate:endDate, hoursPerWeek:40)
	assertEquals(48, resource.calculateBillableHours())
    }

    void testCalculateTotalBillableHoursFor2Months(){
	//((end date - start date) / 7 * hoursPerWeek
        Calendar startDate = Calendar.getInstance()
	startDate.set(2010, Calendar.JANUARY, 1)
	Calendar endDate = Calendar.getInstance()
	endDate.set(2010, Calendar.FEBRUARY, 28)
	ProjectResource resource = new ProjectResource(startDate:startDate, endDate:endDate, hoursPerWeek:40)
	assertEquals(328, resource.calculateBillableHours())
    }
}
