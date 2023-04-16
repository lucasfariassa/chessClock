package com.lucasfariassa.chessclock;

import java.time.Duration;
import java.time.Instant;

public class Clock extends Thread {
    private Duration maxTime, remainingTimeP1, remainingTimeP2;
    private Instant beginningMoment;
    private boolean runningGame;

    public Clock(Duration maxTime, Duration remainingTimeP1, Duration remainingTimeP2) {
        this.maxTime = maxTime;
        this.remainingTimeP1 = remainingTimeP1;
        this.remainingTimeP2 = remainingTimeP2;
        this.runningGame = false;
    }

    // Inicia o relógio da partida, sobrescrevendo o método padrão da classe Thread
    @Override
    public void run() {
        beginningMoment = Instant.now();
        runningGame = true;

        // Verifica o tempo restante de cada jogador
        while (remainingTimeP1.compareTo(Duration.ZERO) > 0 && remainingTimeP2.compareTo(Duration.ZERO) > 0) {

            // Verifica se o jogo está em andamento
            if (runningGame) {
                Instant now = Instant.now(); // Captura o momento atual
                Duration elapsedTime = Duration.between(beginningMoment, now); // Gera o tempo percorrido até o momento

                // Interrompe o jogo ou subtrai o tempo a depender da condição
                if (elapsedTime.compareTo(maxTime) >= 0) {
                    // Interrompe o jogo caso um dos jogadores tenha atingido o tempo máximo definido
                    remainingTimeP1 = Duration.ZERO;
                    remainingTimeP2 = Duration.ZERO;
                    break;
                } else {
                    // Subtrai o tempo decorrido do tempo restante de cada jogador
                    if (remainingTimeP1.compareTo(remainingTimeP2) > 0) {
                        remainingTimeP1 = remainingTimeP1.minus(elapsedTime);
                    } else {
                        remainingTimeP2 = remainingTimeP2.minus(elapsedTime);
                    }
                    beginningMoment = now; // O momento atual é atualizado e o loop continua
                }
            }
        }
        runningGame = false; // Garante o encerramento do jogo quando a condição do tempo define o fim do loop
    }

    public void startClock() {
        start(); // Método padrão da Thread para iniciar um contexto de execução e chamar o método run()
    }

    public void pauseClock() {
        runningGame = false;
    }

    public void restartClock() {
        remainingTimeP1 = maxTime;
        remainingTimeP2 = maxTime;
        beginningMoment = Instant.now();
        runningGame = true;
    }

    public Duration getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Duration maxTime) {
        this.maxTime = maxTime;
    }

    public Duration getRemainingTimeP1() {
        return remainingTimeP1;
    }

    public void setRemainingTimeP1(Duration remainingTimeP1) {
        this.remainingTimeP1 = remainingTimeP1;
    }

    public Duration getRemainingTimeP2() {
        return remainingTimeP2;
    }

    public void setRemainingTimeP2(Duration remainingTimeP2) {
        this.remainingTimeP2 = remainingTimeP2;
    }

    public Instant getBeginningMoment() {
        return beginningMoment;
    }

    public void setBeginningMoment(Instant beginningMoment) {
        this.beginningMoment = beginningMoment;
    }

    public boolean isRunningGame() {
        return runningGame;
    }

    public void setRunningGame(boolean runningGame) {
        this.runningGame = runningGame;
    }
}
