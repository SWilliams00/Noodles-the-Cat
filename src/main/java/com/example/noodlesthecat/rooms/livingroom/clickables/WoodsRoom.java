/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://dribbble.com/shots/9555150-Pixel-woods
 */

package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.NoodlesGUI;
import com.example.noodlesthecat.Room;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WoodsRoom extends Room{

    public WoodsRoom(NoodlesGUI scene) throws FileNotFoundException {
        super(scene);
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
    public List<String> getEnterRoomText(){
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

    public void onYPress(){}
    public void onNPress(){
        List<String> noText = new ArrayList<>();

        noText.add("Noodles: I don't think I need a string. I don't even know how to make a net");
        noText.add("Toby the Fox: I don't know how either.");
        noText.add("Toby the Fox: You know, I heard a rumor that Cathulu, mythical cat-God of the sea is staying near the beach!");
        noText.add("Toby the Fox: Maybe she can help you catch a salmon!");
        noText.add("Noodles: That's a great idea, Toby! Thanks!");
        noText.add("Noodles: I'll see if I can convince Cathulu to help me. I hope I have everything I need..");
        scene.startDisplayTextThread(noText);
    }
}
