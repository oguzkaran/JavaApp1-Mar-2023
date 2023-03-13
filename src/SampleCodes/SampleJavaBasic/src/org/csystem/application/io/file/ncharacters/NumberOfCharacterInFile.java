package org.csystem.application.io.file.ncharacters;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class NumberOfCharacterInFile implements Closeable {
    private final BufferedReader m_br;
    private final char m_ch;
    private long m_count;

    public NumberOfCharacterInFile(String path, char ch) throws IOException
    {
        m_br = Files.newBufferedReader(Path.of(path), StandardCharsets.UTF_8);
        m_ch = ch;
    }

    public long getCount()
    {
        return m_count;
    }

    public void run() throws IOException
    {
        int ch;

        while ((ch = m_br.read()) != -1)
            if (ch == m_ch)
                ++m_count;
    }

    public void close() throws IOException
    {
        if (m_br != null)
            m_br.close();
    }
}
