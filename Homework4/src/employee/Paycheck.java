package employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A abstract class for paycheck information. This class should be inherited by
 * SalariedPaycheck class and HourlyPaycheck class. The pay rate of this class is immutable.
 */
public abstract class Paycheck implements IPaycheck {
  protected final double payRate;
  protected double totalPay;
  protected static final DecimalFormat df = new DecimalFormat("0.00");

  /**
   * Instantiate a Paycheck instance for the child class to inherit.
   *
   * @param payRate a double that shows the pay rate of the employee.
   *                If the employee is a salaried employee, the pay rate should be
   *                his yearly pay rate. Otherwise, the pay rate should be his hourly pay rate.
   * @throws IllegalArgumentException if the pay rate of the paycheck is negative.
   */
  public Paycheck(double payRate) throws IllegalArgumentException {
    if (payRate < 0) {
      throw new IllegalArgumentException("The pay rate of the paycheck cannot be negative.");
    } else {
      this.payRate = payRate;
    }
  }

  /**
   * Return the pay rate of this Paycheck.
   *
   * @return a double that shows the pay rate of this Paycheck.
   */
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Returns the total pay of this Paycheck.
   *
   * @return a double that shows the total pay of this Paycheck.
   */
  public double getTotalPay() {
    return this.totalPay;
  }

  /**
   * Returns the total pay after taxes of this Paycheck.
   * If the total pay is larger than 400, the overall tax rate is 0.85. Otherwise,
   * the overall tax rate is 0.9.
   * If the total pay after taxes is larger than 0 but less than 0.01, 0.01 is paid.
   *
   * @return a double that shows the total pay after taxes, rounded to 2 decimal places.
   */
  public double getPayAfterTaxes() {
    double payAfterTaxes;
    if (this.totalPay < 400) {
      payAfterTaxes = 0.9 * this.totalPay;
    } else {
      payAfterTaxes = 0.85 * this.totalPay;
    }
    if (payAfterTaxes > 0.0 & payAfterTaxes < 0.01) {
      return 0.01;
    } else {
      return payAfterTaxes;
    }
  }

  /**
   * Returns the paycheck information.
   *
   * @return a String object that shows the payment after taxes within 2 decimal places.
   */
  @Override
  public String toString() {
    BigDecimal payAfterTaxesRounded = BigDecimal.valueOf(this.getPayAfterTaxes());
    payAfterTaxesRounded.setScale(2, RoundingMode.HALF_EVEN);
    return "Payment after taxes: $ " + df.format(payAfterTaxesRounded);
  }
}
