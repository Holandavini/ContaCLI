package com.holandavini;

import com.holandavini.model.Conta;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String possuiConta;
        int contaRecebida;
        String opcaoDigitada;
        List<Conta> listaContas = new ArrayList<>();

        Conta contaPadrao = new Conta("067-8", 1021,"Mario Andrade");
        contaPadrao.setSaldo(237.48);
        listaContas.add(contaPadrao);
        Scanner sc = new Scanner(System.in);
        System.out.println(">>> Bem vindo ao seu assistente bancário");
        System.out.println(">>> Você já possui uma conta? s/n");
        possuiConta = sc.next();
        if (possuiConta.toLowerCase().equals("s")){
            Conta contaEncontrada = null;
            System.out.println(">>> Vamos localizar sua conta");
            System.out.println(">>> Por favor, digite o numero da sua conta: ");
            contaRecebida = sc.nextInt();
            for (int i = 0; i < listaContas.size(); i++){
                if(contaRecebida == listaContas.get(i).getNumero()){
                    contaEncontrada = new Conta(listaContas.get(i).getAgencia(),
                            listaContas.get(i).getNumero(), listaContas.get(i).getNome(), listaContas.get(i).getSaldo());
                    System.out.println(">>> Conta localizada.");
                    break;
                }
            }
            System.out.println(">>> Deseja realizar um deposito ou sacar algum valor?");
            System.out.println(">>> Digite 1 para Depósito ou 2 para Saque: ");
            opcaoDigitada = sc.next();
            if (opcaoDigitada.equals("1")){
                System.out.println(">>> Digite o valor a depositar: ");
                int deposito = sc.nextInt();
                assert contaEncontrada != null;
                contaEncontrada.depositar(deposito);
            } else if(opcaoDigitada.equals("2")) {
                System.out.println(">>> Digite o valor a sacar: ");
                int saque = sc.nextInt();
                assert contaEncontrada != null;
                contaEncontrada.sacar(saque);
            } else {
                System.out.println(">>> Opção inválida, tente novamente.");
            }
        } else {
            System.out.println(">>> Vamos realizar a criação da conta.");
            System.out.println(">>> Digite seu Nome: ");
            String nome = sc.next();
            System.out.println(">>> Digite seu Agência: ");
            String ag = sc.next();
            System.out.println(">>> Digite seu Número: ");
            int numero = sc.nextInt();

            Conta novaConta = new Conta(ag, numero, nome);

            System.out.println(">>> Qual o valor do depósito inicial? ");
            double deposito = sc.nextDouble();
            novaConta.setSaldo(deposito);

            System.out.println(">>> Sua conta foi criada com sucesso!");
            System.out.println(">>> Seu saldo é de: " + novaConta.getSaldo());
        }
    }
}