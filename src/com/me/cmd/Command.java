package com.me.cmd;

public enum Command {
    reg(1), add(2), qry(3), del(4), clr(5), bat(6), qt(7);

    private final int value;

    Command(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
