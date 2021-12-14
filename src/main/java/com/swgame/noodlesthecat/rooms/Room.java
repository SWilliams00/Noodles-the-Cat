/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
References for setting background image: https://stackoverflow.com/questions/9738146/javafx-how-to-set-scene-background-image
 */

package com.swgame.noodlesthecat.rooms;

import com.swgame.noodlesthecat.NoodlesGUI.Clickable;
import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private BackgroundImage backgroundImage;
    protected String backgroundImageLocation;
    Room left;
    Room right;
    protected List<Clickable> clickables;
    protected NoodlesGUI scene;

    public Room(NoodlesGUI scene) throws FileNotFoundException {
        this.scene = scene;
        clickables = new ArrayList<>();
        setBackgroundImageLocation();
        setBackgroundImage();
        setClickables();
        getEnterRoomText();
    }

    public BackgroundImage getBackgroundImage() {
        return backgroundImage;
    }

    public Room getLeft() {
        return left;
    }

    public void setLeft(Room left) {
        this.left = left;
    }

    public Room getRight() {
        return right;
    }

    public void setRight(Room right) {
        this.right = right;
    }

    public List<Clickable> getClickables() {
        return clickables;
    }

    protected abstract void setBackgroundImageLocation();
    protected abstract void setClickables();
    public abstract List<String> getEnterRoomText();
    public abstract List<String> getRoomItemText();
    public abstract void onYPress();
    public abstract void onNPress();

    private void setBackgroundImage() throws FileNotFoundException {
        Image image = new Image(backgroundImageLocation);
        this.backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }
}
