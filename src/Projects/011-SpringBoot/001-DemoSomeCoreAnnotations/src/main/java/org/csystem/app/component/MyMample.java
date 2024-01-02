package org.csystem.app.component;


import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class MyMample extends Mample {
    public MyMample()
    {
        System.out.println("I am a default ctor of MyMample");
    }
}
