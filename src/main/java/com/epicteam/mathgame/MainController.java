package com.epicteam.mathgame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Controller of application
 * @author Stahnov
 * @version 1.0.0
 */
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

    /**
     * Initialize of controller
     */
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

        File fileElPrimo = new File("src/main/resources/com/epicteam/mathgame/ElPrimo.png");
        Image imageElPrimo = new Image(fileElPrimo.toURI().toString());
        elPrimo.setImage(imageElPrimo);

        File fileBoard = new File("src/main/resources/com/epicteam/mathgame/Board.png");
        Image imageBoard = new Image(fileBoard.toURI().toString());
        boardInGame.setImage(imageBoard);
        boardInGame1.setImage(imageBoard);

        circles.addAll(new ArrayList<>(Arrays.asList(circle1,circle2,circle3,circle4,circle5,circle6,circle7,circle8,
                circle9,circle10,circle11,circle12,circle13,circle14,circle15,circle16,circle17,circle18,circle19,
                circle20,circle21,circle22,circle23,circle24,circle25,circle26,circle27,circle28,circle29,circle30,
                circle31,circle32,circle33,circle34,circle35,circle36,circle37,circle38,circle39,circle40)));

        File file = new File("src/main/resources/com/epicteam/mathgame/heart.png");

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
    private ImageView elPrimo;

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
    public ImageView heart1;

    @FXML
    public ImageView heart11;

    @FXML
    public ImageView heart111;

    @FXML
    public Button startButton;

    @FXML
    public FlowPane countOfPraxis;

    @FXML
    public FlowPane countOfPraxis1;

    @FXML
    public Button anotherfon;

    @FXML
    public AnchorPane backfon;

    @FXML
    public AnchorPane forwardfon;

    @FXML
    private ImageView boardInGame;

    @FXML
    private ImageView boardInGame1;

    int fon = 1;
    Font tahoma1 = new Font("Tahoma Bold",14);
    Font tahoma2 = new Font("Tahoma Bold",20);
    String currentFontFile = "DS Eraser Cyr Font.ttf";
    InputStream fontStream = Generation.class.getResourceAsStream(currentFontFile);
    Font fontBoard = Font.loadFont(fontStream,12);

    InputStream fontStream1 = Generation.class.getResourceAsStream(currentFontFile);
    Font fontBoard1 = Font.loadFont(fontStream1,17);
    /**
     * Changing the theme of the application by the user
     */
    @FXML
    public void newFon(ActionEvent event){
        fon++;
        if (fon > 3){
            fon = 1;
        }
        switch (fon) {
            case 1 -> {
                forwardfon.setVisible(true);
                boardInGame.setVisible(false);
                boardInGame1.setVisible(false);
                String settings1 = "-fx-background-color: linear-gradient(#0098dc, #0cf1ff); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;";
                changeStyle(tahoma1, tahoma2, settings1);
                anotherfon.setStyle("-fx-background-radius: 30; -fx-background-color: linear-gradient(#0098dc, #0cf1ff);");
                anotherfon.setTextFill(Color.WHITE);
                forwardfon.setStyle("-fx-background-color: #0098dc; -fx-background-radius: 5;");
                backfon.setStyle("-fx-background-color: linear-gradient(#0098dc, #0cf1ff); -fx-background-radius: 5;");
            }
            case 2 -> {
                String settings2 = "-fx-background-color: green; -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;";
                changeStyle(fontBoard, fontBoard1, settings2);
                boardInGame.setVisible(true);
                boardInGame1.setVisible(true);
                forwardfon.setVisible(false);
            }
            case 3 -> {
                expmenu.setFont(tahoma1);
                anotherfon.setFont(tahoma1);
                forwardfon.setVisible(true);
                boardInGame.setVisible(false);
                boardInGame1.setVisible(false);
                String settings3 = "-fx-background-color: linear-gradient(#ffc825, #ffeb57); -fx-background-radius: 30; -fx-background-insets: 0; -fx-text-fill: white;";
                changeStyle(tahoma1, tahoma2, settings3);
                anotherfon.setStyle("-fx-background-radius: 30; -fx-background-color: linear-gradient(#ffc825, #ffeb57);");
                anotherfon.setTextFill(Color.WHITE);
                forwardfon.setStyle("-fx-background-color: #ffc825; -fx-background-radius: 5;");
                backfon.setStyle("-fx-background-color: linear-gradient(#ffc825, #ffeb57); -fx-background-radius: 5;");
            }
            default -> anotherfon.setText("Ошибка");
        }
        anotherfon.setText(list.get(fon - 1));
    }

    private void changeStyle(Font font1, Font font2, String settings){
        startButton.setStyle(settings);
        hardbutton.setStyle(settings);
        levelbutton.setStyle(settings);
        answerButton.setStyle(settings);
        buttonReturn.setStyle(settings);
        expmenu.setStyle(settings);
        anotherfon.setStyle(settings);
        startButton.setFont(font2);
        levelbutton.setFont(font2);
        hardbutton.setFont(font1);
        answerButton.setFont(font1);
        buttonReturn.setFont(font1);
        expmenu.setFont(font1);
        anotherfon.setFont(font1);
    }
    @FXML
    public Button hardbutton;

    @FXML
    public Label diffenough;

    /**
     * Changing the difficulty level with the output of subsequent errors
     */
    @FXML
    public void click2(ActionEvent event) {
        if (!levelenough.isVisible()) {
            diffenough.setVisible(false);
            if (difficult == 1) {
                hardbutton.setText("Сложность: Жесть");
                difficult = 2;
                needexp = 200 * (level - 1) + 100;

                if (arrayLevels[level - 1] != 2  && level != 0) {
                    diffenough.setLayoutX(214);
                    diffenough.setText("Пройди хотя бы 2 раза на легком");
                    diffenough.setVisible(true);
                }
                else{
                    if(needexp > exp && level != 0){
                        diffenough.setText("Недостаточно опыта:" +needexp);
                        diffenough.setVisible(true);
                        diffenough.setLayoutX(232);
                    }
                }
            } else {
                hardbutton.setText("Сложность: Легкий");
                difficult = 1;
            }
        }
    }

    @FXML
    public Button levelbutton;

    @FXML
    public Label levelenough;

    /**
     * Change of the launched level with the output of subsequent errors
     */
    @FXML
    public void click(ActionEvent event) {
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
            if (arrayLevels[level - 1] < 1) {
                levelenough.setText("Предыдущий уровень");
                levelenough.setVisible(true);
                levelenough.setLayoutX(35);
            } else {
                if (exp < needexp) {
                    levelenough.setLayoutX(64);
                    levelenough.setText("Опыт: " + needexp);
                    levelenough.setVisible(true);
                }
            }
        }
    }

    @FXML
    public Label expmenu;

    @FXML
    public AnchorPane mainMenu;

    @FXML
    public AnchorPane gameMenu;

    @FXML
    public Label question1;

    @FXML
    public TextField mainTextField;

    @FXML
    public Button buttonReturn;

    /**
     * Launching the game itself
     */
    @FXML
    public void click1(ActionEvent event){
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
    public Button answerButton;

    @FXML
    public Label question2;

    @FXML
    public Label question3;

    /**
     * Displaying a new level question for the user
     */
    public synchronized void newQuestion(){
        hearts(lives);
        Generation gen = new Generation(level, difficult, arrayLevels);
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
            if (arrayLevels[level - 1] < 2){
                arrayLevels[level - 1]++;
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

    /**
     * Displaying the number of user attempts
     * @param lives User attempts
     */
    public void hearts(int lives){
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

    /**
     * Generating number of level examples
     * @param level selected level
     * @return number of praxis
     */
    public int numberOfLevels(int level){
        if(level != 0) {
            countOfPraxis.setVisible(true);
            praxis = 20;
            switch (level % 3) {
                case 2 -> {
                    praxis = praxis + 10;
                    countOfPraxis1.setVisible(true);
                }
                case 0 -> {
                    praxis = praxis + 20;
                    countOfPraxis1.setVisible(true);
                }
            }
        }
        else{
            praxis = -10;
        }
        return praxis;
    }

    /**
     * User input
     */
    @FXML
    public void clickTextField(ActionEvent event){answer = mainTextField.getText();}

    /**
     * Event of entering the final answer to a question
     */
    @FXML
    public void clickAnswer(ActionEvent event){
        if (mainTextField.getText() != null){
            answerEvent();
        }
    }

    /**
     * Event of entering the final answer to a question
     */
    private void answerEvent(){
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

    /**
     * Validating User-Entered Answer
     */
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

    /**
     * Exit to the menu in infinite damage
     */
    @FXML
    public void clickReturn(ActionEvent event){
        if(!returnBack){
            buttonReturn.setText("Точно?");
            returnBack = true;
        }
        else{
            changeMenu(true);
        }
    }

    /**
     * Switch to game menu or vice versa
     */
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
    public Rectangle timerRectangle;

    /**
     * Timer class for answering a question
     */
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
                    case 150 -> timerRectangle.setFill(Color.rgb(255, 213, 0));
                    case 100 -> timerRectangle.setFill(Color.rgb(239, 165, 16));
                    case 50 -> timerRectangle.setFill(Color.rgb(232, 12, 12));
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