+----------------+
|     Dish       |
+----------------+
| - name: String |
| - type: String |
| - price: double|
+----------------+
| + Dish(name: String, type: String, price: double) |
| + getName(): String                               |
| + getType(): String                               |
| + getPrice(): double                              |
| + toString(): String                              |
+----------------+

+-----------------------------+
|            Menu             |
+-----------------------------+
| - id: int                   |
| - menu: ArrayList<Dish>     |
+-----------------------------+
| + Menu(id: int)                                 |
| + Menu(id: int, menu: ArrayList<Dish>)          |
| + getId(): int                                  |
| + getMenu(): ArrayList<Dish>                    |
| + addDish(dish: Dish): void                     |
| + getTotalPrice(): double                       |
| + toString(): String                            |
+-----------------------------+

+------------------------------------+
|           MenuRegister             |
+------------------------------------+
| - menuRegister: HashMap<Integer, Menu> |
+------------------------------------+
| + MenuRegister()                                  |
| + getMenuRegister(): HashMap<Integer, Menu>       |
| + addDishToMenu(id: int, dish: Dish): void        |
| + findDishByName(name: String): Dish              |
| + findDishesByType(type: String): ArrayList<Dish> |
| + addMenu(menu: ArrayList<Dish>): void            |
| + getMenusInPriceInterval(lower: double, upper: double): ArrayList<Menu> |
+------------------------------------+

+-----------------------------------------------------+
|                       Client                        |
+-----------------------------------------------------+
| - scanner: Scanner                                  |
+-----------------------------------------------------+
| + main(args: String[]): void                        |
| - init(): MenuRegister                              |
| - getValidInt(message: String): int                 |
| - getValidDouble(message: String): double           |
| - getNonEmptyString(message: String): String        |
| - createDish(): Dish                                |
| - addNewDish(menuRegister: MenuRegister): void      |
| - findDishByName(menuRegister: MenuRegister): Dish  |
| - findDishesByType(menuRegister: MenuRegister): ArrayList<Dish> |
| - addMenu(menuRegister: MenuRegister): void         |
| - getMenusInPriceInterval(menuRegister: MenuRegister): ArrayList<Menu> |
| - pickOption(): int                                 |
| - client(menuRegister: MenuRegister): void          |
+-----------------------------------------------------+
