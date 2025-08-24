package com.trabalho;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Coordenador extends Thread {

    private Queue<Processo> fila;
    private String id;
    private boolean vivo;
    private Recurso recurso;
    
    public Coordenador(String id, Recurso recurso) {
        this.id = id;
        this.vivo = true;
        this.recurso = recurso;
        this.fila = new ConcurrentLinkedQueue<Processo>();
        System.out.println("Coordenador " + id + " foi iniciado.");
    }

    public void pedirAcesso(Processo p){
        fila.add(p);
        System.out.println("Processo " + p.getProcessId() + " adicionado à fila do coordenador " + id + ".");   
    }

    public void coordenarAcesso(){
        if(!fila.isEmpty()) {
            Processo p = fila.poll();
            System.out.println("Coordenador " + id + " liberou o processo " + p.getProcessId() + " de acessar o recurso.");
            recurso.acessarRecurso(p.getProcessId());
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

    public boolean isVivo() {
        return vivo;
    }
}
