package ua.onufreiv.inheritance.house;

import ua.onufreiv.inheritance.house.openings.Door;

import java.util.Objects;

/**
 * The purpose of this class is to generate 'keys' for the 'doors' when
 * it is necessary to lock them.
 * <p/> Has {@link Key} nested class in it.
 *
 * @author Yurii Onufreiv
 * @version 1.0
 */
public class KeyGenerator {

    /**
     * Generates new Key object for the specified door
     *
     * @param house house, for entry door of which key will be generated
     * @param door  door that should be locked
     * @return key for further door unlocking
     */
    public static Key generateForDoor(HouseBuilder.House house, Door door) {
        return new Key(house, door);
    }

    /**
     * This class represents key for doors locking/unlocking.
     * The lock is performed with the help of hash value of the specified door
     */
    public static class Key {
        /**
         * Hash code of door that this key suits
         */
        private int doorHashCode;

        /**
         * Parametrized constructor; gets the value of {@code hashCode()} of
         * specified door
         * <p/>It's private for making it impossible to create key object manually
         *
         * @param house that hosts passed {@code door}
         * @param door  key is created for this door
         */
        private Key(HouseBuilder.House house, Door door) {
            this.doorHashCode = formHash(house, door);
        }

        /**
         * Checks if the key could interact (lock/unlock) with the
         * specified door. Compares the value in the {@code doorHashCode}
         * field with the {@code door.hashCode()} value
         *
         * @param house that hosts passed {@code door}
         * @param door  door for the key validation
         * @return true if key is valid to the specified door, false otherwise
         */
        public boolean isValidForDoor(HouseBuilder.House house, Door door) {
            return doorHashCode == formHash(house, door);
        }

        private int formHash(HouseBuilder.House house, Door door) {
            return Objects.hash(house.hashCode() + door.hashCode());
        }

        /**
         * Compares this object to the specified object.  The result if {@code true}
         * if and only if the values of {@code doorHashCode} fields are equals
         *
         * @param otherObject the object to compare with.
         * @return {@code true} if the objects are the same;
         * {@code false} otherwise.
         */
        @Override
        public boolean equals(Object otherObject) {
            if (this == otherObject) return true;

            if (otherObject == null) return false;

            if (getClass() != otherObject.getClass()) return false;

            Key other = (Key) otherObject;

            return Objects.equals(doorHashCode, other.doorHashCode);
        }

        /**
         * Returns a hash code for this {@code Key}.
         * <p/>Based on {@code doorHashCode} hash value
         *
         * @return a hash code value for this object
         */
        @Override
        public int hashCode() {
            return Objects.hash(doorHashCode);
        }

        /**
         * Returns a {@code String} object representing this {@code Key}'s value.
         * Includes it's class name and {@code doorHashCode} value.
         *
         * @return a string representation of the value of this object
         */
        @Override
        public String toString() {
            return "Key: " +
                    "[doorHashCode=" + doorHashCode +
                    ']';
        }
    }
}
