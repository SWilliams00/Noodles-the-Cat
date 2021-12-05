/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
References for Task/Threading: https://docs.oracle.com/javafx/2/threads/jfxpub-threads.htm
        http://tutorials.jenkov.com/javafx/concurrency.html
        https://stackoverflow.com/questions/22772379/updating-ui-from-different-threads-in-javafx
 */

package com.example.noodlesthecat;

import com.example.noodlesthecat.rooms.livingroom.LivingRoom;
import com.example.noodlesthecat.rooms.livingroom.clickables.*;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.FileNotFoundException;


public class NoodlesGUI extends Application {

    private HBox itemsHeld;
    protected Label gameText;
    private Button leftArrow;
    private Button rightArrow;
    private StackPane centerPanel;
    private Room currentRoom;
    private Room roomToGoTo;
    private BorderPane root;
    private Room livingRoom, kitchen, backyard, park;
    private Room town, woods, beach, cave;
    ImageView view;

    public EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
        }
    };

    public void keyPressed(KeyCode keyCode){
        if(keyCode == KeyCode.Y){
            currentRoom.getYesText();
        }
        if(keyCode == KeyCode.N){
            currentRoom.getNoText();
        }
    }

    @Override
    public void start(Stage firstStage) {
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

    //Sets root as a border pane and builds scene with each section in its own method
    private BorderPane buildGameScene() {
        root = new BorderPane();
        addCenter(currentRoom);
        addButtons();
        addItemsBar();
        addLabels();

        changeRoom(currentRoom);
        return root;
    }

    public static void main(String[] args) {
        launch();
    }

    //Initializes room objects and assigns left/right positions. Sets starting room as Living Room
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

    //Builds center panel of the root border pane. Sets background image based off of current room
    private void addCenter(Room currentRoom) {
        centerPanel = new StackPane();
        Background background = new Background(currentRoom.getBackgroundImage());
        centerPanel.setBackground(background);
        centerPanel.setPrefHeight(600);
        centerPanel.setPrefWidth(800);
        root.setCenter(centerPanel);
    }

    /*Creates side panels for root border pane, adds left/right arrow buttons with assigned click events.
        Clicking the arrows navigates to the next room based on current room's left/right assignments.*/
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

    //Creates top panel for root border pane. Items collected in game will display here.
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

    /*Creates bottom panel for root border pane. Applies a label where the gameplay text will display.
        Formats the output of the label text.*/
    private void addLabels() {

        StackPane bottomPanel = new StackPane();
        bottomPanel.setPrefWidth(1000);
        bottomPanel.setPrefHeight(200);
        bottomPanel.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        gameText = new Label("");
        gameText.setMinWidth(600);
        gameText.setMinHeight(150);
        gameText.setWrapText(true);
        gameText.setTextAlignment(TextAlignment.CENTER);
        gameText.setMaxWidth(600);
        gameText.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        gameText.setFont(new Font("Georgia", 24));

        bottomPanel.getChildren().add(gameText);
        gameText.setAlignment(Pos.CENTER);
        root.setBottom(bottomPanel);
        BorderPane.setAlignment(bottomPanel, Pos.BOTTOM_CENTER);
    }

    /*Called when loading each new room. Updates background image and runs the text for each room.
        Reassigns currentRoom object to the new room that was entered.*/
    private void changeRoom(Room roomToGoTo) {
        Background background = new Background(roomToGoTo.getBackgroundImage());
        centerPanel.setBackground(background);
        this.currentRoom = roomToGoTo;

        gameText.setOnKeyPressed((x) -> {keyPressed(KeyCode.Y);});
        gameText.setOnKeyPressed((x) -> {keyPressed(KeyCode.N);});

        /*Task created to manage text output thread. This allows the room to load and display first, then run the
        room's text for the user to read. Output is set on a timer that varies based on the length of each line.*/
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for(String text : roomToGoTo.getEnterRoomText()) {
                    updateMessage(text);
                    if(text.length() > 35){
                        Thread.sleep(4000);
                    }
                   else Thread.sleep(2000);
                }
                return null;
            }
        };
        gameText.textProperty().bind(task.messageProperty());
        new Thread(task).start();
    }
}