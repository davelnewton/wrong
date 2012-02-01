package com.davelnewton.math.wrong;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        List<Weighted<String>> objects =
                new ArrayList<Weighted<String>>() {{
                    add(new Weighted<String>(1, "One"));
                    add(new Weighted<String>(1, "Two"));
                    add(new Weighted<String>(1, "Three"));
                    add(new Weighted<String>(3, "Four"));
                }};

        for (Weighted<String> o : objects) {
            System.out.printf("Weight: %f - %s%n", o.getWeight(), o.getObject());
        }

        System.out.println("----------");

        WeightedRandomObjectNumberGenerator wrong =
                new WeightedRandomObjectNumberGenerator(objects);

        for (int i = 0; i < 20; i++) {
            Weighted<?> o = wrong.next();
            System.out.printf("%s - %f%n", o.getObject().toString(), o.getWeight());
        }
    }

}
