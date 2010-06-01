package com.pillar.fba

class ProjectResourcePlaceholder extends AbstractProjectResource{

    ResourcePlaceholder resourcePlaceholder
  
    static constraints = {
		
    }

    double getCost() {
        return resourcePlaceholder.defaultHourlyCost
    }
}
