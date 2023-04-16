package com.lucasfariassa.chessclock;

import java.time.Duration;
import java.time.Instant;

public class Game {
    private Player player1, player2;
    private Clock clock;
    private int moves;
    private Instant beginning, end;
    private boolean finishedGame;

    public Game(Duration maxTime) {
        this.player1 = new Player(""); // TODO: Adicionar nome do Player 1 ao iniciar jogo
        this.player2 = new Player(""); // TODO: Adicionar nome do Player 2 ao iniciar jogo
        this.clock = new Clock(maxTime, maxTime, maxTime);
        this.moves = 0;
    }

    public void move() {
        // TODO
    }

    public void stopGame() {
        // TODO
    }

    public void startGame() {
        clock.startClock();
    }

    public void pauseGame() {
        clock.pauseClock();
    }

    public void restartGame() {
        clock.restartClock();
    }


}
