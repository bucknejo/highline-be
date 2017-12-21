package com.redbonesolutions.highline.utility;

/**
 * Created by jbuckner on 3/21/17.
 */
public class HighlineCalculator {

    private int first, second;

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int addition() {
        return first + second;
    }

    public int minus() {
        return first - second;
    }

    public int multiply() {
        return first * second;
    }

    public float divide() {
        return first/second;
    }

    public int firstTimesTwo() {
        return first * 2;
    }

    public int secondTimesThree() {
        return second * 3;
    }

    public int paramTest(int a, int b) {
        return a * 2 + b;
    }

}
