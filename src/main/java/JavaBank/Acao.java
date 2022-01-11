package JavaBank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Acao {
    private Connection connection = null;
    private PreparedStatement statement = null;

    public Acao(){
        connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarPessoa(Pessoa pessoa, Conta conta) throws SQLException {
        String query = "INSERT INTO pessoa (cpf, data_nascimento, nome) VALUES (?, ?, ?)";
        statement = connection.prepareStatement(query);
        LocalDate a = LocalDate.now();
        statement.setString(1, pessoa.getCpf());
        statement.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
        statement.setString(3, pessoa.getNome());

        statement.execute();

        query = "INSERT INTO conta (numero_conta) VALUES (?)";
        statement = connection.prepareStatement(query);

        statement.setInt(1, conta.getNumConta());

        statement.execute();
        statement.close();

    }


}
