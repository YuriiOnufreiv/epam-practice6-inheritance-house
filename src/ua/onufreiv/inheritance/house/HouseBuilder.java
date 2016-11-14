package ua.onufreiv.inheritance.house;

import ua.onufreiv.inheritance.house.openings.LockableDoor;
import ua.onufreiv.inheritance.house.openings.OpenedWindowException;
import ua.onufreiv.inheritance.house.openings.Window;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by yurii on 11/13/16.
 */
public class HouseBuilder {

    private House house;

    public HouseBuilder(String address, int floors) {
        this.house = new House(address, floors);
    }

    public House getHouse() {
        return house;
    }

    public void addRoom(Room.RoomType type, int windowsCount, double square) {
        Window[] windows = new Window[windowsCount];
        for (int i = 0; i < windowsCount; i++) {
            windows[i] = new Window();
        }
        house.addRoom(new Room(type, windows, square));
    }

    public class House {
        private String address;
        private LockableDoor entryDoor;
        private int floors;
        private ArrayList<Room> rooms;

        private House(String address, int floors) {
            this.address = address;
            this.floors = floors;
            entryDoor = new LockableDoor();
            rooms = new ArrayList<>();
        }

        private void addRoom(Room room) {
            rooms.add(room);
        }

        public KeyGenerator.Key lockWithKey() throws OpenedWindowException {
            if (entryDoor.isLocked()) {
                return null;
            }

            for (Room room : rooms) {
                if (room.hasOpenedWindow()) {
                    throw new OpenedWindowException(String
                            .format("There is opened window in %s room", room.toString()));
                }
            }

            entryDoor.lock();
            return KeyGenerator.generateForDoor(entryDoor);
        }

        public boolean unlockWithKey(KeyGenerator.Key key) {
            return (isEntryDoorLocked() && entryDoor.unlock(key));
        }

        public boolean isEntryDoorLocked() {
            return entryDoor.isLocked();
        }

        public int getAmountOfWindows() {
            int windowsAmount = 0;
            for (Room room : rooms) {
                windowsAmount += room.getWindowsAmount();
            }
            return windowsAmount;
        }

        public int getAmountOfDoors() {
            return rooms.size() + 1;
        }

        public ArrayList<Room> getRooms() {
            return rooms;
        }

        @Override
        public boolean equals(Object otherObject) {
            if (this == otherObject) return true;

            if (otherObject == null) return false;

            if (getClass() != otherObject.getClass()) return false;

            House other = (House) otherObject;

            return Objects.equals(address, other.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(address);
        }

        @Override
        public String toString() {
            return getClass().getName() +
                    "[address='" + address + '\'' +
                    ", floors=" + floors +
                    ", entryDoor=" + entryDoor +
                    ", rooms=" + rooms +
                    ']';
        }
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        HouseBuilder other = (HouseBuilder) otherObject;

        return Objects.equals(house, other.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(house);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "[house=" + house +
                ']';
    }

}
