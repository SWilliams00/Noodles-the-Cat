package com.example.noodlesthecat;

import com.example.noodlesthecat.rooms.livingroom.LivingRoom;
import com.example.noodlesthecat.rooms.livingroom.clickables.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class NoodlesGUI extends Application {

    private HBox itemsHeld;
    protected Label gameText;
    private TextField userText;
    private Button leftArrow;
    private Button rightArrow;
    private StackPane centerPanel;
    private Room currentRoom;
    private Room roomToGoTo;
    private BorderPane root;
    private Room livingRoom, kitchen, backyard, park;
    private Room town, woods, beach, cave;
    ImageView view;

    @Override
    public void start(Stage firstStage){
        try {
            loadRooms();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading rooms from images");
        }
        BorderPane root = buildGameScene();
        firstStage.setTitle("Noodles!");
        Scene scene = new Scene(root, 1000, 900);
        firstStage.setScene(scene);
        firstStage.show();
    }

    private BorderPane buildGameScene(){
        root = new BorderPane();
        addCenter(currentRoom);
        addButtons();
        addItemsBar();
        addLabels();
        roomOutput();

        changeRoom(currentRoom);

        return root;
    }

    public static void main(String[] args) {
        launch();
    }

    private void loadRooms() throws FileNotFoundException {

        livingRoom = new LivingRoom();
        kitchen = new KitchenRoom();
        backyard = new BackyardRoom();
        park = new ParkRoom();
        town = new TownRoom();
        woods = new WoodsRoom();
        beach = new BeachRoom();
        cave = new CaveRoom();

        livingRoom.setLeft(backyard);
        livingRoom.setRight(kitchen);
        kitchen.setLeft(livingRoom);
        kitchen.setRight(backyard);
        backyard.setLeft(kitchen);
        backyard.setRight(park);
        park.setLeft(backyard);
        park.setRight(town);
        town.setLeft(park);
        town.setRight(woods);
        woods.setLeft(town);
        woods.setRight(beach);
        beach.setLeft(woods);
        beach.setRight(cave);
        cave.setLeft(beach);
        cave.setRight(livingRoom);

        currentRoom = livingRoom;
    }

    private void addCenter(Room currentRoom) {
        centerPanel = new StackPane();
        Background background = new Background(currentRoom.getBackgroundImage());
        centerPanel.setBackground(background);
        centerPanel.setPrefHeight(600);
        centerPanel.setPrefWidth(800);
        root.setCenter(centerPanel);
    }

    private void addButtons() {
        Image leftButton = new Image("/leftArrow.png");
        view = new ImageView(leftButton);
        StackPane leftSide = new StackPane();
        leftSide.setPrefWidth(100);
        leftSide.setPrefHeight(600);
        leftSide.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        leftArrow = new Button();
        leftArrow.setGraphic(view);
        leftSide.getChildren().add(leftArrow);
        root.setLeft(leftSide);
        leftArrow.setOnAction((x) -> changeRoom(currentRoom.getLeft()));

        Image rightButton = new Image("/rightArrow.png");
        view = new ImageView(rightButton);
        StackPane rightSide = new StackPane();
        rightSide.setPrefWidth(100);
        rightSide.setPrefHeight(600);
        rightSide.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        rightArrow = new Button();
        rightArrow.setGraphic(view);
        rightSide.getChildren().add(rightArrow);
        root.setRight(rightSide);
        rightArrow.setOnAction((x) -> changeRoom(currentRoom.getRight()));
    }

    private void addItemsBar() {
        itemsHeld = new HBox();
        Label itemExample = new Label("Items here");
        itemsHeld.getChildren().add(itemExample);
        itemExample.setAlignment(Pos.CENTER); //*********
        itemsHeld.setPrefWidth(1000);
        itemsHeld.setPrefHeight(100);
        itemsHeld.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setTop(itemsHeld);
        BorderPane.setAlignment(itemsHeld, Pos.TOP_RIGHT);
    }

    private void addLabels() {

        StackPane bottomPanel = new StackPane();
        bottomPanel.setPrefWidth(1000);
        bottomPanel.setPrefHeight(200);
        bottomPanel.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        gameText = new Label("");
        gameText.setMinWidth(600);
        gameText.setMinHeight(150);
        gameText.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        gameText.setFont(new Font("Veranda", 24));

        //   currentRoom.roomOutput();
        bottomPanel.getChildren().add(gameText);
        gameText.setAlignment(Pos.CENTER);
        root.setBottom(bottomPanel);
        BorderPane.setAlignment(bottomPanel, Pos.BOTTOM_CENTER);
    }

    private void changeRoom(Room roomToGoTo) {
        Background background = new Background(roomToGoTo.getBackgroundImage());
        centerPanel.setBackground(background);
        this.currentRoom = roomToGoTo;
        new Thread(this::roomOutput).start();
    }

    private void roomOutput() {
        for (String outputText : currentRoom.getRoomText()) {
            gameText.setText(outputText);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}