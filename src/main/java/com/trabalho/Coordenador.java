package com.trabalho;

import java.util.Queue;

public class Coordenador extends Thread {

    private Queue<Integer> fila;
    private int id;
    private boolean processoLivre;
    private boolean vivo;
    
    public Coordenador(int id) {
        this.id = id;
        this.vivo = true;
        System.out.println("Coordenador " + id + " foi iniciado.");
    }

    public void pedirAcesso(){
        if(processoLivre) {
            // TODO: Implementar lógica para pedir acesso
        } else{
            // fila.add();
            System.out.println("Coordenador " + id + " está aguardando acesso.");
        }
    }

    @Override
    public void run() {
        while (vivo) {
            try {
                Thread.sleep(60000);
                vivo = false; 
                System.out.println("Coordenador " + id + " morreu.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
