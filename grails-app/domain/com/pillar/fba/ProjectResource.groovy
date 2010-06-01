package com.pillar.fba

public class ProjectResource extends AbstractProjectResource{

    Resource resource
  
    static constraints = {
		
    }

    double determineCost() {
        return resource.loadedHourlyCost
    }


}
