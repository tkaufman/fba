package com.pillar.fba

public class Project {
    static belongsTo = Client
    static hasMany = [resources:ProjectResource,resourcePlaceHolders:ProjectResourcePlaceholder]


    Client client
    String name
    String description
    int price
    String projectStatus
    Set resources = new HashSet()
    Set resourcePlaceHolders = new HashSet()


    static constraints = {
        description(size:1..255, blank:false)
    }

    def int calculateTotalProjectCost() {
       int rval = 0;
       for(ProjectResource resource : resources){
           rval += resource.calculateCost()
       }
       for(ProjectResourcePlaceholder placeHolder : resourcePlaceHolders){
           rval += placeHolder.calculateCost()
       }
       return rval
    }

    public TreeMap retrieveAllEstimatesForProject(){
        def targets = MarginTarget.list()
        Map estimates = new HashMap()
        for(MarginTarget target : targets){
            estimates.put(target.targetPercentage, target.estimateProject(this))
        }
        return new TreeMap(estimates)
    }

    def double calculateProfitMargin(){
        if(price > 0) {
            return ((price - calculateTotalProjectCost()) / price ) * 100
        } else {
            return 0
        }
    }
	
	def  getEarliestResourceStartDate(){
		Calendar start = Calendar.getInstance()
		Iterator itr = resources.iterator()
		ProjectResource firstResource = itr.next()
		start.setTime(firstResource.startDate.getTime())

		
		for(ProjectResource resource : resources){
			if(start.compareTo(resource.startDate)<0)			
				start.setTime(resource.startDate.getTime())		
		}
		
		return start
	}
	
	def  getLatestResourceEndDate(){
		Calendar end = Calendar.getInstance()
		Iterator itr = resources.iterator()
		end.setTime(itr.next().endDate.getTime())

		for(ProjectResource resource : resources){
			if(end.compareTo(resource.endDate)<0)			
				end.setTime(resource.endDate.getTime())		
		}
	
		return end
	}
	
	def calculateMonthlyProjectedCosts(){	
		ProjectProjectedCost projectedMonthlyCost = new ProjectProjectedCost(Project : this)
		return projectedMonthlyCost.calculateMonthlyProjectedCostForAllMonths()
	}
	

}
