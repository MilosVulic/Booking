package com.metropolitan.booking.customer;

public enum Rola {
    CUSTOMER("Customer"),
    MANAGER("Manager");

    private String ime;

    Rola(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return this.ime;
    }
}
