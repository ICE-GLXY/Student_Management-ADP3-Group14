package za.ac.cput.domain;

/*
Titilayo Akinjole - 220283982
ADP3
School Management

*/
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

public class resources {
    @Id @NotNull
    private String resourcesID;

    @NotNull
    private String textbooks;

    @NotNull
    private String exercises;

    @NotNull
    private String slideshows;


    public resources(resources.Builder b){
        this.resourcesID = b.resourcesId;
        this.textbooks = b.textbooks;
        this.exercises = b.exercises;
        this.slideshows = b.slideshows;
    }

    public resources() {

    }

    public String getResourcesID() {
        return resourcesID;
    }

    public String getTextbooks() {
        return textbooks;
    }

    public String getExercises() {
        return exercises;
    }

    public String getSlideshows() {
        return slideshows;
    }

    @Override
    public String toString() {
        return "resources{" +
                "resourcesID='" + resourcesID + '\'' +
                ", textbooks='" + textbooks + '\'' +
                ", exercises='" + exercises + '\'' +
                ", slideshows='" + slideshows + '\'' +
                '}';
    }

    public static class Builder {

        private String resourcesId;
        private String textbooks;
        private String exercises;
        private String slideshows;


        public resources.Builder resourcesId(String resourcesId) {
            this.resourcesId = resourcesId;
            return this;
        }

        public resources.Builder textbooks(String textbooks) {
            this.textbooks = textbooks;
            return this;
        }

        public resources.Builder exercises(String exercises) {
            this.exercises = exercises;
            return this;
        }

        public resources.Builder slideshows(String slideshows) {
            this.slideshows = slideshows;
            return this;
        }

        public Builder copy(resources e){
            this.resourcesId = resourcesId;
            this.textbooks = textbooks;
            this.exercises = exercises;
            this.slideshows = slideshows;
            return this;
        }

        public resources build(){
            return new resources(this);
        }
    }

}
