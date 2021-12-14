/*Shelby Williams
Advanced Java
12-18-21
Noodles the Cat Point-and-Click Adventure Game
Cathulu Riddles MiniGame
API for all imported libraries used as references. */

package com.swgame.noodlesthecat.mgclasses;

import com.swgame.noodlesthecat.NoodlesGUI.NoodlesGUI;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MGCathuluQuiz {


    private int questionNumberTracker = 0;
    private List<CathuluQuestionClass> questionsArrayList = new ArrayList<>();
    private Stage popupWindow;
    private VBox root, correctAnswer, incorrectAnswer, gameWon;
    private static Scene gamePlayScene, afterCorrectGuessScene, afterIncorrectGuessScene, winningScene;
    private Font titleFont = new Font("Harrington", 28);
    private Background background = new Background(new BackgroundFill(Color.ROSYBROWN, CornerRadii.EMPTY, Insets.EMPTY));
    private Label questionLabel;
    private Button answerToSelect1, answerToSelect2, answerToSelect3, finishGame;
    private String buttonLabel1, buttonLabel2, buttonLabel3;

    public MGCathuluQuiz(){
        popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Cathulu's Riddles");

        finishGame = new Button();

        generateQuestionArray();
        generateGameplayScene();
        runGameplay();
    }


    public EventHandler<MouseEvent> answerButtonClicked = (m) -> {
        Button button =  (Button) (m.getSource());
        if (checkAnswer(button)){
            generateCorrectAnswerScene();
        }
        else generateIncorrectAnswerScene();
    };

    public EventHandler<MouseEvent> goAgainButtonClicked = (m) -> {
        if(questionNumberTracker == 5){
            generateGameWonScene();
        }
        else {
            runGameplay();
            root.setVisible(true);
            popupWindow.setScene(gamePlayScene);

        }
    };

    public EventHandler<MouseEvent> noClicked = (m) -> {
        popupWindow.close();
    };

    public void display() {

        popupWindow.showAndWait();
    }

    //Builds scene for game display
    private void generateGameplayScene(){

        root = new VBox();
        root.setBackground(background);
        Label title = new Label("Cathulu the All-Knowing Asks...");
        title.setFont(titleFont);
        title.setMinHeight(60);
        title.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(title);
        root.setAlignment(Pos.TOP_CENTER);

        VBox secondVBox = new VBox();
        questionLabel = new Label();
        questionLabel.setFont(new Font("Georgia", 18));
        questionLabel.setWrapText(true);
        questionLabel.setTextAlignment(TextAlignment.CENTER);
        questionLabel.setMaxWidth(350);
        questionLabel.setMinHeight(100);
        secondVBox.getChildren().add(questionLabel);
        secondVBox.setAlignment(Pos.TOP_CENTER);

        HBox answerSelect = new HBox();
        answerSelect.setPadding(new Insets(15, 12, 15, 12));
        answerSelect.setSpacing(10);
        answerToSelect1 = new Button();
        answerToSelect2 = new Button();
        answerToSelect3 = new Button();
        answerToSelect1.setOnMouseClicked(answerButtonClicked);
        answerToSelect2.setOnMouseClicked(answerButtonClicked);
        answerToSelect3.setOnMouseClicked(answerButtonClicked);
        answerSelect.getChildren().add(answerToSelect1);
        answerSelect.getChildren().add(answerToSelect2);
        answerSelect.getChildren().add(answerToSelect3);
        secondVBox.getChildren().add(answerSelect);
        answerSelect.setAlignment(Pos.CENTER);

        root.getChildren().add(secondVBox);
        secondVBox.setAlignment(Pos.CENTER);

        gamePlayScene = new Scene(root,500, 300, Color.ALICEBLUE);
        popupWindow.setScene(gamePlayScene);
    }

    //Builds scene to display after correct answer
    private void generateCorrectAnswerScene(){

        root.setVisible(false);
        questionNumberTracker++;

        correctAnswer = new VBox();
        correctAnswer.setBackground(background);
        Label correctLabel = new Label("You are wise in the mysteries of the universe");
        correctLabel.setFont(titleFont);
        correctLabel.setTextAlignment(TextAlignment.CENTER);
        correctLabel.setWrapText(true);
        correctLabel.setMinHeight(200);
        correctLabel.setMaxWidth(350);
        correctAnswer.getChildren().add(correctLabel);
        correctAnswer.setAlignment(Pos.TOP_CENTER);

        Button tryAgain = new Button("Go again");
        tryAgain.setOnMouseClicked(goAgainButtonClicked);
        correctAnswer.getChildren().add(tryAgain);
        correctAnswer.setAlignment(Pos.CENTER);

        afterCorrectGuessScene = new Scene(correctAnswer, 500, 300, Color.ALICEBLUE);
        popupWindow.setScene(afterCorrectGuessScene);
    }

    //Builds scene to display after incorrect answer
    private void generateIncorrectAnswerScene(){

        root.setVisible(false);
        questionNumberTracker++;

        incorrectAnswer = new VBox();
        incorrectAnswer.setBackground(background);
        Label notCorrectLabel = new Label("The universe has much to teach you...");
        notCorrectLabel.setFont(titleFont);
        notCorrectLabel.setTextAlignment(TextAlignment.CENTER);
        notCorrectLabel.setWrapText(true);
        notCorrectLabel.setMinHeight(200);
        notCorrectLabel.setMaxWidth(350);
        incorrectAnswer.getChildren().add(notCorrectLabel);
        incorrectAnswer.setAlignment(Pos.TOP_CENTER);

        Button tryAgain = new Button("Go again");
        tryAgain.setOnMouseClicked(goAgainButtonClicked);
        incorrectAnswer.getChildren().add(tryAgain);
        incorrectAnswer.setAlignment(Pos.CENTER);

        afterIncorrectGuessScene = new Scene(incorrectAnswer, 500, 300, Color.ALICEBLUE);
        popupWindow.setScene(afterIncorrectGuessScene);
    }

    //Builds scene to display after 5 questions have been answered
    private void generateGameWonScene(){

        root.setVisible(false);

        gameWon = new VBox();
        gameWon.setBackground(background);
        Label congratulations = new Label("You have completed my test");
        congratulations.setFont(titleFont);
        congratulations.setTextAlignment(TextAlignment.CENTER);
        congratulations.setWrapText(true);
        congratulations.setMinHeight(200);
        congratulations.setMaxWidth(350);
        gameWon.getChildren().add(congratulations);
        gameWon.setAlignment(Pos.TOP_CENTER);

        finishGame.setText("Finish Game");
        finishGame.setOnMouseClicked(noClicked);
        gameWon.getChildren().add(finishGame);
        gameWon.setAlignment(Pos.CENTER);

        winningScene = new Scene(gameWon, 500, 300, Color.ALICEBLUE);
        popupWindow.setScene(winningScene);
    }

    //Resets text on labels after an answer is processed
    private void runGameplay(){
        questionLabel.setText(setQuestionLabel());
        setButtonLabels();
        answerToSelect1.setText(buttonLabel1);
        answerToSelect2.setText(buttonLabel2);
        answerToSelect3.setText(buttonLabel3);
    }

    //Checks text on selected answerButton with correct answer in Question array
    private Boolean checkAnswer(Button button){
        if (button.getText().equals(questionsArrayList.get(questionNumberTracker).getAnswer())){
            NoodlesGUI.updateScore(10);
            return true;
        }
        else return false;
    }

    //Updates questionLabel text when called with each round
    public String setQuestionLabel(){
        return questionsArrayList.get(questionNumberTracker).getQuestion();
    }

    //Updates button label text when called with each round
    public void setButtonLabels(){
        int correctAnswerSpot = pickRandomButton();

        if (correctAnswerSpot == 1){
            buttonLabel1 = questionsArrayList.get(questionNumberTracker).getAnswer();
            buttonLabel2 = questionsArrayList.get(questionNumberTracker).getAlternateAnswer1();
            buttonLabel3 = questionsArrayList.get(questionNumberTracker).getAlternateAnswer2();
        }
        if (correctAnswerSpot == 2){
            buttonLabel2 = questionsArrayList.get(questionNumberTracker).getAnswer();
            buttonLabel3 = questionsArrayList.get(questionNumberTracker).getAlternateAnswer1();
            buttonLabel1 = questionsArrayList.get(questionNumberTracker).getAlternateAnswer2();
        }
        if (correctAnswerSpot == 3){
            buttonLabel3 = questionsArrayList.get(questionNumberTracker).getAnswer();
            buttonLabel1 = questionsArrayList.get(questionNumberTracker).getAlternateAnswer1();
            buttonLabel2 = questionsArrayList.get(questionNumberTracker).getAlternateAnswer2();
        }
    }

    //Returns an int that is used to randomize the correct answer location in game
    public int pickRandomButton(){
        int min = 1;
        int max = 3;
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public void generateQuestionArray(){
        CathuluQuestionClass cathuluQuestionClass1 = new CathuluQuestionClass("I'm the rare case when today comes before yesterday. What am I?",
                "A dictionary", "Naptime", "Sunset");

        CathuluQuestionClass cathuluQuestionClass2 = new CathuluQuestionClass("What goes all the way around the world, but stays in a corner?",
                "A stamp", "A houseplant", "An airplane");

        CathuluQuestionClass cathuluQuestionClass3 = new CathuluQuestionClass("You cannot keep me until you have given me. What am I?",
                "Your word", "A present", "A high-five");

        CathuluQuestionClass cathuluQuestionClass4 = new CathuluQuestionClass("This is easy to lift but hard to throw. What is it?",
                "A feather", "A rock", "Hank the Black Cat");

        CathuluQuestionClass cathuluQuestionClass5 = new CathuluQuestionClass("What always ends everything?",
                "The letter G", "Entropy", "Bedtime");

        questionsArrayList.add(cathuluQuestionClass1);
        questionsArrayList.add(cathuluQuestionClass2);
        questionsArrayList.add(cathuluQuestionClass3);
        questionsArrayList.add(cathuluQuestionClass4);
        questionsArrayList.add(cathuluQuestionClass5);
    }

    public void setOnClose(EventHandler event) {
        popupWindow.setOnCloseRequest((x) -> {
            event.handle(x);
            popupWindow.close();    }
        );

        finishGame.setOnAction((x) -> {
            event.handle(x);
            popupWindow.close();    }
        );
    }

}
