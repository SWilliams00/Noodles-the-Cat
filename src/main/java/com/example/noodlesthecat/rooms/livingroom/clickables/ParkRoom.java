package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Room;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ParkRoom extends Room{
    public ParkRoom() throws FileNotFoundException {
   //     super(left, right);
    }

    @Override
    protected void setBackgroundImageLocation(){
        this.backgroundImageLocation = "/BGPark.png";
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
        roomText.add("Ronto the Blue Bird: Where is it? Where did I drop it??");
        roomText.add("Ronto the Blue Bird: Oh, I don't see it anywhere!");
        roomText.add("Noodles: That bird sounds like he's missing something. Should I stop to help? Y/N");
        roomText.add("Noodles: Hello there! I'm Noodles the Cat!");
        roomText.add("Noodles: I am a great and fearsome hunter of all things, be they small or big, fuzzy or shiny!");
        roomText.add("Noodles: Can I help you find something?");
        roomText.add("Ronto the Blue Bird: I'm Ronto. I lost a feather! I think I lost it yesterday. I don't see it anywhere.");
        roomText.add("Ronto the Blue Bird: I think it's gone forever!");
        roomText.add("Noodles: Ruh roh..");
        roomText.add("Noodles: Tell Ronto you have the feather? Y/N");
        roomText.add("Noodles: I found a feather yesterday! Is this yours?");
        roomText.add("Ronto the Blue Bird: Yes! That's my missing feather! My feather! Mine!");
        roomText.add("Noodles: I didn't know it belonged to anyone! I'm sorry, here, have it back.");
        roomText.add("Noodles: Your feathers are very pretty!");
        roomText.add("Ronto the Blue Bird: My feather! Thank you!");
        roomText.add("Ronto the Blue Bird: I know feathers fall out sometimes but I like keeping my feathers.");
        roomText.add("Ronto the Blue Bird: I grew them and I want to keep them!");
        roomText.add("Ronto the Blue Bird: Thanks for giving this one back! You're a real friend!");
        roomText.add("Ronto the Blue Bird: I found another feather while I was looking for mine. You should take it!");
        roomText.add("Ronto the Blue Bird: Maybe you'll find the bird this belongs to.");


        return roomText;
    }
}
