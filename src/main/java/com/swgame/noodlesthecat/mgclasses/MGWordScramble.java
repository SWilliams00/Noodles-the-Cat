/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
Word Scramble MiniGame
API for all imported libraries used as references.
Reference for word shuffle using Collections.shuffle method: https://stackoverflow.com/questions/20588736/how-can-i-shuffle-the-letters-of-a-word
Reference for using regex to convert String to all lowercase letters: https://www.codegrepper.com/code-examples/java/how+to+remove+all+commas+in+a+string+java
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
import java.util.*;


public class MGWordScramble {

    private Stage popupWindow;
    private Scene gamePlayScene, afterCorrectGuessScene, winningScene;
    private List<String> wordsList = new ArrayList<String>();
    private int numberOfCorrectGuessesNeeded = 5;
    private VBox root, correctAnswer, gameWon;
    private Font titleFont = new Font("Georgia", 24);
    private Font bigFont = new Font("Elephant", 40);
    private Background background = new Background(new BackgroundFill(Color.CORAL, CornerRadii.EMPTY, Insets.EMPTY));
    private TextField entry;
    private Label titleLabel;
    private Button submit, yesButton, noButton, claimPrize;

    public MGWordScramble(){
        popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Unscramble the word!");

        claimPrize = new Button("All done!");
        noButton = new Button("Finish");
        generateWordsList();
        startNewRound();

        popupWindow.setScene(gamePlayScene);
    }

    public EventHandler<ActionEvent> submitButtonClicked = (m) -> {
        handleSubmitAction();
    };

    public EventHandler<ActionEvent> goAgainButtonClicked = (m) -> {
        correctAnswer.setVisible(false);
        root.setVisible(true);
        popupWindow.setScene(gamePlayScene);
        startNewRound();
    };

    public EventHandler<ActionEvent> finishButtonClicked = (m) -> popupWindow.close();

    public EventHandler<MouseEvent> anotherWordButtonClicked = (m) -> startNewRound();

    public void pressEnterToSubmitGuess(KeyCode keyCode) {
        if (keyCode.equals(KeyCode.ENTER)) {
            handleSubmitAction();
        }
    }

    public void pressEnterToStartNewQuestion(KeyCode keyCode){
        if (keyCode.equals(KeyCode.ENTER)) {
            correctAnswer.setVisible(false);
            root.setVisible(true);
            popupWindow.setScene(gamePlayScene);
            startNewRound();
        }
    }

    //Establishes popup window and calls first round scene to generate
    public void display() {
        popupWindow.showAndWait();
    }

    //Sets scene for each round of gameplay
    public void startNewRound() {
        root = new VBox();
        root.setBackground(background);
        titleLabel = new Label("Can you unscramble this word? Get " + numberOfCorrectGuessesNeeded +
                " more correct and you win!");
        titleLabel.setFont(titleFont);
        titleLabel.setWrapText(true);
        titleLabel.setMaxWidth(350);
        titleLabel.setMinHeight(60);
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(titleLabel);
        root.setAlignment(Pos.TOP_CENTER);

        VBox secondVBox = new VBox();

        Label wordToDisplay = new Label("");
        //Gets word from wordsList
        String wordToScramble = getRandomWordFromMap();
        if (wordToScramble == null) {
            //should never get here
            gameWon();
        } else {
            //gets scrambled word as string, reformats for display to remove spaces and extra characters
            String word = scrambleTheWord(wordToScramble);
            word = word.replaceAll("[^a-zA-Z0-9}]", "");
            word = word.strip();
            wordToDisplay.setFont(bigFont);
            wordToDisplay.setTextAlignment(TextAlignment.CENTER);
            wordToDisplay.setMinHeight(150);
            wordToDisplay.setText(word);
            secondVBox.getChildren().add(wordToDisplay);
            secondVBox.setAlignment(Pos.TOP_CENTER);

            HBox entryPane = new HBox();
            entryPane.setPadding(new Insets(15, 12, 15, 12));
            entryPane.setSpacing(10);
            entry = new TextField();
            entry.setMaxWidth(75);
            submit = new Button("Submit");
            submit.setOnAction(submitButtonClicked);
            entryPane.getChildren().add(entry);
            entryPane.getChildren().add(submit);
            secondVBox.getChildren().add(entryPane);
            entryPane.setAlignment(Pos.CENTER);

            Button getNextWord = new Button("Try another word?");
            getNextWord.setOnMouseClicked(anotherWordButtonClicked);
            secondVBox.getChildren().add(getNextWord);
            getNextWord.setAlignment(Pos.BOTTOM_CENTER);

            root.getChildren().add(secondVBox);
            secondVBox.setAlignment(Pos.CENTER);

            gamePlayScene = new Scene(root, 500, 300, Color.ALICEBLUE);
            gamePlayScene.setOnKeyPressed((k) -> pressEnterToSubmitGuess(k.getCode()));
            popupWindow.setScene(gamePlayScene);
        }
    }

