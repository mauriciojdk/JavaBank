package JavaBank;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {

        //Teste de cadastro
        Pessoa oi = new Pessoa("21", "1212","mauricio");
        Conta hello = new Conta();
        Ações ola = new Ações();
        ola.cadastrarPessoa(oi, hello);

    }
}
