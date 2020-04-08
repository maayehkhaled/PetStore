package model;

import java.util.Random;

public enum Status {
    available, pending, sold;

    public static Status getRandom()
    {
        Random random = new Random();
        int idx = random.nextInt(values().length);
        return values()[idx];
    }
}
