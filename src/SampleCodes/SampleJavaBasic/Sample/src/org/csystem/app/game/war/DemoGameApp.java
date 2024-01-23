package org.csystem.app.game.war;

import org.csystem.game.war.Alien;
import org.csystem.game.war.Color;
import org.csystem.util.string.StringUtil;
import org.csystem.util.thread.ThreadUtil;

import java.util.ArrayList;
import java.util.Random;

public class DemoGameApp {
    public static void run()
    {
        Random r = new Random();
        ArrayList aliens = new ArrayList();
        Color [] colors = Color.values();

        while (true) {
            Alien alien = new Alien()
                    .setTitle(StringUtil.getRandomTextEN(r, r.nextInt(5, 11)))
                    .setColor(colors[r.nextInt(colors.length)]);

            aliens.add(alien);

            ThreadUtil.sleep(1000);

            System.out.println("-------------------------------------------------------");
            System.out.printf("Size:%d%n", aliens.size());
            for (Object o : aliens)
                System.out.println(((Alien)o).toString());
            System.out.println("-------------------------------------------------------");
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
