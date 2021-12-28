package JavaBank;

public interface ContaPadrao {
    public void saque(Double valor);
    public void deposito(Double valor, Conta conta);
    public void transferencia(Double valor, Conta conta);
    public void extrato();

}
