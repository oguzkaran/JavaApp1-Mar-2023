/*----------------------------------------------------------------------------------------------------------------------

----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.concurrent.ThreadUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

class Application {
    public static void run(String [] args)
    {
        try {
            StreetFighterDemo.run();
        }
        catch (Throwable ex) {
            var cause = ex.getCause();
            Console.Error.writeLine(cause != null ? cause.getMessage() : ex.getMessage());
        }
    }
}

class StreetFighterDemo {
    private static void callHitIfExists(Fighter first, Fighter second, int value)
    {
        var cls = first.getClass();

        try {
            var hitMethod = cls.getDeclaredMethod("hit", Fighter.class, int.class);

            hitMethod.setAccessible(true);
            hitMethod.invoke(first, second, value);
            hitMethod.setAccessible(false);
        }
        catch (NoSuchMethodException ignore) {

        }
        catch (InvocationTargetException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean play(Fighter first, Fighter second, Random random)
    {
        int fighterValue = random.nextInt(2);

        if (first.getHealth() <= 0) {
            Console.writeLine("%s wins", second.getName());
            return true;
        }

        if (second.getHealth() <= 0) {
            Console.writeLine("%s wins", first.getName());
            return true;
        }

        if (fighterValue == 0) {
            var val = random.nextInt(5, 16);
            first.setHealth(first.getHealth() - val);
            callHitIfExists(second, first, val);
        }
        else {
            var val = random.nextInt(5, 16);
            second.setHealth(second.getHealth() - val);
            callHitIfExists(first, second, val);
        }

        Console.writeLine("Health of %s: %d, Health of %s: %d", first.getName(), first.getHealth(), second.getName(), second.getHealth());

        return false;
    }
    private static void fight(Fighter first, Fighter second)
    {
        var random = new Random();

        Console.writeLine("First:%s, Second:%s", first.getName(), second.getName());

        while (true) {
            if (play(first, second, random))
                break;
            ThreadUtil.sleep(300);
        }
    }

    public static void run()
    {
        var factory = new FighterFactory();

        while (true) {
            var first = factory.create();
            var second = factory.create();

            Console.writeLine("-----------------");
            fight(first, second);
            Console.writeLine("-----------------");
        }
    }
}

class FighterFactory {
    private final Random m_random = new Random();

    public Fighter create()
    {
        return switch (m_random.nextInt(3)) {
            case 0 -> new Ken();
            case 1 -> new Ryu();
            default -> new Blanka();
        };
    }
}

class GameObject {
    private String m_name;
    //...
    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }
}

class Fighter extends GameObject {
    private int m_health = 100;

    public int getHealth()
    {
        return m_health;
    }

    public void setHealth(int health)
    {
        m_health = health;
    }
}


class Ken extends Fighter {
    //...
    public Ken()
    {
        setName("Ken");
    }
    private void hit(Fighter other, int value)
    {
        Console.writeLine("%s hits %s with value %d", getName(), other.getName(), value);
    }
}

class Ryu extends Fighter {

    public Ryu()
    {
        setName("Ryu");
    }
    private void hit(Fighter other, int value)
    {
        Console.writeLine("%s hits %s with value %d", getName(), other.getName(), value);
    }
}

class Blanka extends Fighter {
    public Blanka()
    {
        setName("Blanka");
    }

    private void hit(Fighter other, int value)
    {
        Console.writeLine("%s hits %s with value %d", getName(), other.getName(), value);
    }
}