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
	
	def calculateProjectedCostForAGivenMonth(Calendar month){
        return (calculateBillableHoursForAGivenMonth(month) * determineCost()) + (calculateBusinessDaysOnProjectForGivenMonth(month) * perDiem)
    }
	
	def calculateBillableHoursForAGivenMonth(Calendar month){
		return (calculateBusinessDaysOnProjectForGivenMonth(month) * (hoursPerWeek / WORK_DAYS_PER_WEEK))
    }
	
	def calculateBusinessDaysOnProjectForGivenMonth(Calendar month){
		int rval = 0;
        Calendar start = Calendar.getInstance();
		Calendar startMonth = Calendar.getInstance();
		Calendar endMonth = Calendar.getInstance();
		
		startMonth.setTime(month.getTime())
		endMonth.setTime(month.getTime())
		
		startMonth.set(Calendar.DAY_OF_MONTH , month.getActualMinimum(Calendar.DAY_OF_MONTH))
		endMonth.set(Calendar.DAY_OF_MONTH , month.getActualMaximum(Calendar.DAY_OF_MONTH))
        start.setTime(startMonth.getTime())

	
		if((endDate.compareTo(startMonth)<0) || (startDate.compareTo(endMonth)>0))
			return 0
		
		while(start.get(Calendar.MONTH) == month.get(Calendar.MONTH)){
			if (start.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && start.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && start.compareTo(endDate)<=0 && start.compareTo(startDate)>=0) {
				rval++
			}
			start.add(Calendar.DAY_OF_MONTH, 1)
		}

		return rval
    }
}
