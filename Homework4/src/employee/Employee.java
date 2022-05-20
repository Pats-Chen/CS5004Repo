package employee;

/**
 * Author: Jiazhe Chen, NUID: 002162461.
 * A class for salaried employee and hourly employee information. The instances created by
 * this class includes instances created by the SalariedPaycheck and HourlyPaycheck class.
 */
public class Employee {
  private String name;
  private String id;
  private double payRate;
  private int payInterval;
  private boolean isManager;
  private double hoursWorked;
  private IPaycheck paycheck;

  /**
   * Instantiate an new instance of a salaried employee.
   *
   * @param name        a String that shows the full name of the employee.
   * @param id          a string that shows the id number of the employee.
   * @param payRate     a double that shows the yearly pay rate of the employee.
   * @param payInterval an integer that shows the frequency of payments for the employee.
   *                    This can only be for one, two, or four weeks per payment.
   * @param isManager   a boolean that shows if the employee is a manager.
   * @throws IllegalArgumentException if the employee name or id is null or empty, or if
   *                                  the pay rate is negative, or if the pay interval is not
   *                                  one, two, nor four.
   */
  public Employee(String name, String id, double payRate, int payInterval, boolean isManager)
          throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("The employee name cannot be null or empty.");
    } else if (id == null || id.equals("")) {
      throw new IllegalArgumentException("The employee id cannot be null or empty.");
    } else if (payRate < 0) {
      throw new IllegalArgumentException("The employee pay rate cannot be negative.");
    } else if (payInterval != 1 && payInterval != 2 && payInterval != 4) {
      throw new IllegalArgumentException("The pay interval of the paycheck for salaried workers"
              + " can only be one, two or four.");
    } else {
      this.name = name;
      this.id = id;
      this.payRate = payRate;
      this.payInterval = payInterval;
      this.isManager = isManager;
      this.paycheck = new SalariedPaycheck(this.payRate, this.payInterval);
    }
  }

  /**
   * Instantiate an new instance of a hourly employee.
   *
   * @param name        a String that shows the full name of the employee.
   * @param id          a string that shows the id number of the employee.
   * @param payRate     a double that shows the hourly pay rate of the employee.
   * @param hoursWorked a double that shows the working hours of the employee this week.
   * @throws IllegalArgumentException if the employee name or id is null or empty, or if
   *                                  the pay rate is negative, or if the working hours is negative.
   */
  public Employee(String name, String id, double payRate, double hoursWorked)
          throws IllegalArgumentException {
    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("The employee name cannot be null or empty.");
    } else if (id == null || id.equals("")) {
      throw new IllegalArgumentException("The employee id cannot be null or empty.");
    } else if (payRate < 0) {
      throw new IllegalArgumentException("The employee pay rate cannot be negative.");
    } else if (hoursWorked < 0) {
      throw new IllegalArgumentException("The employee working hours cannot be negative.");
    } else {
      this.name = name;
      this.id = id;
      this.payRate = payRate;
      this.hoursWorked = hoursWorked;
      this.paycheck = new HourlyPaycheck(this.payRate, this.hoursWorked);
    }
  }

  /**
   * Return a boolean that shows if this employee is a manager or not.
   *
   * @return true if this employee is a manager. False otherwise.
   */
  public boolean isManager() {
    return this.isManager;
  }

  /**
   * Return a SalariedPaycheck or HourlyPaycheck instance saved in the paycheck attribute.
   *
   * @return a SalariedPaycheck instance if this employee is a salaried employee,
   *     a HourlyPaycheck if this employee is an hourly employee.
   */
  public IPaycheck getPaycheck() {
    return this.paycheck;
  }

  /**
   * Returns a String that contains information of the employee and his/her payment after taxes.
   *
   * @return a String variable.
   */
  @Override
  public String toString() {
    return "Name: " + this.name + "\nID: " + this.id + "\n"
            + this.getPaycheck().toString();
  }
}
