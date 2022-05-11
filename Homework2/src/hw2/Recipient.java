package hw2;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A class for creating objects as recipients.
 */
public class Recipient {
  private String firstName;
  private String lastName;
  private String email;

  /**
   * Return a new Recipient object.
   *
   * @param firstName The first name of the recipient as a string.
   * @param lastName  The last name of the recipient as a string.
   * @param email     The email of the recipient as a string.
   * @throws IllegalArgumentException an exception if any of the parameters is
   *                                  null or empty.
   */
  public Recipient(String firstName, String lastName, String email)
          throws IllegalArgumentException {
    if (firstName == null || lastName == null || email == null) {
      throw new IllegalArgumentException("Arguments cannot be null.");
    }
    if (firstName.equals("") || lastName.equals("") || email.equals("")) {
      throw new IllegalArgumentException("Arguments cannot be empty strings.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Return a string showing the information of this recipient.
   *
   * @return A String that includes the first name, last name and email of this recipient.
   */
  @Override
  public String toString() {
    return this.firstName + " " + this.lastName + " Email:" + this.email;
  }
}