package employee;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A concrete class for paychecks of hourly employees. This class should inherit from
 * the Paycheck class.
 */
public class HourlyPaycheck extends Paycheck {
  private double hoursWorked;

  /**
   * Instantiate a HourlyPaycheck instance. If the work hour is larger than 40,
   * then the total pay for that part should be multiplied by 1.5.
   *
   * @param payRate     a double that shows the hourly pay rate of the HourlyPaycheck.
   * @param hoursWorked a double that shows the working hours of the week the HourlyPaycheck.
   * @throws IllegalArgumentException if the working hours of the HourlyPaycheck is negative.
   */
  public HourlyPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {
    super(payRate);
    if (hoursWorked < 0) {
      throw new IllegalArgumentException("The hours worked of the hourly employee"
              + " cannot be negative.");
    } else {
      this.hoursWorked = hoursWorked;
      if (this.hoursWorked <= 40) {
        this.totalPay = this.payRate * this.hoursWorked;
      } else {
        this.totalPay = this.payRate * 40 + 1.5 * this.payRate * (this.hoursWorked - 40);
      }
    }
  }

  /**
   * Increase or decrease the working hour of this HourlyPaycheck.
   *
   * @param hoursAdded the increase or decrease of the working hour. Total working hour
   *                   will not be less than 0.
   */
  public void addHoursWorked(double hoursAdded) {
    double output = this.hoursWorked + hoursAdded;
    if (output < 0) {
      this.hoursWorked = 0;
    } else {
      this.hoursWorked = output;
    }
  }

  /**
   * Reset the working hour of this HourlyPaycheck to 0.
   */
  public void resetHoursWorked() {
    this.hoursWorked = 0;
  }

  /**
   * Return the working hour of this HourlyPaycheck.
   *
   * @return a double that represents the working hour of this HourlyPaycheck.
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }
}
