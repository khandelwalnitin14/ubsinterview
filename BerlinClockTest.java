package com.ubs.opsit.interviews.impl;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BerlinClockTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final BerlinClock clock = new BerlinClock();;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testMinValidBerlinClock() {
    	clock.convertTime("00:00:00");
    }

    @Test
    public void testMaxValidBerlinClock() {
        clock.convertTime("23:59:59");
    }

    @Test
    public void testPrintClock() {
        clock.convertTime("12:30:30");
        clock.printClock();

        String expected = "Y\n" +
                "RR00\n" +
                "RR00\n" +
                "YYRYYR00000\n" +
                "0000\n";

        assertEquals(expected, outContent.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperInvalidHours() {
        clock.convertTime("24:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperInvalidMinutes() {
        clock.convertTime("00:60:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpperInvalidSeconds() {
        clock.convertTime("00:00:60");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerInvalidHours() {
        clock.convertTime("-01:00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerInvalidMinutes() {
        clock.convertTime("00:-01:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLowerInvalidSeconds() {
        clock.convertTime("00:00:-01");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidString() {
        clock.convertTime("00:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullString() {
        clock.convertTime(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyString() {
        clock.convertTime("");
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
