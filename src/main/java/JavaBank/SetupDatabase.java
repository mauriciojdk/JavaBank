package JavaBank;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection conexao = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabank", "suporte", "Mau0521@"); //URL é o nome do servidor e qual banco de dados - USER é usuario seguido da senha para ter acesso
        } catch (SQLException e){
            e.printStackTrace();
        }

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
        sql = "CREATE TABLE IF NOT EXISTS pessoa (id_pessoa INTEGER NOT NULL AUTO_INCREMENT, cpf INTEGER NOT NULL, data_nascimento VARCHAR(11), PRIMARY KEY (id_pessoa))";
        statement.executeUpdate(sql);

    }
}
