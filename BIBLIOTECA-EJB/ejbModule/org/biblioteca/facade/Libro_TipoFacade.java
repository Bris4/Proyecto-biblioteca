
package org.biblioteca.facade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.*;
@Stateless
@LocalBean
public class Libro_TipoFacade {

	@PersistenceContext
	EntityManager em;

    public Libro_TipoFacade() {
      
    }
    public List<Libro_Tipo> buscarTodos() throws Exception {
    String jpql = "SELECT o FROM Libro_Tipo o ORDER BY o.codigo";
    List<Libro_Tipo> Libro_Tipoes = (List<Libro_Tipo>)
    em.createQuery(jpql, Libro_Tipo.class).getResultList();
    if (Libro_Tipoes.isEmpty() )
    return null;
    else
    	return Libro_Tipoes;
    }
    public Libro_Tipo buscarPorCodigo(Integer codigo) throws Exception {
    return em.find(Libro_Tipo.class, codigo);
    }
    public Libro_Tipo actualizar(Libro_Tipo Libro_TipoAct) throws Exception {
   	 Libro_Tipo Libro_Tipo = buscarPorCodigo(Libro_TipoAct.getCodigo()); // Busca el objeto ciudad
   if (Libro_Tipo == null) { // Si no encuentra ciudad valdrá null
   	Libro_TipoAct.setCodigo(null); // para que la bd auto-genere el ID
    em.persist(Libro_TipoAct);
    em.refresh(Libro_TipoAct);
    } else {
    Libro_TipoAct = em.merge(Libro_TipoAct);
    }
    return Libro_TipoAct;
    }

    public void eliminar(Integer codigo) throws Exception {
    Libro_Tipo aut = buscarPorCodigo(codigo); // Busca el objeto ciudad
    if (aut != null) {
    em.remove(aut);
    }
    }

}
