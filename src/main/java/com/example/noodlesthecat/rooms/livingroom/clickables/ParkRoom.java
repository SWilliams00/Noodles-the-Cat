/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/7ueb5j/occcpark_bench/
 */

package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Room;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ParkRoom extends Room{
    public ParkRoom() throws FileNotFoundException {
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
    public List<String> getEnterRoomText(){
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

        return roomText;
    }

    public List<String> getYesText(){
        List<String> yesText = new ArrayList<>();

        yesText.add("Noodles: I found a feather yesterday! Is this yours?");
        yesText.add("Ronto the Blue Bird: Yes! That's my missing feather! My feather! Mine!");
        yesText.add("Noodles: I didn't know it belonged to anyone! I'm sorry, here, have it back!");
        yesText.add("Noodles: Your feathers are very pretty!");
        yesText.add("Ronto the Blue Bird: My feather! Thank you!");
        yesText.add("Ronto the Blue Bird: I know feathers fall out sometimes but I like keeping my feathers.");
        yesText.add("Ronto the Blue Bird: I grew them and I want to keep them!");
        yesText.add("Ronto the Blue Bird: Thanks for giving this one back! You're a real friend!");
        yesText.add("Ronto the Blue Bird: I found another feather while I was looking for mine. You should take it!");
        yesText.add("Ronto the Blue Bird: Maybe you'll find the bird this belongs to.");
        return yesText;
    }
    public List<String> getNoText(){
        List<String> noText = new ArrayList<>();

        noText.add("Noodles: I'm sorry you lost your feather!");
        noText.add("Ronto the Blue Bird: It's okay. I'll grow other feathers. But I like keeping my feathers.");
        noText.add("Ronto the Blue Bird: I grew them and I like to keep them!");
        noText.add("Ronto the Blue Bird: Maybe another bird found it and used it to make a beautiful nest..");
        noText.add("Ronto the Blue Bird: But if you do find it, will you bring it to me?");
        noText.add("Noodles: Sure thing, Ronto! Good luck!");
        return noText;
    }
}
