package effective_java.chapter_1.item_2;

public class Calzone extends Pizza{
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside;

        public Builder sauceInside() {
            this.sauceInside = true;
            return this;
        }

        @Override
        Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    Calzone(Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }
}
