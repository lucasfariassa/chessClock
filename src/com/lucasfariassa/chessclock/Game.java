package com.lucasfariassa.chessclock;

import com.lucasfariassa.chessclock.util.Countdown;
import com.lucasfariassa.chessclock.util.Message;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Game {
    private Clock gameClock;
    private Player player1, player2, currentPlayer;
    private int moves, initialPlayer;
    private Instant beginning, end;
    private boolean finishedGame = false;

    public Game(Clock clock, int initialPlayer) {
        this.player1 = new Player("1"); // TODO: Adicionar nome do Player 1 ao iniciar jogo
        this.player2 = new Player("2"); // TODO: Adicionar nome do Player 2 ao iniciar jogo
        this.moves = 0;
        this.initialPlayer = initialPlayer;
        this.gameClock = clock;
    }


    public void move() {

        // Verifica se é a primeira jogada
        if (moves == 0) {
            System.out.println("Sorteando quem iniciará o jogo...");

            // Inicia o jogo, começando com jogador 1
            if (initialPlayer == 0) {
                Message.sendMessage("\nO jogador "+ player1.getName() + " irá começar o jogo!");
                Countdown.startCountdown(5);
                startGame();

                // Simulando jogada inicial com jogador 1 - TODO: criar botão na UI
                try {
                    Thread.sleep(5000); // Jogador 1 leva 5 segundos para jogar
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentPlayer = player2; // Define o jogador seguinte como 2
                getRemainingTime(gameClock, player1); // Exibe o tempo que sobrou do jogador 1
                moves++;
                move(); // Chama o método novamente
                // Encerrando jogada inicial com jogador 1

            } else {
                // Inicia o jogo, começando com jogador 2
                Message.sendMessage("\nO jogador "+ player2.getName() + " irá começar o jogo!");
                Countdown.startCountdown(5);
                startGame();

                // Simulando jogada inicial com jogador 2 - TODO: criar botão na UI
                try {
                    Thread.sleep(5000); // Jogador 2 leva 5 segundos para jogar
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentPlayer = player1; // Define o jogador seguinte como 1
                getRemainingTime(gameClock, player2); // Exibe o tempo que sobrou do jogador 2
                moves++;
                move();
                // Encerrando jogada inicial com jogador 2
            }
        } else {
            if (currentPlayer == player1) {
                Message.sendMessage("TODO");
                // TODO
            } else {
                Message.sendMessage("TODO");
                // TODO
            }
        }
    }

    public void getRemainingTime(Clock clock, Player player) {
        if (player == player1) {
            Message.sendMessage("Jogador 1 - Tempo restante: " + clock.getRemainingTimeP1() + " minutos");
        } else if (player == player2) {
            Message.sendMessage("Jogador 2 - Tempo restante: " + clock.getRemainingTimeP2() + " minutos");
        } else {
            Message.sendMessage("Tempo esgotado!");
        }
    }

    public void stopGame() {
        // TODO
    }

    public void startGame() {
        gameClock.startClock();
    }

    public void pauseGame() {
        gameClock.pauseClock();
    }

    public void restartGame() {
        gameClock.restartClock();
    }

    public Clock getGameClock() {
        return gameClock;
    }

    public void setGameClock(Clock gameClock) {
        this.gameClock = gameClock;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getInitialPlayer() {
        return initialPlayer;
    }

    public void setInitialPlayer(int initialPlayer) {
        this.initialPlayer = initialPlayer;
    }

    public Instant getBeginning() {
        return beginning;
    }

    public void setBeginning(Instant beginning) {
        this.beginning = beginning;
    }

    public Instant getEnd() {
        return end;
    }

    public void setEnd(Instant end) {
        this.end = end;
    }

    public boolean isFinishedGame() {
        return finishedGame;
    }

    public void setFinishedGame(boolean finishedGame) {
        this.finishedGame = finishedGame;
    }
}
