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
import javafx.event.EventType;
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
import java.util.List;


public class NoodlesGUI extends Application {

    private HBox itemsHeld;
    protected Label gameText;
    private Button leftArrow;
    private Button rightArrow;
    private Pane centerPanel;
    private Room currentRoom;
    private Room roomToGoTo;
    Scene gameScene;
    private BorderPane root;
    private Room livingRoom, kitchen, backyard, park;
    private Room town, woods, beach, cave;
    private Button buttonToAdd;

    private static final int LONG_TEXT_DISPLAY_TIME = 10;
    private static final int SHORT_TEXT_DISPLAY_TIME = 5;

    public EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
        }
    };

    public void keyPressed(KeyCode keyCode) {
        if (keyCode.equals(KeyCode.Y)) {
            currentRoom.onYPress();
        }
        if (keyCode.equals(KeyCode.N)) {
            currentRoom.onNPress();
        }
    }

    @Override
    public void start(Stage firstStage) {
        try {
            loadRooms();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading rooms from images");
        }

        root = buildGameScene();
        firstStage.setTitle("Noodles!");
        gameScene = new Scene(root, 1000, 900);

        firstStage.setScene(gameScene);
        changeRoom(currentRoom);
        firstStage.show();
    }

    //Sets root as a border pane and builds scene with each section in its own method
    private BorderPane buildGameScene() {
        root = new BorderPane();
        addCenter(currentRoom);
        addButtons();
        addItemsBar();
        addLabels();

        return root;
    }

    public static void main(String[] args) {
        launch();
    }

    //Initializes room objects and assigns left/right positions. Sets starting room as Living Room
    private void loadRooms() throws FileNotFoundException {

        livingRoom = new LivingRoom(this);
        kitchen = new KitchenRoom(this);
        backyard = new BackyardRoom(this);
        park = new ParkRoom(this);
        town = new TownRoom(this);
        woods = new WoodsRoom(this);
        beach = new BeachRoom(this);
        cave = new CaveRoom(this);

        livingRoom.setLeft(cave);
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
        centerPanel = new Pane();
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
        ImageView view = new ImageView(leftButton);
        StackPane leftSide = new StackPane();
        leftSide.setPrefWidth(100);
        leftSide.setPrefHeight(600);
        leftSide.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        leftArrow = new Button();
        leftArrow.setGraphic(view);
        leftSide.getChildren().add(leftArrow);
        root.setLeft(leftSide);
        leftArrow.addEventHandler(MouseEvent.MOUSE_CLICKED, (x) -> changeRoom(currentRoom.getLeft()));

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
        rightArrow.addEventHandler(MouseEvent.MOUSE_CLICKED, (x) -> changeRoom(currentRoom.getRight()));
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

        getClickablesAsButtons(centerPanel, roomToGoTo.getClickables());
        startDisplayTextThread(roomToGoTo.getEnterRoomText());
    }

    public void startDisplayTextThread(List<String> stringsToDisplay) {
        //Task created to manage text output thread. This allows the room to load and display first, then run the
        //room's text for the user to read. Output is set on a timer that varies based on the length of each line.
        gameScene.setOnKeyPressed(null);
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (String text : stringsToDisplay) {
                    if (text.equals(stringsToDisplay.get(0))) {
                        updateMessage(text);
                    }
                    else {
                        if (text.length() > 35) {
                            Thread.sleep(LONG_TEXT_DISPLAY_TIME);
                        } else Thread.sleep(SHORT_TEXT_DISPLAY_TIME);
                        updateMessage(text);
                    }
                }
                return null;
            }
        };
        task.setOnSucceeded((x) ->
                gameScene.setOnKeyPressed((k) ->
                        keyPressed(k.getCode())));
        gameText.textProperty().bind(task.messageProperty());
        Thread textThread = new Thread(task);
        textThread.start();
    }

    public void getClickablesAsButtons(Pane pane, List<Clickable> clickables) {
        for (Clickable clickable : clickables) {
            Image clickableImage = clickable.getImage();
            ImageView view = new ImageView(clickableImage);
            view.setFitHeight(clickable.getHeight());
            view.setFitWidth(clickable.getWidth());
            view.setX(clickable.getTopLeft().x);
            view.setY(clickable.getTopLeft().y);
            buttonToAdd = new Button();
            buttonToAdd.setBackground(Background.EMPTY);
            buttonToAdd.setMinWidth(clickable.getWidth());
            buttonToAdd.setMaxWidth(clickable.getWidth());
            buttonToAdd.setMinHeight(clickable.getHeight());
            buttonToAdd.setMaxHeight(clickable.getHeight());
            buttonToAdd.setGraphic(view);
            buttonToAdd.addEventHandler(EventType.ROOT, clickable.getClickEvent());
            buttonToAdd.setLayoutX(clickable.getTopLeft().x);
            buttonToAdd.setLayoutY(clickable.getTopLeft().y);
            pane.getChildren().add(buttonToAdd);

        }
    }

}