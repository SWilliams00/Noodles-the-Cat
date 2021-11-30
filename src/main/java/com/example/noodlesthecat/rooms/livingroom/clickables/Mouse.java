package com.example.noodlesthecat.rooms.livingroom.clickables;

import com.example.noodlesthecat.Clickable;
import javafx.scene.image.Image;

public class Mouse extends Clickable {

    Mouse() {
        this.height = 60;
        this.width = 60;
        this.image = new Image("MouseImage");

    }


    @Override
    public void actionPerformed() {

    }
}
