/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
Background image: https://www.reddit.com/r/PixelArt/comments/g0tqpj/berlin_backyard/
 */

package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Room;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BackyardRoom extends Room {
    public BackyardRoom() throws FileNotFoundException {
    }

    @Override
    protected void setBackgroundImageLocation() {
        this.backgroundImageLocation = "/BGBackyard.png";
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

        roomText.add("Noodles: Howdy, Hank! It's a beautiful morning for adventure!");
        roomText.add("Hank the Black Cat: Why yes it is! I spent all morning in the park.");
        roomText.add("Hank the Black Cat: There were so many birds today! I counted them all!");
        roomText.add("Hank the Black Cat: But then they all flew away and now I don't have anything to do.");
        roomText.add("Hank the Black Cat: Would you want to play a game with me?");
        roomText.add("Noodles: Well, I do love games... But I also want to get to the beach before dark.");
        roomText.add("Noodles: I'm going on an adventure to catch a salmon!");
        roomText.add("Noodles: Should I take a break to play a game with my friend? Y/N");

        return roomText;
    }

    public List<String> getYesText(){
        return null;
    }
    public List<String> getNoText(){
        List<String> noText = new ArrayList<>();

        noText.add("Noodles: I wish I could, Hank, but this quest is dangerous, perilous,");
        noText.add("Noodles: and of the utmost importance that it be completed before dark!");
        noText.add("Noodles: I must stay resolved in my endeavor to catch a salmon for dinner!");
        noText.add("Noodles: As I live and breathe, this cat will not go hungry tonight!!!");
        noText.add("Hank the Black Cat: Wow.. That sounds... unbelievably serious.");
        noText.add("Hank the Black Cat: Isn't your kitchen full of food? I can see all the cans through the window...");
        noText.add("Noodles: Fancy Feast salmon is not real salmon! It's tuna with a blue label!");
        noText.add("Hank the Black Cat: Okay! Nevermind. Well, good luck, my friend!");
        noText.add("Hank the Black Cat: May your belly be full with the bounties of the ocean!");
        noText.add("Noodles: Thanks, Hank!");

        return noText;
    }
}
