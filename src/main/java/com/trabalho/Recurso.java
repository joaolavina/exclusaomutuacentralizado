package com.trabalho;

import java.util.Random;

public class Recurso {

    private boolean livre;

    //ver se precisa mesmo desse synchronized o.O
    public synchronized void acessarRecurso(String id) {
        livre = false;

        try{
            int tempoAcesso = new Random().nextInt(11) + 5;
            Thread.sleep(tempoAcesso * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        livre = true;
    }

    public boolean getLivre() {
        return livre;
    }
}
