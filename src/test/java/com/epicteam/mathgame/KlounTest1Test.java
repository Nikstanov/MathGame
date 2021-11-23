package com.epicteam.mathgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KlounTest1Test {

    @Test
    void prikol() {
        KlounTest1 t = new KlounTest1();

        int nikoNikoDoka = t.prikol(1,2);
        assertEquals(3,nikoNikoDoka);
    }
}