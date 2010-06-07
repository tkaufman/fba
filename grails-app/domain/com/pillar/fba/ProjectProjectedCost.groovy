package com.pillar.fba

class ProjectProjectedCost {

  Project project
  Map monthlyCosts  = new HashMap()

  
  
    static constraints = {
		
    }
	
	def calculateMonthlyProjectedCostForAllMonths(){
	
		
	
	
		Calendar currentDate = Calendar.getInstance()
		currentDate.setTime(project.getEarliestResourceStartDate().getTime())
		Calendar end = Calendar.getInstance()
		end.setTime(project.getLatestResourceEndDate().getTime())
		
		
		while((currentDate.get(Calendar.MONTH)!=end.get(Calendar.MONTH)) || (currentDate.get(Calendar.YEAR)!=end.get(Calendar.YEAR))){
			Date d = new Date(currentDate.getTimeInMillis())
			//String.format('%tA %<te %<tB %<ty', c1)
			monthlyCosts.put([(String.format('%tB %<tY', currentDate)), calculateMonthlyCost(currentDate)])
			//monthlyCosts.put([(currentDate.get(Calendar.MONTH) +"-"+ currentDate.get(Calendar.YEAR)), calculateMonthlyCost(currentDate)])
			currentDate.add(Calendar.MONTH, 1)
		}
		
		monthlyCosts.put([(String.format('%tB %<tY', currentDate)), calculateMonthlyCost(currentDate)])
		
		return monthlyCosts
	}
	
	def calculateMonthlyCost(Calendar currentMonth){
		double costForTheCurrentMont = 0
		for(ProjectResource resource : project.resources){
			costForTheCurrentMont += resource.calculateProjectedCostForAGivenMonth(currentMonth)
		}
		
		return costForTheCurrentMont
	}
	
}
