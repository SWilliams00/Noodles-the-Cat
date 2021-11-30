package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Room;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BeachRoom extends Room {

    public BeachRoom() throws FileNotFoundException {
       // super(left, right);
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
    protected List<String> getRoomText(){
        List<String> roomText = new ArrayList<>();
        roomText.add("Noodles: Ooh! Who's that over there? Her singing is lovely...");
        roomText.add("Noodles: But she sounds...sad..");
        roomText.add("Noodles: Hey there! I'm Noodles the Cat! Are you okay?");
        roomText.add("Eudora the Mercat: Oh, hello there. I'm Eudora, it's good to meet you.");
        roomText.add("Eudora the Mercat: I'm fine, just a little sad. I lost my favorite starfish that I wear as a hat.");
        roomText.add("Eudora the Mercat: I looked everywhere for it but it must have floated away..");
        roomText.add("Eudora the Mercat: But that's okay. Singing makes me feel better! So I'll do that until I'm not sad anymore.");
        roomText.add("Noodles: I'm so sorry! I bet it was a really pretty hat!");
        roomText.add("Noodles: Goodness. She seems really sad. I bet this Fancy Feather would make a nice hat..");
        roomText.add("Noodles: But I wanted to give this to Cathulu so she could help me make a net..");
        roomText.add("Noodles: But I bet this feather would really cheer Eudora up..");
        roomText.add("Noodles: Should I give my Fancy Feather to Eudora? Y/N");


        roomText.add("Noodles: Hey, Eudora! Do you want a shiny feather for your hair?");
        roomText.add("Noodles: I bet it would look as pretty as your starfish did!");
        roomText.add("Eudora the Mercat: ");
        roomText.add("Yay, we're friends");

        return roomText;
    }
}
