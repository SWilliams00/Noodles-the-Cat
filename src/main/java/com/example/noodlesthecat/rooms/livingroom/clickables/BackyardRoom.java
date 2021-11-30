package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Room;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BackyardRoom extends Room {
    public BackyardRoom() throws FileNotFoundException {
    }

    @Override
    protected void setBackgroundImageLocation() {
        this.backgroundImageLocation = "/BGBackyard.png";
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
        roomText.add("Noodles: Howdy, Hank! It's a beautiful morning for adventure!");
        roomText.add("Hank the Black Cat: Why yes it is! I spent all morning in the park.");
        roomText.add("Hank the Black Cat: There were so many birds today! I counted them all!");
        roomText.add("Hank the Black Cat: But then they all flew away and now I don't have anything to do.");
        roomText.add("Hank the Black Cat: Would you want to play a game with me?");
        roomText.add("Noodles: Well, I do love games... But I also want to get to the beach before dark.");
        roomText.add("Noodles: I'm going on an adventure to catch a salmon!");
        roomText.add("Noodles: Should I take a break to play a game with my friend? Y/N");

        return roomText;
    }
}
