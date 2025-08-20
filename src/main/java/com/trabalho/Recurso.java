package com.trabalho;

import java.util.Random;

public class Recurso {

    public void acessarRecurso(int id) {

        try{
            int tempoAcesso = new Random().nextInt(11) + 5;
            Thread.sleep(tempoAcesso * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
