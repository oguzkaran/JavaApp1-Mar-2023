/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki örneği ve ilgili metotları inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.util.console.Console;

import java.util.ArrayList;
import java.util.LinkedList;

class Application {
    public static void run(String[] args)
    {
        ArrayList<LinkedList<String>> stringHash = new ArrayList<>();

        while (true) {
            var str = Console.read("Bir yazı giriniz:");
            var index = HashUtil.hash(str);

            Console.writeLine("Hash Kodu:%d", index);
            if (index < stringHash.size())
                stringHash.get(index).add(str);
            else {
                var list = new LinkedList<String>();

                list.add(str);

                stringHash.add(list);
            }


            if ("elma".equals(str))
                break;
        }

        stringHash.forEach(list -> {list.forEach(str -> Console.write("%s ", str)); Console.writeLine();});
    }
}

class HashUtil {
    public static int hash(String str)
    {
        int result = 8128;
        int len = str.length();

        for (int i = 0; i < len; ++i)
            result = ((result << 5) + result) + str.charAt(i);

        return Math.abs(result % len);
    }
}

