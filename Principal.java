//Kauan Franco Moura - 5829678510
//Phelipe Meireles de Oliveira - 30488753

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Banco> contas = new ArrayList<Banco>();
        ArrayList<Pessoa> clientes = new ArrayList<Pessoa>();

        int opcao = 0;

        do {
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar conta");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Exibir contas");
            System.out.println("5 - Sacar dinheiro");
            System.out.println("6 - Depositar dinheiro");
            System.out.println("7 - Sair");
            System.out.println("-----------------------------------------");

            System.out.println("Digite o número da opção desejada: ");

            opcao = sc.nextInt();

            boolean contaEncontrada = false;

            switch (opcao) {
                case 1:
                    System.out.println("-----------------------------------------");
                    System.out.println("Digite o nome do cliente: ");
                    String nome = sc.next();
                    System.out.println("Digite o CPF do cliente: ");
                    String cpf = sc.next();
                    Pessoa pessoa = new Pessoa(nome, cpf);
                    clientes.add(pessoa);
                    System.out.println("----------------Cliente cadastrado com sucesso!----------------");
                    break;

                case 2:
                    System.out.println("-----------------------------------------");
                    System.out.println("Digite o número da conta: ");
                    String numeroConta = sc.next();
                    System.out.println("Digite o saldo inicial da conta: ");
                    double saldoInicial = sc.nextDouble();
                    System.out.println("Digite o CPF do titular da conta: ");
                    cpf = sc.next();

                    Pessoa titular = null;
                    for (Pessoa c: clientes) {
                        if (c.getCpfPessoa().equals(cpf)) {
                            titular = c;
                            break;
                        }
                    }

                    if (titular != null) {
                        Banco conta = new Banco(titular, numeroConta, saldoInicial);
                        contas.add(conta);
                        System.out.println("----------------Conta cadastrada com sucesso!----------------");
                    }
                    break;
                case 3:
                    contaEncontrada = false;

                    System.out.println("-----------------------------------------");
                    System.out.println("Digite o número da conta: ");
                    numeroConta = sc.next();

                    for(Banco bancos : contas) {
                        if (bancos.getNumeroconta().equals(numeroConta)) {
                            System.out.println("O saldo da conta número " + bancos.getNumeroconta() + " é R$ " + bancos.getSaldo());
                            System.out.println("-----------------------------------------");
                            contaEncontrada = true;
                            break;
                        }
                    }

                    if (!contaEncontrada) {
                        System.out.println("----------------A conta não foi encontrada!----------------");
                    }
                    break;
                case 4:
                    for (Banco bancos : contas) {
                        System.out.println("-----------------------------------------");
                        System.out.println("Nome do titular da conta: " +bancos.getCliente().getNomePessoa());
                        System.out.println("CPF: " +bancos.getCliente().getCpfPessoa());
                        System.out.println("Número da conta " +bancos.getNumeroconta());
                        System.out.println("Saldo: R$ " +bancos.getSaldo());
                        System.out.println("-----------------------------------------");
                    }
                    break;
                case 5:
                    System.out.println("-----------------------------------------");
                    System.out.println("Digite o número da conta: ");
                    numeroConta = sc.next();

                    for (Banco banco: contas) {
                        if (banco.getNumeroconta().equals(numeroConta)) {
                            System.out.println("Digite o valor a ser sacado: ");
                            double valorSacado = sc.nextDouble();

                            if (banco.getSaldo() < valorSacado) {
                                System.out.println("----------------Saldo insuficiente!----------------");
                                contaEncontrada = true;
                                break;
                            }

                            banco.sacar(valorSacado);
                            System.out.println("----------------Saque realizado com sucesso!----------------");
                            contaEncontrada = true;
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("-----------------------------------------");
                    System.out.println("Digite o número da conta: ");
                    numeroConta = sc.next();

                    for (Banco banco: contas) {
                        if (banco.getNumeroconta().equals(numeroConta)) {
                            System.out.println("Digite o valor a ser depositado: ");
                            double valorDepositado = sc.nextDouble();

                            banco.depositar(valorDepositado);
                            System.out.println("----------------Depósito realizado com sucesso!----------------");
                            contaEncontrada = true;
                            break;
                        }
                    }

                    if (!contaEncontrada) {
                        System.out.println("----------------A conta não foi encontrada!----------------");
                    }
                    break;
            }
        } while (opcao != 7);
    }
}
