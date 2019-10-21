package com.xiaoniu.stream;

/**
 * @author lihoujing
 * @date 2019/10/12 16:11
 */
public class Dish {
        public enum Type {MEAT, FISH, OTHER}

        /** 食物名称 */
        private final String name;
        /** 是否是素食 */
        private final boolean vegetarian;
        /** 卡路里 */
        private final int calories;
        /** 类型：肉，海鲜，其他 */
        private final Type type;

        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        @Override
        public String toString() {
            return this.getName();
        }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }
}
