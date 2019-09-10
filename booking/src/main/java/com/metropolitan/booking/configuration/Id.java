package com.metropolitan.booking.configuration;

import java.util.UUID;

public class Id {

    public static String generate() {
        return UUID.randomUUID().toString();
    }

}
