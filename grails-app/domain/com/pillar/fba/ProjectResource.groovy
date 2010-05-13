package com.pillar.fba

public class ProjectResource {
  static belongsTo = Project
  Project project
  Resource resource
  Date startDate
  Date endDate
  int hoursPerWeek
  int perDiem
  
    static constraints = {
		
    }
}
