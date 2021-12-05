//Radio button resource: https://www.geeksforgeeks.org/javafx-radiobutton-with-examples/

package com.example.noodlesthecat.rooms.livingroom.clickables;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MGCathuluQuiz {

    private static int questionNumberTracker = 0;
    private static int questionsRight = 0;
    private static List<Question> questionsArray = new ArrayList<>();

    private static Scene scene;
    private static Stage popupWindow;

    private static Label questionLabel;
    private static RadioButton selectAnswer1, selectAnswer2, selectAnswer3;
    private static Button submit;
    private static boolean isAnswerCorrect;

    private static ToggleGroup group = new ToggleGroup();

    public static EventHandler<MouseEvent> yesClicked = (m) -> {
          generateGamePane();
    };
    public static EventHandler<MouseEvent> noClicked = (m) -> {
        popupWindow.close();
    };

    public static void display() {

        popupWindow = new Stage();
        popupWindow.initModality(Modality.APPLICATION_MODAL);
        popupWindow.setTitle("Riddles");

        generateGamePane();

        popupWindow.setScene(scene);
        popupWindow.showAndWait();
    }

    private static void generateGamePane(){
        BorderPane root = new BorderPane();
        Label title = new Label("Cathulu the All-Knowing Asks...");
        title.setFont(new Font("Harrington", 28));
        root.setTop(title);

        BorderPane centerPane = new BorderPane();
        questionLabel = new Label("");
        questionLabel.setFont(new Font("Georgia", 18));
        centerPane.setTop(questionLabel);
        questionLabel.setAlignment(Pos.CENTER);
        setQuestion();

        HBox answerSelect = new HBox();
        selectAnswer1 = new RadioButton();
        selectAnswer2 = new RadioButton();
        selectAnswer3 = new RadioButton();
        selectAnswer1.setToggleGroup(group);
        selectAnswer2.setToggleGroup(group);
        selectAnswer3.setToggleGroup(group);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {
                RadioButton rb = (RadioButton)group.getSelectedToggle();
                if (rb != null) {
                    checkAnswer(rb);
                    generateSubmittedAnswerPane();
                }
            }
        });

        answerSelect.getChildren().add(selectAnswer1);
        answerSelect.getChildren().add(selectAnswer2);
        answerSelect.getChildren().add(selectAnswer3);
        centerPane.setCenter(answerSelect);
        setRadioButtonLabels();

        root.setCenter(centerPane);

        scene = new Scene(root,500, 500, Color.ALICEBLUE);
    }

    private static boolean checkAnswer(RadioButton rb){
        if (rb.getText() == questionsArray.get(questionNumberTracker).getAnswer()){
            questionNumberTracker++;
            return isAnswerCorrect = true;
        }
        else return isAnswerCorrect = false;
    }

    public static String outputAnswerResult(){
        String answerIs;
        if(isAnswerCorrect){
            return answerIs = "correct.";
        }
        else return answerIs = "incorrect.";
    }

    private static void generateSubmittedAnswerPane(){
        BorderPane answerPane = new BorderPane();
        Label answerPaneTitle = new Label("That answer is " + outputAnswerResult());
        answerPane.setTop(answerPaneTitle);

        BorderPane centerPane = new BorderPane();
        Label resetQuestion = new Label("Do you want to try another?");
        centerPane.setTop(resetQuestion);

        HBox centerButtonsBox = new HBox();
        Button yesButton = new Button("Yes");
        yesButton.setOnMouseClicked(yesClicked);
        Button noButton = new Button("No");
        noButton.setOnMouseClicked(noClicked);
        centerButtonsBox.getChildren().add(yesButton);
        centerButtonsBox.getChildren().add(noButton);
        centerPane.setCenter(centerButtonsBox);

        answerPane.setCenter(centerPane);

    }

    public static void setQuestion(){
        questionLabel.setText(questionsArray.get(questionNumberTracker).getQuestion());
    }

    public static void setRadioButtonLabels(){
        int correctAnswerSpot = pickRandomButton();
        if (correctAnswerSpot == 1){
            selectAnswer1.setText(questionsArray.get(questionNumberTracker).getAnswer());
            selectAnswer2.setText(questionsArray.get(questionNumberTracker).getAlternateAnswer1());
            selectAnswer3.setText(questionsArray.get(questionNumberTracker).getAlternateAnswer2());
        }
        if (correctAnswerSpot == 2){
            selectAnswer2.setText(questionsArray.get(questionNumberTracker).getAnswer());
            selectAnswer1.setText(questionsArray.get(questionNumberTracker).getAlternateAnswer1());
            selectAnswer3.setText(questionsArray.get(questionNumberTracker).getAlternateAnswer2());
        }
        if (correctAnswerSpot == 3){
            selectAnswer3.setText(questionsArray.get(questionNumberTracker).getAnswer());
            selectAnswer1.setText(questionsArray.get(questionNumberTracker).getAlternateAnswer1());
            selectAnswer2.setText(questionsArray.get(questionNumberTracker).getAlternateAnswer2());
        }
    }

    public static int pickRandomButton(){
        int min = 1;
        int max = 3;
        int buttonToPlace = ThreadLocalRandom.current().nextInt(min, max + 1);
        return buttonToPlace;
    }

    public static void generateQuestionArray(){
        Question question1 = new Question("I'm the rare case when today comes before yesterday. What am I?",
                "A dictionary", "Naptime", "Sunset");

        Question question2 = new Question("What goes all the way around the world, but stays in a corner?",
                "A stamp", "A houseplant", "An airplane");

        Question question3 = new Question("You cannot keep me until you have given me. What am I?",
                "Your word", "A present", "A high-five");

        Question question4 = new Question("This is easy to lift but hard to throw. What is it?",
                "A feather", "A rock", "Hank the Black Cat");

        Question question5 = new Question("What always ends everything?",
                "The letter G", "Entropy", "Bedtime");

        questionsArray.add(question1);
        questionsArray.add(question2);
        questionsArray.add(question3);
        questionsArray.add(question4);
        questionsArray.add(question5);
    }

}
