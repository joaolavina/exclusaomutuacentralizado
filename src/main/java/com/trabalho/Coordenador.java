package com.trabalho;

import java.util.Queue;
import java.util.UUID;

public class Coordenador extends Thread {

    private Queue<Processo> fila;
    private String id;
    private boolean vivo;
    private Recurso recurso;
    
    public Coordenador(String id) {
        this.id = id;
        this.vivo = true;
        System.out.println("Coordenador " + id + " foi iniciado.");
    }

    public void pedirAcesso(Processo p){
        if(recurso.getLivre() && fila.isEmpty()) {
            System.out.println("Coordenador " + id + " liberou o processo " + p + " de acessar o recurso.");
            recurso.acessarRecurso(p.getId());
        } else{
            fila.add(p);
            System.out.println("Processo " + p + " adicionado à fila do coordenador " + id + ".");
        }
    }

    public void coordenarAcesso(){
        if(!fila.isEmpty()) {
            Processo p = fila.poll();
            System.out.println("Coordenador " + id + " liberou o processo " + p + " de acessar o recurso.");
            recurso.acessarRecurso(p.getId());
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
