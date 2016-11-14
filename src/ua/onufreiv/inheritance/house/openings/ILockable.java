package ua.onufreiv.inheritance.house.openings;

import ua.onufreiv.inheritance.house.KeyGenerator;

/**
 * Created by yurii on 11/14/16.
 */
public interface ILockable {
    KeyGenerator.Key lock();
    boolean unlock(KeyGenerator.Key key);
    boolean isLocked();
}
