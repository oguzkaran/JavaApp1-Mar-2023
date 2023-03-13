package org.csystem.application.parser;

public interface ISource {
    int nextChar() throws Exception;
    void reset() throws Exception;
}
