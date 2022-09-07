package org.biblioteca.facade;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.Ciudad;
@Stateless
@LocalBean
public class CiudadFacade  {

	@PersistenceContext
	EntityManager em;

    public CiudadFacade() {
      
    }
    public List<Ciudad> buscarTodos() throws Exception {
    String jpql = "SELECT o FROM Ciudad o ORDER BY o.codigo";
    List<Ciudad> ciudades = (List<Ciudad>)
    em.createQuery(jpql, Ciudad.class).getResultList();
    if (ciudades.isEmpty() )
    return null;
    else
    	return ciudades;
    }
    public Ciudad buscarPorCodigo(Integer codigo) throws Exception {
    return em.find(Ciudad.class, codigo);
    }
    public Ciudad actualizar(Ciudad ciudadAct) throws Exception {
    Ciudad ciudad = buscarPorCodigo(ciudadAct.getCodigo()); // Busca el objeto ciudad
    if (ciudad == null) { // Si no encuentra ciudad valdrá null
    ciudadAct.setCodigo(null); // para que la bd auto-genere el ID
    em.persist(ciudadAct);
    em.refresh(ciudadAct);
    } else {
    ciudadAct = em.merge(ciudadAct);
    }
    return ciudadAct;
    }

    public void eliminar(Integer codigo) throws Exception {
    Ciudad ciu = buscarPorCodigo(codigo); // Busca el objeto ciudad
    if (ciu != null) {
    em.remove(ciu);
    }
    }

}
