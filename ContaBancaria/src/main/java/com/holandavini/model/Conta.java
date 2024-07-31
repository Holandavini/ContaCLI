package com.holandavini.model;

public class Conta {

    private String agencia;
    private int numero;
    private String nome;
    private double saldo;

    public Conta(String agencia, int numero, String nome){
        this.agencia = agencia;
        this.numero = numero;
        this.nome = nome;
    }

    public Conta(String agencia, int numero, String nome, double saldo){
        this.agencia = agencia;
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                '}';
    }

    public void depositar(double deposito){
        System.out.println(">>> Seu saldo atual é de: " + saldo);
        if(deposito > 0){
            System.out.println(">>> O valor depositado é de: " + deposito);
            saldo = saldo + deposito;
            System.out.println(">>> Seu novo saldo é de: " + saldo);
        } else {
            System.out.println(">>> Valor de depósito inválido.");
        }
    }

    public void sacar(double saque){
        if(saque > saldo){
            System.out.println(">>> Saldo insuficiente");
        } else {
            saldo = saldo - saque;
            System.out.println(">>> Saque realizado");
            System.out.println(">>> Seu novo saldo é de: " + saldo);
        }

    }
}
