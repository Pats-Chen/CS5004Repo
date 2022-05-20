package employee;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A concrete class for paychecks of salaried employees. This class should inherit from
 * the Paycheck class. The pay interval of this class is immutable.
 */
public class SalariedPaycheck extends Paycheck {
  private final int payInterval;

  /**
   * Instantiate a SalariedPaycheck instance.
   *
   * @param payRate     a double that shows the pay rate of the SalariedPaycheck.
   * @param payInterval an integer that shows the pay interval in weeks of the SalariedPaycheck.
   * @throws IllegalArgumentException if the pay interval of the SalariedPaycheck is not
   *                                  one, two nor four.
   */
  public SalariedPaycheck(double payRate, int payInterval) throws IllegalArgumentException {
    super(payRate);
    if (payInterval != 1 && payInterval != 2 && payInterval != 4) {
      throw new IllegalArgumentException("The pay interval of the paycheck for salaried workers"
              + " can only be one, two or four.");
    } else {
      this.payInterval = payInterval;
      this.totalPay = (this.payRate / 52) * this.payInterval;
    }
  }
}
