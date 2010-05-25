package com.pillar.fba

public class ProjectResource {
  static belongsTo = Project
  Project project
  Resource resource
  Calendar startDate
  Calendar endDate
  int hoursPerWeek
  int perDiem
  static final int WORK_DAYS_PER_WEEK = 5
  
    static constraints = {
		
    }

   def double calculateCost(){
   }

   def double calculateBillableHours(){
	double rval = 0.0;
	int daysBetween = (endDate - startDate)
	if(daysBetween < 5) {
	    rval = daysBetween * (hoursPerWeek / WORK_DAYS_PER_WEEK)   
	} else {
	    rval = getBusinessDaysOnProject() * (hoursPerWeek / WORK_DAYS_PER_WEEK)
	}
	return rval
   }

   def int getBusinessDaysOnProject(){
	int rval = 0;

	while(startDate.getTimeInMillis() <= endDate.getTimeInMillis()){
	    if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	    ++rval
	    }
	    startDate.add(Calendar.DAY_OF_MONTH, 1)
	}
	return rval;
   }


}
