package com.samnjoyin.www.services;

import org.junit.Test;

import java.util.Optional;

public class GeneralServiceTest {

    @Test
    public void test_happyCase() {
        GeneralService.amazingPrint(Optional.of("test message"));
    }
}