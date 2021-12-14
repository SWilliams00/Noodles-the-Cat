package com.swgame.noodlesthecat.rooms;

import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;

import java.io.FileNotFoundException;
import java.util.List;

public class FinalSceneRoom extends Room {
    public FinalSceneRoom(NoodlesGUI scene) throws FileNotFoundException {
        super(scene);
    }

    @Override
    protected void setBackgroundImageLocation() {this.backgroundImageLocation = "/BGFinalScene.png";}

    @Override
    protected void setClickables() {}

    @Override
    public List<String> getEnterRoomText() {return null;}

    @Override
    public List<String> getRoomItemText() {return null;}

    @Override
    public void onYPress() {}

    @Override
    public void onNPress() {}
}
