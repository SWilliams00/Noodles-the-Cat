/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/kmx13i/pixel_art_of_a_cave_c/
 */

package com.swgame.noodlesthecat.rooms;

import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;
import com.swgame.noodlesthecat.mgclasses.MGCathuluQuiz;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CaveRoom extends Room {

    Room finalRoom = new FinalSceneRoom(scene);

    public CaveRoom(NoodlesGUI scene) throws FileNotFoundException {
        super(scene);
    }

    @Override
    protected void setBackgroundImageLocation() {
        this.backgroundImageLocation = "/BGCave.png";
    }

    @Override
    protected void setClickables() {
        this.clickables = new ArrayList<com.swgame.noodlesthecat.NoodlesGUI.Clickable>() {
        };
    }

    @Override
    public List<String> getEnterRoomText() {
        List<String> roomText = new ArrayList<>();

        roomText.add("Cathulu the Mystical: Who goes there? Who dares to interrupt my commune with the Old Ones?");
        roomText.add("Noodles: Hi. Just me. Hello, Sea-God Cathulu.. I'm Noodles");
        roomText.add("Noodles: I'm a cat..");
        roomText.add("Cathulu the Mystical: Ah, yes. I have been observing your adventures since you embarked upon your quest.");
        roomText.add("Cathulu the Mystical: I know who you are little one.");
        roomText.add("Noodles: You have? You do? How?");
        roomText.add("Cathulu the Transcendent: I see all points of time across infinity.");
        roomText.add("Cathulu the Transcendent: I see the first lights of the opening of this universe..");
        roomText.add("Cathulu the Transcendent: I hear the bells that knell it's closing..");
        roomText.add("Cathulu the Transcendent: And I see all that resides between..");
        roomText.add("Noodles: Whoa. How come you didn't know it was me");
        roomText.add("Cathulu the Transcendent: Time is fickle when you see all that I See");
        roomText.add("Noodles: Do you also just like to be mysterious?");
        roomText.add("Cathulu the Mysterious: Yes. Fewer people bother me that way.");
        roomText.add("Cathulu the Mysterious: You are very observant for one so young.");
        roomText.add("Cathulu the Mysterious: Tell me what brings you to my cave today..");
        roomText.add("Noodles: I wondered if you could help me catch a salmon!");
        roomText.add("Cathulu the Mysterious: I see...");
        roomText.add("Noodles: I thought I could give you a gift... And I have some stuff I thought might help catch a fish..");
        roomText.add("Cathulu the Mysterious: I have no need for material objects!");
        roomText.add("Cathulu the Overencumbered: The sea is wet and I have no pockets..");
        roomText.add("Cathulu the Mysterious: I seek amusement...");
        roomText.add("Cathulu the Mysterious: I will ask you questions, entertain me with your answers");
        roomText.add("Cathulu the Mysterious: Do this and we will discuss the completion of your quest.");
        roomText.add("Press Y to continue");

        return roomText;
    }

    public void onYPress() {

        MGCathuluQuiz minigame = new MGCathuluQuiz();
        minigame.setOnClose((e) ->  {
            scene.startDisplayTextThread(getRoomItemText());
        });
        minigame.display();
    }

    public void onNPress() {
        scene.createFinalScene();
    }

    @Override
    public List<String> getRoomItemText(){
        List<String> endOfGameText = new ArrayList<>();
        endOfGameText.add("Cathulu the Kindly: You know much for one so.. fuzzy. I am amused.");
        endOfGameText.add("Cathulu the Kindly: Tell me, Noodles. Why was this quest important to you?");
        endOfGameText.add("Noodles: I had a dream! I crossed magical realms, fought mythical beasts, slayed a giant salmon!");
        endOfGameText.add("Noodles: I was sad after I woke up, I never do anything heroic or fun like that..");
        endOfGameText.add("Noodles: I wanted to have an adventure and catch a real salmon! To be brave and heroic!");
        endOfGameText.add("Cathulu the Wizened: And has your quest been a success?");
        endOfGameText.add("Noodles: Well. I'm not eating a salmon right now..");
        endOfGameText.add("Cathulu the Wizened: Yes, but, did you travel far?");
        endOfGameText.add("Noodles: Well, the beach is kinda far from my house..");
        endOfGameText.add("Cathulu the Wizened: And did you brave mythical beasts?");
        endOfGameText.add("Noodles: You're not a beast! But coming to ask for your help *was* a little scary");
        endOfGameText.add("Cathulu the Wizened: And did you meet other new people?");
        endOfGameText.add("Noodles: Yeah! I met Ronto and Spot and Eudora. Eudora says 'Hi!'");
        endOfGameText.add("Cathulu the Wizened: Ah yes, Eudora is my closest friend, I am pleased that you met her.");
        endOfGameText.add("Cathulu the Wizened: Tell me, Noodles. You do not have a fish. But have you had an adventure?");
        endOfGameText.add("Noodles: I haven't looked at it that way! I did!");
        endOfGameText.add("Noodles: I met a bunch of new people, made a harrowing journey to a new land, and conquered my fears!");
        endOfGameText.add("Noodles: And I'll have a new story to tell all my friends tomorrow! I did have an adventure!");
        endOfGameText.add("Cathulu the Wizened: Yes you did, little one. You should be proud.");
        endOfGameText.add("Noodles: I think Hank is right...eating a raw fish sounds kinda gross.. I didn't think this through..");
        endOfGameText.add("Noodles: My food at home has gravy.. Fresh salmon doesn't come with any gravy, right?");
        endOfGameText.add("Cathulu the Wizened: No. Ocean fish do not come with a side of gravy..");
        endOfGameText.add("Cathulu the Wizened: I do not find it gross, but I am a creature of the sea.");
        endOfGameText.add("Cathulu the Wizened: And you, a creature of the land, are accustomed to tasty processed foods.");
        endOfGameText.add("Cathulu the Wizened: I would conjure you a fish if you want one, but such treasures from the ocean should not be wasted.");
        endOfGameText.add("Noodles: Cathulu... I don't think I want a fish anymore. Actually, I'm ready for another nap..");
        endOfGameText.add("Noodles: I've had such a long adventure! But, there is maybe something else I want...");
        endOfGameText.add("Cathulu the Suspicious: Yes?");
        endOfGameText.add("Noodles: Cathulu? Will you be my friend?");
        endOfGameText.add("Cathulu the Honored: Why yes, Noodles. Of course I will :)");
        endOfGameText.add("Press N to finish game");

        return endOfGameText;
    }
}
