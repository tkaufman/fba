package com.pillar.fba

class Client {

  String name
  String abbr
  
    static constraints = {
		name()
		abbr(unique:true)
    }
  
}
