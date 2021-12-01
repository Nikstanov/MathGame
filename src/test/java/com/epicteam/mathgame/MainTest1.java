package com.epicteam.mathgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest1 {

    @Test
    void main() {
        Main mainTest = new Main();
        mainTest.load();
        MainController controller = new MainController(mainTest.exp, mainTest.arrayLevels);
        mainTest.saveData(controller);
        controller.praxisLeft = 1;
        mainTest.saveData(controller);
    }
}