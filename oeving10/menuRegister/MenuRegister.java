package oeving10.menuRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MenuRegister {
    private HashMap<Integer, Menu> menuRegister;

    public MenuRegister() {
        this.menuRegister = new HashMap<>();
    }

    public HashMap<Integer, Menu> getMenuRegister() {
        return menuRegister;
    }

    public void addDishToMenu(int id, Dish dish) {
        menuRegister.get(id).addDish(dish);
    }

    public Dish findDishByName(String name) {
        return menuRegister.values().stream()
                .flatMap(menu -> menu.getMenu().stream())
                .filter(dish -> dish.getName().equals(name))
                .findFirst().orElse(null);
    }

    public ArrayList<Dish> findDishesByType(String type) {
        return menuRegister.values().stream()
                .flatMap(menu -> menu.getMenu().stream())
                .filter(dish -> dish.getType().equals(type))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void addMenu(ArrayList<Dish> menu) {
        menuRegister.put(menuRegister.size(), new Menu(menuRegister.size(), menu));
    }

    public ArrayList<Menu> getMenusInPriceInterval(double lower, double upper) {
        return menuRegister.values().stream()
                .filter(menu -> menu.getTotalPrice() >= lower && menu.getTotalPrice() <= upper)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
