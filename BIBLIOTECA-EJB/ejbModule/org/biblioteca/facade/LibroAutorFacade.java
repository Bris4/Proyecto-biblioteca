package org.biblioteca.facade;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.LibroAutor;
@Stateless
@LocalBean
public class LibroAutorFacade  {

	@PersistenceContext
	EntityManager em;

    public LibroAutorFacade() {
      
    }
    public List<LibroAutor> buscarTodos() throws Exception {
    String jpql = "SELECT o FROM LibroAutor o ORDER BY o.codigo";
    List<LibroAutor> libroAutores = (List<LibroAutor>)
    em.createQuery(jpql, LibroAutor.class).getResultList();
    if (libroAutores.isEmpty() )
    return null;
    else
    	return libroAutores;
    }
    public LibroAutor buscarPorCodigo(Integer codigo) throws Exception {
    return em.find(LibroAutor.class, codigo);
    }
    public LibroAutor Actualizar(LibroAutor libroAutorAct) throws Exception {
    LibroAutor libroAutor = buscarPorCodigo(libroAutorAct.getCodigo()); // Busca el objeto libroAutor
    if (libroAutor == null) { // Si no encuentra libroAutor valdrá null
    libroAutorAct.setCodigo(null); // para que la bd auto-genere el ID
    em.persist(libroAutorAct);
    em.refresh(libroAutorAct);
    } else {
    libroAutorAct = em.merge(libroAutorAct);
    }
    return libroAutorAct;
    }

    public void eliminar(Integer codigo) throws Exception {
    LibroAutor ciu = buscarPorCodigo(codigo); // Busca el objeto libroAutor
    if (ciu != null) {
    em.remove(ciu);
    }
    }

}
