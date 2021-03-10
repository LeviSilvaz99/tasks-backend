package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void isEqualOrFutureDate() {
        LocalDate date = LocalDate.of(2030, 01,01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void isFalseOrFutureDate() {
        LocalDate date = LocalDate.of(2010, 01,01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
    }
    @Test
    public void isTrueOrAtualDate() {
        LocalDate date = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));

    }
}