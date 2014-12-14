/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.schneidersa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sandra Schneider
 */
public class GameLogicTest {

    public GameLogicTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class GameLogic.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        GameLogic instance = new GameLogic();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of addWords method, of class GameLogic.
     */
    @Test
    public void testAddWords() {
        System.out.println("addWords");
        String word = "";
        String[] words = null;
        GameLogic instance = new GameLogic();
        instance.addWords(word, words);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of anonymizeAndCheckWord method, of class GameLogic.
     */
    @Test
    public void testAnonymizeAndCheckWord() {
        System.out.println("anonymizeAndCheckWord");
        GameLogic instance = new GameLogic();
        instance.addWords("test");
        String expResult = "_ _ _ _ ";
        String result = instance.anonymizeAndCheckWord();

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of nextRound method, of class GameLogic.
     */
    @Test
    public void testNextRound() {
        System.out.println("nextRound");
        GameLogic instance = new GameLogic();
        boolean expResult = true;
        boolean result = instance.nextRound();
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of winGame method, of class GameLogic.
     */
    @Test
    public void testWinGame() {
        System.out.println("winGame");
        GameLogic instance = new GameLogic();
        boolean expResult = false;
        boolean result = instance.winGame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of resetGame method, of class GameLogic.
     */
    @Test
    public void testResetGame() {
        System.out.println("resetGame");
        GameLogic instance = new GameLogic();
        instance.resetGame();
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

}
