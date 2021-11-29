package com.epicteam.mathgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Parent;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Objects;
import java.util.Scanner;

/**
 * <h1> Main application class </h1>
 * Applications for pumping brains, developing the ability to solve the school curriculum of mathematics
 * @author Stahnov
 * @version 1.0.0
 */
public class Main extends Application {
    int exp = 15;
    int[] arrayLevels = {0,0,0,0,0,0,0,0,0,0};

    MainController controller;

    /**
     * Main method
     */
    public static void main(String[] args){
        Application.launch(args);
    }

    /**
     * Opening an application
     * @param stage application stage
     */
    @Override
    public void start(Stage stage) throws Exception {

        load();

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("Main.fxml")));

        controller = new MainController(exp, arrayLevels);
        loader.setController(controller);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("MathGame");
        stage.setWidth(400);
        stage.setHeight(500);
        stage.setResizable(false);
        stage.show();
        super.stop();

        stage.setOnCloseRequest(windowEvent -> {
            saveData(controller);
            System.exit(0);
        });
    }

    /**
     * Loading user data and game progress
     */
    public void load() {
        try(FileReader fr = new FileReader("preservation.txt")) {
            try (Scanner scan = new Scanner(fr)) {
                exp = Integer.parseInt(scan.nextLine());
                for (int i = 0; i < 10; i++) {
                    arrayLevels[i] = Integer.parseInt(scan.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saving data about the user and the progress of the game
     * @param controller of application
     */
    public void saveData(MainController controller){
        if (controller.praxisLeft != 0 && controller.level != 0 && controller.exp >= 200){
            controller.exp = controller.exp - 200;
        }
        try (FileWriter fw = new FileWriter("preservation.txt")){
            fw.write(controller.exp+"\n");
            for(int i = 0;i < 10;i++){
                fw.write(controller.arrayLevels[i] + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}