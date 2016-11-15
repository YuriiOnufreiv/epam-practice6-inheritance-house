package ua.onufreiv.inheritance.house;

import ua.onufreiv.inheritance.house.openings.LockableDoor;
import ua.onufreiv.inheritance.house.openings.Window;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This is some kind of factory class for creating houses
 * <p/> Has {@link House} inner class in it.
 *
 * @version 1.0
 * @author Yurii Onufreiv
 */
public class HouseBuilder {

    /**
     * This class represents house containing it's address, amount of floors,
     * entry door and rooms objects
     */
    public class House {
        /** Physical address of the house */
        private String address;
        /** Amount of floors in the house */
        private int floors;
        /** It's fron door */
        private LockableDoor entryDoor;
        /** Rooms in the house */
        private ArrayList<Room> rooms;

        /**
         * Parametrized constructor; initializes fields with specified values
         * @param address address of house
         * @param floors amount of floors in the house
         */
        private House(String address, int floors) {
            this.address = address;
            this.floors = floors;
            entryDoor = new LockableDoor();
            rooms = new ArrayList<>();
        }

        /**
         * Adds room to the house. It's private to prevent adding of rooms directly
         * without the {@code HouseBuilder} class instance
         * @param room
         */
        private void addRoom(Room room) {
            rooms.add(room);
        }

        /**
         * Switches the entry door into 'locked' state if it's in 'unlocked' one.
         * Returns the generated the key for the door.
         * <p/> Prints warning message to the console in case there some window in the opened state
         * @return key object if the door locking was successful; null if it is already locked
         */
        public KeyGenerator.Key lockWithKey() {
            if (entryDoor.isLocked()) {
                return null;
            }

            for (Room room : rooms) {
                if (room.hasOpenedWindow()) {
                    System.out.printf("WARNING!!! There is opened window in the %s room%n", room.toString());
                }
            }

            entryDoor.lock();
            return KeyGenerator.generateForDoor(entryDoor);
        }

        /**
         * Switches the door into 'unlocked' state if two conditions are satisfied:
         * <p/>1. it is in 'locked' state
         * <p/>2. passed key object is valid for this doors
         * @param key key for unlocking the door
         * @return {@code true} if door where successfully unlocked, {@code false} otherwise
         */
        public boolean unlockWithKey(KeyGenerator.Key key) {
            return (isEntryDoorLocked() && entryDoor.unlock(key));
        }

        /**
         * Indicates whether the door in sin the 'locked' state
         * @return true if the door is locked, false otherwise
         */
        public boolean isEntryDoorLocked() {
            return entryDoor.isLocked();
        }

        /**
         * Returns amount of windows in the house
         * @return amount of windows
         */
        public int getAmountOfWindows() {
            int windowsAmount = 0;
            for (Room room : rooms) {
                windowsAmount += room.getWindowsAmount();
            }
            return windowsAmount;
        }

        /**
         * Returns amount of doors in the house
         * @return amount of doors
         */
        public int getAmountOfDoors() {
            return rooms.size() + 1;
        }

        /**
         * Returns {@code ArrayList} of {@code rooms} in the house
         * @return list of rooms
         */
        public ArrayList<Room> getRooms() {
            return rooms;
        }

        /**
         * Compares this object to the specified object.  The result if {@code true}
         * if and only if the values of {@code address} fields are equals
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

            House other = (House) otherObject;

            return Objects.equals(address, other.address);
        }

        /**
         * Returns a hash code for this {@code House}.
         * <p/>Based on {@code address} hash value
         *
         * @return  a hash code value for this object
         */
        @Override
        public int hashCode() {
            return Objects.hash(address);
        }

        /**
         * Returns a {@code String} object representing this {@code House}'s value.
         * Includes it's class name, {@code address}, {@code floors}, {@code entryDoor}
         * and {@code rooms.size()} values.
         *
         * @return  a string representation of the value of this object
         */
        @Override
        public String toString() {
            return getClass().getName() +
                    "[address='" + address + '\'' +
                    ", floors=" + floors +
                    ", entryDoor=" + entryDoor +
                    ", roomsAmount=" + rooms.size() +
                    ']';
        }
    }

    /** House for performing building operations */
    private House house;

    /**
     * Parametrized constructor; initializes fields with specified values
     * @param address address of house
     * @param floors amount of floors in the house
     */
    public HouseBuilder(String address, int floors) {
        this.house = new House(address, floors);
    }

    /**
     * Returns built house
     * @return house that was built
     */
    public House getHouse() {
        return house;
    }

    /**
     * Adds room the building house
     * @param type type of room
     * @param windowsCount amount of windows in the room
     * @param square square of the room
     */
    public void addRoom(Room.RoomType type, int windowsCount, double square) {
        Window[] windows = new Window[windowsCount];
        for (int i = 0; i < windowsCount; i++) {
            windows[i] = new Window();
        }
        house.addRoom(new Room(type, windows, square));
    }

    /**
     * Compares this object to the specified object.  The result if {@code true}
     * if and only if the values of {@code house} fields are equals
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

        HouseBuilder other = (HouseBuilder) otherObject;

        return Objects.equals(house, other.house);
    }

    /**
     * Returns a hash code for this {@code HouseBuilder}.
     * <p/>Based on {@code house} hash value
     *
     * @return  a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(house);
    }

    /**
     * Returns a {@code String} object representing this {@code HouseBuilder}'s value.
     * Includes it's class name nd {@code house} value.
     *
     * @return  a string representation of the value of this object
     */
    @Override
    public String toString() {
        return getClass().getName() +
                "[house=" + house +
                ']';
    }

}