    //Sets scene following a correct guess, allows user to continue or stop game
    public void afterCorrectGuess() {

        root.setVisible(false);

        correctAnswer = new VBox();
        correctAnswer.setBackground(background);
        Label congratulations = new Label("You guessed right!");
        congratulations.setFont(bigFont);
        congratulations.setTextAlignment(TextAlignment.CENTER);
        congratulations.setMinHeight(150);
        correctAnswer.getChildren().add(congratulations);
        correctAnswer.setAlignment(Pos.TOP_CENTER);

        HBox correctAnswerCenter = new HBox();
        yesButton = new Button("Go again?");
        yesButton.setOnAction(goAgainButtonClicked);
        correctAnswerCenter.getChildren().add(yesButton);
        correctAnswerCenter.getChildren().add(noButton);
        correctAnswer.getChildren().add(correctAnswerCenter);
        correctAnswerCenter.setAlignment(Pos.CENTER);

        afterCorrectGuessScene = new Scene(correctAnswer, 500, 300, Color.ALICEBLUE);
        afterCorrectGuessScene.setOnKeyPressed((k) -> pressEnterToStartNewQuestion(k.getCode()));
        popupWindow.setScene(afterCorrectGuessScene);
    }

    //Sets scene that displays after 5 correct guesses
    public void gameWon() {

        root.setVisible(false);

        gameWon = new VBox();
        gameWon.setBackground(background);
        Label youWin = new Label("Congratulations! You won!");
        youWin.setFont(bigFont);
        youWin.setTextAlignment(TextAlignment.CENTER);
        youWin.setMinHeight(150);
        youWin.setMaxWidth(350);
        youWin.setWrapText(true);
        gameWon.getChildren().add(youWin);
        gameWon.setAlignment(Pos.TOP_CENTER);

        claimPrize.setOnAction(finishButtonClicked);
        gameWon.getChildren().add(claimPrize);
        gameWon.setAlignment(Pos.CENTER);

        winningScene = new Scene(gameWon, 500, 300, Color.ALICEBLUE);
        popupWindow.setScene(winningScene);

    }

    //Shuffles wordsList and returns first element to allow variety between rounds
    private String getRandomWordFromMap() {
        Collections.shuffle(wordsList);
        if (!wordsList.isEmpty()) {
            return wordsList.get(0);
        } else return null;
    }

    //Takes first element of wordsList, converts to a scrambled char array and returns as a string
    public String scrambleTheWord(String wordToScramble) {
        List<Character> arrayOfScrambledLetters = new ArrayList<>();
        for (char letter : wordToScramble.toCharArray()) {
            arrayOfScrambledLetters.add(letter);
        }
        Collections.shuffle(arrayOfScrambledLetters);
        return arrayOfScrambledLetters.toString();
    }

    //Checks if user guess is present in wordsList and removes the word from the List if it was correct
    public void checkGuess(String userGuess) {
        //remove returns a boolean if the operation is successful (if the word was correct)
        if (wordsList.remove(userGuess.toLowerCase(Locale.ROOT))) {
            NoodlesGUI.updateScore(10);
            numberOfCorrectGuessesNeeded--;
            if (numberOfCorrectGuessesNeeded == 0) {
                gameWon();
            } else afterCorrectGuess();
        } else titleLabel.setText("That's not right! Try again!");
    }

    public void handleSubmitAction(){
        String userGuess = entry.getText();
        checkGuess(userGuess);
        entry.clear();
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

    public void generateWordsList() {
        wordsList.add("fur");
        wordsList.add("catnip");
        wordsList.add("tuna");
        wordsList.add("kibble");
        wordsList.add("toy");
        wordsList.add("mouse");
        wordsList.add("hairball");
        wordsList.add("salmon");
    }

    public Stage getPopupWindow() {
        return popupWindow;
    }
}


