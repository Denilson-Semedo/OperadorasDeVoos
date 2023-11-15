package com.example.operadoradevoos;

public class Voos {
    private String chegada;
    private String data;
    private int lugares;
    private String operadora;
    private String partida;
    private String preco;
    private String id;

    public Voos() {
    }

    public Voos(String chegada, String data, int lugares, String operadora, String partida, String preco, String id) {
        this.chegada = chegada;
        this.data = data;
        this.lugares = lugares;
        this.operadora = operadora;
        this.partida = partida;
        this.preco = preco;
        this.id = id;
    }

    public String getChegada() {
        return chegada;
    }

    public void setChegada(String chegada) {
        this.chegada = chegada;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getLugares() {
        return lugares;
    }

    public void setLugares(int lugares) {
        this.lugares = lugares;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
