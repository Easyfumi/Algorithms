package ru.marinin;

import java.util.Scanner;

public class CashierAndCoins {  // Кассир и монеты
    public static void main(String[] args) {
        Coin[] coins = new Coin[]{new Coin(1,"руб"), new Coin(2,"руб"), new Coin(5,"руб"),
                new Coin(10,"руб"), new Coin(50,"руб"), new Coin(100,"руб"), new Coin(200,"руб"),
                new Coin(500,"руб"),new Coin(1000,"руб"),new Coin(2000,"руб"),new Coin(5000,"руб")};

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String str = "";

        for (int i = coins.length-1; i>=0; i--) {
            int count = 0;
            while (n > 0 && n >= coins[i].getValue()) {
                n -= coins[i].getValue();
                count++;
            }
            str = coins[i] + " - " + count + ", " + str;
        }

        System.out.println(str.substring(0, str.length() - 2));

    }
}

class Coin {
    private int value;
    private String countryName;
    public Coin(int value, String countryName) {
        this.value = value;
        this.countryName = countryName;
    }
    public int getValue() {
        return value;
    }
    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return value+countryName;
    }
}
