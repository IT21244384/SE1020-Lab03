/**
 * Represents an employee whose details and performance evaluation
 * are handled securely (private fields with controlled access via
 * getters and setters).
 */
public class Employee {

    private int employeeId;
    private String employeeName;
    private double basicSalary;
    private int performanceRating; // valid range: 1 - 5

    public Employee(int employeeId, String employeeName, double basicSalary, int performanceRating) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        setBasicSalary(basicSalary);
        setPerformanceRating(performanceRating);
    }

    // ----- Getters and Setters -----

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        if (basicSalary < 0) {
            throw new IllegalArgumentException("Basic salary cannot be negative.");
        }
        this.basicSalary = basicSalary;
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int performanceRating) {
        if (performanceRating < 1 || performanceRating > 5) {
            throw new IllegalArgumentException("Performance rating must be between 1 and 5.");
        }
        this.performanceRating = performanceRating;
    }

    // ----- Business Logic -----

    /**
     * Calculates the bonus amount based on the employee's performance rating.
     * 5 -> 20%, 4 -> 15%, 3 -> 10%, 2 -> 5%, 1 -> 0%
     */
    public double calculateBonus() {
        double bonusPercentage;

        switch (performanceRating) {
            case 5:
                bonusPercentage = 0.20;
                break;
            case 4:
                bonusPercentage = 0.15;
                break;
            case 3:
                bonusPercentage = 0.10;
                break;
            case 2:
                bonusPercentage = 0.05;
                break;
            default:
                bonusPercentage = 0.0;
        }

        return basicSalary * bonusPercentage;
    }

    /**
     * Total Salary = Basic Salary + Bonus
     */
    public double calculateTotalSalary() {
        return basicSalary + calculateBonus();
    }

    public void displayEmployeeDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + employeeName);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Performance Rating: " + performanceRating);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Total Salary: " + calculateTotalSalary());
    }
}
