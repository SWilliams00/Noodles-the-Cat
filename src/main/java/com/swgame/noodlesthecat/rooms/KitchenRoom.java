/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/88l1t2/occc_living_room_and_kitchen/
 */

package com.swgame.noodlesthecat.rooms;

import com.swgame.noodlesthecat.NoodlesGUI.Clickable;
import com.swgame.noodlesthecat.NoodlesGUI.Coordinates;
import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;
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
    protected void setClickables(){
        Clickable clickableToAdd = new Clickable(scene);
        clickableToAdd.setItem(scene.getItemPool().getFoil());
        clickableToAdd.setWidth(60);
        clickableToAdd.setHeight(40);
        clickableToAdd.setTopLeft(new Coordinates(650, 425));
        clickables.add(clickableToAdd);
    }

    @Override
    public List<String> getEnterRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Noodles: Hmm... Canned food... meh");
        roomText.add("Noodles: Kibble??! Not today!");
        roomText.add("Noodles: Treats? Schmeats! I want something fancier!");
        roomText.add("Noodles: Bah! Nothing sounds good after dreaming of a meal as tasty as that salmon..");
        roomText.add("Noodles: Like my favorite wet food and catnip combined...mmmm");
        roomText.add("Noodles: Wait. I'm having a genius idea..");
        roomText.add("Noodles: Yes... No... \nYes!");
        roomText.add("Noodles: I know what I'll do today! I'll go to the beach and catch a salmon!");
        roomText.add("Noodles: A fresh salmon that I caught myself will surely be as delicious as my dream salmon!");
        roomText.add("Noodles: Hmm.. How do you catch a salmon without getting your paws wet?");
        roomText.add("Noodles: In my dream I used a sword and magic!");
        roomText.add("Noodles: I don't think I know any fire spells...");
        roomText.add("Noodles: Whatever! I'll figure it out on the way!");
        roomText.add("Noodles: Maybe I can find some stuff that would help me catch a fish!");

        return roomText;
    }

    public void onYPress(){}
    public void onNPress(){}

    @Override
    public List<String> getRoomItemText(){
        NoodlesGUI.updateScore(50);
        List<String> foilItemText = new ArrayList<>();
        foilItemText.add("Noodles: What's that shiny thing over there??");
        foilItemText.add("Noodles: Ooh, that foil is SO shiny!");
        foilItemText.add("Noodles: Like shiny salmon scales...");
        foilItemText.add("Noodles: Play..? No! Stay focused!");
        foilItemText.add("Noodles: Ah! My genius is striking again!");
        foilItemText.add("Noodles: Salmon like shiny things, right?");
        foilItemText.add("Noodles: I'm going to take this with me.. maybe I can use this foil somehow");

        return foilItemText;
    }
}
