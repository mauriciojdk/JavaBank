package JavaBank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Pessoa {
    private Integer id;
    private String cpf;
    private LocalDate dataNascimento;
    private String nome;

    public Pessoa(){}
    
    public Pessoa(String cpf, LocalDate dataNascimento, String nome) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLastId() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        connection = new ConnectionFactory().getConnection();

        Integer id_pessoa = 0;
        String query = "SELECT max(id_pessoa) FROM pessoa";
        statement = connection.prepareStatement(query);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            id_pessoa = res.getInt(1);
            return id_pessoa;
        }

        return id_pessoa;
    }
}
