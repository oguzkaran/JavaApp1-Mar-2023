package org.csystem.application.parser;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class FileAsciiSource extends FileSource {
    public FileAsciiSource(String path) throws IOException
    {
        this(Path.of(path));
    }

    public FileAsciiSource(Path path) throws IOException
    {
        super(path, StandardCharsets.US_ASCII);
    }
}
