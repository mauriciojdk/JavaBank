package JavaBank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ações {
    private Connection connection = null;
    private PreparedStatement statement = null;

    public Ações (){
        connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarPessoa(Pessoa pessoa) throws SQLException {
        String query = "INSERT INTO pessoa (cpf, data_nascimento, nome) VALUES (?, ?, ?)";
        statement = connection.prepareStatement(query);

        statement.setString(1, pessoa.getCpf());
        statement.setString(2, pessoa.getData_Nascimento());
        statement.setString(3, pessoa.getNome());

        statement.execute();
        statement.close();
    }


}
