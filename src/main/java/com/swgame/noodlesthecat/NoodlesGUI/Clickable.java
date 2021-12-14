/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
Clickable class - Sets framework for all clickable Item objects
API for all imported libraries used as references.
*/

package com.swgame.noodlesthecat.NoodlesGUI;

import com.swgame.noodlesthecat.rooms.Room;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Clickable {

    NoodlesGUI game;
    public Clickable(NoodlesGUI game) {
        this.game = game;
    }
    protected Coordinates topLeft;
    protected int width;
    protected int height;
    protected Item item;

    public Coordinates getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Coordinates topLeft) {
        this.topLeft = topLeft;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    /*Click event called when item present in scene is clicked. Calls methods to display new item's
    text and updates image location/score */
    public EventHandler<MouseEvent> getClickEvent(Room currentRoom) {
        return mouseEvent -> {
            NoodlesGUI.updateScore(getItem().getScore());
            game.addItem(getItem());
            game.startDisplayTextThread(currentRoom.getRoomItemText());
            game.removeItemFromDisplay((Button) mouseEvent.getSource());
        };
    }
}
