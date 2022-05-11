package hw2;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A class for creating objects as hotel rooms.
 */
public class Room {
  private RoomType roomType;
  private int maximumOccupancy;
  private double price;
  private int numberOfGuests;

  /**
   * Return a new Room object.
   *
   * @param roomType a enumerated type for the type of this room.
   * @param price    a double type number for the price of this room.
   * @throws IllegalArgumentException an exception when the input price is less than zero.
   */
  public Room(RoomType roomType, double price) throws IllegalArgumentException {
    if (price < 0) {
      throw new IllegalArgumentException("Room price cannot be less than zero.");
    }
    this.roomType = roomType;
    switch (this.roomType) {
      case SINGLE:
        this.maximumOccupancy = 1;
        break;
      case DOUBLE:
        this.maximumOccupancy = 2;
        break;
      case FAMILY:
        this.maximumOccupancy = 4;
        break;
    }
    this.price = price;
    this.numberOfGuests = 0;
  }

  /**
   * Return a boolean value for the availability of this room.
   *
   * @return true if this room is available; false otherwise.
   */
  public boolean isAvailable() {
    return (this.numberOfGuests == 0);
  }

  /**
   * Set the number of guests to the parameter if this room is available,
   * and the number is less than maximum capacity.
   *
   * @param newNumberOfGuests number of guests who want to book this room.
   */
  public void bookRoom(int newNumberOfGuests) {
    if (newNumberOfGuests > 0
            && this.isAvailable() == true && newNumberOfGuests <= this.maximumOccupancy) {
      this.numberOfGuests = newNumberOfGuests;
    }
  }

  /**
   * Get the number of guests for this room.
   *
   * @return an integer for the number of guests. It should be no less than zero.
   */
  public int getNumberOfGuests() {
    return this.numberOfGuests;
  }
}
