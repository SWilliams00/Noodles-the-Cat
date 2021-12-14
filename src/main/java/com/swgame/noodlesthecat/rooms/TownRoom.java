/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/o2s1l2/little_town_pixel_art/
 */

package com.swgame.noodlesthecat.rooms;

import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;
import com.swgame.noodlesthecat.mgclasses.MGWordScramble;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TownRoom extends Room {

    public TownRoom(NoodlesGUI scene) throws FileNotFoundException {
        super(scene);
    }

    @Override
    protected void setBackgroundImageLocation(){
        this.backgroundImageLocation = "/BGTown.png";
    }

    @Override
    protected void setClickables(){}

    @Override
    public List<String> getEnterRoomText(){
        List<String> roomText = new ArrayList<>();

        roomText.add("Noodles: Okay, I made it to town. I'm halfway to the beach!");
        roomText.add("Noodles: I see my fashionable friend, Mittens over there! And she has a new friend!");
        roomText.add("Noodles: Hi, Mittens! You two are very fancy today!");
        roomText.add("Mittens the Fancy Cat: Noodles! This is my friend Spot! We got all dressed up for a visit to town!");
        roomText.add("Spot the Suave Cat: Hi Noodles! We showed off our new looks all morning! I love my new bowtie!");
        roomText.add("Spot the Suave Cat: We were just about to play a game. Do you want to join us?");
        roomText.add("Noodles: Gosh, I don't know... I'm on a mission! Do I have time to play a game? Y/N");

        return roomText;
    }

    public void onYPress(){
        MGWordScramble minigame = new MGWordScramble();
        minigame.setOnClose((e) ->  {
            if(scene.doesNoodlesHaveItem(scene.getItemPool().getBird().getName())) {
                NoodlesGUI.updateScore(50);
                scene.startDisplayTextThread(getRoomItemText());
                scene.removeItem(scene.getItemPool().getBird());
            }
            else {
                List<String> noBirdText = new ArrayList<>();
                noBirdText.add("Noodles: That was a lot of fun, but I've got to get to the beach now.");
                noBirdText.add("Mittens the Fancy Cat: Okay then! That was a great game! We'll see you later!");
                noBirdText.add("Spot the Suave Cat: Thanks for playing, Noodles! It was great to meet you!");
                noBirdText.add("Noodles: See you guys later!");
                scene.startDisplayTextThread(noBirdText);
            }
        });
        minigame.display();
    }
    public void onNPress(){
        NoodlesGUI.updateScore(-10);
        List<String> noText = new ArrayList<>();
        noText.add("Noodles: I would love to play but I have to get to the beach.");
        noText.add("Noodles: I'm on an epic quest of high stakes and fraught with danger!");
        noText.add("Mittens the Fancy Cat: Oh no! What are you doing?");
        noText.add("Noodles: I'm going to try to catch a salmon for dinner! Hunger is the foe of all cat-kind!");
        noText.add("Mittens the Fancy Cat: Fresh fish?? Ew..");
        noText.add("Spot the Suave Cat: You're right about that, Mittens! But whatever makes you happy, Noodles! Good luck!");
        scene.startDisplayTextThread(noText);
    }

    @Override
    public List<String> getRoomItemText(){
        List<String> giveToyBirdItemText = new ArrayList<>();
        giveToyBirdItemText.add("Noodles: I know! Hank gave me this toy bird.");
        giveToyBirdItemText.add("Noodles: I have to go, but you guys should take it to play with!");
        giveToyBirdItemText.add("Mittens the Fancy Cat: Gosh, Noodles! That would be a lot of fun!");
        giveToyBirdItemText.add("Spot the Suave Cat: We could play with this at the park!");
        giveToyBirdItemText.add("Spot the Suave Cat: Thanks, Noodles! Mittens has the best friends!");
        giveToyBirdItemText.add("Mittens the Fancy Cat: Thanks, Noodles! Maybe we can all play together tomorrow!");
        giveToyBirdItemText.add("Noodles: That would be great! I'll see you guys after I finish my quest!");
        giveToyBirdItemText.add("Mittens the Fancy Cat: Quest??");
        giveToyBirdItemText.add("Noodles: No time now! See ya later!");

        return giveToyBirdItemText;
    }
}
