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
    protected List<String> getRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Cathulu! Oh no!");
        roomText.add("Scared...");
        roomText.add("Quizzy");

        return roomText;
    }
}
