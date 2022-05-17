package chess;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A test class for King class.
 */
public class KingTest {
  private King king1;
  private King king2;

  /**
   * Setup some King instances for tests.
   */
  @Before
  public void setUp() {
    king1 = new King(0, 3, Color.WHITE);
    king2 = new King(7, 3, Color.BLACK);
  }

  /**
   * Test to see if King constructor works properly.
   */
  @Test
  public void testQueen() {
    Queen queen3 = new Queen(7, 6, Color.WHITE);
    Queen queen4 = new Queen(1, 5, Color.BLACK);
  }

  /**
   * Test to see if King constructor handles exception properly.
   * Exception1: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testQueenException1() {
    King king3 = new King(9, -2, Color.WHITE);
  }

  /**
   * Test to see if Queen constructor handles exception properly.
   * Exception2: The (row, col) location is out of the game board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testQueenException2() {
    King king3 = new King(-7, 21, Color.BLACK);
  }

  /**
   * Test to see if getRow method works properly.
   */
  @Test
  public void testGetRow() {
    assertEquals(0, king1.getRow());
    assertEquals(7, king2.getRow());
  }

  /**
   * Test to see if getColumn method works properly.
   */
  @Test
  public void testGetColumn() {
    assertEquals(3, king1.getColumn());
    assertEquals(3, king2.getColumn());
  }

  /**
   * Test to see if getColor method works properly.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.WHITE, king1.getColor());
    assertEquals(Color.BLACK, king2.getColor());
  }

  /**
   * Test to see if isKingReach method works properly.
   */
  @Test
  public void testIsKingReach() {
    assertEquals(true, king1.isKingReach(0, 2));
    assertEquals(true, king1.isKingReach(0, 4));
    assertEquals(true, king1.isKingReach(1, 3));
    assertEquals(true, king1.isKingReach(1, 2));
    assertEquals(true, king1.isKingReach(1, 4));
    assertEquals(true, king2.isKingReach(7, 2));
    assertEquals(true, king2.isKingReach(7, 4));
    assertEquals(true, king2.isKingReach(6, 3));
    assertEquals(true, king2.isKingReach(6, 2));
    assertEquals(true, king2.isKingReach(6, 4));
  }

  /**
   * Test to see if canMove method works properly.
   */
  @Test
  public void testCanMove() {
    assertEquals(false, king1.canMove(-1, 5));
    assertEquals(false, king1.canMove(2, -4));
    assertEquals(false, king1.canMove(-7, 9));
    assertEquals(false, king1.canMove(12, -6));
    assertEquals(false, king1.canMove(0, 3));
    assertEquals(false, king1.canMove(3, 3));
    assertEquals(false, king1.canMove(0, 5));
    assertEquals(false, king1.canMove(2, 5));
    assertEquals(false, king2.canMove(7, 3));
  }
}