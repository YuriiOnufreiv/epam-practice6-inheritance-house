package ua.onufreiv.inheritance.house.openings;

import ua.onufreiv.inheritance.house.KeyGenerator;

/**
 * This interface represents mechanism for locking some objects
 * (with the help of {@code KeyGenerator.Key} class)
 *
 * @version 1.0
 * @author Yurii Onufreiv
 */
public interface ILockable {
    KeyGenerator.Key lock();
    boolean unlock(KeyGenerator.Key key);
    boolean isLocked();
}
