package com.pillar.fba

public class MarginTarget {
    String name
    int targetPercentage
  
    static constraints = {
	targetPercentage(min:0,max:99)
    }

    public double estimateProject(Project project){
	if ( targetPercentage < 0 || targetPercentage > 99 ) {
		throw new RuntimeException("you're fu is not good!")
	}
	def denominator = (1 - (targetPercentage / 100))
        def answer = project.calculateTotalProjectCost() / denominator
	return answer
    }

}
