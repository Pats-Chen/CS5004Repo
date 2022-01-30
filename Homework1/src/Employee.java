import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A class for employee information. The instances created by this class
 * includes objects created by the Paycheck class.
 */
public class Employee {
  private String name;
  private String id;
  private double workHour;
  private double payRate;
  private static final DecimalFormat df = new DecimalFormat("0.00");

  /**
   * Generates an instance of an employee.
   *
   * @param name    full name of the employee.
   * @param id      id number of the employee.
   * @param payRate hourly pay rate of the employee.
   */
  public Employee(String name, String id, double payRate) {
    this.name = name;
    this.id = id;
    this.payRate = payRate;
    this.workHour = 0;
  }

  /**
   * Increase or decrease the work hour of the current week.
   *
   * @param moreHour the increase or decrease of the work hour. Total work hour
   *                 will not be less than 0.
   */
  public void addHoursWorked(double moreHour) {
    double output = this.workHour + moreHour;
    if (output < 0) {
      this.workHour = 0;
    } else {
      this.workHour = output;
    }
  }

  /**
   * Reset the work hour to 0.
   */
  public void resetHoursWorked() {
    this.workHour = 0;
  }

  /**
   * Returns the work hour of the current week.
   *
   * @return a double type number that represents the work hour.
   */
  public double getHoursWorked() {
    return this.workHour;
  }

  /**
   * Initializes a new Paycheck instance and return it.
   *
   * @return a new Paycheck instance.
   */
  public Paycheck getWeeklyCheck() {
    return new Paycheck(this.payRate, this.workHour);
  }

  /**
   * Returns a String that contains information of the employee
   * and his/her payment for the week after taxes.
   *
   * @return a String variable.
   */
  @Override
  public String toString() {
    return "Name: " + this.name + "\nID: " + this.id + "\nPayment after taxes: $ "
            + df.format(this.getWeeklyCheck().getPayAfterTaxes());
  }
}
