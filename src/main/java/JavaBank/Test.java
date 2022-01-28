package JavaBank;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {

        Acao acao = new Acao();
        LocalDate localDateAntigo = LocalDate.of(2043, 5, 05);
        Pessoa pessoa = new Pessoa("111",localDateAntigo ,"sal");
        Conta conta = new Conta();
        acao.inserirPessoa(pessoa, conta);

    }
}




