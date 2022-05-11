package hw2;

/**
 * Author: Jiazhe Chen, NUID: 002162461
 * A class for creating objects as mail items.
 */
public class MailItem {
  private int width;
  private int height;
  private int depth;
  private Recipient recipient;

  /**
   * Return a new MailItem object.
   *
   * @param width     The width of the mail item. An integer. Should be no less than 1.
   * @param height    The height of the mail item. An integer. Should be no less than 1.
   * @param depth     The depth of the mail item. An integer. Should be no less than 1.
   * @param recipient The recipient of the mail item. A Recipient object. Should not be null.
   * @throws IllegalArgumentException an exception if width, height or depth of the
   *                                  mail item is less than 1, or the recipient is null.
   */
  public MailItem(int width, int height, int depth, Recipient recipient)
          throws IllegalArgumentException {
    if (width < 1 || height < 1 || depth < 1) {
      throw new IllegalArgumentException("The width, height and depth cannot be less than 1.");
    }
    if (recipient == null) {
      throw new IllegalArgumentException("Recipient of the mail item cannot be null.");
    }
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

  /**
   * Return the width of this mail item.
   *
   * @return an integer. Should be no less than 1.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Return the height of this mail item.
   *
   * @return an integer. Should be no less than 1.
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Return the depth of this mail item.
   *
   * @return an integer. Should be no less than 1.
   */
  public int getDepth() {
    return this.depth;
  }

  /**
   * Return the recipient of this mail item.
   *
   * @return an Recipient object. Should not be null.
   */
  public Recipient getRecipient() {
    return this.recipient;
  }
}
