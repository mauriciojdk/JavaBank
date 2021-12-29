package JavaBank;

public class Pessoa {
    private Integer id;
    private String cpf;
    private String data_Nascimento;
    private String nome;

    public Pessoa(){}

    public Pessoa( String cpf, String data_Nascimento, String nome){
        this.cpf = cpf;
        this.data_Nascimento = data_Nascimento;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_Nascimento() {
        return data_Nascimento;
    }

    public void setData_Nascimento(String data_Nascimento) {
        this.data_Nascimento = data_Nascimento;
    }



}
