package org.csystem.generator.random;

public interface IConsumer<T> {
    void accept(T t) throws Exception;
}
