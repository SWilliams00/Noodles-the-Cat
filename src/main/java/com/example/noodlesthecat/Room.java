package com.example.noodlesthecat;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.FileNotFoundException;
import java.util.List;

public abstract class Room {
    private BackgroundImage backgroundImage;
    protected String backgroundImageLocation;
    Room left;
    Room right;
    protected List<String> commands;
    protected List<Clickable> clickables;
    protected List<String> roomText;

    public Room() throws FileNotFoundException {

        setBackgroundImageLocation();
        setBackgroundImage();
        setClickables();
        setCommands();
        getRoomText();

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

    public List<String> getCommands() {
        return commands;
    }

    public List<Clickable> getClickables() {
        return clickables;
    }

    protected abstract void setBackgroundImageLocation();
    protected abstract void setCommands();
    protected abstract void setClickables();
    protected abstract List<String> getRoomText();



    private void setBackgroundImage() throws FileNotFoundException {
        Image image = new Image(backgroundImageLocation);
        this.backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }
}
