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


package com.example.noodlesthecat.rooms.livingroom.clickables;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.UnaryOperator;

//Need to implement way to input only numbers


public class MGGuessTheNumber {

    private static Stage popupWindow;
    private static BorderPane root, centerPane;
    private static HBox entryPane;
    private static Scene scene;
    private static Label instructions, gameInfo;
    private static TextField entry;
    private static Button submit;
    private static int lowNumber, highNumber, winningNumber;
    private static int totalCorrectGuesses = 0;
    public static EventHandler<MouseEvent> submitClicked = (m) -> {
            int userGuess = Integer.parseInt(entry.getText());
            checkGuess(userGuess);
    };
    public static EventHandler<MouseEvent> yesClicked = (m) -> {
        startNewRound();
    };
    public static EventHandler<MouseEvent> noClicked = (m) -> {
        popupWindow.close();
    };

    public static void display(){

        popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Guess the number!");

        startNewRound();

        popupWindow.setScene(scene);
        popupWindow.showAndWait();
    }

    public static void startNewRound(){
        Label titleLabel = new Label("Guess the number!");
        titleLabel.setFont(new Font("Elephant", 36));
        root.setTop(titleLabel);
        titleLabel.setAlignment(Pos.TOP_CENTER);

        centerPane = new BorderPane();
        gameRunner();

        instructions = new Label("I'm thinking of a number between " + lowNumber + " and " + highNumber + "!");
        instructions.setWrapText(true);
        instructions.setMaxWidth(300);
        instructions.setFont(new Font("Georgia", 18));
        centerPane.setTop(instructions);

        gameInfo = new Label("");
        centerPane.setCenter(gameInfo);
        createStartGameText(gameInfo);

        entryPane = new HBox();
        entry = new TextField();
        entry.setPrefColumnCount(10);
        //validate numbers
        submit = new Button("Submit");
        submit.setOnMouseClicked(submitClicked);
        entryPane.getChildren().add(entry);
        entryPane.getChildren().add(submit);
        centerPane.setBottom(entryPane);

        root.setCenter(centerPane);
        scene = new Scene(root,500, 500, Color.ALICEBLUE);
    }

    public static void createStartGameText(Label gameInfo){
        gameInfo.setText("Hank loves numbers! Guess the number he's thinking of." +
                "Guess correctly 3 times and you win!");
    }

    public static void gameRunner(){
        setGameNumbers(lowNumber, highNumber, winningNumber);
    }

    public static void setGameNumbers(int lowNumber, int highNumber, int numberToGuess){
        lowNumber = lowNumberGenerator();
        highNumber = highNumberGenerator(lowNumber);
        numberToGuess = numberToGuess(lowNumber, highNumber);
    }

    public static int lowNumberGenerator(){
        int min = 1;
        int max = 100000;
        int lowestNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        return lowestNumber;
    }

    public static int highNumberGenerator(int lowNumber){
        int max = 150000;
        int highestNumber = ThreadLocalRandom.current().nextInt(lowNumber, max + 1);
        return highestNumber;
    }

    public static int numberToGuess(int lowNumber, int highNumber){
        winningNumber = ThreadLocalRandom.current().nextInt(lowNumber, highNumber + 1);
        return winningNumber;
    }

    public static void checkGuess (int userGuess){
        if(userGuess > winningNumber){
            gameInfo.setText("That number is too big! Try again!");
        }
        if(userGuess < winningNumber){
            gameInfo.setText("That number is too small! Try again!");
        }
        if(userGuess == winningNumber){
            gameInfo.setText("That's the right number! You did it! Let's do another!");
            totalCorrectGuesses++;
            afterCorrectGuess();
        }
    }

    public static void afterCorrectGuess(){

        totalCorrectGuesses++;
        BorderPane correctAnswer = new BorderPane();
        Label congratulations = new Label("Congratulations! Go again?");
        correctAnswer.setTop(congratulations);

        HBox correctAnswerCenter = new HBox();
        Button yesButton = new Button("Yes");
        yesButton.setOnMouseClicked(yesClicked);
        Button noButton = new Button("No");
        noButton.setOnMouseClicked(noClicked);
        correctAnswerCenter.getChildren().add(yesButton);
        correctAnswerCenter.getChildren().add(noButton);
        correctAnswer.setCenter(correctAnswerCenter);

        scene = new Scene(correctAnswer,500, 500, Color.ALICEBLUE);

//        setGameNumbers(lowNumber, highNumber, winningNumber);
//        instructions.setText("I'm thinking of a number between " + lowNumber + " and " + highNumber + "!");
    }

    public static void checkIfGameWon(){
        if(totalCorrectGuesses == 3){
            BorderPane gameWon = new BorderPane();
            Label youWin = new Label("Congratulations! You win!");
            gameWon.setTop(youWin);

            Button claimPrize = new Button("Claim your prize!");
            claimPrize.setOnMouseClicked(noClicked);
            gameWon.setCenter(claimPrize);

            scene = new Scene(gameWon, 500, 500, Color.ALICEBLUE);
//            instructions.setText("You guessed all 3 numbers correctly! Congratulations!");
//            gameInfo.setText("You win a prize!");

        }
    }

    UnaryOperator<TextFormatter.Change> numberValidationFormatter = change -> {
        if(change.getText().matches("\\d+")){
            return change; //if change is a number
        } else {
            change.setText(""); //else make no change
            change.setRange(    //don't remove any selected text either.
                    change.getRangeStart(),
                    change.getRangeStart()
            );
            return change;
        }
    };
}
