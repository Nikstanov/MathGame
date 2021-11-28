package com.epicteam.mathgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerationTest {

    @Test
    void generator() {
        Generation gen = new Generation(1,1);
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);
    }
}