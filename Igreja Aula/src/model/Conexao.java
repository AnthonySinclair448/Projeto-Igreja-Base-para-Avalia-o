package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection conexao = null;

    public void conecte() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/igreja?useSSL=false";
        String usuario = "root";
        String senha = "root";

        Class.forName("com.mysql.jdbc.Driver");
        this.conexao = DriverManager.getConnection(url, usuario, senha);
    }
}