package JavaBank;

import java.sql.SQLException;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) throws SQLException {

      /*  LocalDate localDateAntigo = LocalDate.of(2003, 5, 05);
        //Teste de cadastro
        Pessoa pessoa = new Pessoa("08466356545",localDateAntigo ,"Mauricio");
        Conta conta = new Conta();
        Acao acao = new Acao();
        acao.cadastrarPessoa(pessoa, conta);*/
        Acao acao = new Acao();
        acao.removerConta(2);

       /* LocalDate a = LocalDate.now();
       System.out.println(a);
        */

       /* Integer oi = pessoa.getLastId();
        System.out.println(oi);*/

    }
}
