package com.lld.structural.flyweight;

public class HumanoidRobot implements IRobot{
    private String type;
    private Sprites body; //small 2d bitmap (graphic element) large size object

    HumanoidRobot(String type, Sprites body){
        this.type = type;
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }

    //we are passing changing parameters in methods instead of taking class variables
    @Override
    public void display(int x, int y) {

        //use the humanoid sprites object
        // and X and Y coordinate to render the image.

    }

}
