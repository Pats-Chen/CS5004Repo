package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A test class for Knight class.
 */
public class KnightTest {
  private Knight knight1;
  private Knight knight2;

  /**
   * Setup some Knight instances for tests.
   */
  @Before
  public void setUp() {
    knight1 = new Knight(0,1, Color.WHITE);
    knight2 = new Knight(7, 6, Color.BLACK);
  }

  /**
   * Test to see if Knight constructor works properly.
   */
  @Test
  public void testKnight() {
    Knight pawn3 = new Knight(3, 4, Color.WHITE);
    Knight pawn4 = new Knight(4, 6, Color.BLACK);
  }

  /**
   * Test to see if Knight constructor handles exception properly.
   * Exception1: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testKnightException1() {
    Knight knight3 = new Knight(-7, -7, Color.WHITE);
  }

  /**
   * Test to see if Knight constructor handles exception properly.
   * Exception1: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testKnightException2() {
    Knight knight3 = new Knight(11, 8, Color.BLACK);
  }

  /**
   * Test to see if getRow method works properly.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, knight1.getRow());
    assertEquals(7, knight2.getRow());
  }

  /**
   * Test to see if getColumn method works properly.
   */
  @Test
  public void testGetColumn() {
    assertEquals(1, knight1.getColumn());
    assertEquals(6, knight2.getColumn());
  }

  /**
   * Test to see if getColor method works properly.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, knight1.getColor());
    assertEquals(Color.BLACK, knight2.getColor());
  }

  /**
   * Test to see if canMove method works properly.
   */
  @Test
  public void testCanMove() {
    assertEquals(true, knight1.canMove(2,0));
    assertEquals(true, knight1.canMove(2,2));
    assertEquals(true, knight1.canMove(1,3));
    assertEquals(true, knight2.canMove(6,4));
    assertEquals(true, knight2.canMove(5,5));
    assertEquals(true, knight2.canMove(5,7));
    assertEquals(false, knight1.canMove(2,1));
    assertEquals(false, knight1.canMove(1,2));
    assertEquals(false, knight1.canMove(1,0));
    assertEquals(false, knight1.canMove(0,0));
    assertEquals(false, knight1.canMove(1,1));
    assertEquals(false, knight1.canMove(0,2));
    assertEquals(false, knight2.canMove(6,5));
    assertEquals(false, knight2.canMove(6,6));
    assertEquals(false, knight2.canMove(6,7));
    assertEquals(false, knight2.canMove(5,6));
  }
}