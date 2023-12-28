package org.csystem.app.component;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component("alican")
public class Sample {
    public Sample()
    {
        System.out.println("I am a default ctor of Sample");
    }

    @PostConstruct
    public void foo()
    {
        System.out.println("I am foo!...");
    }
}
