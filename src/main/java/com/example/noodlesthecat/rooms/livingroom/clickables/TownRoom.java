package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Room;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TownRoom extends Room {

    public TownRoom() throws FileNotFoundException {

    }


    @Override
    protected void setBackgroundImageLocation(){
        this.backgroundImageLocation = "/BGTown.png";
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
        roomText.add("Noodles: Okay, I made it to town. I'm halfway to the beach!");
        roomText.add("Noodles: I see my fashionable friend, Mittens over there! I wonder who her new friend is?");
        roomText.add("Noodles: Hi, Mittens! You two are very fancy today!");
        roomText.add("Mittens: Noodles! This is my friend Spot! We got dressed up for a visit to town!");
        roomText.add("Spot: Hi Noodles! We showed off our new looks all morning!");
        roomText.add("Spot: We were just about to play a game. Any friend of Mittens is a friend of mine!");
        roomText.add("Mittens: Do you want to join us?");
        roomText.add("Noodles: Gosh, I don't know. Do I have time to play a game? Y/N");
        roomText.add("Noodles: Here! You guys should take this toy I found! You'll have much more fun playing with it together!");
        roomText.add("Noodles: I love making new friends!");
        roomText.add("Noodles: But back to the adventure at hand! Tasty salmon! Here I come!");

        return roomText;
    }
}
