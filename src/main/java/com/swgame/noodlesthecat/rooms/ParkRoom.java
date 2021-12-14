/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/7ueb5j/occcpark_bench/
 */

package com.swgame.noodlesthecat.rooms;

import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ParkRoom extends Room {

    public ParkRoom(NoodlesGUI scene) throws FileNotFoundException {
        super(scene);
    }

    @Override
    protected void setBackgroundImageLocation() {
        this.backgroundImageLocation = "/BGPark.png";
    }

    @Override
    protected void setClickables() { }

    @Override
    public List<String> getEnterRoomText() {
        List<String> roomText = new ArrayList<>();
        roomText.add("Ronto the Blue Bird: Where is it? Where did I drop it??");
        roomText.add("Ronto the Blue Bird: Oh, I don't see it anywhere!");
        roomText.add("Noodles: Hello there! I'm Noodles the Cat! Can I help you find something?");
        roomText.add("Noodles: I am a great and fearsome hunter of all things, be they small or big, fuzzy or shiny!");
        roomText.add("Ronto the Blue Bird: I'm Ronto. I lost a feather! I think I lost it yesterday. Oh! It's gone forever!");
        roomText.add("Noodles: Ruh roh..");
        roomText.add("Noodles: Tell Ronto you took the feather? Y/N");

        return roomText;
    }

    public void onYPress() {

        List<String> yesText = new ArrayList<>();

        if(scene.doesNoodlesHaveItem(scene.getItemPool().getFeather().getName())){
            NoodlesGUI.updateScore(50);
            yesText.add("Noodles: Oh no! Is this your feather?? I found it here yesterday.");
            yesText.add("Ronto the Blue Bird: Yes! That's my missing feather! My feather! Mine!");
            yesText.add("Noodles: I didn't know it belonged to anyone! I'm so sorry. Here, have it back!");
            yesText.add("Noodles: Your feathers are very pretty! I felt like a great hunter for finding it..");
            yesText.add("Noodles: But I didn't mean to take anything from you..");
            yesText.add("Ronto the Blue Bird: My feathers are pretty! Thank you!");
            yesText.add("Ronto the Blue Bird: I know feathers fall out sometimes but I like keeping my feathers.");
            yesText.add("Ronto the Blue Bird: I grew them and I want to keep them!");
            yesText.add("Ronto the Blue Bird: Thanks for giving back my feather! You're a real friend!");
            scene.removeItem(scene.getItemPool().getFeather());
        }

       else {
           NoodlesGUI.updateScore(25);
           yesText.add("Noodles: I found a feather here yesterday! It's blue like your feathers.");
           yesText.add("Noodles: It's still at home though.. I didn't know it belonged to anybody..");
           yesText.add("Noodles: I'm sorry! But I can bring it to you later!");
           yesText.add("Ronto the Blue Bird: That does sound like my feather! You don't mind bringing it back?");
           yesText.add("Ronto the Blue Bird: I know feathers fall out sometimes, but I like keeping my feathers.");
           yesText.add("Ronto the Blue Bird: I grew them and I want to keep them!");
           yesText.add("Ronto the Blue Bird: Thanks for telling me about my feather! You're a real friend!");
        }

        yesText.add("Ronto the Blue Bird: Say, I found another feather while I was looking for mine.");
        yesText.add("Ronto the Blue Bird: Maybe you'll find the bird this belongs to.");
        yesText.add("Noodles: Ronto gave me a Fancy Feather!");
        yesText.add("Noodles: This doesn't look like it came from a real bird. I think it's plastic..");
        yesText.add("Noodles: But it's very pretty! I'll find something to do with it!");
        yesText.add("Noodles: Thanks Ronto! I love it! I'll see you later!");
        scene.addItem(scene.getItemPool().getFancy_feather());
        scene.startDisplayTextThread(yesText);
    }

    public void onNPress() {
        NoodlesGUI.updateScore(-10);
        List<String> noText = new ArrayList<>();
        noText.add("Noodles: I'm sorry you lost your feather!");
        noText.add("Ronto the Blue Bird: It's okay. I'll grow other feathers. But I like keeping my feathers.");
        noText.add("Ronto the Blue Bird: I grew them and I like to keep them!");
        noText.add("Ronto the Blue Bird: Maybe another bird found it and used it to make a beautiful nest..");
        noText.add("Ronto the Blue Bird: But if you do find it, will you bring it to me?");
        noText.add("Noodles: Sure thing, Ronto! Good luck!");
        scene.startDisplayTextThread(noText);
    }

    @Override
    public List<String> getRoomItemText(){return null;}

}
