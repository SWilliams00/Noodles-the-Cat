/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
ItemPool class */

package com.swgame.noodlesthecat.NoodlesGUI;

public class ItemPool {
    private Item feather;
    private Item foil;
    private Item bird;
    private Item fancy_feather;
    private Item string;

    public ItemPool() {
        feather = new Item("/ItemFeather.png", "Feather");
        foil = new Item("/ItemFoil.png", "Foil");
        bird = new Item("/ItemBird.png", "Toy Bird");
        fancy_feather = new Item("/ItemFancyFeather.png", "Fancy Feather");
        string = new Item("/ItemString.png", "String");
    }

    public Item getFeather() {
        return feather;
    }

    public Item getFoil() {
        return foil;
    }

    public Item getBird() {
        return bird;
    }

    public Item getFancy_feather() {
        return fancy_feather;
    }

    public Item getString() {
        return string;
    }
}
