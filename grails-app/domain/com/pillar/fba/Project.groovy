package com.pillar.fba

public class Project {
    static belongsTo = Client
    static hasMany = [resources:ProjectResource,resourcePlaceHolders:ProjectResourcePlaceholder]


    Client client
    String name
    String description

    static constraints = {
        description(size:1..255, blank:false)
    }

    def int getTotalProjectCost() {
       return 0;
    }
}
