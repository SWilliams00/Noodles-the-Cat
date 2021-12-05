package com.example.noodlesthecat.rooms.livingroom.clickables;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//text formatter to allow only lowercase letters
public class MGWordScramble {

    private static Stage popupWindow;
    private static Scene scene;
    private static List<String> wordsList = new ArrayList<>();
    private static int questionNumberTracker = 0;
    private static TextField entry;
    private static Label titleLabel;

    public static EventHandler<MouseEvent> submitClicked = (m) -> {
        String userGuess = entry.getText();
        checkGuess(userGuess);
    };
    public static EventHandler<MouseEvent> yesClicked = (m) -> {
        startNewRound();
    };
    public static EventHandler<MouseEvent> noClicked = (m) -> {
        popupWindow.close();
    };

    public static void display() {

        popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Unscramble the word!");


        popupWindow.setScene(scene);
        popupWindow.showAndWait();
    }

    public static String scrambleTheWord(String wordsList){
        String scrambledWord;
        List<Character> arrayOfScrambledLetters = new ArrayList<>();
        for(char letter : wordsList.toCharArray()){
            arrayOfScrambledLetters.add(letter);
        }
        Collections.shuffle(arrayOfScrambledLetters);
        return scrambledWord = arrayOfScrambledLetters.toString();
    }

    public static void checkGuess(String userGuess){
        if (userGuess == wordsList.get(questionNumberTracker)){
            afterCorrectGuess();
        }
        else titleLabel.setText("That's not right! Try again!");
    }

    public static void startNewRound(){
        BorderPane root = new BorderPane();
        titleLabel = new Label("Can you unscramble this word?");
        titleLabel.setFont(new Font("Elephant", 28));
        root.setTop(titleLabel);

        BorderPane centerPane = new BorderPane();
        Label wordToDisplay = new Label("");
        wordToDisplay.setText(scrambleTheWord(wordsList.get(questionNumberTracker)));
        centerPane.setTop(wordToDisplay);

        HBox entryPane = new HBox();
        entry = new TextField();
        entry.setPrefColumnCount(30);
        Button submit = new Button("Submit");
        submit.setOnMouseClicked(submitClicked);
        entryPane.getChildren().add(entry);
        entryPane.getChildren().add(submit);
        centerPane.setCenter(entryPane);

        root.setCenter(centerPane);
        scene = new Scene(root, 500, 500, Color.ALICEBLUE);
    }

    public static void afterCorrectGuess(){
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
    }

    public static void generateWordsList(){
        wordsList.add("catnip");
        wordsList.add("kibble");
        wordsList.add("hairball");
        wordsList.add("scratching post");
        wordsList.add("salmon");
    }
}
