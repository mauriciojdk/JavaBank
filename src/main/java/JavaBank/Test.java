package JavaBank;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) throws SQLException, ParseException {
       //CREATE
/*        LocalDate localDateAntigo = LocalDate.of(2003, 5, 05);
        Pessoa pessoa = new Pessoa("000000",localDateAntigo ,"formato");
        Conta conta = new Conta();
        Acao acao = new Acao();
        acao.cadastrarPessoa(pessoa, conta);*/


        //SELECT
        Acao acao = new Acao();
        for (Pessoa p : acao.getPessoas() ){
            System.out.println("ID: " + p.getId());
            System.out.println("Pessoa: " + p.getNome());
            System.out.println("CPF: " + p.getCpf());
            System.out.println("Data de nascimento: " + p.getDataNascimento());
            System.out.println("");
        }

        //REMOVE
       // Acao acao = new Acao();
       // acao.removerConta(2);


        //UPDATE
        /*localDateAntigo = LocalDate.of(2022, 6, 06);
        pessoa.setCpf("123456");
        pessoa.setNome("LINDO");
        pessoa.setDataNascimento(localDateAntigo);
        acao.updateBank(pessoa);*/


        //PEGAR ULTIMO ID

       /* Integer oi = pessoa.getLastId();
        System.out.println(oi);*/

    }
}
