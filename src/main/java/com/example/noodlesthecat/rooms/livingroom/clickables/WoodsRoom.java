package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Room;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WoodsRoom extends Room{

    public WoodsRoom() throws FileNotFoundException {
    }

    @Override
    protected void setBackgroundImageLocation(){
        this.backgroundImageLocation = "/BGWoods.png";
    }

    @Override
    protected void setCommands(){
        this.commands = new ArrayList<>(){};
    }

    @Override
    protected void setClickables(){
        this.clickables = new ArrayList<>(){};
    }

    @Override
    protected List<String> getRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Toby the Fox: Hey there Noodles! What brings you to the woods?");
        roomText.add("Noodles: Hi Toby! I'm going to the beach. I want to catch a salmon but I don't know how.");
        roomText.add("Noodles: I have this shiny foil to use as a lure.");
        roomText.add("Noodles: But I haven't seen anything I can use to catch a fish with!");
        roomText.add("Toby the Fox: I have this string! You could use it to make a net!");
        roomText.add("Toby the Fox: I'll give it to you if you can beat me in a game!");
        roomText.add("Noodles: Should I try to play for the string? Y/N");


        return roomText;
    }
}
