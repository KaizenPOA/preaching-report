package com.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstTestTask {
    FirstTask task = new FirstTask();

    @Test
    public void douglasTest() {
        assertEquals(task.douglas(), "Haruo");
    }
}