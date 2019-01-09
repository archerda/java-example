package com.github.archerda.advices151;

/**
 * 用枚举实现工厂方法模式更简洁
 * Created by luohd on 16/12/29.
 */
public class FactoryMethodPatternUsingEnum88 {

    public static void main(String[] args) {
        CarFactory.FordCar.create();
        CarFactory.BuickCar.create();
    }

    interface Car {
    }

    public static class FordCar implements Car {
    }

    public static class BuickCar implements Car {
    }

    enum CarFactory {
        FordCar {
            @Override
            public Car create() {
                return new FordCar();
            }
        },

        BuickCar {
            @Override
            public Car create() {
                return new BuickCar();
            }
        };

        public abstract Car create();
    }

}
