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

import org.biblioteca.entidad.Ciudad;
import org.biblioteca.facade.CiudadFacade;
@Path("ciudad")
public class CiudadRestService {
@EJB
CiudadFacade cs;
//GET http://127.0.0.1:8080/PROYECTO-REST/rest/ciudad/list
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Ciudad> listar() throws Exception{
return cs.buscarTodos();
}
//GET  http://127.0.0.1:8080/PROYECTO-REST/rest/ciudad/find/n
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/find/{codigo}")
public Ciudad buscar(@PathParam("codigo") Integer codigo) throws Exception{
return cs.buscarPorCodigo(codigo);
}
//PUT  http://127.0.0.1:8080/PROYECTO-REST/rest/ciudad/update
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Path("/update")
public Ciudad actualizar(Ciudad ciudad) throws Exception {
return cs.actualizar(ciudad);
}
//DELETE  http://127.0.0.1:8080/PROYECTO-REST/rest/ciudad/delete/n
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("/delete/{codigo}")
public void borrar(@PathParam("codigo") Integer codigo) throws Exception{
cs.eliminar(codigo);
}
}
