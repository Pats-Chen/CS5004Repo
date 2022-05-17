package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A test class for Bishop class.
 */
public class BishopTest {
  private Bishop bishop1;
  private Bishop bishop2;

  /**
   * Setup some Bishop instances for tests.
   */
  @Before
  public void setUp() {
    bishop1 = new Bishop(0, 2, Color.WHITE);
    bishop2 = new Bishop(7, 5, Color.BLACK);
  }

  /**
   * Test to see if Bishop constructor works properly.
   */
  @Test
  public void testBishop() {
    Bishop bishop3 = new Bishop(1, 0, Color.WHITE);
    Bishop bishop4 = new Bishop(7, 4, Color.BLACK);
  }

  /**
   * Test to see if Bishop constructor handles exception properly.
   * Exception1: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBishopException1() {
    Bishop bishop3 = new Bishop(-5, 4, Color.WHITE);
  }

  /**
   * Test to see if Bishop constructor handles exception properly.
   * Exception2: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBishopException2() {
    Bishop bishop3 = new Bishop(2, 10, Color.BLACK);
  }

  /**
   * Test to see if getRow method works properly.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, bishop1.getRow());
    assertEquals(7, bishop2.getRow());
  }

  /**
   * Test to see if getColumn method works properly.
   */
  @Test
  public void testGetColumn() {
    assertEquals(2, bishop1.getColumn());
    assertEquals(5, bishop2.getColumn());
  }

  /**
   * Test to see if getColor method works properly.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, bishop1.getColor());
    assertEquals(Color.BLACK, bishop2.getColor());
  }

  /**
   * Test to see if canMove method works properly.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, bishop1.canMove(8,8));
    assertEquals(false, bishop1.canMove(0,2));
    assertEquals(true, bishop1.canMove(2,4));
    assertEquals(false, bishop1.canMove(4,5));
    assertEquals(false, bishop1.canMove(5,1));
    assertEquals(false, bishop1.canMove(-1,-1));
    assertEquals(false, bishop1.canMove(7,5));
    assertEquals(true, bishop2.canMove(2,0));
    assertEquals(false, bishop2.canMove(5,6));
    assertEquals(false, bishop2.canMove(2,4));
  }
}