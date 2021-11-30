package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Room;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class KitchenRoom extends Room {

    public KitchenRoom() throws FileNotFoundException{
    }

    @Override
    protected void setBackgroundImageLocation(){
        this.backgroundImageLocation = "/BGKitchen.png";
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
        roomText.add("Noodles: Hmm...");
        roomText.add("Noodles: Canned food...meh");
        roomText.add("Noodles: Kibble??! Not today!");
        roomText.add("Noodles: Treats? Schmeats! I want something fancier");
        roomText.add("Noodles: Bah! How is there NOTHING to eat??");

        return roomText;
    }
}
