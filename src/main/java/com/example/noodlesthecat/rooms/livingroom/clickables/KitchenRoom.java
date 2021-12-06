/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/88l1t2/occc_living_room_and_kitchen/
 */

package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Clickable;
import com.example.noodlesthecat.Coordinates;
import com.example.noodlesthecat.NoodlesGUI;
import com.example.noodlesthecat.Room;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class KitchenRoom extends Room {

    public KitchenRoom(NoodlesGUI scene) throws FileNotFoundException{
        super(scene);
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
        Clickable clickableToAdd = new Clickable();
        clickableToAdd.setImage(new Image("/ItemFoil.png"));
        clickableToAdd.setWidth(80);
        clickableToAdd.setHeight(40);
        clickableToAdd.setTopLeft(new Coordinates(550, 200));
        clickables.add(clickableToAdd);
    }

    @Override
    public List<String> getEnterRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Noodles: Hmm...");
        roomText.add("Noodles: Canned food...meh");
        roomText.add("Noodles: Kibble??! Not today!");
        roomText.add("Noodles: Treats? Schmeats! I want something fancier!");
        roomText.add("Noodles: Isn't there anything delicious to eat?");
        roomText.add("Noodles: Bah! Nothing sounds good after dreaming of a meal as tasty as that salmon..");
        roomText.add("Noodles: Wait.");
        roomText.add("Noodles: I'm having a genius idea");
        roomText.add("Noodles: Yes.");
        roomText.add("Noodles: No...");
        roomText.add("Noodles: Yes!");
        roomText.add("Noodles: I know what I'm going to do today!");
        roomText.add("Noodles: I'm going to go to the beach and catch a salmon!");
        roomText.add("Noodles: ...");
        roomText.add("Noodles: Hmm.. How do you catch a salmon?");
        roomText.add("Noodles: In my dream I used a sword and magic!");
        roomText.add("Noodles: I don't think I know any fire spells...");
        roomText.add("Noodles: I could use my paws.. but I don't want to get wet!");
        roomText.add("Noodles: Whatever! I'll figure it out on the way!");

        return roomText;
    }

    public void onYPress(){}
    public void onNPress(){}
}
