package ua.onufreiv.inheritance.house;

import ua.onufreiv.inheritance.house.openings.Door;

import java.util.Objects;

/**
 * Created by yurii on 11/13/16.
 */
public class KeyGenerator {

    public static Key generateForDoor(Door door) {
        return new Key(door);
    }

    public static class Key {
        private int doorHashCode;

        private Key(Door door) {
            this.doorHashCode = door.hashCode();
        }

        public boolean isValidForDoor(Door door) {
            return doorHashCode == door.hashCode();
        }

        @Override
        public boolean equals(Object otherObject) {
            if (this == otherObject) return true;

            if (otherObject == null) return false;

            if (getClass() != otherObject.getClass()) return false;

            Key other = (Key) otherObject;

            return Objects.equals(doorHashCode, other.doorHashCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(doorHashCode);
        }

        @Override
        public String toString() {
            return getClass().getName() +
                    "[doorHashCode=" + doorHashCode +
                    ']';
        }
    }
}
