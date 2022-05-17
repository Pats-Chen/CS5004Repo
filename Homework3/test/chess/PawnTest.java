package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A test class for Pawn class.
 */
public class PawnTest {
  private Pawn pawn1;
  private Pawn pawn2;

  /**
   * Setup some Pawn instances for tests.
   */
  @Before
  public void setUp() {
    pawn1 = new Pawn(1, 1, Color.WHITE);
    pawn2 = new Pawn(6, 5, Color.BLACK);
  }

  /**
   * Test to see if Pawn constructor works properly.
   */
  @Test
  public void testPawn() {
    Pawn pawn3 = new Pawn(4, 6, Color.WHITE);
    Pawn pawn4 = new Pawn(5, 7, Color.BLACK);
  }

  /**
   * Test to see if Pawn constructor handles exception properly.
   * Exception1: The (row, col) location is on row 0 for WHITE Pawns.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPawnException1() {
    Pawn pawn3 = new Pawn(0, 6, Color.WHITE);
  }

  /**
   * Test to see if Pawn constructor handles exception properly.
   * Exception1: The (row, col) location is on row 7 for BLACK Pawns.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPawnException2() {
    Pawn pawn3 = new Pawn(7, 3, Color.BLACK);
  }

  /**
   * Test to see if Pawn constructor handles exception properly.
   * Exception2: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPawnException3() {
    Pawn pawn3 = new Pawn(17, -4, Color.BLACK);
  }

  /**
   * Test to see if Pawn isStartLocation works properly.
   */
  @Test
  public void testIsStartLocation() {
    assertEquals(true, pawn1.isStartLocation());
  }

  /**
   * Test to see if getRow method works properly.
   */
  @Test
  public void testGetRow() {
    assertEquals(1, pawn1.getRow());
    assertEquals(6, pawn2.getRow());
  }

  /**
   * Test to see if getColumn method works properly.
   */
  @Test
  public void testGetColumn() {
    assertEquals(1, pawn1.getColumn());
    assertEquals(5, pawn2.getColumn());
  }

  /**
   * Test to see if getColor method works properly.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, pawn1.getColor());
    assertEquals(Color.BLACK, pawn2.getColor());
  }

  /**
   * Test to see if canMove method works properly.
   */
  @Test
  public void testCanMove() {
    assertEquals(true, pawn1.canMove(2, 1));
    assertEquals(true, pawn1.canMove(3, 1));
    assertEquals(false, pawn1.canMove(0, 1));
    assertEquals(false, pawn1.canMove(1, 2));
    assertEquals(false, pawn1.canMove(1, 0));
    assertEquals(false, pawn1.canMove(2, 2));
    assertEquals(false, pawn1.canMove(0, 0));
    assertEquals(false, pawn1.canMove(0, 2));
    assertEquals(false, pawn1.canMove(2, 0));
    assertEquals(false, pawn1.canMove(1, 1));
    assertEquals(false, pawn1.canMove(1, 7));
    assertEquals(false, pawn1.canMove(5, 1));
    assertEquals(false, pawn1.canMove(3, 4));
  }
}