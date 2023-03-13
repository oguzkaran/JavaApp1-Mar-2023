/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Komut satırından aşağıdaki gibi çalışan programı yazınız:
        java org.csystem.app.App <src> <dest>
    Program komut satırı argümanı verilmezse klavyeden yol ifadesini isteyecektir. src ile aldığı dosyayı dest ile
    aldığı dosya olarak kopyalayacaktır. Hedef dosya varsa hedef dosya ismi ve uzantısının sonuna "-bak" eklenerek
    yedeklenecektir. Daha önce yedeklenmişse üzerine yazılacaktır. Bu işlemden sonra kopyalama yapılacaktır
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.application.io.file.copy;

import org.csystem.util.console.CommandLineUtil;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class BackupAndCopyApp {
    private static String [] checkCommandLineArgs(String [] args)
    {
        if (args.length != 2 && args.length != 0) {
            System.err.println("Usage:java CopyAndBackupApp.jar <source path> <destination path>");
            System.exit(1);
        }

        return CommandLineUtil.getArguments(args, "Input source and destination file paths:");
    }

    public static void run(String [] args)
    {
        args = checkCommandLineArgs(args);

        try {
            BackupAndCopy backupAndCopy = new BackupAndCopy(args[0], args[1]);

            System.out.println(backupAndCopy.run());
        }
        catch (NoSuchFileException ignore) {
            System.err.println("File not found");
        }
        catch (IOException ignore) {
            System.err.println("Invalid arguments");
        }
    }
}
