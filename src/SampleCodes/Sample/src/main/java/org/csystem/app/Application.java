/*----------------------------------------------------------------------------------------------------------------------
    Aşağıdaki demo örneği inceleyiniz
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import com.karandev.io.util.console.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

class Application {
    private static void fillCounties(ArrayList<String> counties)
    {
        while (true) {
            var county = Console.read("İlçeyi giriniz:");

            if (county.equals("0"))
                break;

            counties.add(county);
        }

        Collections.sort(counties);
    }

    private static void fillCities(TreeMap<Integer, ArrayList<String>> cityMap)
    {
        while (true) {
            var code = Console.readInt("Telefon kodunu giriniz:");

            if (code <= 0)
                break;

            if (!cityMap.containsKey(code))
                cityMap.put(code, new ArrayList<>());

            fillCounties(cityMap.get(code));
        }
    }

    private static void codeCallback(TreeMap<Integer, ArrayList<String>> cityMap, Integer code)
    {
        Console.write("%d: ", code);
        cityMap.get(code).forEach(c -> Console.write("%s ", c));
        Console.writeLine();
    }

    public static void run(String[] args)
    {
        var cityMap = new TreeMap<Integer, ArrayList<String>>(Comparator.reverseOrder());

        fillCities(cityMap);

        cityMap.keySet().forEach(p -> codeCallback(cityMap, p));
    }
}


