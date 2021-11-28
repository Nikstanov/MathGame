package com.epicteam.mathgame;

import javafx.application.Platform;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {

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

                    main.controller.click(new ActionEvent());
                    assertEquals(2,main.controller.level);
                    assertEquals("Сложность: Легкий", main.controller.hardbutton.getText());

                    main.controller.diffenough.setVisible(false);
                    main.controller.levelenough.setVisible(false);
                    main.controller.click1(new ActionEvent());
                    main.controller.newQuestion();
                    assertNotNull(main.controller.question1);

                    main.controller.changeMenu(true);

                    main.controller.level = 0;
                    main.controller.diffenough.setVisible(false);
                    main.controller.levelenough.setVisible(false);
                    main.controller.click1(new ActionEvent());
                    main.controller.newQuestion();
                    assertNotNull(main.controller.question1);
                    main.controller.clickReturn(new ActionEvent());
                    main.controller.clickReturn(new ActionEvent());


                    main.controller.click2(new ActionEvent());
                    assertEquals("Сложность: Жесть", main.controller.hardbutton.getText());

                    main.controller.diffenough.setVisible(false);
                    main.controller.levelenough.setVisible(false);
                    main.controller.click1(new ActionEvent());
                    main.controller.newQuestion();
                    assertNotNull(main.controller.question1);

                    main.controller.clickTextField(new ActionEvent());
                    assertNotNull(main.controller.mainTextField.getText());

                    main.controller.clickAnswer(new ActionEvent());
                    assertTrue(main.controller.answerIsRight);

                    main.controller.lives = 2;
                    main.controller.clickAnswer(new ActionEvent());
                    assertTrue(main.controller.answerIsRight);

                    main.controller.lives = 1;
                    main.controller.clickAnswer(new ActionEvent());
                    assertTrue(main.controller.answerIsRight);

                    main.controller.lives = 0;
                    main.controller.clickAnswer(new ActionEvent());

                    //main.controller.timer.start();
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
