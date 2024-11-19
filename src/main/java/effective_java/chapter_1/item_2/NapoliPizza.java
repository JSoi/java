package effective_java.chapter_1.item_2;

public class NapoliPizza extends Pizza {
    private final int cheeseCount;

    public static class Builder extends Pizza.Builder<Builder> {
        private int cheeseCount;

        Builder defaultNapoli() {
            this.cheeseCount = 1;
            return this;
        }

        Builder addCheese() {
            this.cheeseCount += 1;
            return this;
        }

        @Override
        Pizza build() {
            return new NapoliPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    NapoliPizza(Builder builder) {
        super(builder);
        this.cheeseCount = builder.cheeseCount;
    }

    @Override
    public String toString() {
        return "NapoliPizza{" +
                "toppings=" + toppings +
                ", cheeseCount=" + cheeseCount +
                '}';
    }

    public static void main(String[] args) {
        Pizza napoliPizza = new NapoliPizza.Builder()
                .defaultNapoli()
                .addTopping(Topping.HAM)
                .addCheese().addCheese().build();
        System.out.println(napoliPizza);
        System.out.println("Napoli.main");
    }
}
