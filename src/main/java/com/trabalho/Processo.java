package com.trabalho;

import java.util.Random;

public class Processo extends Thread {

    private String id;
    private Coordenador coordenador;

    public Processo(String id, Coordenador coordenador) {
        this.id = id;
        this.coordenador = coordenador;
        System.out.println("Processo " + id + " criado.");
    }

    public String getProcessId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                int tempoAcesso = random.nextInt(16) + 10;
                Thread.sleep(tempoAcesso * 1000);
                coordenador.pedirAcesso(this);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
