package com.pillar.fba

public class MarginTarget {
    String name
    int targetPercentage
  
    static constraints = {
    }

    public double estimateProject(Project project){
        return project.calculateTotalProjectCost() * (1 + (targetPercentage / 100))
    }
}
