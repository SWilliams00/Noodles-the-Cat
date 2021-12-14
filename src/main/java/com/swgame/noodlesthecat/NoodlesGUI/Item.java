/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
Item class - Sets framework for in-game items
API for all imported libraries used as references.
*/

package com.swgame.noodlesthecat.NoodlesGUI;

import javafx.scene.image.Image;
import java.util.Objects;

public class Item {
    private String imagePath;
    private String name;
    private int score;


    public Item(String imagePath, String name) {
        this.imagePath = imagePath;
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Image getImage() {
        return new Image(getImagePath());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return score == item.score && Objects.equals(imagePath, item.imagePath) && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imagePath, name, score);
    }
}
