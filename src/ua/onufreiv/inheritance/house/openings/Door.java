package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * Created by yurii on 11/13/16.
 */
public class Door extends Opening {

    public Door() {
        super();
    }

    public Door(String material, String color) {
        super(material, color);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("The door is opened");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("The door is closed");
    }

    @Override
    public OpeningType getType() {
        return OpeningType.DOOR;
    }

    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject)
                && Objects.equals(getType(), ((Door) otherObject).getType());
    }

    @Override
    public int hashCode() {
        return super.hashCode() + getType().hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + "[type=" + getType() + "]";
    }
}
