package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    // método responsável por autenticar o usuário
    public boolean autentique(String login, String senha) throws ClassNotFoundException, SQLException {
        // conecta com o banco de dados
        Conexao c = new Conexao();
        c.conecte();

        // consulta SQL para verificar o login e senha
        String sql = "select * from usuario where login = ? and senha = ?";
        
        // prepara a consulta
        PreparedStatement st = c.conexao.prepareStatement(sql);
        st.setString(1, login);
        st.setString(2, senha);
        
        // executa a consulta e obtém o resultado
        ResultSet rs = st.executeQuery();

        // retorna true se encontrar um usuário ou false se não encontrar
        return rs.next();
    }
}
