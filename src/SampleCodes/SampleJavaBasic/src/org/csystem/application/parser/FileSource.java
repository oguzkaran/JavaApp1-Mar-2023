package org.csystem.application.parser;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

abstract public class FileSource implements ISource, Closeable {
    protected BufferedReader br;
    protected Charset charset;
    protected Path path;

    protected FileSource(String path) throws IOException
    {
        this(path, StandardCharsets.UTF_8);
    }

    protected FileSource(Path path) throws IOException
    {
        this(path, StandardCharsets.UTF_8);
    }

    protected FileSource(String path, Charset charset) throws IOException
    {
        this(Path.of(path), charset);
    }

    protected FileSource(Path path, Charset charset) throws IOException
    {
        this.path = path;
        this.charset = charset;
        br = Files.newBufferedReader(path, charset);
    }

    public int nextChar() throws IOException
    {
        return br.read();
    }

    public void reset() throws IOException
    {
        br = Files.newBufferedReader(path, charset);
    }

    public void close() throws IOException
    {
        br.close();
    }
}


