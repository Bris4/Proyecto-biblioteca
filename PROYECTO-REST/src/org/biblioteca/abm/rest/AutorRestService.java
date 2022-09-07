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

import org.biblioteca.facade.*;
import org.biblioteca.entidad.*;
@Path("autor")
public class AutorRestService {
@EJB
AutorFacade at;
//GET http://127.0.0.1:8080/PROYECTO-REST/rest/autor/list
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Autor> listar() throws Exception{
return at.buscarTodos();
}
//GET  http://127.0.0.1:8080/PROYECTO-REST/rest/autor/find/n
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/find/{codigo}")
public Autor buscar(@PathParam("codigo") Integer codigo) throws Exception{
return at.buscarPorCodigo(codigo);
}
//PUT  http://127.0.0.1:8080/PROYECTO-REST/rest/autor/update
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Path("/update")
public Autor actualizar(Autor ciudad) throws Exception {
return at.actualizar(ciudad);
}
//DELETE  http://127.0.0.1:8080/PROYECTO-REST/rest/autor/delete/n
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("/delete/{codigo}")
public void borrar(@PathParam("codigo") Integer codigo) throws Exception{
at.eliminar(codigo);
}
}