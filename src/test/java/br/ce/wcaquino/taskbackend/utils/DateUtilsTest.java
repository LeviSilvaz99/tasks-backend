package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {
    @Test
    public void deveRetornarTrue(){
        LocalDate date = LocalDate.of(2030, 010 , 01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void deveRetornarFalseDatasPassadas(){
        LocalDate date = LocalDate.of(2010, 010 , 01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void deveRetornarTrueParaDataAtual(){
        LocalDate date = LocalDate.of(2030, 010 , 01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }
}
