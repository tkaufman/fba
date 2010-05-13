package com.pillar.fba

public class Project {
    static belongsTo = Client
    static hasMany = [resources:ProjectResource]

    Client client
    String name
    String description

<<<<<<< HEAD
    static constraints = {
        description(size:1..255, blank:false)
    }

    def int getTotalProjectCost() {
       return 0;
=======
	static hasMany = [resources:ProjectResource,resourcePlaceHolders:ProjectResourcePlaceholder]

   static constraints = {
>>>>>>> 8b83b6f1e04200c725b5bb5e5c78f4033e7d6362
    }
}
