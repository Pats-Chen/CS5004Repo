package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A test class for Queen class.
 */
public class QueenTest {
  private Queen queen1;
  private Queen queen2;

  /**
   * Setup some Queen instances for tests.
   */
  @Before
  public void setUp() {
    queen1 = new Queen(0, 4, Color.WHITE);
    queen2 = new Queen(7, 4, Color.BLACK);
  }

  /**
   * Test to see if Queen constructor works properly.
   */
  @Test
  public void testQueen() {
    Queen queen3 = new Queen(0, 1, Color.WHITE);
    Queen queen4 = new Queen(0, 6, Color.BLACK);
  }

  /**
   * Test to see if Queen constructor handles exception properly.
   * Exception1: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testQueenException1() {
    Queen queen3 = new Queen(-5, 3, Color.WHITE);
  }

  /**
   * Test to see if Queen constructor handles exception properly.
   * Exception2: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testQueenException2() {
    Queen queen3 = new Queen(2, 20, Color.BLACK);
  }

  /**
   * Test to see if getRow method works properly.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, queen1.getRow());
    assertEquals(7, queen2.getRow());
  }

  /**
   * Test to see if getColumn method works properly.
   */
  @Test
  public void testGetColumn() {
    assertEquals(4, queen1.getColumn());
    assertEquals(4, queen2.getColumn());
  }

  /**
   * Test to see if getColor method works properly.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, queen1.getColor());
    assertEquals(Color.BLACK, queen2.getColor());
  }

  /**
   * Test to see if isQueenReach method works properly.
   */
  @Test
  public void testIsQueenReach() {
    assertEquals(true, queen1.isQueenReach(3, 1));
    assertEquals(true, queen1.isQueenReach(2, 6));
    assertEquals(true, queen1.isQueenReach(5, 4));
    assertEquals(true, queen1.isQueenReach(0, 7));
    assertEquals(false, queen1.isQueenReach(1, 0));
    assertEquals(false, queen1.isQueenReach(3, 5));
  }

  /**
   * Test to see if canMove method works properly.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, queen1.canMove(-2, 1));
    assertEquals(false, queen1.canMove(2, -6));
    assertEquals(false, queen1.canMove(24, 12));
    assertEquals(false, queen1.canMove(-10, -10));
    assertEquals(false, queen1.canMove(0, 4));
    assertEquals(false, queen2.canMove(7, 4));
  }
}