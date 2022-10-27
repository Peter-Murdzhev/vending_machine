package vending_machine;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class Coin {
    public static final HashMap<Integer, Double> coins = new LinkedHashMap<>() {{
        put(1, 0.01);
        put(2, 0.02);
        put(5, 0.05);
        put(10, 0.1);
        put(20, 0.2);
        put(50, 0.5);

    }};


}
