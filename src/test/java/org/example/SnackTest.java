package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnackTest {
    private Snack snack;

    @BeforeEach
    void setUp() {
        snack = new Snack("Coke", 5, 1.50);
    }

    @Test
    void constructionTest() {
        assertEquals("Coke", snack.getName());
        assertEquals(5, snack.getQuantity());
        assertEquals(1.50, snack.getPrice());
    }

    @Test
    void quantityMinusOneTest() {
        snack.quantityMinusOne();
        assertEquals(4, snack.getQuantity());
    }
}