/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/gg3oe8/a_nice_beach_shore/
 */

package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.NoodlesGUI;
import com.example.noodlesthecat.Room;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BeachRoom extends Room {

    public BeachRoom(NoodlesGUI scene) throws FileNotFoundException {
        super(scene);
    }

    @Override
    protected void setBackgroundImageLocation(){
        this.backgroundImageLocation = "/BGBeach.png";
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
    public List<String> getEnterRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Noodles: Ooh! Who's that over there? Her singing is lovely...");
        roomText.add("Noodles: But she sounds...sad..");
        roomText.add("Noodles: Hey there! I'm Noodles the Cat!");
        roomText.add("Eudora the Mercat: Oh, hello there! I'm Eudora, it's good to meet you.");
        roomText.add("Eudora the Mercat: I've never seen you at the beach before. Are you here to have a picnic?");
        roomText.add("Noodles the Cat: I am on a mighty quest to catch a salmon!");
        roomText.add("Noodles the Cat: I have a lure and some string, but I don't know how to make a net..");
        roomText.add("Noodles the Cat: My friend told me that Cathulu is here. I wanted to ask for her help.");
        roomText.add("Noodles the Cat: Do you know where she is?");
        roomText.add("Eudora the Mercat: Ooh! Cathulu is one of my best friends!");
        roomText.add("Eudora the Mercat: She is wise in the deep workings of the nature of the universe..");
        roomText.add("Eudora the Mercat: Fearsome to behold! A harbinger of truth and knowledge..");
        roomText.add("Eudora the Mercat: We collect seashells together! And she taught me how to build sandcastles that don't wash away!");
        roomText.add("Eudora the Mercat: She can be tricky though.. I don't think she likes strangers..");
        roomText.add("Noodles the Cat: All I can do is try! I brought her a present! And I have lots of friends..");
        roomText.add("Noodles the Cat: Maybe I can be Cathulu's friend too!");
        roomText.add("Eudora the Mercat: You seem really nice! She's staying in a cave over there, conferring with the Old Ones.");
        roomText.add("Eudora the Mercat: She's really nice when you get to know her. I think she'll help you.");
        roomText.add("Noodles the Cat: Thanks, Eudora! Say, are you okay? You sounded a little sad when you were singing..");
        roomText.add("Eudora the Mercat: I am a little sad. I lost my favorite starfish that I wear as a hat.");
        roomText.add("Eudora the Mercat: I looked everywhere for it but it must have floated away..");
        roomText.add("Eudora the Mercat: But that's okay. Singing makes me feel better! So I'll do that until I'm not sad anymore.");
        roomText.add("Noodles: I'm so sorry! I bet it was a really pretty hat!");
        roomText.add("Noodles: Goodness. She seems really sad. I bet this Fancy Feather would make a nice hat..");
        roomText.add("Noodles: But I wanted to give this to Cathulu so she could help me make a net..");
        roomText.add("Noodles: But I bet this feather would really cheer Eudora up..");
        roomText.add("Noodles: Should I give my Fancy Feather to Eudora? Y/N");

        return roomText;
    }

    public void onYPress(){
        List<String> yesText = new ArrayList<>();

        yesText.add("Noodles: Hey, Eudora! Take this shiny feather! I bet it will make a pretty hat!");
        yesText.add("Eudora the Mercat: Really? Are you sure?");
        yesText.add("Eudora the Mercat: Ooh! It IS really pretty!");
        yesText.add("Eudora the Mercat: It's perfect! It matches my tail! Thank you, Noodles!");
        yesText.add("Noodles: It will be a perfect hat! I'm glad it made you happy!");
        yesText.add("Eudora the Mercat: Cathulu is really going to like you! Tell her I said 'Hi!'");
        scene.startDisplayTextThread(yesText);
    }
    public void onNPress(){
        List<String> noText = new ArrayList<>();

        noText.add("Noodles: I hope you feel better soon!");
        noText.add("Noodles: Maybe I can come back tomorrow and we can build sandcastles!");
        noText.add("Eudora the Mercat: That would be a lot of fun! Bye, Noodles!");

        scene.startDisplayTextThread(noText);
    }
}
