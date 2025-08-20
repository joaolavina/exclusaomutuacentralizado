package com.trabalho;

import java.util.Random;
public class Processo {

    private String id;
    private int tempoComsumo;

    public Processo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void tempoComsumo(int id) {

        try{
            int tempoAcesso = new Random().nextInt(16) + 10;
            Thread.sleep(tempoAcesso * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
