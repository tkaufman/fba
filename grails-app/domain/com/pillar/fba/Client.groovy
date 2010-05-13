package com.pillar.fba

public class Client {

  String name
  String abbreviation
  
    static constraints = {
		name()
		abbreviation(unique:true)
    }
  
}
