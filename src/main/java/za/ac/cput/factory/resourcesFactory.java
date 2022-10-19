package za.ac.cput.factory;

import za.ac.cput.domain.resources;

public class resourcesFactory {

    public static resources build (String resourcesID, String textbooks, String exercises, String slideshows){
        if(resourcesID.isEmpty() || !textbooks.isEmpty())
            throw new IllegalArgumentException("Resources ID is empty");
        return new resources.Builder()
                .resourcesId(resourcesID)
                .textbooks(textbooks)
                .exercises(exercises)
                .slideshows(slideshows)
                .build();
    }
}
