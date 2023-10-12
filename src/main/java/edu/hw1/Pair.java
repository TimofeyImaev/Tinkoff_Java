package edu.hw1;

public class Pair<A, B> {
    public A first;
    public B second;

    public Pair(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public Pair() {
        this.first = null;
        this.second = null;
    }
}
