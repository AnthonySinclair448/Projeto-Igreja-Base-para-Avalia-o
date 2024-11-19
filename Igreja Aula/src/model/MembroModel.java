package model;

import java.sql.ResultSet;
import java.sql.Statement;
import controller.Membro;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MembroModel {
    // metodo de listagem de membros
    public ArrayList liste() throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<Membro> membros = new ArrayList<>();
        
        Conexao c = new Conexao();
        c.conecte();
        
        Statement st = c.conexao.createStatement();
        
        String sql = "select membro_id, nome, data_nascimento, telefone, usuario_id from membro order by nome";
        
        ResultSet rs = st.executeQuery(sql);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        
        while (rs.next()) {
            Membro membro = new Membro();
            membro.setMembroId( rs.getInt(1) );
            membro.setNome( rs.getString(2) );
            membro.setDataNascimento( format.parse(rs.getString(3)) );
            membro.setTelefone(rs.getString(4));
            membro.setUsuarioId( rs.getInt(5) );
            
            membros.add(membro);
        }
        
        return membros;
    }
    
    // metodo de registro de membro
    
    // metodo de remoção de membro
    
}
