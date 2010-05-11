package com.pillar.fba

class Project {
    static belongsTo = Client

    Client client
    String name
    String description

	static hasMany = [resources:ProjectResource,resourcePlaceHolders:ProjectResourcePlaceholder]

   static constraints = {
    }
}
