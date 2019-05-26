package com.example.jo.counter;

public class counter {

    public counter(int count) {
        this.count = count;
    }

    private int count=0 ;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void increment(){
        this.count++;
    }

    public void decrement(){
        this.count--;
    }

    public void reset(){
        this.count=0;
    }

}
