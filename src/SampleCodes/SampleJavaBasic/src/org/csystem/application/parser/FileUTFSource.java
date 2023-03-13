package org.csystem.application.parser;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class FileUTFSource extends FileSource implements ISource, Closeable {
    public FileUTFSource(String path) throws IOException
    {
        this(Path.of(path));
    }

    public FileUTFSource(Path path) throws IOException
    {
        super(path, StandardCharsets.UTF_8);
    }
}
