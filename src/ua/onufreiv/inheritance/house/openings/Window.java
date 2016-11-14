package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * Created by yurii on 11/13/16.
 */
public class Window extends Opening {

    public Window() {
        super();
    }

    public Window(String material, String color) {
        super(material, color);
    }

    @Override
    public void open() {
        super.open();
        System.out.println("The window is opened");
    }

    @Override
    public void close() {
        super.close();
        System.out.println("The window is closed");
    }

    @Override
    public OpeningType getType() {
        return OpeningType.WINDOW;
    }

    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject)
                && Objects.equals(getType(), ((Window) otherObject).getType());
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
