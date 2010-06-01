package com.pillar.fba

public class Project {
    static belongsTo = Client
    static hasMany = [resources:ProjectResource,resourcePlaceHolders:ProjectResourcePlaceholder]


    Client client
    String name
    String description
    List resources = new ArrayList()

    static constraints = {
        description(size:1..255, blank:false)
    }

    def int calculateTotalProjectCost() {
       int rval = 0;
       for(Resource resource : resources){
           rval += resource.calculateCost()
       }
       return rval
    }


}
