/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/kmx13i/pixel_art_of_a_cave_c/
 */

package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.NoodlesGUI;
import com.example.noodlesthecat.Room;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CaveRoom extends Room {

    public CaveRoom(NoodlesGUI scene) throws FileNotFoundException {
        super(scene);
    }

    @Override
    protected void setBackgroundImageLocation() {
        this.backgroundImageLocation = "BGCave.png";
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
    public List<String> getEnterRoomText() {
        List<String> roomText = new ArrayList<>();

        roomText.add("Cathulu the Mystical: Who goes there? Who dares to interrupt my commune with the Old Ones?");
        roomText.add("Noodles: Hi. Just me. Hello, Sea-God Cathulu..");
        roomText.add("Noodles: I'm Noodles.");
        roomText.add("Noodles: I'm a cat..");
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
        roomText.add("Noodles: I had a dream!");
        roomText.add("Noodles: I crossed magical realms, fought mythical beasts");
        roomText.add("Noodles: And at the end I caught a gigantic salmon!");
        roomText.add("Noodles: I was sad after I woke up, I never do anything heroic or fun like that..");
        roomText.add("Noodles: I wanted to have an adventure and catch a real salmon!");
        roomText.add("Noodles: But I don't know how...");
        roomText.add("Noodles: I have a lure and some string for a net. I wondered if you could help me");
        roomText.add("Cathulu the Mysterious: I see...");
        roomText.add("Noodles: I could find you a gift!");
        roomText.add("Cathulu the Mysterious: I have no need for material objects!");
        roomText.add("Cathulu the Overencumbered: The sea is wet and I have no pockets..");
        roomText.add("Cathulu the Mysterious: I seek entertainment...");
        roomText.add("Cathulu the Mysterious: I will ask you questions, amuse me with your answers");
        roomText.add("Cathulu the Mysterious: Do this and I will help you complete your quest");
        roomText.add("Noodles: Should I play? Y/N");

        roomText.add("Cathulu the Kindly: That was amusing indeed, little one.");
        roomText.add("Cathulu the Kindly: You know much for one so.. small");


        return roomText;
    }

    public void onYPress() {
        MGCathuluQuiz minigame = new MGCathuluQuiz();
        minigame.display();
    }

    public void onNPress() {

    }
}
