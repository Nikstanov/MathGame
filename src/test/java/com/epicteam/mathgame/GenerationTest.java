package com.epicteam.mathgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerationTest {

    @Test
    void generator() {

        Generation gen = new Generation(1,1, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(2,1, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.question1);

        gen = new Generation(3,1, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(1,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.question1);

        gen = new Generation(2,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);

        gen = new Generation(3,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);


        gen = new Generation(4,1, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(5,1, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(6,1, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(4,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(5,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(6,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);


        gen = new Generation(7,1, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(8,1, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(9,1, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.question1);

        gen = new Generation(7,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(8,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(9,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);


        gen = new Generation(0,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen = new Generation(0,2, new int[]{2,2,2,2,2,2,2,2,2,2});
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);


        gen.easyEquationsEasy();
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen.fraction();
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen.quadEquationsEasy();
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[1]);

        gen.trigonEquations();
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen.logEquationsEasy();
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen.hardEquationsEasy();
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen.hardEquationsHard();
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[0]);

        gen.quadEquationsHard();
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[1]);

        gen.cubicEquations();
        assert(100 < gen.layoutQuestion2Y);
        assertNotNull(gen.answer0[2]);
    }
}