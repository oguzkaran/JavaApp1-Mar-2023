package org.csystem.app.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bartu")
@Scope("prototype")
public class Mample {
    public Mample()
    {
        System.out.println("I am a default ctor of Mample");
    }
}

