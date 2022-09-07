package org.biblioteca.facade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.*;
@Stateless
@LocalBean
public class AutorFacade {

	@PersistenceContext
	EntityManager em;

    public AutorFacade() {
      
    }
    public List<Autor> buscarTodos() throws Exception {
    String jpql = "SELECT o FROM Autor o ORDER BY o.codigo";
    List<Autor> Autores = (List<Autor>)
    em.createQuery(jpql, Autor.class).getResultList();
    if (Autores.isEmpty() )
    return null;
    else
    	return Autores;
    }
    public Autor buscarPorCodigo(Integer codigo) throws Exception {
    return em.find(Autor.class, codigo);
    }
    public Autor actualizar(Autor AutorAct) throws Exception {
    Autor Autor = buscarPorCodigo(AutorAct.getCodigo()); // Busca el objeto ciudad
    if (Autor == null) { // Si no encuentra ciudad valdrá null
    AutorAct.setCodigo(null); // para que la bd auto-genere el ID
    em.persist(AutorAct);
    em.refresh(AutorAct);
    } else {
    AutorAct = em.merge(AutorAct);
    }
    return AutorAct;
    }

    public void eliminar(Integer codigo) throws Exception {
    Autor aut = buscarPorCodigo(codigo); // Busca el objeto ciudad
    if (aut != null) {
    em.remove(aut);
    }
    }

}
