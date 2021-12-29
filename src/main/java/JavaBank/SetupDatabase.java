package JavaBank;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {

    public static void main(String[] args) throws SQLException {

        Connection conexao;
        conexao = new ConnectionFactory().getConnection();

        if (conexao == null) { //Testar conexão
            System.out.println("Failed");
            return;
        }

        Statement statement = conexao.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS banco (id_banco INTEGER NOT NULL AUTO_INCREMENT, nome VARCHAR(255) NOT NULL, PRIMARY KEY (id_banco))";
        statement.executeUpdate(sql);
        sql = "CREATE TABLE IF NOT EXISTS agencia (id_agencia INTEGER NOT NULL AUTO_INCREMENT, numero_agencia INTEGER NOT NULL, PRIMARY KEY (id_agencia))";
        statement.executeUpdate(sql);
        sql = "CREATE TABLE IF NOT EXISTS conta (id_conta INTEGER NOT NULL AUTO_INCREMENT, numero_conta INTEGER NOT NULL, saldo DOUBLE, PRIMARY KEY (id_conta))";
        statement.executeUpdate(sql);
        sql = "CREATE TABLE IF NOT EXISTS pessoa (id_pessoa INTEGER NOT NULL AUTO_INCREMENT, cpf VARCHAR(15) NOT NULL, data_nascimento VARCHAR(15) NOT NULL, nome VARCHAR(255) NOT NULL, PRIMARY KEY (id_pessoa))";
        statement.executeUpdate(sql);
        statement.close();
    }
}
