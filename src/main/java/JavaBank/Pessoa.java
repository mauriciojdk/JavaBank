package JavaBank;

import java.time.LocalDate;

public class Pessoa {
    private Integer id;
    private String cpf;
    private LocalDate dataNascimento;
    private String nome;

    public Pessoa(){}

    public Pessoa(String cpf, LocalDate dataNascimento, String nome){
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
}
