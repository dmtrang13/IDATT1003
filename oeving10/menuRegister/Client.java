package oeving10.menuRegister;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private static final Scanner scanner = new Scanner(System.in);

    private static MenuRegister init(){
        MenuRegister menuRegister = new MenuRegister();

        ArrayList<Dish> italianDishes = new ArrayList<>();
        italianDishes.add(new Dish("Caesar Salad", "Appetizer", 59.90));
        italianDishes.add(new Dish("Spaghetti Carbonara", "Main", 129.90));
        italianDishes.add(new Dish("Tiramisu", "Dessert", 69.90));
        italianDishes.add(new Dish("Lemonade", "Drink", 25.00));

        ArrayList<Dish> americanDishes = new ArrayList<>();
        americanDishes.add(new Dish("Garlic Bread", "Appetizer", 39.90));
        americanDishes.add(new Dish("Steak", "Main", 199.90));
        americanDishes.add(new Dish("Cheesecake", "Dessert", 75.00));
        americanDishes.add(new Dish("Coffee", "Drink", 20.00));

        menuRegister.addMenu(italianDishes);
        menuRegister.addMenu(americanDishes);

        return menuRegister;

    } 

    private static int getValidInt(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine(); 
            try {   
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer");
            }
        }
    }

    private static double getValidDouble(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine(); 
            try {   
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid double");
            }
        }
    }

    private static String getNonEmptyString(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Please enter a valid string");
            } else {
                return input;
            }
        }
    }

    private static Dish createDish() {
        String name = getNonEmptyString("Dish name:");
        String type = getNonEmptyString("Dish type:");
        double price = getValidDouble("Dish price:");

        return new Dish(name, type, price);
    }

    private static void addNewDish(MenuRegister menuRegister) {
        int id = getValidInt("Menu id:");

        menuRegister.addDishToMenu(id, createDish());
    }

    private static Dish findDishByName(MenuRegister menuRegister) {
        String name = getNonEmptyString("Dish name:");

        return menuRegister.findDishByName(name);
    }

    private static ArrayList<Dish> findDishesByType(MenuRegister menuRegister) {
        String type = getNonEmptyString("Dish type:");

        return menuRegister.findDishesByType(type);
    }

    private static void addMenu(MenuRegister menuRegister) {
        int dishCount = getValidInt("How many dishes:");
        ArrayList<Dish> dishes = new ArrayList<>();

        for (int i = 0; i < dishCount; i++) {
            dishes.add(createDish());
        }

        menuRegister.addMenu(dishes);
    }

    private static ArrayList<Menu> getMenusInPriceInterval(MenuRegister menuRegister) {
        double lower = getValidDouble("Lower price:");
        double upper = getValidDouble("Upper price:");

        return menuRegister.getMenusInPriceInterval(lower, upper);
    }

    private static int pickOption() {
        return getValidInt("Please pick an option:\n"
                + "1. Add new dish\n"
                + "2. Find dish by name\n"
                + "3. Find dishes by type\n"
                + "4. Add menu\n"
                + "5. Get menus in price interval\n"
                + "6. Quit");
    }

    private static void client(MenuRegister menuRegister) {
        while (true) {
            int option = pickOption();

            switch (option) {
                case 1 -> {
                    addNewDish(menuRegister);
                }
                case 2 -> {
                    System.out.println(findDishByName(menuRegister));
                }
                case 3 -> {
                    findDishesByType(menuRegister).stream().forEach(dish -> System.out.println(dish + "\n"));
                }
                case 4 -> {
                    addMenu(menuRegister);
                }
                case 5 -> {
                    getMenusInPriceInterval(menuRegister).stream().forEach(menu -> System.out.println(menu + "\n"));
                }
                case 6 -> {
                    return;
                }
            }
        }
    }
    public static void main(String[] args) {
        MenuRegister menuRegister = init();
        client(menuRegister);
        scanner.close();
    }
}
