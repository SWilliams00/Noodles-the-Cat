/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/g0tqpj/berlin_backyard/
 */

package com.swgame.noodlesthecat.rooms;

import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;
import com.swgame.noodlesthecat.mgclasses.MGGuessTheNumber;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BackyardRoom extends Room {

    public BackyardRoom(NoodlesGUI scene) throws FileNotFoundException {
        super(scene);
    }

    @Override
    protected void setBackgroundImageLocation() {
        this.backgroundImageLocation = "/BGBackyard.png";
    }

    @Override
    protected void setClickables() {}

    @Override
    public List<String> getEnterRoomText(){
        List<String> roomText = new ArrayList<>();

        roomText.add("Noodles: Howdy, Hank! It's a beautiful morning for adventure!");
        roomText.add("Hank the Black Cat: Why yes it is! I spent all morning in the park, watching the birds.");
        roomText.add("Hank the Black Cat: There were so many today! I counted them all! Numbers are fun!");
        roomText.add("Hank the Black Cat: But then they all flew away and now I don't have anything to do.");
        roomText.add("Hank the Black Cat: Say, would you want to play a game with me before naptime?");
        roomText.add("Noodles: Well, I do love games... But I also have to get to the beach before dark!");
        roomText.add("Noodles: I'm on a Herculean quest to catch a salmon!");
        roomText.add("Noodles: It's going to be the tastiest dinner I'll ever have!");
        roomText.add("Hank the Black Cat: Fresh fish? Not in can? With no delicious gravy...? Doesn't that sound a little gross?");
        roomText.add("Noodles: Never had it! But I'm not scared!");
        roomText.add("Hank the Black Cat: Well, that doesn't sound very good to me..But I hope you have fun!");
        roomText.add("Noodles: Thanks, Hank! I'm having fun already! But playing a game sounds fun too...");
        roomText.add("Noodles: Should I take a break to play a game with my friend? Y/N");

        return roomText;
    }

    public void onYPress(){
        MGGuessTheNumber minigame = new MGGuessTheNumber();
        minigame.setOnClose((e) ->  {
            scene.startDisplayTextThread(getRoomItemText());
            scene.addItem(scene.getItemPool().getBird());
        });
        minigame.display();
    }

    public void onNPress(){

        NoodlesGUI.updateScore(-10);
        List<String> noText = new ArrayList<>();
        noText.add("Noodles: I wish I could, Hank, but this quest is dangerous, perilous,");
        noText.add("Noodles: and of the utmost importance that it be completed before dark!");
        noText.add("Noodles: I must stay resolved in my endeavor to catch a salmon for dinner!");
        noText.add("Noodles: As I live and breathe, this cat will not go hungry tonight!!!");
        noText.add("Hank the Black Cat: Wow.. That sounds... unbelievably serious.");
        noText.add("Hank the Black Cat: Nevermind, then. Well, good luck, my friend!");
        noText.add("Hank the Black Cat: May your belly be full with the bounties of the ocean!");
        noText.add("Noodles: Thanks, Hank!");
        scene.startDisplayTextThread(noText);
    }

    @Override
    public List<String> getRoomItemText(){
        NoodlesGUI.updateScore(50);
        List<String> toyBirdItemText = new ArrayList<>();

        toyBirdItemText.add("Hank the Black Cat: That was really fun!");
        toyBirdItemText.add("Hank the Black Cat: Hey! I found this toy bird in the park. I prefer watching real birds.");
        toyBirdItemText.add("Hank the Black Cat: Here, take it. You'll find a way to have fun with it!");
        toyBirdItemText.add("Noodles: Hank gave me a toy bird! It does look like fun!");
        toyBirdItemText.add("Noodles: Thanks, Hank!");
        toyBirdItemText.add("Hank the Black Cat: Good luck on your quest!");

        return toyBirdItemText;
    }
}
