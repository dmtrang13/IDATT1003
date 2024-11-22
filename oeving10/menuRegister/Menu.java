package oeving10.menuRegister;

import java.util.ArrayList;

public class Menu {
    private int id;
    private ArrayList<Dish> menu;

    public Menu(int id) {
        this.id = id;
        this.menu = new ArrayList<>();
    }

    public Menu(int id, ArrayList<Dish> menu) {
        this.id = id;
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Dish> getMenu() {
        return menu;
    }

    public void addDish(Dish dish) {
        menu.add(dish);
    }

    public double getTotalPrice() {
        return menu.stream().mapToDouble(dish -> dish.getPrice()).sum();
    }

    @Override
    public String toString() {
        String string = "-----------Menu " + id + "-----------\n";

        for (Dish dish : menu) {
            string += dish + "\n";
        }

        string += "----------------------------";

        return string;
    }
}