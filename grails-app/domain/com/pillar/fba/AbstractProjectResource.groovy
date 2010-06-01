package com.pillar.fba

abstract class AbstractProjectResource {

    static belongsTo = Project
    Project project
    Calendar startDate
    Calendar endDate
    int hoursPerWeek
    int perDiem
    static final int WORK_DAYS_PER_WEEK = 5

    static constraints = {

    }

    abstract double determineCost()

    double calculateCost(){
        return (calculateBillableHours() * determineCost()) + (calculateBusinessDaysOnProject() * perDiem)
    }

    double calculateBillableHours(){
	int daysBetween = (endDate - startDate)
	return calculateBusinessDaysOnProject() * (hoursPerWeek / WORK_DAYS_PER_WEEK)
    }

    int calculateBusinessDaysOnProject(){
	int rval = 0;
        Calendar start = Calendar.getInstance();
        start.setTime(startDate.getTime())
	while(start.getTimeInMillis() <= endDate.getTimeInMillis()){
	    if (start.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && start.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	        ++rval
	    }
	    start.add(Calendar.DAY_OF_MONTH, 1)
	}
	return rval;
    }
}
