package JavaBank;

import java.sql.SQLException;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) throws SQLException {

        LocalDate localDateAntigo = LocalDate.of(2002, 6, 21);
        //Teste de cadastro
        Pessoa pessoa = new Pessoa("134564564",localDateAntigo ,"isabela");
        Conta conta = new Conta();
        Acao acao = new Acao();
        acao.cadastrarPessoa(pessoa, conta);

       /* LocalDate a = LocalDate.now();
       System.out.println(a);
        */

       /* Integer oi = pessoa.getLastId();
        System.out.println(oi);*/

    }
}
