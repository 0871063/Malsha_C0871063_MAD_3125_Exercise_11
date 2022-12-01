package com.example.exercise_11;

public class ImageObject {
    private int imageID;
    private boolean isTrafficLight;

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public boolean isTrafficLight() {
        return isTrafficLight;
    }

    public void setTrafficLight(boolean trafficLight) {
        isTrafficLight = trafficLight;
    }

    public ImageObject(int imageID, boolean isTrafficLight) {
        this.imageID = imageID;
        this.isTrafficLight = isTrafficLight;
    }
}
