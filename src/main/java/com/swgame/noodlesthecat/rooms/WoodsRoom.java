/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://dribbble.com/shots/9555150-Pixel-woods
 */

package com.swgame.noodlesthecat.rooms;

import com.swgame.noodlesthecat.NoodlesGUI.Clickable;
import com.swgame.noodlesthecat.NoodlesGUI.Coordinates;
import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;
import com.swgame.noodlesthecat.NoodlesGUI.Item;
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
    protected void setClickables(){
        Item itemToAdd = new Item("/ItemString.png", "String");
        Clickable clickableToAdd = new Clickable(scene);
        clickableToAdd.setItem(itemToAdd);
        clickableToAdd.setWidth(80);
        clickableToAdd.setHeight(40);
        clickableToAdd.setTopLeft(new Coordinates(550, 550));
        clickables.add(clickableToAdd);
    }

    @Override
    public List<String> getEnterRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Toby the Fox: Hey there Noodles! What brings you to the woods today?");
        roomText.add("Noodles: Hi Toby! I'm going to the beach to complete my day-long quest to catch a salmon!");
        roomText.add("Toby the Fox: No way! That sounds like a lot of fun!");
        roomText.add("Noodles: But... I'm almost at the beach...And I don't know how to catch a fish..");
        roomText.add("Noodles: I really don't want to get *in* the water..");
        roomText.add("Toby the Fox: Whoa. I found some string when I was exploring earlier! Maybe you could make a net!");
        roomText.add("Noodles: That's amazing, Toby! Do you know how to make a net?");
        roomText.add("Toby the Fox: Well.. no.");
        roomText.add("Noodles: Me neither.. That's okay.. Maybe I just stop my quest. I'm not really sure I even want to catch a fish.");
        roomText.add("Noodles: Hank says that fresh fish might be gross... I'm worried he's right.");
        roomText.add("Noodles: I do really love gravy..");
        roomText.add("Toby the Fox: That's a tough call, Noodles.");
        roomText.add("Toby the Fox: You know, I heard that Cathulu, mythical Cat-God of the Sea is staying nearby");
        roomText.add("Toby the Fox: She comes to town every year for the Seafood and Catnip Festival");
        roomText.add("Toby the Fox: I bet she could help you decide what to do. She probably even knows how to make a net!");
        roomText.add("Noodles: No way, Toby! It's crazy that you have exactly the thing and information I need to finish my quest!");
        roomText.add("Noodles: Are you an Oracle??");
        roomText.add("Toby the Fox: Nope! I'm just an expedient way to wrap things up!\nAnd a good friend!");
        roomText.add("Toby the Fox: Now. Take that string and go finish your quest! You can tell me all about it tomorrow!");
        roomText.add("Noodles: Thanks, Toby! I'm off to brave the Sea-God Cathulu! Hopefully she doesn't eat me!");
        roomText.add("Toby the Fox: Don't worry! She's pescatarian. ...I think...");
        roomText.add("Toby the Fox: Good luck!");

        return roomText;
    }

    @Override
    public List<String> getRoomItemText(){
        return null;
    }

    public void onYPress(){}
    public void onNPress(){}
}
