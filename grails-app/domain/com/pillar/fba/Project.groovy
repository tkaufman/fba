package com.pillar.fba

class Project {
    static belongsTo = Client

    Client client
    String name
    String description

	static hasMany = [resources:ProjectResource]

    static constraints = {
        description(size:1..255, blank:false)
    }
}
