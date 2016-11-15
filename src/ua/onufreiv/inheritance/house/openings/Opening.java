package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * This abstract class represents general behavior of door and window,
 * such as it's opening and closing
 *
 * @version 1.0
 * @author Yurii Onufreiv
 */
public abstract class Opening {

    /**
     * Possible types of openings
     */
    public enum OpeningType {
        WINDOW, DOOR
    }

    /** Material of opening */
    private String material;
    /** Color of opening */
    private String color;
    /** Indicates whether it is in 'opened' state */
    private boolean isOpened;

    /**
     * Default constructor;
     * initializes {@code material} filed with value 'Wood' and
     * {@code color} with 'White'
     */
    public Opening() {
        this.material = "Wood";
        this.color = "White";
    }

    /**
     * Parametrized constructor; initializes fields with specified values
     * @param material material of opening
     * @param color color of opening
     */
    public Opening(String material, String color) {
        this.material = material;
        this.color = color;
    }

    /**
     * Getter for {@code material} field
     * @return {@code material} field value
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Getter for {@code color} field
     * @return {@code color} field value
     */
    public String getColor() {
        return color;
    }

    /**
     * Getter for {@code isOpened} field
     * @return true, if this object is in 'opened' state, false otherwise
     */
    public boolean isOpened() {
        return isOpened;
    }

    /**
     * Switches current opening to the 'opened' state
     */
    public void open() {
        isOpened = true;
    }

    /**
     * Switches current opening to the 'closed' state
     */
    public void close() {
        isOpened = false;
    }

    /**
     * Abstract method for getting type of opening
     * @return value from the {@code OpeningType} enum
     */
    public abstract OpeningType getType();

    /**
     * Compares this object to the specified object.  The result if {@code true}
     * if and only if the values of {@code material}, {@code color} and {@code isOpened}
     * fields are equals
     *
     * @param   otherObject the object to compare with.
     * @return  {@code true} if the objects are the same;
     *          {@code false} otherwise.
     */
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

    /**
     * Returns a hash code for this {@code Opening}.
     * <p/>Based on {@code material}, {@code color} and {@code isOpened} hash values
     *
     * @return  a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(material, color, isOpened);
    }

    /**
     * Returns a {@code String} object representing this {@code Opening}'s value.
     * Includes it's class name, {@code material}, {@code color}, {@code isOpened} values.
     *
     * @return  a string representation of the value of this object
     */
    @Override
    public String toString() {
        return getClass().getName() +
                "[material=" + material +
                ", color=" + color +
                ", isOpened=" + isOpened +
                ']';
    }
}
