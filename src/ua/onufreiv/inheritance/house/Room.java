package ua.onufreiv.inheritance.house;

import ua.onufreiv.inheritance.house.openings.Door;
import ua.onufreiv.inheritance.house.openings.Window;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by yurii on 11/13/16.
 */
public class Room {
    public enum RoomType {
        BEDROOM, LIVING_ROOM, KITCHEN
    }

    private RoomType type;
    private double square;
    private Door door;
    private Window[] windows;

    public Room(RoomType type, Window[] windows, double square) {
        this.type = type;
        door = new Door();
        this.windows = windows;
        this.square = square;
    }

    public RoomType getType() {
        return type;
    }

    public int getWindowsAmount() {
        return windows.length;
    }

    public double getSquare() {
        return square;
    }

    public void openRoomDoor() {
        door.open();
    }

    public void closeRoomDoor() {
        door.close();
    }

    public boolean openWindow() {
        for (Window window : windows) {
            if (!window.isOpened()) {
                window.open();
                return true;
            }
        }
        return false;
    }

    public boolean closeWindow() {
        for (Window window : windows) {
            if (window.isOpened()) {
                window.close();
                return true;
            }
        }
        return false;
    }

    public boolean hasOpenedWindow() {
        for (int i = 0; i < windows.length; i++) {
            if (windows[i].isOpened()) {
                return true;
            }
        }
        return false;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(type, square, door, windows);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[type=" + type +
                ", square=" + square +
                ", door=" + door +
                ", windows=" + Arrays.toString(windows) +
                ']';
    }
}
