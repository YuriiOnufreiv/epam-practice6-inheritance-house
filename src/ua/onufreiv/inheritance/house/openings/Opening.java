package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * Created by yurii on 11/13/16.
 */
public abstract class Opening {

    public enum OpeningType {
        WINDOW, DOOR
    }

    private String material;
    private String color;
    private boolean isOpened;

    public Opening() {
        this.material = "Wood";
        this.color = "White";
    }

    public Opening(String material, String color) {
        this.material = material;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void open() {
        isOpened = true;
    }

    public void close() {
        isOpened = false;
    }

    public abstract OpeningType getType();

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        Opening other = (Opening) otherObject;

        return Objects.equals(material, other.material)
                && Objects.equals(color, other.color)
                && isOpened == other.isOpened;
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, color, isOpened);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[material=" + material +
                ", color=" + color +
                ", isOpened=" + isOpened +
                ']';
    }
}
