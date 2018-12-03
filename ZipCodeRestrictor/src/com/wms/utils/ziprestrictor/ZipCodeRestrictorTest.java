package com.wms.utils.ziprestrictor;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ZipCodeRestrictorTest {
    private static Integer[][] input;

    @BeforeClass
    public static void beforeTest() {
        input = new Integer[][] { { 94133, 94133 }, { 94200, 94299 }, { 94226, 94399 } };
    }

    @Test
    public void testRestrictor() {
        Integer[] actual = ZipCodeRestrictor.restrictor(input).peek();
        Integer[] expected = { 94200, 94399 };
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testZipRestrictorCount() {
        Integer[] actual = ZipCodeRestrictor.restrictor(input).peek();
        Assert.assertTrue(actual.length == 2);
    }
}
