package JavaBank;

import java.sql.*;
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

        statement.setString(1, pessoa.getCpf());
        statement.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
        statement.setString(3, pessoa.getNome());

        statement.execute();


        query = "INSERT INTO conta (numero_conta, pessoa_id) VALUES (?, ?)";
        statement = connection.prepareStatement(query);

        Integer last = pessoa.getLastId();
        statement.setInt(1, conta.getNumConta());
        statement.setInt(2, last);

        statement.execute();
        statement.close();

    }




}
