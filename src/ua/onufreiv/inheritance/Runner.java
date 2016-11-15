package ua.onufreiv.inheritance;

import ua.onufreiv.inheritance.house.HouseBuilder;
import ua.onufreiv.inheritance.house.KeyGenerator;
import ua.onufreiv.inheritance.house.Room;

/**
 * Created by yurii on 11/13/16.
 */
public class Runner {
    public static void main(String[] args) {
        HouseBuilder houseBuilder1 = new HouseBuilder("Kyiv", 2);
        HouseBuilder.House house1 = houseBuilder1.getHouse();

        HouseBuilder houseBuilder2 = new HouseBuilder("Lviv", 1);
        HouseBuilder.House house2 = houseBuilder2.getHouse();

        houseBuilder1.addRoom(Room.RoomType.BEDROOM, 3, 25);
        houseBuilder1.addRoom(Room.RoomType.KITCHEN, 1, 15);
        System.out.println(house1);
        System.out.println(houseBuilder1.hashCode());

        System.out.println("Windows amount: " + house1.getAmountOfWindows());
        System.out.println("Doors amount: " + house1.getAmountOfDoors());

        KeyGenerator.Key key1 = null;
        KeyGenerator.Key key2 = null;
        key2 = house2.lockWithKey();

        Room room = house1.getRooms().get(0);
        room.openWindow();
        room.openWindow();

        key1 = house1.lockWithKey();


        System.out.println("Entry door is locked: " + house1.isEntryDoorLocked());
        house1.unlockWithKey(key2);
        System.out.println("Entry door is locked: " + house1.isEntryDoorLocked());
        house1.unlockWithKey(key1);
        System.out.println("Entry door is locked: " + house1.isEntryDoorLocked());


    }
}
