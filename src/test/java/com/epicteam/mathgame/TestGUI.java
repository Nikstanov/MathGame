package com.epicteam.mathgame;

import javafx.application.Platform;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class TestGUI {

    @Test
    void testA() throws InterruptedException {
        Thread thread = new Thread(() -> {
            new JFXPanel();
            Platform.runLater(() -> {
                try {
                    Main main = new Main();
                    Stage stage = new Stage();
                    main.start(stage);

                    main.controller.newFon(new ActionEvent());
                    assertEquals(2,main.controller.fon);

                    main.controller.newFon(new ActionEvent());
                    assertEquals(3,main.controller.fon);

                    main.controller.newFon(new ActionEvent());
                    assertEquals(1,main.controller.fon);

                    main.controller.diffenough.setVisible(false);
                    main.controller.levelenough.setVisible(false);
                    main.controller.click1(new ActionEvent());
                    main.controller.newQuestion();
                    assertNotNull(main.controller.question1);

                    main.controller.clickTextField(new ActionEvent());
                    assertNotNull(main.controller.mainTextField.getText());

                    main.controller.timer.start();
                    main.saveData(main.controller);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        });
        thread.start();
        Thread.sleep(10000);
    }
}
