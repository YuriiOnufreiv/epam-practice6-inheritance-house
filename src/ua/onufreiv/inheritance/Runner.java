package ua.onufreiv.inheritance;

import ua.onufreiv.inheritance.house.HouseBuilder;
import ua.onufreiv.inheritance.house.KeyGenerator;
import ua.onufreiv.inheritance.house.Room;

/**
 * Created by yurii on 11/13/16.
 */
public class Runner {
    public static void main(String[] args) {
        // create house in Kyiv
        HouseBuilder kyivBuilder = new HouseBuilder("Kyiv, Khreschatyk", 2);
        HouseBuilder.House kyivHouse = kyivBuilder.getHouse();
        kyivBuilder.addRoom(Room.RoomType.BEDROOM, 2, 25);
        kyivBuilder.addRoom(Room.RoomType.LIVING_ROOM, 3, 30);
        kyivBuilder.addRoom(Room.RoomType.KITCHEN, 1, 15);

        // create house in Lviv
        HouseBuilder lvivBuilder = new HouseBuilder("Lviv, prosp. Svobody", 1);
        HouseBuilder.House lvivHouse = lvivBuilder.getHouse();
        lvivBuilder.addRoom(Room.RoomType.BEDROOM, 2, 15);
        lvivBuilder.addRoom(Room.RoomType.KITCHEN, 1, 10);

        // print amount of windows and doors
        System.out.printf("Kyiv House - doors: %d, windows: %d%n",
                kyivHouse.getAmountOfDoors(), kyivHouse.getAmountOfWindows());
        System.out.printf("Lviv House - doors: %d, windows: %d%n",
                lvivHouse.getAmountOfDoors(), lvivHouse.getAmountOfWindows());

        // test equals() method for houses
        System.out.println("\nkyivHouse.equals(lvivHouse): " + kyivHouse.equals(lvivHouse));

        // lock the doors in both houses
        KeyGenerator.Key kyivKey = kyivHouse.lockWithKey();
        KeyGenerator.Key lvivKey = lvivHouse.lockWithKey();
        System.out.println("\nkyivKey: " + kyivKey.toString());
        System.out.println("lviviKey: " + lvivKey.toString());

        // open the door with valid/invalid key
        System.out.println("\nkyivHouse.unlockWithKey(lvivKey) : " + kyivHouse.unlockWithKey(lvivKey));
        System.out.println("kyivHouse.unlockWithKey(kyivKey) : " + kyivHouse.unlockWithKey(kyivKey));
    }
}
