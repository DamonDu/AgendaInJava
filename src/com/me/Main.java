package com.me;

import com.me.data.User;

import static java.util.Objects.hash;

public class Main {

    public static void main(String[] args) {
	// write your code here
        User a = new User("abc", "abc");
        User b = new User("abc", "abc");
        System.out.println(a.getUid() == b.getUid());
    }
}
