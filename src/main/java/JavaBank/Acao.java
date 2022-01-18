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

    public void removerConta(Integer id) throws SQLException {
        String query = "DELETE FROM conta WHERE id_conta = ?";
        PreparedStatement stm = null;

        stm = connection.prepareStatement(query);
        stm.setInt(1, id);
        stm.execute();

        query = "DELETE FROM pessoa WHERE id_pessoa = ?";
        stm = connection.prepareStatement(query);
        stm.setInt(1, id);
        stm.execute();

        if (connection != null){
            connection.close();
        } if (statement != null){
            statement.close();
        }


    }

    public void updateBank(Conta conta, Pessoa pessoa ) throws SQLException {
        String query = "UPDATE pessoa SET cpf = ?, data_nascimento = ?, nome = ? WHERE id_pessoa = ?";
        PreparedStatement stm = null;

        stm = connection.prepareStatement(query);
        stm.setString(1, pessoa.getCpf());
        stm.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
        stm.setString(3, pessoa.getNome());
        stm.setInt(4, pessoa.getLastId());

        stm.execute();

    }

}
