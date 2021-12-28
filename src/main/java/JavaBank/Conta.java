package JavaBank;

import java.util.ArrayList;

public class Conta implements ContaPadrao {
    private Double saldo;
    private int agencia;
    private int numConta;

    ArrayList<String> extratoConta = new ArrayList<String>();

    public Conta(double saldo, int agencia, int numConta) {
        this.saldo = saldo;
        this.agencia = agencia;
        this.numConta = numConta;
    }

    public Conta() {
    }

    ;

    @Override
    public void saque(Double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            extratoConta.add("Sacou " + valor);
        } else {
            System.out.println("Erro: Saque maior que o saldo");
        }
    }

    @Override
    public void deposito(Double valor, Conta conta) {
        extratoConta.add("Depositou " + valor);
        conta.saldo += valor;
    }

    @Override
    public void transferencia(Double valor, Conta conta) {
        if (saldo >= valor) {
            saldo -= valor;
            conta.saldo += valor;
            extratoConta.add("Transferiu " + valor + " Para " + conta.numConta);
        } else {
            System.out.println("Erro:Transferencia maior que o saldo");
        }
    }

    @Override
    public void extrato() {
        System.out.println("Extrato da conta");
        for (String ext : extratoConta) {
            System.out.println(ext);
        }
    }

}
