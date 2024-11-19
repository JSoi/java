package effective_java.chapter_1.item_2;

import java.util.Objects;

public class NyPizza extends Pizza {
    enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    public NyPizza(Builder builder) {
        super(builder); // 부모 생성자 사용
        size = builder.size;
    }
}
