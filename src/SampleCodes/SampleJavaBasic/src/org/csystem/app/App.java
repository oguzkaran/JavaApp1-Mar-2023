/*----------------------------------------------------------------------------------------------------------------------
	CSDArrayList sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.application.device.Device;
import org.csystem.util.console.Console;
import org.csystem.util.string.StringUtil;
import org.csystem.util.tuple.Pair;

import java.util.ArrayList;
import java.util.Random;

class App {
	public static void main(String[] args)
	{
		ArrayList<Pair<String, Device>> devices = new ArrayList<>();
		Random r = new Random();
		int count = Console.readInt("Bir sayı giriniz:");

		for (int i = 0; i < count; ++i) {
			String name = StringUtil.getRandomTextTR(r, 10);
			devices.add(Pair.of(name, new Device(i + 1, name, Util.getRandomHost(r))));
		}

		int size = devices.size();

		for (int i = 0; i < size; ++i)
			System.out.println(devices.get(i));
	}
}

class Util {
	public static String getRandomHost(Random r)
	{
		return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
	}
}
