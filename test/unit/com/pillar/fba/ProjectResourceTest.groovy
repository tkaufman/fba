package com.pillar.fba

import grails.test.GrailsUnitTestCase
import junit.framework.Test

class ProjectResourceTest extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCalculateTotalBillableHoursFor1Day(){
        ProjectResource resource = buildProjectResourceFor1Day()
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

    void testCalculateCostFor1DayWithNoPerDiem(){
        ProjectResource projectResource = buildProjectResourceFor1Day()
        assertEquals(400, projectResource.calculateCost())
    }

    void testCalculateCostFor1DayWithPerDiem(){
        ProjectResource projectResource = buildProjectResourceFor1Day()
        projectResource.perDiem = 40;
        assertEquals(440, projectResource.calculateCost())
    }

    void testCalculateBillableHoursFor5DaysWith5HoursPerWeek(){
        Calendar startDate = Calendar.getInstance()
	startDate.set(2010, Calendar.MAY, 3)
	Calendar endDate = Calendar.getInstance()
	endDate.set(2010, Calendar.MAY, 7)
	ProjectResource projectResource = new ProjectResource(startDate:startDate, endDate:endDate, hoursPerWeek:5)
        assertEquals(5, projectResource.calculateBillableHours())
    }

    Resource buildResource(){
        Resource resource = new Resource()
        resource.name = "Test Name"
        resource.loadedHourlyCost = 50
        return resource
    }

    ProjectResource buildProjectResourceFor1Day(){
        Calendar startDate = Calendar.getInstance()
	startDate.set(2010, Calendar.MAY, 3)
	Calendar endDate = Calendar.getInstance()
	endDate.set(2010, Calendar.MAY, 3)
	ProjectResource projectResource = new ProjectResource(startDate:startDate, endDate:endDate, hoursPerWeek:40)
        projectResource.resource = buildResource()
        return projectResource
    }
}
