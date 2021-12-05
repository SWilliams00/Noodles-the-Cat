/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/lzbq24/1930s_living_room/
 */

package com.example.noodlesthecat.rooms.livingroom;

import com.example.noodlesthecat.Room;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LivingRoom extends Room {

    public LivingRoom() throws FileNotFoundException {
    }

    @Override
    protected void setBackgroundImageLocation() {
        this.backgroundImageLocation = "/BGLivingRoom.png";
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
    public List<String> getEnterRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Noodles: *Yawn*");
        roomText.add("Noodles: That was a great third nap this morning!");
        roomText.add("Noodles: And what a dream I had...");
        roomText.add("Noodles: I traveled to the ends of the earth on a quest.");
        roomText.add("Noodles: I met lots of new people and saw lots of new places.");
        roomText.add("Noodles: And THEN...");
        roomText.add("Noodles: I caught a giant salmon!");
        roomText.add("Noodles: It was an enormous and fearsome beast! And I caught it all by myself!");
        roomText.add("Noodles: I was incredible!");
        roomText.add("Noodles: And the salmon... MMMM..  It was sooo tasty!");
        roomText.add("Noodles: *Sigh* Well, now what am I going to do today?");
        roomText.add("Noodles: Nothing will seem as fun after a dream like that");
        roomText.add("Noodles: I never do anything that exciting!");
        roomText.add("Noodles: All I ever do is play with my toys");
        roomText.add("Noodles: And wander around town..");
        roomText.add("Noodles: And hang out with my friends..");
        roomText.add("Noodles: And nap..");
        roomText.add("Noodles: And EAT!");
        roomText.add("Noodles: *Sigh* Now I'm bored AND hungry!");
        roomText.add("Noodles: I wonder if there's anything good to eat in the kitchen..");

        return roomText;
    }

    public List<String> getYesText(){
        return null;
    }
    public List<String> getNoText(){
        return null;
    }
}
