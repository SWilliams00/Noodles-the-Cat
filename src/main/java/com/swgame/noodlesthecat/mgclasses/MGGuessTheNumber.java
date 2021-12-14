/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
Random Number MiniGame
API for all imported libraries used as references.
References for popup window: https://examples.javacodegeeks.com/desktop-java/javafx/dialog-javafx/javafx-dialog-example/
        http://www.learningaboutelectronics.com/Articles/How-to-create-a-pop-up-window-in-JavaFX.php
References for textfield formatting: https://stackoverflow.com/questions/14169240/getting-integer-values-from-textfield
        https://edencoding.com/javafx-textfield/
 */


package com.swgame.noodlesthecat.mgclasses;

import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;


public class MGGuessTheNumber {

    private Stage popupWindow;
    private VBox root = new VBox();
    private VBox correctAnswer;
    private static Scene gamePlayScene, wonRoundScene, winningScene;
    private Label instructions = new Label("");
    private Label gameInfo = new Label("");;
    private Font bigFont = new Font("Elephant", 40);
    private TextField entry;
    private Background background = new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY));
    private int lowNumber, highNumber, winningNumber;
    private int totalCorrectGuesses = 0;
    private Button submit, claimPrize, noButton;

    public MGGuessTheNumber (){
        popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Guess the random number!");

        claimPrize = new Button("Claim your prize!");
        noButton = new Button("All done");
        startNewRound();
        popupWindow.setScene(gamePlayScene);
    }

    public  EventHandler<MouseEvent> submitClicked = (m) -> {
        handleSubmitAction();
    };

    //Allows user to press enter key to submit guess
    public void keyPressed(KeyCode keyCode) {
        if (keyCode.equals(KeyCode.ENTER)) {
            handleSubmitAction();
        }
    }

    //reloads gameplay scene if user chooses to complete another round
    public EventHandler<ActionEvent> yesClicked = (m) -> {
        correctAnswer.setVisible(false);
        root.setVisible(true);
        popupWindow.setScene(gamePlayScene);
        createStartGameText();
    };

    public EventHandler<MouseEvent> noClicked = (m) -> {
        popupWindow.close();
    };

    public void goAgainKeyPressed(KeyCode keyCode){
        if(keyCode.equals(KeyCode.ENTER)){
            correctAnswer.setVisible(false);
            root.setVisible(true);
            popupWindow.setScene(gamePlayScene);
            createStartGameText();
        }
    }

    public void display(){
        popupWindow.showAndWait();
    }

    //Sets scene for each round of gameplay
    public void startNewRound(){

        Label titleLabel = new Label("Guess the number!");
        titleLabel.setFont(bigFont);
        titleLabel.setTextFill(Color.DARKBLUE);
        root.getChildren().add(titleLabel);
        root.setAlignment(Pos.TOP_CENTER);
        root.setBackground(background);


        VBox instructionsPane = new VBox();
        instructions.setWrapText(true);
        instructions.setMaxWidth(350);
        instructions.setPrefWidth(350);
        instructions.setPrefHeight(60);
        instructions.setFont(new Font("Georgia", 18));
        instructionsPane.getChildren().add(instructions);
        instructions.setAlignment(Pos.TOP_CENTER);

        VBox gameInfoPane = new VBox();
        gameInfo.setWrapText(true);
        gameInfo.setMaxWidth(400);
        gameInfo.setPrefWidth(400);
        gameInfo.setPrefHeight(50);
        gameInfo.setFont(new Font("Georgia", 14));
        gameInfo.setTextAlignment(TextAlignment.CENTER);
        gameInfoPane.getChildren().add(gameInfo);
        gameInfo.setAlignment(Pos.TOP_CENTER);
        createStartGameText();


        HBox entryPane = new HBox();
        entry = new TextField();
        entry.setPrefColumnCount(8);
        submit = new Button("Submit");
        submit.setOnMouseClicked(submitClicked);
        entryPane.getChildren().add(entry);
        entryPane.getChildren().add(submit);

        gameInfoPane.getChildren().add(entryPane);
        entryPane.setAlignment(Pos.TOP_CENTER);

        instructionsPane.getChildren().add(gameInfoPane);
        gameInfoPane.setAlignment(Pos.CENTER);

        root.getChildren().add(instructionsPane);
        instructionsPane.setAlignment(Pos.CENTER);

        gamePlayScene = new Scene(root,500, 300, Color.ALICEBLUE);
        gamePlayScene.setOnKeyPressed((k) -> keyPressed(k.getCode()));

    }

    //Sets display scene if user made a correct guess but has not reached 3 correct guesses
    public void inBetweenRounds(){

        root.setVisible(false);

        correctAnswer = new VBox();
        correctAnswer.setBackground(background);
        Label congratulations = new Label("You did it!");
        congratulations.setFont(bigFont);
        congratulations.setTextFill(Color.DARKBLUE);
        congratulations.setTextAlignment(TextAlignment.CENTER);
        congratulations.setMinHeight(150);
        correctAnswer.getChildren().add(congratulations);
        correctAnswer.setAlignment(Pos.TOP_CENTER);


        HBox correctAnswerCenter = new HBox();
        Button yesButton = new Button("Go again?");
        yesButton.setOnAction(yesClicked);
        correctAnswerCenter.getChildren().add(yesButton);
        correctAnswerCenter.getChildren().add(noButton);
        correctAnswer.getChildren().add(correctAnswerCenter);
        correctAnswerCenter.setAlignment(Pos.CENTER);


        wonRoundScene = new Scene(correctAnswer,500, 300, Color.LAVENDER);
        wonRoundScene.setOnKeyPressed((k) -> goAgainKeyPressed(k.getCode()));
        popupWindow.setScene(wonRoundScene);

    }

    //Sets display if user has guessed the correct number 3 times
    public void gameWon(){

        root.setVisible(false);

        VBox gameWon = new VBox();
        gameWon.setBackground(background);
        Label youWin = new Label("Congratulations! You won!");
        youWin.setFont(bigFont);
        youWin.setTextFill(Color.DARKBLUE);
        youWin.setTextAlignment(TextAlignment.CENTER);
        youWin.setMinHeight(150);
        youWin.setMaxWidth(350);
        youWin.setWrapText(true);
        gameWon.getChildren().add(youWin);
        gameWon.setAlignment(Pos.TOP_CENTER);
        gameWon.getChildren().add(claimPrize);
        gameWon.setAlignment(Pos.CENTER);

        winningScene = new Scene(gameWon, 500, 300, Color.ALICEBLUE);
        popupWindow.setScene(winningScene);
    }

    //Method calls function to generate new numbers and resets the game text
    public void createStartGameText(){
        gameRunner();
        gameInfo.setText("Hank loves numbers! Guess the number he's thinking of. " +
                "Guess correctly 3 times and you win!");
        instructions.setText("I'm thinking of a number between " + (lowNumber - 1) + " and "
                + (highNumber + 1) + "!");
    }

       public void gameRunner(){
        setGameNumbers(lowNumber, highNumber, winningNumber);
    }

    //Calls methods to generate random numbers. Low and high numbers also randomized to provide variety
    public void setGameNumbers(int lowNumber, int highNumber, int winningNumber){
        lowNumber = lowNumberGenerator();
        highNumber = highNumberGenerator(lowNumber);
        winningNumber = numberToGuess(lowNumber, highNumber);
    }

    public int lowNumberGenerator(){
        int min = 1;
        int max = 50;
        lowNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        return lowNumber;
    }

    public int highNumberGenerator(int lowNumber){
        int max = 100;
        highNumber = ThreadLocalRandom.current().nextInt(lowNumber, max + 1);
        return highNumber;
    }

    public int numberToGuess(int lowNumber, int highNumber){
        winningNumber = ThreadLocalRandom.current().nextInt(lowNumber, highNumber + 1);
        return winningNumber;
    }

    /*Processes user guess, updates gameInfo label to provide feedback to user.
        If user guess is correct the scene is updated to either offer another round or show that
        the game has been won.*/
    public void checkGuess (int userGuess){
        if(userGuess == -1){
            gameInfo.setText("Guess a number, silly!");
        }
        else if(userGuess > winningNumber){
            gameInfo.setText("That number is too big! Try again!");
        }
        else if(userGuess < winningNumber){
            gameInfo.setText("That number is too small! Try again!");
        }
        else {
            NoodlesGUI.updateScore(10);
            totalCorrectGuesses++;
          if(totalCorrectGuesses == 3){
              gameWon();
          }
            else inBetweenRounds();
        }
    }

    public void setOnClose(EventHandler event) {
        popupWindow.setOnCloseRequest((x) -> {
            event.handle(x);
            popupWindow.close();    }
        );
        claimPrize.setOnAction((x) -> {
            event.handle(x);
            popupWindow.close();    }
        );
        noButton.setOnAction((x) -> {
            event.handle(x);
            popupWindow.close();    }
        );
    }

    public void handleSubmitAction(){
        int userGuess = -1;
        if(entry.getText().matches("\\d+")) {
            userGuess = Integer.parseInt(entry.getText());
        }
        checkGuess(userGuess);
        entry.clear();
    }

    public Stage getPopupWindow() {
        return popupWindow;
    }
}
