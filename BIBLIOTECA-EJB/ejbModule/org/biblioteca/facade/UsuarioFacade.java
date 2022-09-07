package org.biblioteca.facade;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.Usuario;
@Stateless
@LocalBean
public class UsuarioFacade  {

	@PersistenceContext
	EntityManager em;

    public UsuarioFacade() {
      
    }
    public List<Usuario> buscarTodos() throws Exception {
    String jpql = "SELECT o FROM Usuario o ORDER BY o.codigo";
    List<Usuario> usuarioes = (List<Usuario>)
    em.createQuery(jpql, Usuario.class).getResultList();
    if (usuarioes.isEmpty() )
    return null;
    else
    	return usuarioes;
    }
    public Usuario buscarPorCodigo(Integer codigo) throws Exception {
    return em.find(Usuario.class, codigo);
    }
    public Usuario actualizar(Usuario usuarioAct) throws Exception {
    Usuario usuario = buscarPorCodigo(usuarioAct.getCodigo()); // Busca el objeto usuario
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
    Usuario usu = buscarPorCodigo(codigo); // Busca el objeto usuario
    if (usu != null) {
    em.remove(usu);
    }
    }

}