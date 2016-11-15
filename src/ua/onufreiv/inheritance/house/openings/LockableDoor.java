package ua.onufreiv.inheritance.house.openings;

import ua.onufreiv.inheritance.house.KeyGenerator;

import java.util.Objects;

/**
 * This class represents 'locked door' object extending the {@code Door} class.
 * It inherits all functionality of {@code Door} and by implementing {@code ILockable}
 * interface add possibilities to 'locking the door with key'
 *
 * @version 1.0
 * @author Yurii Onufreiv
 */
public class LockableDoor extends Door implements ILockable {
    /** Indicates whether it is in 'locked' state */
    private boolean isLocked;

    /**
     * Default constructor
     */
    public LockableDoor() {
        super();
    }

    /**
     * Parametrized constructor; initializes fields with specified values
     * using call to {@code super()}
     * @param material material of door
     * @param color color of door
     */
    public LockableDoor(String material, String color) {
        super(material, color);
    }

    /**
     * Switches the door into 'locked' state if it's in 'unlocked' state
     * generates the key for unlocking and returns generated key
     * @return generated {@code KeyGenerator.Key} object for further unlocking,
     *         or {@code null} value if the door is already in the 'locked' state
     */
    @Override
    public KeyGenerator.Key lock() {
        if (isLocked) {
            return null;
        }
        isLocked = true;
        return KeyGenerator.generateForDoor(this);
    }

    /**
     * Switches the door into 'unlocked' state if two conditions are satisfied:
     * <p/>1. it is in 'locked' state
     * <p/>2. passed key object is valid for this doors
     * @param key key for unlocking the door
     * @return {@code true} if door where successfully unlocked, {@code false} otherwise
     */
    @Override
    public boolean unlock(KeyGenerator.Key key) {
        if (isLocked && key.isValidForDoor(this)) {
            isLocked = false;
            return true;
        }
        return false;
    }

    /**
     * Getter for {@code isLocked} field
     * @return true, if this object is in 'locked' state, false otherwise
     */
    @Override
    public boolean isLocked() {
        return isLocked;
    }

    /**
     * Compares this object to the specified object.  The result if {@code true}
     * if and only if the call to {@code super.equals()} returns true and both of
     * doors are in 'locked'/'unlocked' state
     *
     * @param   otherObject the object to compare with.
     * @return  {@code true} if the objects are the same;
     *          {@code false} otherwise.
     */
    @Override
    public boolean equals(Object otherObject) {
        return super.equals(otherObject)
                && Objects.equals(isLocked, ((LockableDoor) otherObject).isLocked);
    }

    /**
     * Returns a hash code for this {@code LockableDoor}.
     * <p/>Based on {@code super.hashCode()} and {@code isLocked} hash values
     *
     * @return  a hash code value for this object
     */
    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hashCode(isLocked);
    }

    /**
     * Returns a {@code String} object representing this {@code LockableDoor}'s value.
     * Includes call to {@code super.toString()} and {@code isLocked} value.
     *
     * @return  a string representation of the value of this object
     */
    @Override
    public String toString() {
        return super.toString() + "[isLocked=" + isLocked + "]";
    }
}
