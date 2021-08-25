package br.edu.utfpr.dv.ceprest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.dv.ceprest.model.Cidade;
import br.edu.utfpr.dv.ceprest.model.Estado;

public class EstadoDAO {
	
	public List<Estado> listar() throws SQLException{
		Statement stmt = Conexao.getInstance().getConexao().createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM state ORDER BY title");
		List<Estado> list = new ArrayList<Estado>();
		
		while(rs.next()){
			Estado e = new Estado();
			
			e.setId(rs.getInt("id"));
			e.setNome(rs.getString("title"));
			e.setSigla(rs.getString("letter"));
			
			list.add(e);
		}
		
		return list;
	}

	public List<Estado> listarPorID(String id) throws SQLException{
		PreparedStatement stmt = Conexao.getInstance().getConexao().prepareStatement(
				"SELECT * FROM state WHERE state.id=?");
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		List<Estado> list = new ArrayList<Estado>();
		
		while(rs.next()){
			
			Estado e = new Estado();
			
			e.setId(rs.getInt("id"));
			e.setNome(rs.getString("title"));
			e.setSigla(rs.getString("letter"));
			
			list.add(e);
		}
		
		return list;
	}
	

}
