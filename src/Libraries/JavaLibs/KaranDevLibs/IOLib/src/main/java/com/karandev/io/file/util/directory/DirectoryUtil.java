/*----------------------------------------------------------------------
	FILE        : Directory.java
	AUTHOR      : Oğuz Karan
	LAST UPDATE : 27.10.2023

	Utility class for directory operations

	Copyleft (c) 1993 by C and System Programmers Association (CSD)
	All Rights Free
-----------------------------------------------------------------------*/
package com.karandev.io.file.util.directory;



import com.karandev.io.IConsumer;

import java.nio.file.*;

public class DirectoryUtil {
    private DirectoryUtil()
    {
    }

    public static void watchDirectory(String pathStr, IConsumer<WatchEvent<?>> consumer) throws Exception
    {
        watchDirectory(pathStr, consumer,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.OVERFLOW);
    }

    public static void watchDirectoryForCreate(String pathStr, IConsumer<WatchEvent<?>> consumer) throws Exception
    {
        watchDirectory(pathStr, consumer, StandardWatchEventKinds.ENTRY_CREATE);
    }

    public static void watchDirectoryForDelete(String pathStr, IConsumer<WatchEvent<?>> consumer) throws Exception
    {
        watchDirectory(pathStr, consumer, StandardWatchEventKinds.ENTRY_DELETE);
    }

    public static void watchDirectoryForModify(String pathStr, IConsumer<WatchEvent<?>> consumer) throws Exception
    {
        watchDirectory(pathStr, consumer, StandardWatchEventKinds.ENTRY_MODIFY);
    }

    public static void watchDirectoryForOverflow(String pathStr, IConsumer<WatchEvent<?>> consumer) throws Exception
    {
        watchDirectory(pathStr, consumer, StandardWatchEventKinds.OVERFLOW);
    }

    public static void watchDirectory(String pathStr, IConsumer<WatchEvent<?>> consumer, WatchEvent.Kind<?>... events)
            throws Exception
    {
        Path path = Path.of(System.getProperty(pathStr));
        WatchService watchService = FileSystems.getDefault().newWatchService();

        path.register(
                watchService, events);

        WatchKey key;

        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents())
                consumer.accept(event);
            key.reset();
        }
    }
}
