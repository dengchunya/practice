package com.dengchunya.practice.P20190731;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BirthdayGreetTest {

    @Test
    public void greet() throws IOException {
        BirthdayGreet birthdayGreet = new BirthdayGreet();
        birthdayGreet.greet("C:\\code\\practice\\src\\main\\java\\com\\dengchunya\\practice\\P20190731\\record.txt");
    }
}