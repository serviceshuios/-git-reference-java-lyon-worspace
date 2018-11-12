package session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import metier.Produit;

/**
 * Session Bean implementation class ProduitEJBImpl
 */
@Stateless
public class ProduitEJBImpl implements ProduitRemote, ProduitLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(name="ejb-pu")
	private EntityManager em;
	
    public ProduitEJBImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int ajouterProduit(Produit p) {
		// TODO Auto-generated method stub
		em.persist(p);
		return p.getId();
	}

	@Override
	public Produit modifierProduit(Produit p) {
		// TODO Auto-generated method stub
		em.merge(p);
		return p;
	}

	@Override
	public void supprimerProduit(Produit p) {
		// TODO Auto-generated method stub
		em.remove(p);
	}

	@Override
	public Produit getProduit(int idProduit) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, idProduit);
	}

	@Override
	public List<Produit> findAllProduits() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Produit p").getResultList();
	}

}