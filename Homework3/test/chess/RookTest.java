package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A test class for Rook class.
 */
public class RookTest {
  private Rook rook1;
  private Rook rook2;

  /**
   * Setup some Rook instances for tests.
   */
  @Before
  public void setUp() {
    rook1 = new Rook(0,0, Color.WHITE);
    rook2 = new Rook(7, 7, Color.BLACK);
  }

  /**
   * Test to see if Rook constructor works properly.
   */
  @Test
  public void testRook() {
    Rook rook3 = new Rook(6, 5, Color.WHITE);
    Rook rook4 = new Rook(1, 2, Color.BLACK);
  }

  /**
   * Test to see if Rook constructor handles exception properly.
   * Exception1: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRookException1() {
    Rook rook3 = new Rook(1, -100, Color.WHITE);
  }

  /**
   * Test to see if Rook constructor handles exception properly.
   * Exception2: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRookException2() {
    Rook rook3 = new Rook(8, 6, Color.BLACK);
  }

  /**
   * Test to see if getRow method works properly.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, rook1.getRow());
    assertEquals(7, rook2.getRow());
  }

  /**
   * Test to see if getColumn method works properly.
   */
  @Test
  public void testGetColumn() {
    assertEquals(0, rook1.getColumn());
    assertEquals(7, rook2.getColumn());
  }

  /**
   * Test to see if getColor method works properly.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, rook1.getColor());
    assertEquals(Color.BLACK, rook2.getColor());
  }

  /**
   * Test to see if canMove method works properly.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, rook1.canMove(0,8));
    assertEquals(false, rook1.canMove(0,0));
    assertEquals(true, rook1.canMove(0,7));
    assertEquals(true, rook1.canMove(7,0));
    assertEquals(false, rook1.canMove(7,7));
    assertEquals(false, rook1.canMove(4,7));
    assertEquals(true, rook2.canMove(7,5));
    assertEquals(true, rook2.canMove(3,7));
    assertEquals(false, rook2.canMove(3,3));
    assertEquals(false, rook2.canMove(6,1));
  }
}