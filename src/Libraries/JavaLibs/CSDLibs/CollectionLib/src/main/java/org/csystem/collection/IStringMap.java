package org.csystem.collection;

import java.util.Optional;

public interface IStringMap<T> {
    int count();
    boolean addElement(String key, T value);
    boolean removeElement(String key);
    Optional<T> getValue(String key);
    T getValue(String key, T defaultValue);
}
