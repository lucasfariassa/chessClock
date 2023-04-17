package com.lucasfariassa.chessclock.test;

import com.lucasfariassa.chessclock.Clock;
import com.lucasfariassa.chessclock.Game;

import java.time.Duration;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // Sorteia quem será o primeiro jogador
        Random random = new Random();
        int initialPlayer = random.nextInt(2);

        // Cria o relógio que será utilizado para a partida, com os parâmetros de tempo e qual o jogador inicial
        Clock gameClock = new Clock(Duration.ofMinutes(20), initialPlayer);

        // Inicia o jogo
        Game game = new Game(gameClock, initialPlayer);
        game.startGame();
        game.move();
    }
}
