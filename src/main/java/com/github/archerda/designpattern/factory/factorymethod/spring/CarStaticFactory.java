package com.github.archerda.designpattern.factory.factorymethod.spring;

        import java.util.HashMap;
        import java.util.Map;

/**
 * Create by archerda on 2017/11/09.
 */
public class CarStaticFactory {

    private static final Map<String, Car> CAR_MAP = new HashMap<String, Car>();

    static {
        CAR_MAP.put("Honda", new Car("Honda"));
        CAR_MAP.put("BMW", new Car("BMW"));
        CAR_MAP.put("AUDI", new Car("AUDI"));
    }

    public static Car getCar(String name) {
        return CAR_MAP.get(name);
    }
}
