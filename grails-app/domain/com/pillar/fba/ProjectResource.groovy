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
	int daysBetween = (endDate - startDate)
	return calculateBusinessDaysOnProject() * (hoursPerWeek / WORK_DAYS_PER_WEEK)
   }

   def int calculateBusinessDaysOnProject(){
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
