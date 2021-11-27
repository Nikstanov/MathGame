package com.epicteam.mathgame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class MainController implements Initializable {

    private static final String STRINGEXP = "Ваш опыт: ";
    int exp;
    int[] arrayLevels;
    int level = 1;
    int difficult = 1;
    int praxis;
    int praxisLeft;
    int lives;
    int needexp = 0;

    int praxisInARow;
    String answer;
    String[] answer0;
    ArrayList<Circle> circles = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    boolean answerIsRight;
    boolean returnBack;

    Thread timer = new Thread(new Timer());
    int width = 200;

    public MainController(int exp, int[] arrayLevels){
        this.exp = exp;
        this.arrayLevels = arrayLevels;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        list.addAll(new ArrayList<>(Arrays.asList("Синий фон", "Красный фон", "Желтый фон")));
        mainMenu.setDisable(false);
        gameMenu.setDisable(true);
        mainMenu.setVisible(true);
        gameMenu.setVisible(false);
        expmenu.setText(STRINGEXP + exp);
        returnBack = false;
        startButton.defaultButtonProperty();

        circles.addAll(new ArrayList<>(Arrays.asList(circle1,circle2,circle3,circle4,circle5,circle6,circle7,circle8,
                circle9,circle10,circle11,circle12,circle13,circle14,circle15,circle16,circle17,circle18,circle19,
                circle20,circle21,circle22,circle23,circle24,circle25,circle26,circle27,circle28,circle29,circle30,
                circle31,circle32,circle33,circle34,circle35,circle36,circle37,circle38,circle39,circle40)));

        File file = new File("heart.png");

        try {
            String localUrl = file.toURI().toURL().toString();
            Image image = new Image(localUrl);
            heart1.setImage(image);
            heart11.setImage(image);
            heart111.setImage(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Circle circle1;

    @FXML
    private Circle circle2;

    @FXML
    private Circle circle3;

    @FXML
    private Circle circle4;

    @FXML
    private Circle circle5;

    @FXML
    private Circle circle6;

    @FXML
    private Circle circle7;

    @FXML
    private Circle circle8;

    @FXML
    private Circle circle9;

    @FXML
    private Circle circle10;

    @FXML
    private Circle circle11;

    @FXML
    private Circle circle12;

    @FXML
    private Circle circle13;

    @FXML
    private Circle circle14;

    @FXML
    private Circle circle15;

    @FXML
    private Circle circle16;

    @FXML
    private Circle circle17;

    @FXML
    private Circle circle18;

    @FXML
    private Circle circle19;

    @FXML
    private Circle circle20;

    @FXML
    private Circle circle21;

    @FXML
    private Circle circle22;

    @FXML
    private Circle circle23;

    @FXML
    private Circle circle24;

    @FXML
    private Circle circle25;

    @FXML
    private Circle circle26;

    @FXML
    private Circle circle27;

    @FXML
    private Circle circle28;

    @FXML
    private Circle circle29;

    @FXML
    private Circle circle30;

    @FXML
    private Circle circle31;

    @FXML
    private Circle circle32;

    @FXML
    private Circle circle33;

    @FXML
    private Circle circle34;

    @FXML
    private Circle circle35;

    @FXML
    private Circle circle36;

    @FXML
    private Circle circle37;

    @FXML
    private Circle circle38;

    @FXML
    private Circle circle39;

    @FXML
    private Circle circle40;

    @FXML
    private ImageView heart1;

    @FXML
    private ImageView heart11;

    @FXML
    private ImageView heart111;

    @FXML
    private Button startButton;

    @FXML
    private FlowPane countOfPraxis;

    @FXML
    private FlowPane countOfPraxis1;

    @FXML
    private Button anotherfon;

    @FXML
    private AnchorPane backfon;

    @FXML
    private AnchorPane forwardfon;

    int fon = 1;
    @FXML
    public void newFon(ActionEvent event){
        fon++;
        if (fon > 3){
            fon = 1;
        }
        switch (fon) {
            case 1:
                String settings1 = "-fx-background-color: linear-gradient(#0098dc, #0cf1ff); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;";
                anotherfon.setStyle("-fx-background-radius: 30; -fx-background-color: linear-gradient(#0098dc, #0cf1ff);");
                anotherfon.setTextFill(Color.WHITE);
                forwardfon.setStyle("-fx-background-color: #0098dc; -fx-background-radius: 5;");
                backfon.setStyle("-fx-background-color: linear-gradient(#0098dc, #0cf1ff); -fx-background-radius: 5;");
                startButton.setStyle(settings1);
                hardbutton.setStyle(settings1);
                levelbutton.setStyle(settings1);
                answerButton.setStyle(settings1);
                buttonReturn.setStyle(settings1);
                expmenu.setStyle(settings1);
                anotherfon.setStyle(settings1);
                break;
            case 2:
                String settings2 = "-fx-background-color: linear-gradient(#ea323c, #f5555d); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;";
                anotherfon.setStyle("-fx-background-radius: 30; -fx-background-color: linear-gradient(#ea323c, #f5555d);");
                anotherfon.setTextFill(Color.WHITE);
                forwardfon.setStyle("-fx-background-color: #ea323c; -fx-background-radius: 5;");
                backfon.setStyle("-fx-background-color: linear-gradient(#ea323c, #f5555d); -fx-background-radius: 5;");
                startButton.setStyle(settings2);
                hardbutton.setStyle(settings2);
                levelbutton.setStyle(settings2);
                answerButton.setStyle(settings2);
                buttonReturn.setStyle(settings2);
                expmenu.setStyle(settings2);
                anotherfon.setStyle(settings2);
                break;
            case 3:
                String settings3 = "-fx-background-color: linear-gradient(#ffc825, #ffeb57); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;";
                anotherfon.setStyle("-fx-background-radius: 30; -fx-background-color: linear-gradient(#ffc825, #ffeb57);");
                anotherfon.setTextFill(Color.WHITE);
                forwardfon.setStyle("-fx-background-color: #ffc825; -fx-background-radius: 5;");
                backfon.setStyle("-fx-background-color: linear-gradient(#ffc825, #ffeb57); -fx-background-radius: 5;");
                startButton.setStyle(settings3);
                hardbutton.setStyle(settings3);
                levelbutton.setStyle(settings3);
                answerButton.setStyle(settings3);
                buttonReturn.setStyle(settings3);
                expmenu.setStyle(settings3);
                anotherfon.setStyle(settings3);
                break;
        }
        anotherfon.setText(list.get(fon - 1));
    }


    @FXML
    private Button hardbutton;

    @FXML
    private Label diffenough;

    @FXML
    private void click2(ActionEvent event) {
        if (!levelenough.isVisible()) {
            diffenough.setVisible(false);
            if (difficult == 1) {
                hardbutton.setText("Сложность: Жесть");
                difficult = 2;
                needexp = 200 * (level - 1) + 100;

                if (arrayLevels[level] != 2  && level != 0) {
                    diffenough.setLayoutX(202);
                    diffenough.setText("Пройди хотя бы 2 раза на легком");
                    diffenough.setVisible(true);
                }
                else{
                    if(needexp > exp && level != 0){
                        diffenough.setText("Недостаточно опыта:" +needexp);
                        diffenough.setVisible(true);
                        diffenough.setLayoutX(220);
                    }
                }
            } else {
                hardbutton.setText("Сложность: Легкий");
                difficult = 1;
            }
        }
    }

    @FXML
    private Button levelbutton;

    @FXML
    private Label levelenough;

    @FXML
    private void click(ActionEvent event) {
        if(level < 9) {
            level = level + 1;
        }
        else{
            level = 0;
        }

        levelenough.setVisible(false);

        diffenough.setVisible(false);
        hardbutton.setText("Сложность: Легкий");
        difficult = 1;

        levelbutton.setText("Уровень: " + level);
        needexp = 200 * (level - 1);
        if(level == 0){
            needexp = 0;
        }

        if(level != 0) {
            if (arrayLevels[level] < 1) {
                levelenough.setText("Предыдущий уровень");
                levelenough.setVisible(true);
                levelenough.setLayoutX(50);
            } else {
                if (exp < needexp) {
                    levelenough.setLayoutX(79);
                    levelenough.setText("Опыт: " + needexp);
                    levelenough.setVisible(true);
                }
            }
        }
    }

    @FXML
    private Label expmenu;

    @FXML
    private AnchorPane mainMenu;

    @FXML
    private AnchorPane gameMenu;

    @FXML
    private Label question1;

    @FXML
    private TextField mainTextField;

    @FXML
    private Button buttonReturn;

    @FXML
    private void click1(ActionEvent event){
        if(!levelenough.isVisible() && !diffenough.isVisible()) {
            expmenu.setText(STRINGEXP + exp);
            if (levelenough.isVisible() && exp >= needexp && level != 0 && arrayLevels[level] >= 1) {
                levelenough.setVisible(false);
            }
            if (diffenough.isVisible() && exp >= needexp && level != 0 && arrayLevels[level] > 1) {
                diffenough.setVisible(false);
            }

            changeMenu(false);
            countOfPraxis.setVisible(false);
            countOfPraxis1.setVisible(false);

            praxisInARow = 0;

            praxis = numberOfLevels(level);
            praxisLeft = praxis;
            circles.forEach(circle -> circle.setFill(Color.WHITE));

            lives = 3;

            buttonReturn.setVisible(false);
            if(level == 0){
                buttonReturn.setVisible(true);
            }

            newQuestion();

            width = 200;
            if(!timer.isAlive()){
                Thread timer1 = new Thread(new Timer());
                timer1.start();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Some troubles");
            alert.setHeaderText(null);
            alert.setContentText("Проверьте уровень и сложность");

            alert.showAndWait();
        }
    }

    @FXML
    private Button answerButton;

    @FXML
    private Label question2;

    @FXML
    private Label question3;

    private synchronized void newQuestion(){
        hearts(lives);
        Generation gen = new Generation(level, difficult);
        question1.setText(gen.question1);
        question1.setLayoutX(gen.layoutQuestion1);
        question2.setText(gen.question2);
        question2.setLayoutX(gen.layoutQuestion2);
        question2.setFont(new Font(gen.question2Font));
        question2.setLayoutY(gen.layoutQuestion2Y);
        question3.setLayoutX(gen.layoutQuestion3);
        question3.setText(gen.question3);
        answer0 = gen.answer0;
        mainTextField.setText(answer0[0]);
        if(praxisLeft == 0) {
            if(level != 0) {
                exp = exp + 200;
            }
            if (arrayLevels[level] < 2){
                arrayLevels[level]++;
            }
            changeMenu(true);
        }
        if(lives == 0){
            changeMenu(true);
            if(level != 0 && exp > 0){
                exp = exp - 400;
            }
        }
        expmenu.setText(STRINGEXP + exp);
        praxisLeft--;
    }

    private void hearts(int lives){
        heart1.setVisible(true);
        heart11.setVisible(true);
        heart111.setVisible(true);
        switch (lives){
            case 3:
                break;
            case 2:
                heart1.setVisible(false);
                break;
            case 1:
                heart1.setVisible(false);
                heart11.setVisible(false);
                break;
            default:
                heart1.setVisible(false);
                heart11.setVisible(false);
                heart111.setVisible(false);
        }
    }


    private int numberOfLevels(int level){
        if(level != 0) {
            countOfPraxis.setVisible(true);
            switch (level % 3) {
                case 1:
                    praxis = 20;
                    break;
                case 2:
                    praxis = 30;
                    countOfPraxis1.setVisible(true);
                    break;
                case 0:
                    praxis = 40;
                    countOfPraxis1.setVisible(true);
                    break;
                default:
                    praxis = 10;
            }
        }
        else{
            praxis = -10;
        }
        return praxis;
    }

    @FXML
    private void clickTextField(ActionEvent event){answer = mainTextField.getText();}


    @FXML
    private void clickAnswer(ActionEvent event){
        if (mainTextField.getText() != null){
            answerEvent();
        }
    }

    public void answerEvent(){
        answer = mainTextField.getText();

        answerIsRight = false;
        checkAnswer();
        if(answerIsRight) {
            praxisInARow++;
            if (praxisInARow == 7 && lives < 3){
                lives++;
            }
            exp = exp + 5;
            if(difficult == 2){
                exp = exp + 5;
            }
            circles.get(praxis - praxisLeft - 1).setFill(Color.GREEN);
        }
        else{
            circles.get(praxis - praxisLeft - 1).setFill(Color.RED);
            praxisInARow = 0;
            lives--;
            if(exp > 10){
                exp = exp - 5;
                if(difficult == 2){
                    exp = exp - 5;
                }
            }
            else{
                exp = 0;
            }
        }
        expmenu.setText(STRINGEXP + exp);
        newQuestion();
        width = 200;
    }

    private void checkAnswer(){
        boolean flag = false;
        for(int i = 0; i < 6; i++){
            if (answer0[i] != null && answer.equals(answer0[i])) {
                flag = true;
                break;
            }
        }
        answerIsRight = flag;
    }

    @FXML
    private void clickReturn(ActionEvent event){
        if(!returnBack){
            buttonReturn.setText("Точно?");
            returnBack = true;
        }
        else{
            changeMenu(true);
        }
    }

    public void changeMenu(boolean trueMax){
        mainMenu.setVisible(trueMax);
        mainMenu.setDisable(!trueMax);
        gameMenu.setDisable(trueMax);
        gameMenu.setVisible(!trueMax);
        if (exp < 0){
            exp = 0;
        }
    }

    @FXML
    private Rectangle timerRectangle;

    class Timer implements Runnable{
        @Override
        public void run() {
            while (width >= 1 && gameMenu.isVisible()) {
                timerRectangle.setWidth(width);
                width = width - 1;
                if(width > 150){
                    timerRectangle.setFill(Color.rgb(146,168,25));
                }
                switch (width) {
                    case 150:
                        timerRectangle.setFill(Color.rgb(255, 213, 0));
                        break;
                    case 100:
                        timerRectangle.setFill(Color.rgb(239, 165, 16));
                        break;
                    case 50:
                        timerRectangle.setFill(Color.rgb(232, 12, 12));
                        break;
                }
                try {
                    Thread.sleep(330);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
            if(gameMenu.isVisible()){
                lives = lives - 1;
                exp = exp - 5;
                Platform.runLater(MainController.this::newQuestion);
                timerRectangle.setWidth(200);
                width = 200;
                Thread timer1 = new Thread(new Timer());
                timer1.start();
            }
        }
    }
}