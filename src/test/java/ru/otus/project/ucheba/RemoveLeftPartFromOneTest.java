package ru.otus.project.ucheba;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.otus.project.ucheba.Homework22.Main.removeLeftPartFromOne;

class RemoveLeftPartFromOneTest {
    @Test
    void removeLeftPartFromOneTestTrue() {
        Integer[] array = {1, 2, 1, 2, 2};
        Assertions.assertArrayEquals(new Integer[]{2, 2}, removeLeftPartFromOne(array));
    }

    @Test
    void removeLeftPartFromOneTestZero() {
        Integer[] array = {1, 2, 3, 4, 1};
        Assertions.assertArrayEquals(new Integer[]{}, removeLeftPartFromOne(array));
    }

    @Test
    void removeLeftPartFromOneTestThrow() {
        Integer[] array = {2, 2, 2, 2};
        Assertions.assertThrowsExactly(RuntimeException.class, () -> removeLeftPartFromOne(array));
    }

    @Test
    void removeLeftPartFromOneTestThrowZero() {
        Integer[] array = {};
        Assertions.assertThrowsExactly(RuntimeException.class, () -> removeLeftPartFromOne(array));
    }
}
