import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Reads employee details from the console, computes the performance
 * based bonus and total salary, and displays the final result.
 */
public class EmployeeApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int employeeId = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Enter Employee Name: ");
        String employeeName = sc.nextLine().trim();

        System.out.print("Enter Basic Salary: ");
        double basicSalary = Double.parseDouble(sc.nextLine().trim());

        int performanceRating = -1;
        while (performanceRating < 1 || performanceRating > 5) {
            System.out.print("Enter Performance Rating (1-5): ");
            try {
                performanceRating = Integer.parseInt(sc.nextLine().trim());
                if (performanceRating < 1 || performanceRating > 5) {
                    System.out.println("Invalid rating. Please enter a value between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number between 1 and 5.");
            }
        }

        Employee employee = new Employee(employeeId, employeeName, basicSalary, performanceRating);
        employee.displayEmployeeDetails();

        sc.close();
    }
}
