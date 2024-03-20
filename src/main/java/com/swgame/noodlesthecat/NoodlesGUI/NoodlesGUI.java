/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
API for all imported libraries used as references.
References for Task/Threading: https://docs.oracle.com/javafx/2/threads/jfxpub-threads.htm
        http://tutorials.jenkov.com/javafx/concurrency.html
        https://stackoverflow.com/questions/22772379/updating-ui-from-different-threads-in-javafx
Reference for disabling clickable buttons: https://stackoverflow.com/questions/40707131/how-to-enable-or-disable-the-buttons-in-javafx-form
 */

package com.swgame.noodlesthecat.NoodlesGUI;

import com.swgame.noodlesthecat.rooms.*;
import com.swgame.noodlesthecat.rooms.LivingRoom;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class NoodlesGUI extends Application {

    protected Label gameText;
    private Pane centerPanel;
    private Room currentRoom;
    static Scene gameScene;
    private BorderPane root;
    public static int score = 0;
    protected static Label scoreLabel;
    private Set<Item> itemInventory;
    private ItemPool itemPool;
    HBox topPanel;
    Button leftArrow, rightArrow;

    private static final int SHORT_TEXT_DISPLAY_TIME = 2000;
    private static final int MEDIUM_TEXT_DISPLAY_TIME = 3500;
    private static final int LONG_TEXT_DISPLAY_TIME = 4000;

    private Background panelBackground = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
    private Background labelBackground = new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY));

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
        itemPool = new ItemPool();
        itemInventory = new HashSet<>();
        try {
            loadRooms();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading rooms from images");
        }

        root = buildGameScene();
        firstStage.setTitle("Noodles!");
        gameScene = new Scene(root, 1000, 950);

        firstStage.setScene(gameScene);
        changeRoom(currentRoom);
        firstStage.show();
    }

    //Sets root as a border pane and builds scene with each section in its own method
    private BorderPane buildGameScene() {
        root = new BorderPane();
        addCenter(currentRoom);
        addButtons();
        addScoreAndItemsBar();
        addLabels();

        return root;
    }

    public static void main(String[] args) {
        launch();
    }

    //Initializes room objects and assigns left/right positions. Sets starting room as Living Room
    private void loadRooms() throws FileNotFoundException {

        Room livingRoom = new LivingRoom(this);
        Room kitchen = new KitchenRoom(this);
        Room backyard = new BackyardRoom(this);
        Room park = new ParkRoom(this);
        Room town = new TownRoom(this);
        Room woods = new WoodsRoom(this);
        Room beach = new BeachRoom(this);
        Room cave = new CaveRoom(this);

        livingRoom.setLeft(kitchen);
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
        cave.setLeft(cave);
        cave.setRight(cave);

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
        Image leftButton = new Image("/LeftArrow.png");
        ImageView view = new ImageView(leftButton);
        StackPane leftSide = new StackPane();
        leftSide.setPrefWidth(100);
        leftSide.setPrefHeight(600);
        leftSide.setBackground(panelBackground);
        leftArrow = new Button();
        leftArrow.setGraphic(view);
        leftSide.getChildren().add(leftArrow);
        root.setLeft(leftSide);
        leftArrow.addEventHandler(MouseEvent.MOUSE_CLICKED, (x) -> changeRoom(currentRoom.getLeft()));

        Image rightButton = new Image("/RightArrow.png");
        view = new ImageView(rightButton);
        StackPane rightSide = new StackPane();
        rightSide.setPrefWidth(100);
        rightSide.setPrefHeight(600);
        rightSide.setBackground(panelBackground);
        rightArrow = new Button();
        rightArrow.setGraphic(view);
        rightSide.getChildren().add(rightArrow);
        root.setRight(rightSide);
        rightArrow.addEventHandler(MouseEvent.MOUSE_CLICKED, (x) -> changeRoom(currentRoom.getRight()));
    }

    //Creates top panel for root border pane. Items collected in game will display here.
    private void addScoreAndItemsBar() {
        topPanel = new HBox();
        topPanel.setPrefWidth(1000);
        topPanel.setPrefHeight(100);
        topPanel.setSpacing(10);
        topPanel.setBackground(panelBackground);
        topPanel.setAlignment(Pos.BASELINE_RIGHT);

        root.setTop(topPanel);
    }

    /*Creates bottom panel for root border pane. Applies a label where the gameplay text will display.
        Formats the output of the label text.*/
    private void addLabels() {

        VBox bottomPanel = new VBox();
        bottomPanel.setPrefWidth(1000);
        bottomPanel.setPrefHeight(250);
        bottomPanel.setBackground(panelBackground);
        bottomPanel.setSpacing(10);

        gameText = new Label("");
        gameText.setMinWidth(600);
        gameText.setMinHeight(150);
        gameText.setWrapText(true);
        gameText.setTextAlignment(TextAlignment.CENTER);
        gameText.setMaxWidth(600);
        gameText.setBackground(labelBackground);
        gameText.setFont(new Font("Georgia", 24));

        bottomPanel.getChildren().add(gameText);
        gameText.setAlignment(Pos.CENTER);

        scoreLabel = new Label();
        scoreLabel.setMinWidth(200);
        scoreLabel.setMinHeight(50);
        scoreLabel.setTextAlignment(TextAlignment.CENTER);
        scoreLabel.setBackground(labelBackground);
        scoreLabel.setFont(new Font("Georgia", 24));
        scoreLabel.setText("Score: " + score);

        bottomPanel.getChildren().add(scoreLabel);
        scoreLabel.setAlignment(Pos.CENTER);
        bottomPanel.setAlignment(Pos.CENTER);

        root.setBottom(bottomPanel);
        BorderPane.setAlignment(bottomPanel, Pos.BOTTOM_CENTER);
    }

    /*Called when loading each new room. Updates background image and runs the text for each room.
        Reassigns currentRoom object to the new room that was entered. Clears any objects remaining from previous room*/
    public void changeRoom(Room roomToGoTo) {
        Background background = new Background(roomToGoTo.getBackgroundImage());
        centerPanel.getChildren().clear();
        centerPanel.setBackground(background);
        this.currentRoom = roomToGoTo;
        getClickablesAsButtons(centerPanel, roomToGoTo.getClickables());
        startDisplayTextThread(roomToGoTo.getEnterRoomText());
    }

    public void startDisplayTextThread(List<String> stringsToDisplay) {
        /*Task created to manage text output thread. This allows the room to load and display first, then run the
        room's text for the user to read. Output is set on a timer that varies based on the length of each line.*/
        gameScene.setOnKeyPressed(null);
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (String text : stringsToDisplay) {
                    if (text.equals(stringsToDisplay.get(0))) {
                        updateMessage(text);
                    } else {
                        if (text.length() > 50){
                            Thread.sleep(LONG_TEXT_DISPLAY_TIME);
                        }
                        if (text.length() > 30) {
                            Thread.sleep(MEDIUM_TEXT_DISPLAY_TIME);
                        }
                        else Thread.sleep(SHORT_TEXT_DISPLAY_TIME);
                        updateMessage(text.replace(":", ":\n"));
                    }
                }
                return null;
            }
        };
        task.setOnSucceeded((x) -> {
                    gameScene.setOnKeyPressed((k) ->
                            keyPressed(k.getCode()));
                }
        );
        gameText.textProperty().bind(task.messageProperty());
        //Renders item unclickable until scene dialogue is complete, resource linked in comments at the top
        centerPanel.getChildren().forEach(x -> x.disableProperty().bind(task.runningProperty()));
        Thread textThread = new Thread(task);
        textThread.start();
    }

    //Creates clickable item on scene display.
    public void getClickablesAsButtons(Pane pane, List<Clickable> clickables) {
        for (Clickable clickable : clickables) {
            if (!itemInventory.contains(clickable.getItem())) {
                Image clickableImage = clickable.getItem().getImage();
                ImageView view = new ImageView(clickableImage);
                view.setFitHeight(clickable.getHeight());
                view.setFitWidth(clickable.getWidth());
                view.setX(clickable.getTopLeft().x);
                view.setY(clickable.getTopLeft().y);
                Button buttonToAdd = new Button();
                buttonToAdd.setBackground(Background.EMPTY);
                buttonToAdd.setMinWidth(clickable.getWidth());
                buttonToAdd.setMaxWidth(clickable.getWidth());
                buttonToAdd.setMinHeight(clickable.getHeight());
                buttonToAdd.setMaxHeight(clickable.getHeight());
                buttonToAdd.setGraphic(view);
                buttonToAdd.setOnMouseClicked(clickable.getClickEvent(currentRoom));
                buttonToAdd.setLayoutX(clickable.getTopLeft().x);
                buttonToAdd.setLayoutY(clickable.getTopLeft().y);
                pane.getChildren().add(buttonToAdd);
            }
        }
    }

    //Adds points to total score and updates score label
    public static void updateScore(int points) {
        score += points;
        scoreLabel.setText("Score: " + score);
    }

    public int getScore() {
        return score;
    }

    //Adds item to inventory display
    public void addItem(Item item) {
        itemInventory.add(item);
        drawItems();
    }

    //Removes item from inventory display
    public void removeItem(Item item){
        itemInventory.remove(item);
        drawItems();
    }

    //Removes item from scene
    public void removeItemFromDisplay(Button source) {
        centerPanel.getChildren().remove(source);
    }

    //Sets items displayed in inventory bar at the top of the scene
    private void drawItems() {
        topPanel.getChildren().clear();
        itemInventory.forEach(x -> topPanel.getChildren().add(new ImageView(x.getImage())));
    }

    public Set<Item> getItemInventory() {
        return itemInventory;
    }

    public boolean doesNoodlesHaveItem(String itemName) {
        return itemInventory.stream().anyMatch(x -> x.getName().equals(itemName));
    }

    public ItemPool getItemPool() {
        return itemPool;
    }

    public void createFinalScene(){
        Image image = new Image("/BGFinalScene.png");
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        centerPanel.getChildren().clear();
        centerPanel.setBackground(background);
        itemInventory.clear();
        drawItems();
        leftArrow.setVisible(false);
        rightArrow.setVisible(false);
        List<String> finalSceneText = new ArrayList<>();
        finalSceneText.add("Noodles regaled her friends with tales of her amazing adventure!\nThe End.");
        this.startDisplayTextThread(finalSceneText);

      //  startDisplayTextThread(roomToGoTo.getEnterRoomText());
    }
}