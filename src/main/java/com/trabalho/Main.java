package com.trabalho;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        if (coordenador != null && coordenador.isAlive()) {
            coordenador.interrupt();
        }

        coordenador = new Coordenador(gerarId(), recurso);
        coordenador.start();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleAtFixedRate(Main::criarNovoProcesso, 0, 40, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(() -> {
            if (coordenador != null && coordenador.isVivo()) {
                coordenador.coordenarAcesso();
            } else {
                if (coordenador != null && coordenador.isAlive()) {
                    coordenador.interrupt();
                }

                coordenador = new Coordenador(gerarId(), recurso);
                coordenador.start();
            }
        }, 0, 1, TimeUnit.MILLISECONDS);
    }

    private static Coordenador coordenador;
    private static final Recurso recurso = new Recurso();

    private static String gerarId() {
        return UUID.randomUUID().toString();
    }

    private static void criarNovoProcesso() {
        String novoIdProcesso = gerarId();
        Processo novoProcesso = new Processo(novoIdProcesso, coordenador);
        novoProcesso.start();
    }
}
