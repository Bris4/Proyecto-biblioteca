package org.biblioteca.facade;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.Libro;
@Stateless
@LocalBean
public class LibroFacade  {

	@PersistenceContext
	EntityManager em;

    public LibroFacade() {
      
    }
    public List<Libro> buscarTodos() throws Exception {
    String jpql = "SELECT o FROM Libro o ORDER BY o.codigo";
    List<Libro> usuarioes = (List<Libro>)
    em.createQuery(jpql, Libro.class).getResultList();
    if (usuarioes.isEmpty() )
    return null;
    else
    	return usuarioes;
    }
    public Libro buscarPorCodigo(Integer codigo) throws Exception {
    return em.find(Libro.class, codigo);
    }
    public Libro actualizar(Libro usuarioAct) throws Exception {
    Libro usuario = buscarPorCodigo(usuarioAct.getCodigo()); // Busca el objeto usuario
    if (usuario == null) { // Si no encuentra usuario valdrá null
    usuarioAct.setCodigo(null); // para que la bd auto-genere el ID
    em.persist(usuarioAct);
    em.refresh(usuarioAct);
    } else {
    usuarioAct = em.merge(usuarioAct);
    }
    return usuarioAct;
    }

    public void eliminar(Integer codigo) throws Exception {
    Libro usu = buscarPorCodigo(codigo); // Busca el objeto usuario
    if (usu != null) {
    em.remove(usu);
    }
    }

}