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
import org.biblioteca.entidad.PrestamoLibro;
import org.biblioteca.facade.*;
@Path("prestamolibro")
public class PrestamoLibroRestService {
@EJB
PrestamoLibroFacade pls;
//GET http://localhost:8080/PROYECTO-REST/rest/prestamo-libro/find-by-prestamo/{prestamoId}
@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/find/{codigo}")
public List<PrestamoLibro> buscar(@PathParam("codigo") Integer codigo) throws Exception{
return pls.buscarPorNumeroPrestamo(codigo);
}
//DELETE http://localhost:8080/PROYECTO-REST/rest/prestamo-libro/delete/{prestamoId}
@DELETE
@Produces(MediaType.APPLICATION_JSON)
@Path("/delete/{prestamoId}")
public void borrarPorPrestamo(@PathParam("prestamoId") Integer prestamoId) throws Exception{
pls.eliminarPorPrestamo(prestamoId);
}
}
