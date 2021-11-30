package com.example.noodlesthecat.rooms.livingroom;

import com.example.noodlesthecat.Room;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LivingRoom extends Room {

    public LivingRoom() throws FileNotFoundException {
    }

    @Override
    protected void setBackgroundImageLocation() {
        this.backgroundImageLocation = "/BGLivingRoom.png";
    }

    @Override
    protected void setCommands() {
        this.commands = new ArrayList<>() {
        };
    }

    @Override
    protected void setClickables() {
        this.clickables = new ArrayList<>() {

        };
    }

    @Override
    protected List<String> getRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Noodles: *Yawn*");
        roomText.add("Noodles: That was a great nap!");
        roomText.add("Noodles: I dreamed I caught a giant salmon. It was sooo tasty.");
        roomText.add("Noodles: *Sigh* Boy, am I HUNGRY!");
        roomText.add("Noodles: I wonder if there's anything good to eat in the kitchen..");


        return roomText;
    }

}
