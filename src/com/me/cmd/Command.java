package com.me.cmd;

/**
 * <h1>Command</h1>
 * <p>为枚举类型，为用户提供的命令集。
 *
 */
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
