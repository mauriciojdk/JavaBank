package JavaBank;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) throws SQLException, ParseException {
        //CREATE
    /*   LocalDate localDateAntigo = LocalDate.of(1999, 5, 05);
       Pessoa pessoa = new Pessoa("4545441",localDateAntigo ,"Wesley");
       Conta conta = new Conta();
       Acao acao = new Acao();
       acao.cadastrarPessoa(pessoa, conta);

}*/

        Acao acao = new Acao();

        System.out.println("ID: " +  acao.buscarPeloCpf("311"));


    }
}



