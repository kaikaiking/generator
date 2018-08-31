package com.king.gen.controller;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kai on 2018/8/14.
 */
public class Test {
    private final Set<String> stooges = new HashSet<>();

    public Test() {
        stooges.add("Moe");
        stooges.add("Larry");
        stooges.add("Curly");
  }

  public boolean isStooge(String name) {
      return stooges.contains(name);
  }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.isStooge("Larry"));
        test.stooges.add("Sir");
        System.out.println(test.isStooge("Sir"));
        test.stooges.remove("Larry");
        System.out.println(test.isStooge("Larry"));
    }


}
