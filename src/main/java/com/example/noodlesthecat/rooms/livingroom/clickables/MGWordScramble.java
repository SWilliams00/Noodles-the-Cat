package com.example.noodlesthecat.rooms.livingroom.clickables;

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


//text formatter to allow only lowercase letters
public class MGWordScramble {

    private Stage popupWindow;
    private Scene gamePlayScene, afterCorrectGuessScene, winningScene;
    private List<String> wordsList = new ArrayList<String>();
    private int numberOfCorrectGuesses;
    private VBox root, correctAnswer, gameWon;
    private Font titleFont = new Font("Georgia", 24);
    private Font bigFont = new Font("Elephant", 40);
    private Background background = new Background(new BackgroundFill(Color.CORAL, CornerRadii.EMPTY, Insets.EMPTY));
    private TextField entry;
    private Label titleLabel;
    private Map<String, Boolean> wordsMap = new HashMap<>();

    public void keyPressed(KeyCode keyCode) {
        if (keyCode.equals(KeyCode.ENTER)) {
            String userGuess = entry.getText();
            checkGuess(userGuess);
            entry.clear();
        }
    }

    public EventHandler<MouseEvent> submitClicked = (m) -> {
        String userGuess = entry.getText();
        checkGuess(userGuess);
    };

    public EventHandler<MouseEvent> yesClicked = (m) -> {
        correctAnswer.setVisible(false);
        root.setVisible(true);
        popupWindow.setScene(gamePlayScene);
        startNewRound();
    };

    public EventHandler<MouseEvent> noClicked = (m) -> popupWindow.close();

    public EventHandler<MouseEvent> anotherWordClicked = (m) -> startNewRound();

    public void display() {

        popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Unscramble the word!");

        generateWordsList();
        startNewRound();

        popupWindow.setScene(gamePlayScene);
        popupWindow.showAndWait();
    }

    public void startNewRound() {
        root = new VBox();
        root.setBackground(background);
        titleLabel = new Label("Can you unscramble this word? Get 5 correct and you win!");
        titleLabel.setFont(titleFont);
        titleLabel.setWrapText(true);
        titleLabel.setMaxWidth(350);
        titleLabel.setMinHeight(60);
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(titleLabel);
        root.setAlignment(Pos.TOP_CENTER);

        VBox secondVBox = new VBox();

        Label wordToDisplay = new Label("");
        String wordToScramble = getRandomWordFromMap();
        if (wordToScramble == null) {
            //should never get here
            gameWon();
        } else {
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
            Button submit = new Button("Submit");
            submit.setOnMouseClicked(submitClicked);
            entryPane.getChildren().add(entry);
            entryPane.getChildren().add(submit);
            secondVBox.getChildren().add(entryPane);
            entryPane.setAlignment(Pos.CENTER);

            Button getNextWord = new Button("Try another word?");
            getNextWord.setOnMouseClicked(anotherWordClicked);
            secondVBox.getChildren().add(getNextWord);
            getNextWord.setAlignment(Pos.BOTTOM_CENTER);

            root.getChildren().add(secondVBox);
            secondVBox.setAlignment(Pos.CENTER);

            gamePlayScene = new Scene(root, 500, 300, Color.ALICEBLUE);
            gamePlayScene.setOnKeyPressed((k) -> keyPressed(k.getCode()));
            popupWindow.setScene(gamePlayScene);
        }
    }

    public String scrambleTheWord(String wordToScramble) {
        List<Character> arrayOfScrambledLetters = new ArrayList<>();
        for (char letter : wordToScramble.toCharArray()) {
            arrayOfScrambledLetters.add(letter);
        }
        Collections.shuffle(arrayOfScrambledLetters);
        return arrayOfScrambledLetters.toString();
    }

    public void checkGuess(String userGuess) {
        //remove returns a boolean if the operation is successful (if the word was correct)
        if (wordsList.remove(userGuess.toLowerCase(Locale.ROOT))) {
            numberOfCorrectGuesses++;
            if (numberOfCorrectGuesses == 5) {
                gameWon();
            } else afterCorrectGuess();
        } else titleLabel.setText("That's not right! Try again!");
    }

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
        Button yesButton = new Button("Go again?");
        yesButton.setOnMouseClicked(yesClicked);
        Button noButton = new Button("Finish");
        noButton.setOnMouseClicked(noClicked);
        correctAnswerCenter.getChildren().add(yesButton);
        correctAnswerCenter.getChildren().add(noButton);
        correctAnswer.getChildren().add(correctAnswerCenter);
        correctAnswerCenter.setAlignment(Pos.CENTER);

        afterCorrectGuessScene = new Scene(correctAnswer, 500, 300, Color.ALICEBLUE);
        popupWindow.setScene(afterCorrectGuessScene);
    }

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

        Button claimPrize = new Button("All done!");
        claimPrize.setOnMouseClicked(noClicked);
        gameWon.getChildren().add(claimPrize);
        gameWon.setAlignment(Pos.CENTER);

        winningScene = new Scene(gameWon, 500, 300, Color.ALICEBLUE);
        popupWindow.setScene(winningScene);

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

        wordsMap.put("fur", false);
        wordsMap.put("catnip", false);
        wordsMap.put("tuna", false);
        wordsMap.put("kibble", false);
        wordsMap.put("toy", false);
        wordsMap.put("mouse", false);
        wordsMap.put("hairball", false);
        wordsMap.put("salmon", false);

    }

    private String getRandomWordFromMap() {
        Collections.shuffle(wordsList);
        if (!wordsList.isEmpty()) {
            return wordsList.get(0);
        } else return null;
    }
}
