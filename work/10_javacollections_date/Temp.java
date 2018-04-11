package com.company;


import java.util.Objects;

public class Temp {
    public int count;
    public int position;
    public int value;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increaseCount(){
        this.count=this.count+1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temp temp = (Temp) o;
        return value == temp.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}
