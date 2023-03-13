package org.csystem.application.io.file.randomaccess;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public final class RandomAccessFileWriteFromStdIn implements Closeable {
    private final RandomAccessFile m_raf;
    private final Scanner m_stdIn;
    private final String m_quitText;
    private final String m_prompt;

    private void runForWrite() throws IOException
    {
        m_raf.seek(m_raf.length()); //Dosya göstericisini sona çektik

        for (;;) {
            System.out.print(m_prompt);
            String text = m_stdIn.nextLine();

            if (m_quitText.equals(text))
                break;

            m_raf.writeUTF(text);
        }
    }

    private void runForRead() throws IOException
    {
        m_raf.seek(0); //Dosya göstericisini başa çektik
        try {
            for (;;) {
                String text = m_raf.readUTF();

                System.out.println(text);
            }
        }
        catch (EOFException ignore) {

        }
    }

    public RandomAccessFileWriteFromStdIn(String path, String quitText, String prompt) throws IOException
    {
        this(path, new Scanner(System.in), quitText, prompt);
    }

    public RandomAccessFileWriteFromStdIn(String path, Scanner stdIn, String quitText, String prompt) throws IOException
    {
        m_raf = new RandomAccessFile(path, "rw");
        m_stdIn = stdIn;
        m_quitText = quitText;
        m_prompt = prompt;
    }

    public void run() throws IOException
    {
        runForWrite();
        runForRead();
    }

    public void close() throws IOException
    {
        m_raf.close();
    }
}
