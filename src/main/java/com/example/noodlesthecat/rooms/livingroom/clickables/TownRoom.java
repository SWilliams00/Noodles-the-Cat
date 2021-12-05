/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/o2s1l2/little_town_pixel_art/
 */

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
    public List<String> getEnterRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Noodles: Okay, I made it to town. I'm halfway to the beach!");
        roomText.add("Noodles: I see my fashionable friend, Mittens over there! I wonder who her new friend is?");
        roomText.add("Noodles: Hi, Mittens! You two are very fancy today!");
        roomText.add("Mittens: Noodles! This is my friend Spot! We got dressed up for a visit to town!");
        roomText.add("Spot: Hi Noodles! We showed off our new looks all morning!");
        roomText.add("Spot: We were just about to play a game. Any friend of Mittens is a friend of mine!");
        roomText.add("Mittens: Do you want to join us?");
        roomText.add("Noodles: Gosh, I don't know. Do I have time to play a game? Y/N");

        //if yes
        roomText.add("That was a lot of fun!");
        roomText.add("Noodles: Here! You guys should take this toy I found! You'll have much more fun playing with it together!");
        roomText.add("Noodles: I love making new friends!");
        roomText.add("Noodles: But back to the adventure at hand! Tasty salmon! Here I come!");

        //if no
        roomText.add("Noodles: I would love to play but I have to get to the beach.");
        roomText.add("Noodles: I'm on a Herculean quest, fraught with danger!");
        roomText.add("Mittens: Oh no! What are you doing?");
        roomText.add("Noodles: I'm going to try to catch a salmon for dinner! Hunger is the foe of all cat-kind!");
        roomText.add("Spot: You're right about that, Noodles! Good luck!");

        return roomText;
    }

    public List<String> getYesText(){
        List<String> yesText = new ArrayList<>();
        return yesText;
    }
    public List<String> getNoText(){
        List<String> noText = new ArrayList<>();
        return noText;
    }
}
