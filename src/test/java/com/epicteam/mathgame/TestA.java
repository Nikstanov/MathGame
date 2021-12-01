package com.epicteam.mathgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestA {

    @Test
    void main() {
        Main mainTest = new Main();
        mainTest.load();
        MainController controller = new MainController(mainTest.exp, mainTest.arrayLevels);
        assertEquals(mainTest.exp,controller.exp);
        mainTest.saveData(controller);
        controller.praxisLeft = 1;
        mainTest.saveData(controller);
        assert(mainTest.exp >= 0);
    }
}