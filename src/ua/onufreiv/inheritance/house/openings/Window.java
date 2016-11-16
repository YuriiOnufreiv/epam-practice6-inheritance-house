package ua.onufreiv.inheritance.house.openings;

import java.util.Objects;

/**
 * This class represents 'window' object extending the {@code Opening} class
 *
 * @version 1.0
 * @author Yurii Onufreiv
 */
public class Window extends Opening {

    /**
     * Default constructor
     */
    public Window() {
    }

    /**
     * Parametrized constructor; initializes fields with specified values
     * using call to {@code super()}
     * @param material material of window
     * @param color color of window
     */
    public Window(String material, String color) {
        super(material, color);
    }

    /**
     * Switches the window to the 'opened' state
     */
    @Override
    public void open() {
        super.open();
        System.out.println("The window is opened");
    }

    /**
     * Switches the window to the 'closed' state
     */
    @Override
    public void close() {
        super.close();
        System.out.println("The window is closed");
    }

    /**
     * Returns type of opening
     * @return {@code OpeningType.WINDOW} value
     */
    @Override
    public OpeningType getType() {
        return OpeningType.WINDOW;
    }

    /**
     * Compares this object to the specified object.  The result if {@code true}
     * if and only if the call to {@code super.equals()} returns true and it's types
     * are equals
     *
     * @param   otherObject the object to compare with.
     * @return  {@code true} if the objects are the same;
     *          {@code false} otherwise.
     */
    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject)
                && Objects.equals(getType(), ((Window) otherObject).getType());
    }

    /**
     * Returns a hash code for this {@code Window}.
     * <p/>Based on {@code super.hashCode()} and {@code getType()} hahs value
     *
     * @return  a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType());
    }

    /**
     * Returns a {@code String} object representing this {@code Window}'s value.
     * Includes call to {@code super.toString()} and {@code getType()} .
     *
     * @return  a string representation of the value of this object
     */
    @Override
    public String toString() {
        return "Window: " + super.toString();
    }
}
