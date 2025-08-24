package com.trabalho;

import java.util.Random;

public class Recurso {

    private boolean livre;

    public synchronized void acessarRecurso(String id) {
        livre = false;
        System.out.println("Processo " + id + " está acessando o recurso.");

        try{
            int tempoAcesso = new Random().nextInt(11) + 5;
            Thread.sleep(tempoAcesso * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            livre = true;
        }
    }

    public boolean getLivre() {
        return livre;
    }
}
