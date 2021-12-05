/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/kmx13i/pixel_art_of_a_cave_c/
 */

package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Room;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CaveRoom extends Room{
    public CaveRoom() throws FileNotFoundException {
    //    super(left, right);
    }

    @Override
    protected void setBackgroundImageLocation(){
        this.backgroundImageLocation = "BGCave.png";
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

        roomText.add("Cathulu the Mystical: Who goes there? Who dares to interrupt my commune with the Old Ones?");
        roomText.add("Noodles: Hi. Just me. Hello, Sea-God Cathulu..");
        roomText.add("Noodles: I'm Noodles. I'm a cat..");
        roomText.add("Cathulu the Mystical: Ah yes, Noodles.");
        roomText.add("Cathulu the Mystical: I have been observing your adventures since you embarked upon your quest.");
        roomText.add("Cathulu the Mystical: I know who you are little one.");
        roomText.add("Noodles: You have? You do? How?");
        roomText.add("Cathulu the Transcendent: I see all points of time across infinity.");
        roomText.add("Cathulu the Transcendent: I see the first lights of the opening of this universe..");
        roomText.add("Cathulu the Transcendent: I hear the bells that knell it's closing..");
        roomText.add("Cathulu the Transcendent: And I see all that resides between..");
        roomText.add("Noodles: Whoa.");
        roomText.add("Noodles: How come you didn't know it was me");
        roomText.add("Cathulu the Transcendent: Time is fickle when you see all that I See");
        roomText.add("Noodles: Do you also just like to be mysterious?");
        roomText.add("Cathulu the Mysterious: Yes. Fewer people bother me that way.");
        roomText.add("Cathulu the Mysterious: You are very observant for one so young.");
        roomText.add("Cathulu the Mysterious: Tell me what brings you to my cave today..");
        roomText.add("Noodles: I wanted to have an adventure and catch a salmon!");

        return roomText;
    }

    public List<String> getYesText(){
        return null;
    }
    public List<String> getNoText(){
        return null;
    }
}
