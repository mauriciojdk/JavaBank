package JavaBank;

import java.sql.SQLException;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) throws SQLException {
       //CREATE
        LocalDate localDateAntigo = LocalDate.of(2003, 5, 05);
        Pessoa pessoa = new Pessoa("08466356545",localDateAntigo ,"Mauricio");
        Conta conta = new Conta();
        Acao acao = new Acao();
        acao.cadastrarPessoa(pessoa, conta);


        //REMOVE
       // Acao acao = new Acao();
       // acao.removerConta(2);


        //UPDATE
        localDateAntigo = LocalDate.of(2022, 6, 06);
        pessoa.setCpf("123456");
        pessoa.setNome("LINDO");
        pessoa.setDataNascimento(localDateAntigo);
        acao.updateBank(conta, pessoa);


        //PEGAR ULTIMO ID

       /* Integer oi = pessoa.getLastId();
        System.out.println(oi);*/

    }
}
