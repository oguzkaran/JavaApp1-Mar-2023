package org.csystem.app.component;

import com.karandev.io.util.console.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplication implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        Console.writeLine("MyApplication.run");
    }
}
