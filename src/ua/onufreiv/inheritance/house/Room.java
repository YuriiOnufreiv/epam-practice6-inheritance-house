package ua.onufreiv.inheritance.house;

import ua.onufreiv.inheritance.house.openings.Door;
import ua.onufreiv.inheritance.house.openings.Window;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class contains information about room in a house, including
 * information about it's type, square, room door and windows in it
 *
 * @version 1.0
 * @author Yurii Onufreiv
 */
public class Room {
    /**
     * Possible types of rooms
     */
    public enum RoomType {
        BEDROOM, LIVING_ROOM, KITCHEN
    }

    /** Type of room */
    private RoomType type;
    /** Square of room */
    private double square;
    /** Room front door */
    private Door door;
    /** Windows in the room */
    private Window[] windows;

    /**
     * Parametrized constructor; initializes fields with specified values
     * @param type type of room
     * @param windows array of windows in the room
     * @param square square of the room
     */
    public Room(RoomType type, Window[] windows, double square) {
        this.type = type;
        door = new Door();
        this.windows = windows;
        this.square = square;
    }

    /**
     * Returns the type of room
     * @return value from the {@code RoomType} enum
     */
    public RoomType getType() {
        return type;
    }

    /**
     * Returns the amount of windows in the room
     * @return amount if windows
     */
    public int getWindowsAmount() {
        return windows.length;
    }

    /**
     * Returns the square of the room
     * @return square of room
     */
    public double getSquare() {
        return square;
    }

    /**
     * Opens the door in the room by calling {@code open()} method from
     * {@code door} field
     */
    public void openRoomDoor() {
        door.open();
    }

    /**
     * Closes the door in the room by calling {@code close()} method from
     * {@code door} field
     */
    public void closeRoomDoor() {
        door.close();
    }

    /**
     * Opens any of the closed windows in the room if there are such of them
     * @return true if at least one window were opened, false otherwise
     */
    public boolean openWindow() {
        for (Window window : windows) {
            if (!window.isOpened()) {
                window.open();
                return true;
            }
        }
        return false;
    }

    /**
     * Closes any of the opened windows in the room if there are such of them
     * @return true if at least one window were closed, false otherwise
     */
    public boolean closeWindow() {
        for (Window window : windows) {
            if (window.isOpened()) {
                window.close();
                return true;
            }
        }
        return false;
    }

    /**
     * Indicates whether there are some window that is in the 'opened' state
     * @return true, if at least one window is opened, false otherwise
     */
    public boolean hasOpenedWindow() {
        for (int i = 0; i < windows.length; i++) {
            if (windows[i].isOpened()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compares this object to the specified object.  The result if {@code true}
     * if and only if the values of {@code type}, {@code square}, {@code door}
     * and {@code windows} fields are equals
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

        Room other = (Room) otherObject;

        return Objects.equals(type, other.type)
                && (Double.compare(square, other.square) == 0)
                && Objects.equals(door, other.door)
                && Arrays.equals(windows, other.windows);
    }

    /**
     * Returns a hash code for this {@code Room}.
     * <p/>Based on {@code type}, {@code square}, {@code door} and
     * {@code windows} hash values
     *
     * @return  a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(type, square, door, windows);
    }

    /**
     * Returns a {@code String} object representing this {@code Room}'s value.
     * Includes it's class name, {@code type}, {@code square}, {@code door} and
     * {@code windows.length} values.
     *
     * @return  a string representation of the value of this object
     */
    @Override
    public String toString() {
        return getClass().getName() +
                "[type=" + type +
                ", square=" + square +
                ", door=" + door +
                ", windowsAmount=" + windows.length +
                ']';
    }
}
