package ua.onufreiv.inheritance.house.openings;

import ua.onufreiv.inheritance.house.KeyGenerator;

import java.util.Objects;

/**
 * Created by yurii on 11/14/16.
 */
public class LockableDoor extends Door implements ILockable {
    private boolean isLocked;

    public LockableDoor() {
        super();
    }

    public LockableDoor(String material, String color) {
        super(material, color);
    }

    @Override
    public KeyGenerator.Key lock() {
        if (isLocked) {
            return null;
        }
        isLocked = true;
        return KeyGenerator.generateForDoor(this);
    }

    @Override
    public boolean unlock(KeyGenerator.Key key) {
        if (isLocked && key.isValidForDoor(this)) {
            isLocked = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject)
                && Objects.equals(isLocked, ((LockableDoor) otherObject).isLocked);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hashCode(isLocked);
    }

    @Override
    public String toString() {
        return super.toString() + "[isLocked=" + isLocked + "]";
    }
}
