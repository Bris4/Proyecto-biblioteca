package org.biblioteca.facade;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.*;



/**
 * Session Bean implementation class CiudadFacade
 */
@Stateless
@LocalBean
public class ClienteFacade  {

	@PersistenceContext
	EntityManager em;

    public ClienteFacade() {
        // TODO Auto-generated constructor stub
    }
    

  
    public List<Cliente> buscarTodos() throws Exception {
    String jpql = "SELECT o FROM Cliente o ORDER BY o.codigocli";
    List<Cliente> Clientees = (List<Cliente>)
    em.createQuery(jpql, Cliente.class).getResultList();
    return Clientees;
    }
  

  
    public Cliente buscarPorCodigo(Integer codigo) throws Exception {
    return em.find(Cliente.class, codigo);
    }


    
    public Cliente Actualizar (Cliente cli) throws Exception 
    {
    	
    	Cliente clien = buscarPorCodigo(cli.getCodigo2());
    	if (clien==null) 
    	{
    		cli.setCodigo2(null);
    		em.persist(cli);
    		em.refresh(cli);
    	}
    	else 
    	{
    		cli=em.merge(cli);
    	}
    	return cli;
    }
    
    public void eliminar(Integer codigo) throws Exception {
    Cliente ciu = buscarPorCodigo(codigo); // Busca el objeto Cliente
    if (ciu != null) {
    em.remove(ciu);
    }
    }


}
