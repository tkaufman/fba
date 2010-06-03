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

}
