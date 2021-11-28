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


public class Main extends Application {
    int exp = 15;
    int[] arrayLevels = {0,0,0,0,0,0,0,0,0,0};

    MainController controller;

    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        load();

        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("Main.fxml")));

        controller = new MainController(exp, arrayLevels);
        loader.setController(controller);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Математический тренажер");
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

    public void load() throws Exception {
        FileReader fr = new FileReader("preservation.txt");
        try (Scanner scan = new Scanner(fr)) {
            exp = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < 10; i++) {
                arrayLevels[i] = Integer.parseInt(scan.nextLine());
            }
            fr.close();
        }
    }

    public void saveData(MainController controller){
        if (controller.praxisLeft != 0 && controller.level != 0 && controller.exp >= 200){
            controller.exp = controller.exp - 200;
        }
        try {
            FileWriter fw = new FileWriter("preservation.txt");
            fw.write(controller.exp+"\n");
            for(int i = 0;i < 10;i++){
                fw.write(controller.arrayLevels[i] + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}