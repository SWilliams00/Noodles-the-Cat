/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/lzbq24/1930s_living_room/
 */

package com.swgame.noodlesthecat.rooms;

import com.swgame.noodlesthecat.NoodlesGUI.Clickable;
import com.swgame.noodlesthecat.NoodlesGUI.Coordinates;
import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class LivingRoom extends Room {

    public LivingRoom(NoodlesGUI scene) throws FileNotFoundException {
        super(scene);
    }

    @Override
    protected void setBackgroundImageLocation() {
        this.backgroundImageLocation = "/BGLivingRoom.png";
    }

    @Override
    protected void setClickables() {
        Clickable clickableToAdd = new Clickable(scene);
        clickableToAdd.setItem(scene.getItemPool().getFeather());
        clickableToAdd.setWidth(80);
        clickableToAdd.setHeight(40);
        clickableToAdd.setTopLeft(new Coordinates(550, 500));
        clickables.add(clickableToAdd);
    }

    @Override
    public List<String> getEnterRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Noodles: *Yawn*");
        roomText.add("Noodles: That was a great third nap this morning!");
        roomText.add("Noodles: And what a dream I had...");
        roomText.add("Noodles: I traveled to the ends of the earth on an epic quest!");
        roomText.add("Noodles: I met lots of new people and saw lots of new places.");
        roomText.add("Noodles: And THEN...");
        roomText.add("Noodles: I fought a giant salmon!");
        roomText.add("Noodles: It was an enormous and fearsome beast! And I caught it all by myself! It was so tasty!");
        roomText.add("Noodles: And I was incredible!");
        roomText.add("Noodles: *Sigh* Nothing I do today will seem as fun after a dream like that!");
        roomText.add("Noodles: All I ever do is play with my toys, and wander around town, and hang out with my friends,");
        roomText.add("Noodles: And hunt for trinkets in the park, and nap, and.. I eat.. a lot!");
        roomText.add("Noodles: *Sigh* Now I'm bored AND hungry!");
        roomText.add("Noodles: I wonder if there's anything good in the kitchen..");

        return roomText;
    }

    public void onYPress(){}
    public void onNPress(){}

    @Override
    public List<String> getRoomItemText(){
        NoodlesGUI.updateScore(50);
        List <String> featherItemText = new ArrayList<>();
        featherItemText.add("Noodles: Ooh! My new feather! It's sooo pretty!");
        featherItemText.add("Noodles: I had such a great time playing with that yesterday.");
        featherItemText.add("Noodles: It was laying in the park..");
        featherItemText.add("Noodles: And I brought it ALL the way back here!");
        featherItemText.add("Noodles: From the park!");
        featherItemText.add("Noodles: I'm such a great hunter..");
        featherItemText.add("Noodles: I'll take this with me. Maybe I can show it off to my friends.");
        return featherItemText;
    }
}
