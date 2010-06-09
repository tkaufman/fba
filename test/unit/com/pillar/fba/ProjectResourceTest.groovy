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
		Resource resource = buildResource("resource1", 40)
		Calendar startDate = Calendar.getInstance()
		startDate.set(2010, Calendar.MAY, 3)
		Calendar endDate = Calendar.getInstance()
		endDate.set(2010, Calendar.MAY, 3)

        ProjectResource projectResource = buildProjectResource(resource, startDate, endDate, null , 0)
		assertEquals(8, projectResource.calculateBillableHours())
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
		Resource resource = buildResource("resource1", 50)
		Calendar startDate = Calendar.getInstance()
		startDate.set(2010, Calendar.MAY, 3)
		Calendar endDate = Calendar.getInstance()
		endDate.set(2010, Calendar.MAY, 3)

        ProjectResource projectResource = buildProjectResource(resource, startDate, endDate, null, 0)
        assertEquals(400, projectResource.calculateCost())
    }

    void testCalculateCostFor1DayWithPerDiem(){
		Resource resource = buildResource("resource1", 50)
		Calendar startDate = Calendar.getInstance()
		startDate.set(2010, Calendar.MAY, 3)
		Calendar endDate = Calendar.getInstance()
		endDate.set(2010, Calendar.MAY, 3)

        ProjectResource projectResource = buildProjectResource(resource, startDate, endDate, null, 40)
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
	
	void testCalculateProjectedCostForGivenMonthWithOneDayOfWork(){
		Resource resource = buildResource("resource1", 50)
		Calendar startDate = Calendar.getInstance()
		startDate.set(2010, Calendar.MAY, 3)
		Calendar endDate = Calendar.getInstance()
		endDate.set(2010, Calendar.MAY, 3)

        ProjectResource projectResource = buildProjectResource(resource, startDate, endDate, null , 0)
		assertEquals(400, projectResource.calculateProjectedCostForAGivenMonth(startDate))
	}
	
	void testCalculateProjectedCostForGivenMonthWithoutDayOfWork(){
		Resource resource = buildResource("resource1", 50)
		Calendar startDate = Calendar.getInstance()
		startDate.set(2010, Calendar.JUNE, 12)
		Calendar endDate = Calendar.getInstance()
		endDate.set(2010, Calendar.JUNE, 12)

        ProjectResource projectResource = buildProjectResource(resource, startDate, endDate, null , 0)
		assertEquals(0, projectResource.calculateProjectedCostForAGivenMonth(startDate))
	}
	
	void testCalculateBillableHoursForGivenMonthWithoutDayOfWorkOrOnlyWeekend(){
		Resource resource = buildResource("resource1", 50)
		Calendar startDate = Calendar.getInstance()
		startDate.set(2010, Calendar.JUNE, 12)
		Calendar endDate = Calendar.getInstance()
		endDate.set(2010, Calendar.JUNE, 12)

        ProjectResource projectResource = buildProjectResource(resource, startDate, endDate, null , 0)
		assertEquals(0, projectResource.calculateBillableHoursForAGivenMonth(startDate))
	}
	
	void testCalculateBillableHoursForGivenMonthWithManyDayOfWork(){
		Resource resource = buildResource("resource1", 50)
		Calendar startDate = Calendar.getInstance()
		startDate.set(2010, Calendar.JUNE, 14)
		Calendar endDate = Calendar.getInstance()
		endDate.set(2010, Calendar.JUNE, 18)

        ProjectResource projectResource = buildProjectResource(resource, startDate, endDate, null , 0)
		assertEquals(40, projectResource.calculateBillableHoursForAGivenMonth(startDate))
	}
	
	void testCalculateBusinessDaysOnprojectForGivenMonth(){
		Resource resource = buildResource("resource1", 50)
		Calendar startDate = Calendar.getInstance()
		startDate.set(2010, Calendar.JUNE, 14)
		Calendar endDate = Calendar.getInstance()
		endDate.set(2010, Calendar.JUNE, 18)

        ProjectResource projectResource = buildProjectResource(resource, startDate, endDate, null , 0)
		assertEquals(5, projectResource.calculateBusinessDaysOnProjectForGivenMonth(startDate))

		startDate.set(2010, Calendar.JUNE, 13)
		endDate.set(2010, Calendar.JUNE, 13)

        ProjectResource projectResource = buildProjectResource(resource, startDate, endDate, null , 0)
		assertEquals(5, projectResource.calculateBusinessDaysOnProjectForGivenMonth(startDate))
	}
	
    Resource buildResource(String resourceName, int resourceLoadedHourlyCost){
        Resource resource = new Resource()
        resource.name = resourceName
        resource.loadedHourlyCost = resourceLoadedHourlyCost
        return resource
    }

    ProjectResource buildProjectResource(Resource resource, Calendar startDate, Calendar endDate, Project project, int perDiem){

		ProjectResource projectResource = new ProjectResource(startDate:startDate, endDate:endDate, hoursPerWeek:40, perDiem:perDiem, resource:resource)
        return projectResource
    }
}
