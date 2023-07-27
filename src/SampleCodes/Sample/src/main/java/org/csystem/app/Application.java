/*----------------------------------------------------------------------------------------------------------------------
    Method Reference Çeşitleri:
    1. static metot referansı (static method reference)
    2. Bir nesneye ilişkin non-static metot referansı (reference to an instance method of particular object)
    3. Bir türe ilişkin non-static metot referansı (reference to an instance method of any object of a particular type)
    4. ctor referansı (reference to constructor)

    Aşağıdaki örneklerde atama işlemi metot parametreleri için yani callback/callable olarak da düşünülmelidir. Örnekler tamamen
    metot referansını göstermek için doğrudan atama olarak yapılmıştır. Bu sebeple örneklerde metot referans kullanımına
    odaklanınız
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

import java.util.Random;

class Application {
    public static void run(String [] args)
    {
        var random = new Random();

        IIntBinaryOperator ibo = IntOperation::add; //1 -> (a, b) -> IntOperation.add(a, b);
        Console.writeLine(ibo.applyAsInt(10, 20));
        Console.writeLine("---------------------------------------------------------------------------");
        IIntPredicate intPredicate = NumberUtil::isPrime; //1 -> a -> NumberUtil.isPrime(a);

        Console.writeLine(intPredicate.test(1_000_003) ? "Prime" : "Not a prime");
        Console.writeLine("---------------------------------------------------------------------------");

        IIntSupplier intSupplier = random::nextInt; //2 -> () -> random.nextInt();

        Console.writeLine(intSupplier.get());
        Console.writeLine("---------------------------------------------------------------------------");

        IIntRandomSupplier supplier = Random::nextInt; //3 -> (r, b) -> r.nextInt(b);

        Console.writeLine(supplier.get(random, 100));
        Console.writeLine("---------------------------------------------------------------------------");

        IStringToIntConverter converter = String::length; //3 -> s -> s.length()

        Console.writeLine(converter.convert("CSD"));
        Console.writeLine("---------------------------------------------------------------------------");

        IFactory<Integer, IntValue> factory = IntValue::new; //val -> new IntValue(val);

        Console.writeLine("Value:%d", factory.create(10).getVal());

        Console.writeLine("---------------------------------------------------------------------------");
    }
}

class IntOperation {
    public static int add(int a, int b)
    {
        return a + b;
    }
}

class IntValue {
    private int m_val;

    public IntValue()
    {
    }

    public IntValue(int val)
    {
        m_val = val;
    }

    public int getVal()
    {
        return m_val;
    }

    public void setVal(int val)
    {
        m_val = val;
    }
}

interface IIntBinaryOperator {
    int applyAsInt(int a, int b);
}

interface IIntPredicate {
    boolean test(int a);
}

interface IIntSupplier {
    int get();
}

interface IFactory<T, R> {
    R create(T t);
}

interface IDefaultFactory<T> {
    T create();
}

interface IIntRandomSupplier {
    int get(Random random, int bound);
}

interface IStringToIntConverter {
    int convert(String str);
}
