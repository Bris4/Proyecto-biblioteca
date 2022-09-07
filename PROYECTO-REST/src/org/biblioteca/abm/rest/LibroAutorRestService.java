package org.biblioteca.abm.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.biblioteca.entidad.LibroAutor;
import org.biblioteca.facade.LibroAutorFacade;
@Path("libroAutor")
public class LibroAutorRestService {
	@EJB
	LibroAutorFacade cs;
	//GET http://127.0.0.1:8080/PROYECTO-REST/rest/libroAutor/list
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public List<LibroAutor> listar() throws Exception{
	return cs.buscarTodos();
	}
	//GET  http://127.0.0.1:8080/PROYECTO-REST/rest/libroAutor/find/n
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{codigo}")
	public LibroAutor buscar(@PathParam("codigo") Integer codigo) throws Exception{
	return cs.buscarPorCodigo(codigo);
	}
	//PUT  http://127.0.0.1:8080/PROYECTO-REST/rest/libroAutor/update
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public LibroAutor actualizar(LibroAutor libroAutor) throws Exception {
	return cs.Actualizar(libroAutor);
	}
	//DELETE  http://127.0.0.1:8080/PROYECTO-REST/rest/libroAutor/delete/n
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{codigo}")
	public void borrar(@PathParam("codigo") Integer codigo) throws Exception{
	cs.eliminar(codigo);
	}
}
