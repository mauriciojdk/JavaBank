package JavaBank;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Acao {
    private Connection connection = null;
    private PreparedStatement statement = null;

    public Acao() {
        connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarPessoa(Pessoa pessoa, Conta conta) {
        try {

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

            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro SQL " + e);
        }
    }

    public void removerConta(Integer id) {
        try {

            String query = "DELETE FROM conta WHERE id_conta = ?";
            PreparedStatement stm = null;

            stm = connection.prepareStatement(query);
            stm.setInt(1, id);

            stm.execute();

            query = "DELETE FROM pessoa WHERE id_pessoa = ?";
            stm = connection.prepareStatement(query);
            stm.setInt(1, id);

            stm.execute();

            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro SQL " + e);
        }

    }

    public void updateBank(Pessoa pessoa) {
        try {

            String query = "UPDATE pessoa SET cpf = ?, data_nascimento = ?, nome = ? WHERE id_pessoa = ?";
            PreparedStatement stm = null;

            stm = connection.prepareStatement(query);
            stm.setString(1, pessoa.getCpf());
            stm.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
            stm.setString(3, pessoa.getNome());
            stm.setInt(4, pessoa.getLastId());

            stm.execute();

            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro SQL " + e);
        }

    }

    public List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = null;
        try {

            String query = "SELECT * FROM pessoa";
            pessoas = new ArrayList<Pessoa>();
            PreparedStatement stm = null;
            ResultSet rset = null;

            stm = connection.prepareStatement(query);

            rset = stm.executeQuery();

            while (rset.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setId(rset.getInt("id_pessoa"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setCpf(rset.getString("cpf"));
                pessoa.setDataNascimento(LocalDate.parse((String.valueOf(rset.getDate("data_nascimento")))));

                pessoas.add(pessoa);

            }

            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro SQL " + e);
        }
        return pessoas;
    }

    public List<Pessoa> getPessoasMaiores() {
        List<Pessoa> pessoas = null;
        try {

            String query = "SELECT id_pessoa, nome, cpf, data_nascimento FROM pessoa WHERE data_nascimento < '2003-01-01'";
            pessoas = new ArrayList<Pessoa>();
            PreparedStatement stm = null;
            ResultSet rset = null;

            stm = connection.prepareStatement(query);

            rset = stm.executeQuery();

            while (rset.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setId(rset.getInt("id_pessoa"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setCpf(rset.getString("cpf"));
                pessoa.setDataNascimento(LocalDate.parse((String.valueOf(rset.getDate("data_nascimento")))));

                pessoas.add(pessoa);

            }

            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro SQL " + e);
        }

        return pessoas;

    }

    public List<Pessoa> getPessoasMenores() {
        List<Pessoa> pessoas = null;
        try {

            String query = "SELECT id_pessoa, nome, cpf, data_nascimento FROM pessoa WHERE data_nascimento > '2003-01-01'";
            pessoas = new ArrayList<Pessoa>();
            PreparedStatement stm = null;
            ResultSet rset = null;

            stm = connection.prepareStatement(query);

            rset = stm.executeQuery();

            while (rset.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setId(rset.getInt("id_pessoa"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setCpf(rset.getString("cpf"));
                pessoa.setDataNascimento(LocalDate.parse((String.valueOf(rset.getDate("data_nascimento")))));

                pessoas.add(pessoa);

            }

            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro SQL " + e);
        }

        return pessoas;

    }

    public List<Pessoa> getSaldoPositivos() {
        List<Pessoa> pessoas = null;
        try {

            String query = "SELECT pessoa_id FROM conta WHERE saldo > '0'";
            pessoas = new ArrayList<Pessoa>();
            PreparedStatement stm = null;
            ResultSet rset = null;

            stm = connection.prepareStatement(query);

            rset = stm.executeQuery();

            rset.next();
            Pessoa people = new Pessoa();
            people.setId(rset.getInt("pessoa_id"));

            query = "SELECT id_pessoa, nome, cpf, data_nascimento FROM pessoa WHERE id_pessoa = ?";
            stm = connection.prepareStatement(query);
            stm.setInt(1, people.getId());
            rset = stm.executeQuery();

            while (rset.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setId(rset.getInt("id_pessoa"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setCpf(rset.getString("cpf"));
                pessoa.setDataNascimento(LocalDate.parse((String.valueOf(rset.getDate("data_nascimento")))));

                pessoas.add(pessoa);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return pessoas;

    } //a concertar

    public List<Pessoa> getSaldoNegativos() {
        List<Pessoa> pessoas = null;
        try {

            String query = "SELECT pessoa_id FROM conta WHERE saldo < '0'";
            pessoas = new ArrayList<Pessoa>();
            PreparedStatement stm = null;
            ResultSet rset = null;

            stm = connection.prepareStatement(query);

            rset = stm.executeQuery();

            rset.next();
                Pessoa people = new Pessoa();
                people.setId(rset.getInt("pessoa_id"));

                query = "SELECT id_pessoa, nome, cpf, data_nascimento FROM pessoa WHERE id_pessoa = ?";
                stm = connection.prepareStatement(query);
                stm.setInt(1, people.getId());
                rset = stm.executeQuery();

            while (rset.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setId(rset.getInt("id_pessoa"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setCpf(rset.getString("cpf"));
                pessoa.setDataNascimento(LocalDate.parse((String.valueOf(rset.getDate("data_nascimento")))));

                pessoas.add(pessoa);
                rset.next();

            }



        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return pessoas;

    } //a concertar
}

