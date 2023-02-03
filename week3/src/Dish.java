import java.util.*; // for conciseness

public record Dish(String name, boolean vegetarian, int calories, Dish.Type type) {

    public static List<Dish> getMenu() { return
            List.of(new Dish("pork", false, 800, Type.MEAT),
                    new Dish("beef", false, 700, Type.MEAT),
                    new Dish("chicken", false, 400, Type.MEAT),
                    new Dish("french fries", true, 530, Type.OTHER),
                    new Dish("rice", true, 350, Type.OTHER),
                    new Dish("season fruit", true, 120, Type.OTHER),
                    new Dish("pizza", true, 550, Type.OTHER),
                    new Dish("prawns", false, 400, Type.FISH),
                    new Dish("salmon", false, 450, Type.FISH));
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type { MEAT, FISH, OTHER }
}