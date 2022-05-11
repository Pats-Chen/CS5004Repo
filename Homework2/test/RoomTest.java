package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A test class for the Room class.
 */
public class RoomTest {
  private Room room1;
  private Room room2;
  private Room room3;

  /**
   * Instantiate a new Room instance for tests.
   */
  @Before
  public void setUp() {
    room1 = new Room(RoomType.SINGLE, 150.0);
    room2 = new Room(RoomType.DOUBLE, 250.0);
    room3 = new Room(RoomType.FAMILY, 400.5);
  }

  /**
   * Test to see if Room constructor handles exceptions properly.
   * Case 1: Use a negative number as price.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRoomException() {
    Room room4 = new Room(RoomType.SINGLE, -5.0);
  }

  /**
   * Test to see if isAvailable method works properly.
   * Case 1: A new room should be available.
   * Case 2: After booking, the room should not be available.
   */
  @Test
  public void testIsAvailable() {
    assertEquals(true, room1.isAvailable());
    room1.bookRoom(1);
    assertEquals(false, room1.isAvailable());
  }

  /**
   * Test to see if getNumberOfGuest works properly.
   */
  @Test
  public void testGetNumberOfGuests() {
    assertEquals(0, room3.getNumberOfGuests());
  }

  /**
   * Test to see if bookRoom method works properly.
   * Case 1: Number of new guests is larger than the maximum occupancy of the room.
   * Case 2: Number of new guests is the same as the maximum occupancy of the room.
   * Case 2: Number of new guests is smaller than the maximum occupancy of the room.
   * Case 4: After the room is booked, new guests should not be able to book this room
   * even though the number of new guests are no more than the maximum occupancy of it.
   */
  @Test
  public void testBookRoom() {
    room1.bookRoom(2);
    assertEquals(0, room1.getNumberOfGuests());
    room1.bookRoom(1);
    assertEquals(1, room1.getNumberOfGuests());
    room3.bookRoom(2);
    assertEquals(2, room3.getNumberOfGuests());
    room2.bookRoom(2);
    room2.bookRoom(1);
    assertEquals(2, room2.getNumberOfGuests());
  }

  /**
   * Test to see if bookRoom method handles errors properly.
   * Case 1: Should raise an exception when the number of guests is negative.
   * Case 2: Should raise an exception when the number of guests is zero.
   */
  @Test
  public void testBookRoomException() {
    room1.bookRoom(-1);
    assertEquals(0, room1.getNumberOfGuests());
    room1.bookRoom(0);
    assertEquals(true, room1.isAvailable());
  }
}