package com.example.noodlesthecat;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public abstract class Clickable {

    protected Coordinates topLeft;
    protected int width;
    protected int height;
    protected Image image;

    abstract public void actionPerformed();

    public List<String> itemText(){

        List <String> featherItemText = new ArrayList<>();
        featherItemText.add("Noodles: Uh oh! I left my new feather on the floor!");
        featherItemText.add("Noodles: I had such a great time playing with that yesterday");
        featherItemText.add("Noodles: Maybe I should bring it with me.. What if I get bored?");
        featherItemText.add("Noodles: What if I need to show off what a great hunter I am?");

        List<String> foilItemText = new ArrayList<>();
        foilItemText.add("Noodles: Ooh, that foil is shiny!");
        foilItemText.add("Noodles: Like shiny salmon scales...");
        foilItemText.add("Noodles: Play..? No! Stay focused!");
        foilItemText.add("Noodles: Wait.");
        foilItemText.add("Noodles: I'm having a genius idea");
        foilItemText.add("Noodles: Yes.");
        foilItemText.add("Noodles: No...");
        foilItemText.add("Noodles: Yes!");
        foilItemText.add("Noodles: I know what I'm going to do today!");
        foilItemText.add("Noodles: I'm going to go to the beach and catch a salmon!");
        foilItemText.add("Noodles: Salmon like shiny things, right?");
        foilItemText.add("Noodles: I'm going to take this with me..");
        foilItemText.add("Noodles: Maybe I can find something to make a fishing pole or net with.");

        List<String> toyBirdItemText = new ArrayList<>();
        toyBirdItemText.add("Hank the Black Cat: That was a great game! Thanks for playing with me!");
        toyBirdItemText.add("Hank the Black Cat: I found this toy bird in the park. I prefer watching real birds.");
        toyBirdItemText.add("Hank the Black Cat: Here, take it. You'll find a way to have fun with it!");
        toyBirdItemText.add("Noodles: Hank gave me a toy bird!");
        toyBirdItemText.add("Noodles: It does look like fun!");
        toyBirdItemText.add("Noodles: Thanks, Hank!");
        toyBirdItemText.add("Noodles: Say, I'm off to the beach to catch a salmon. Want to come?");
        toyBirdItemText.add("Hank the Black Cat: No, no. You go on without me. It's been a busy morning.");
        toyBirdItemText.add("Hank the Black Cat: I'm ready for a nap. Tell me all about your adventures tomorrow.");

        List<String> fancyFeatherItemText = new ArrayList<>();
        fancyFeatherItemText.add("Noodles: Ronto gave me a Fancy Feather!");
        fancyFeatherItemText.add("Noodles: This doesn't look like it came from a real bird.");
        fancyFeatherItemText.add("Noodles: It's too fancy to play with..");
        fancyFeatherItemText.add("Noodles: I don't think I can fish with it..");
        fancyFeatherItemText.add("Noodles: But a gift is a gift!");
        fancyFeatherItemText.add("Noodles: Thanks Ronto! I'll see you later!");
        fancyFeatherItemText.add("Noodles: I'll sure miss that feather but I'm glad I made a new friend.");

        List<String> stringItemText = new ArrayList<>();
        stringItemText.add("Noodles: Thanks, Toby! This string looks useful! Maybe I can make a fishing net?");
        stringItemText.add("Noodles: But I don't know how...");
        stringItemText.add("Toby the Fox: I don't know how to make a net either...");
        stringItemText.add("Toby the Fox: You know, I've heard rumors that the mythical Cathulu is staying nearby.");
        stringItemText.add("Toby the Fox: She would know how to make a net..");
        stringItemText.add("Toby the Fox: But, Noodles.. She sounds scary and I don't think she gives away anything for free..");
        stringItemText.add("Noodles: Well.. I love meeting new friends AND I really want a salmon..");
        stringItemText.add("Noodles: I know! I have this Fancy Feather that a friend gave me!");
        stringItemText.add("Noodles: It's sooooo fancy! And shiny!");
        stringItemText.add("Noodles: Maybe Cathulu would teach me how to make a net if I gave her a nice present?");
        stringItemText.add("Noodles: I have a plan! I'm off to find Cathulu!");
        stringItemText.add("Toby the Fox: Good luck, Noodles! I'll be sad if you get eaten!");


        return featherItemText;


    }

}
