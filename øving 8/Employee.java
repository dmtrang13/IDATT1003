import java.util.GregorianCalendar;
import java.util.Calendar;

public class Employee {
    private Person person;
    private int id;
    private int yearOfEmployment;
    private double salary;
    private double taxPercentage;

    public Employee(Person person, int id, int yearOfEmployment, double salary, double taxPercentage) {
        this.person = person;
        this.id = id;
        this.yearOfEmployment = yearOfEmployment;
        this.salary = salary;
        this.taxPercentage = taxPercentage;
    }

    public Person getPerson() {
        return this.person;
    }

    public int getId() {
        return this.id;
    }

    public int getYearOfEmployment() {
        return this.yearOfEmployment;
    }

    public double getSalary() {
        return this.salary;
    }

    public double getTaxPercentage() {
        return this.taxPercentage;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double getNetSalary() {
        return this.salary * (1 - this.taxPercentage);
    }

    public double getGrossYearlySalary() {
        return this.salary * 12;
    }

    public double getYearlyTaxes() {
        return this.salary * this.taxPercentage * 10.5;
    }

    public String getFullName() {
        return person.getFirstName() + ", " + person.getLastName();
    }

    public int getAge() {
        return getCurrentYear() - person.getYearOfBirth();
    }

    public int getYearsEmployed() {
        return getCurrentYear() - this.yearOfEmployment;
    }

    public boolean employedLongerThan(int year) {
        return getYearsEmployed() > year ? true : false;
    }

    public static int getCurrentYear() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.get(Calendar.YEAR);
    }

    public String toString() {
        String string = "Person: " + person.toString() + "\n"
            + "Year of birth: " + person.getYearOfBirth() + "\n"
            + "Id: " + this.id + "\n"
            + "Year of employment: " + this.yearOfEmployment + "\n"
            + "Salary: " + this.salary + "\n"
            + "Tax percentage: " + this.taxPercentage + "\n"
            + "Net salary: " + getNetSalary() + "\n"
            + "Gross yearly salary: " + getGrossYearlySalary() + "\n"
            + "Yearly taxes: " + getYearlyTaxes() + "\n"
            + "Full name: " + getFullName() + "\n"
            + "Age:" + getAge() + "\n"
            + "Years employed:" + getYearsEmployed() + "\n"
            + "Employed longer than 5 years: " + employedLongerThan(5);
        
        return string;
    }
}
