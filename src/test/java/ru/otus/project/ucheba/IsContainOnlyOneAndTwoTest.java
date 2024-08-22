package ru.otus.project.ucheba;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.otus.project.ucheba.Homework22.Main.isContainOnlyOneAndTwo;

public class IsContainOnlyOneAndTwoTest {
    @Test
    void isContainOnlyOneAndTwoTestTrue() {
        Integer[] array = {1, 2};
        Assertions.assertTrue(isContainOnlyOneAndTwo(array));
    }

    @Test
    void isContainOnlyOneAndTwoTestFalse1() {
        Integer[] array = {1, 1};
        Assertions.assertFalse(isContainOnlyOneAndTwo(array));
    }

    @Test
    void isContainOnlyOneAndTwoTestFalse2() {
        Integer[] array = {2, 2};
        Assertions.assertFalse(isContainOnlyOneAndTwo(array));
    }

    @Test
    void isContainOnlyOneAndTwoTestFalseAnyOther() {
        Integer[] array = {1, 3};
        Assertions.assertFalse(isContainOnlyOneAndTwo(array));
    }

    @Test
    void isContainOnlyOneAndTwoTestFalseZero() {
        Integer[] array = {};
        Assertions.assertFalse(isContainOnlyOneAndTwo(array));
    }
}
