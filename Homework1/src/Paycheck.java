import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A class for paycheck information. The attributes of this class is immutable.
 */
public class Paycheck {
  private final double payRate;
  private final double workHour;
  private final double totalPay;
  private static final DecimalFormat df = new DecimalFormat("0.00");

  /**
   * Generates an instance of a paycheck.
   * If the work hour is larger than 40, then the total pay is multiplied by 1.5.
   *
   * @param payRate  hourly pay rate of the paycheck.
   * @param workHour current work hour of the week for the paycheck.
   */
  public Paycheck(double payRate, double workHour) {
    this.payRate = payRate;
    this.workHour = workHour;
    if (this.workHour <= 40) {
      this.totalPay = this.payRate * this.workHour;
    } else {
      this.totalPay = this.payRate * 40 + 1.5 * this.payRate * (this.workHour - 40);
    }
  }

  /**
   * Returns the total pay of the paycheck.
   *
   * @return total pay of the week as a double.
   */
  public double getTotalPay() {
    return this.totalPay;
  }

  /**
   * Returns the total pay after taxes.
   * If the total pay is larger than 400, the overall tax rate is 0.85. Otherwise,
   * the overall tax rate is 0.9.
   * If the total pay after taxes is larger than 0 but less than 0.01, 0.01 is paid.
   *
   * @return total pay after taxes as a double, rounded to 2 decimal places.
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
    return "Payment after taxes: $ " + df.format(Math.floor(this.getPayAfterTaxes()
            * 100.0) / 100.0);
  }
}
