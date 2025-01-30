import java.util.Scanner;

public class Client {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getValidInt(String message) {
        while (true) {
            System.out.println(message);
            try {
                int option = Integer.parseInt(scanner.nextLine()); //convert input into interger
                return option;
            }
            catch (NumberFormatException e) { //catch runtime exception when converting non-convertible integer
                System.out.println("Invalid input!");
            }
        }
    }

    public static double getValidDouble(String message) {
        while (true) {
            System.out.println(message);
            try {
                double option = Double.parseDouble(scanner.nextLine()); //convert input into double
                return option;
            }
            catch (NumberFormatException e) { //catch runtime exception when converting non-convertible double
                System.out.println("Invalid input!"); 
            }
        }
    }

    public static int pickOption() {
        System.out.println("Pick an option:");
        while (true) {
            System.out.println("1. Print employee");
            System.out.println("2. Set salary");
            System.out.println("3. Set tax percentage");
            System.out.println("4. Quit");

            int option = getValidInt("");

            if (option > 0 && option < 5) {
                return option;
            }
            else {
                System.out.println("Pick a valid option");
            }
        }
    }

    public static void runClient(Employee employee) {
        boolean run = true;

        while (run) {
            int option = pickOption();

            switch (option) {
                case 1 -> System.out.println(employee.toString());
                case 2 -> {
                    double newSalary = getValidDouble("New salary:");
                    employee.setSalary(newSalary);
                    System.out.println("Salary: " + employee.getSalary());
                }
                case 3 -> {
                    double newTaxPercentage = getValidDouble("New tax percentage:");
                    employee.setTaxPercentage(newTaxPercentage);
                    System.out.println("Tax percentage: " + employee.getTaxPercentage());
                }
                case 4 -> run = false;
                default -> System.out.println("Pick a valid option");
            }
        }
    }



    public static void main(String[] args) {
        Employee employee = new Employee(new Person("Trang", "Minh Duong", 2005), 0, 2018, 50000, 0.3);
        System.out.println(employee.toString());

        runClient(employee);

        scanner.close();
    }
}
