package org.csystem.app.lottery.numericlottery;

import org.csystem.random.lottery.numericlottery.NumericLottery;
import org.csystem.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class NumericLotteryApp {
    public static void run()
    {
        Random random = new Random();
        Scanner kb = new Scanner(System.in);
        NumericLottery lottery = new NumericLottery(random);

        for (;;) {
            System.out.print("Kaç tane kupon oynamak istiyorsunuz?");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            ArrayUtil.print(2, lottery.getNumbers(n));
        }
    }

    public static void main(String[] args)
    {
        run();
    }
}
