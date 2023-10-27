package com.karandev.io;

@FunctionalInterface
public interface IConsumer<T> {
    void accept(T t) throws Exception;
}
