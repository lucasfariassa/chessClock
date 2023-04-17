package com.lucasfariassa.chessclock.util;

public class Countdown {

    public static void startCountdown(int duration) {
        Message.sendMessage("\nIniciando o jogo em...");
        for (int i = duration; i > 0; i--) {
            try {
                Thread.sleep(1000);
                Message.sendMessage(String.valueOf(" " + i + " "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
