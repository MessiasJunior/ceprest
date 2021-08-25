package br.edu.utfpr.dv.ceprest.service;

import java.sql.SQLException;
import java.util.List;

import br.edu.utfpr.dv.ceprest.dao.CidadeDAO;
import br.edu.utfpr.dv.ceprest.dao.EstadoDAO;
import br.edu.utfpr.dv.ceprest.model.Cidade;
import br.edu.utfpr.dv.ceprest.model.Estado;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/estados")
public class EstadoService {

	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Estado> listar() {
		try {
			return new EstadoDAO().listar();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar/id/{param}")
	public List<Estado> listarPorId(@PathParam("param") String id) {
		try {
			return new EstadoDAO().listarPorID(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
