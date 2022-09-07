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

import org.biblioteca.entidad.Usuario;
import org.biblioteca.facade.UsuarioFacade;
@Path("usuario")
public class UsuarioRestService {
@EJB
UsuarioFacade cs;
//GET http://127.0.0.1:8080/PROYECTO-REST/rest/usuario/list
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/list")
public List<Usuario> listar() throws Exception{
return cs.buscarTodos();
}
//GET  http://127.0.0.1:8080/PROYECTO-REST/rest/usuario/find/n
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/find/{codigo}")
public Usuario buscar(@PathParam("codigo") Integer codigo) throws Exception{
return cs.buscarPorCodigo(codigo);
}
//PUT  http://127.0.0.1:8080/PROYECTO-REST/rest/usuario/update
@PUT
@Produces(MediaType.APPLICATION_JSON)
@Path("/update")
public Usuario actualizar(Usuario usuario) throws Exception {
return cs.actualizar(usuario);
}
//DELETE  http://127.0.0.1:8080/PROYECTO-REST/rest/usuario/delete/n
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("/delete/{codigo}")
public void borrar(@PathParam("codigo") Integer codigo) throws Exception{
cs.eliminar(codigo);
}
}
