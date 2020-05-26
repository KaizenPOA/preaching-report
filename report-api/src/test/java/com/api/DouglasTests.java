package com.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DouglasTests {
    Douglas task = new Douglas("Haruo");

    @Test
    public void returnName() {
        Assertions.assertEquals(task.getName(), "Haruo");
    }
}