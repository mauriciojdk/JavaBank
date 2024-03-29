package JavaBank;

import javax.swing.*;
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

    private void cadastrarPessoa(Pessoa pessoa, Conta conta) {
        try {

            String query = "INSERT INTO pessoa (cpf, data_nascimento, nome) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, pessoa.getCpf());
            statement.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
            statement.setString(3, pessoa.getNome());

            statement.execute();

            query = "SELECT id_pessoa FROM pessoa WHERE cpf = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, pessoa.getCpf());

            ResultSet rset = null;
            rset = statement.executeQuery();
            Integer id = null;
           while (rset.next()){
               id = rset.getInt("id_pessoa");

               query = "INSERT INTO conta (numero_conta, pessoa_id) VALUES (?, ?)";
               statement = connection.prepareStatement(query);


               statement.setInt(1, conta.getNumConta());
               statement.setInt(2, id);

               statement.execute();
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
    }

    private void removerConta(Integer id) {
        try {

            String query = "DELETE FROM conta WHERE id_conta = ?";
            PreparedStatement statement = null;

            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            statement.execute();

            query = "DELETE FROM pessoa WHERE id_pessoa = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

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

    private void updateBank(Pessoa pessoa) {
        try {

            String query = "UPDATE pessoa SET cpf = ?, data_nascimento = ?, nome = ? WHERE id_pessoa = ?";
            PreparedStatement statement = null;

            statement = connection.prepareStatement(query);
            statement.setString(1, pessoa.getCpf());
            statement.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
            statement.setString(3, pessoa.getNome());
            statement.setInt(4, pessoa.getId());

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

    private List<Pessoa> getPessoas() {
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

    private List<Pessoa> getPessoasMaiores() {
        List<Pessoa> pessoas = null;
        try {

            String query = "SELECT id_pessoa, nome, cpf, data_nascimento FROM pessoa WHERE data_nascimento < '2003-01-01'";
            pessoas = new ArrayList<Pessoa>();
            PreparedStatement statement = null;
            ResultSet rset = null;

            statement = connection.prepareStatement(query);

            rset = statement.executeQuery();

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

    private List<Pessoa> getPessoasMenores() {
        List<Pessoa> pessoas = null;
        try {

            String query = "SELECT id_pessoa, nome, cpf, data_nascimento FROM pessoa WHERE data_nascimento > '2003-01-01'";
            pessoas = new ArrayList<Pessoa>();
            PreparedStatement statement = null;
            ResultSet rset = null;

            statement = connection.prepareStatement(query);

            rset = statement.executeQuery();

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

    private List<Pessoa> getSaldoPositivos() {
        List<Pessoa> pessoas = null;
        try {

            String query = "SELECT pessoa_id FROM conta WHERE saldo > '0'";
            pessoas = new ArrayList<Pessoa>();
            PreparedStatement statement = null;
            ResultSet rset = null;

            statement = connection.prepareStatement(query);

            rset = statement.executeQuery();

            rset.next();
            Pessoa people = new Pessoa();
            people.setId(rset.getInt("pessoa_id"));

            query = "SELECT id_pessoa, nome, cpf, data_nascimento FROM pessoa WHERE id_pessoa = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, people.getId());
            rset = statement.executeQuery();

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

    /*public List<Pessoa> getSaldoNegativos() {
        List<Pessoa> pessoas = null;
        try {
                List <Pessoa> olhar = getSaldoNegativos();
                for (Integer t : olhar)
                Pessoa people = new Pessoa();
                people.setId(rset.getInt("pessoa_id"));

                query = "SELECT id_pessoa, nome, cpf, data_nascimento FROM pessoa WHERE id_pessoa = ?";
                stm = connection.prepareStatement(query);
                stm.setInt(1, people.getId());
                rset = stm.executeQuery();

                pessoa.setId(rset.getInt("id_pessoa"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setCpf(rset.getString("cpf"));
                pessoa.setDataNascimento(LocalDate.parse((String.valueOf(rset.getDate("data_nascimento")))));




        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return pessoas;

    }*/ //a concertar

    private List<Pessoa> getIdSaldoNegativo(){
        List<Pessoa> pessoas = null;
        try {

            String query = "SELECT pessoa_id FROM conta WHERE saldo < '0'";
            pessoas = new ArrayList<Pessoa>();
            PreparedStatement stm = null;
            ResultSet rset = null;

            stm = connection.prepareStatement(query);
            rset = stm.executeQuery();

            while (rset.next()){
                Pessoa a = new Pessoa();
                a.setId(rset.getInt("pessoa_id"));

                pessoas.add(a);
            }




            } catch (SQLException e) {
                e.printStackTrace();
            }

            return  pessoas;
        }

    public Integer buscarPeloId(Integer idPessoa) {
        Integer id = null;
        try {
            String query = "SELECT id_pessoa, nome, cpf, data_nascimento FROM pessoa WHERE id_pessoa = ?";

            PreparedStatement stm = null;
            stm = connection.prepareStatement(query);
            stm.setInt(1, idPessoa);
            ResultSet rset = null;

            rset = stm.executeQuery();
            while (rset.next()){
                id = rset.getInt("id_pessoa");

                if (id != null) {
                    return id;
                } else {
                    Integer validacao;
                    return validacao = null;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro SQL " + e);
        }

        return id;
    }

    public String buscarPeloCpf(String cpfPessoa) {
        String cpf = null;
        try {
            String query = "SELECT id_pessoa, nome, cpf, data_nascimento FROM pessoa WHERE cpf = ?";

            PreparedStatement stm = null;
            statement = connection.prepareStatement(query);
            statement.setString(1, cpfPessoa);
            ResultSet rset = null;

            rset = statement.executeQuery();
            while (rset.next()){
                cpf = rset.getString("cpf");

                if (cpf != null) {
                    return cpf;
                } else {
                    String validacao;
                    return validacao = null;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro SQL " + e);
        }

        return cpf;
    }

    public void inserirPessoa(Pessoa pessoa, Conta conta){
       try {
           if (buscarPeloCpf(pessoa.getCpf()) != null){
               System.out.println("CPF já cadastrado");
           } else {
                cadastrarPessoa(pessoa, conta);
               System.out.println("Cadastrado com sucesso!");
           }
       }catch (Exception e){
           System.out.println("Erro: " + e);
       }
    }

    public void atualizarCadastro(Integer idPessoa, Pessoa pessoa){
        String query = null;
        PreparedStatement statement = null;
        ResultSet rset = null;
        try {
            if (buscarPeloId(idPessoa) != null){
                query = "SELECT id_pessoa FROM pessoa WHERE id_pessoa = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, idPessoa);
                rset = statement.executeQuery();

                while (rset.next()) {
                    pessoa.setId(rset.getInt("id_pessoa"));
                }

                updateBank(pessoa);
                System.out.println("Dados atualizados com sucesso!");
            }else {
                System.out.println("Id não encontrado");
            }
        }catch (Exception e){
            System.out.println("Erro: " + e);
        }

    }

    public void deletarConta(Integer id){
        try {
            if (buscarPeloId(id) != null){
                removerConta(id);
                System.out.println("Conta removida");
            }else {
                System.out.println("Conta não encontrada");
            }
        }catch (Exception e){
            System.out.println("Erro: " + e);
        }
    }

}

