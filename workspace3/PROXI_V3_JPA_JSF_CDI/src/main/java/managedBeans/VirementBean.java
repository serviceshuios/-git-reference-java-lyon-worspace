package managedBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import metier.Compte;
import service.ConseillerClienteleService;
import service.IConseillerClienteleService;

/**
 * 
 * Bean de la vue virements
 *
 */
//@Named	// pour dire que c'est un Bean dans le conteneur de CDI. @Named inclut @ManagedBean de JSF
//@ManagedBean(name = "virementBean")
//@ViewScoped
@Named
@SessionScoped
public class VirementBean implements Serializable {

	/* ----------------- Attributs ----------------- */

	// appel de la couche service
	@Inject
	private IConseillerClienteleService service;// = new ConseillerClienteleService();

	// compte à débiter
	private Compte selectedDebit;

	// compte à créditer
	private Compte selectedCredit;

	// montant
	private double montant;
	
	/**
	 * methode statique d'arrondi
	 * @param d
	 * @param decimalPlace
	 * @return
	 */
	public static double round(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
	
	/* ----------------- Méthodes ----------------- */

	public String effectuerVirement() {

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();

		Compte compteADebiter = selectedDebit;
		Compte compteACrediter = selectedCredit;
		
		//System.out.println(montant);
		//System.out.println(compteACrediter);
		//System.out.println(compteADebiter);
		
		if (compteADebiter==null || compteACrediter==null){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sélection incomplète","");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "virements";
		}
		
		if (montant == 0){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Montant nul","");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "virements";
		}
		
		try {
			
			//arrondi à 2 décimales
			montant = round(montant, 2);
			
			//System.out.println(montant);
			// test de l'arrondis System.out.println(montant);
			service.effectuerVirement(compteADebiter, compteACrediter, montant);
			FacesMessage message = new FacesMessage("Virement éffectué " + montant + "€ du compte " + compteADebiter.getIdCompte() + " vers le compte " + compteACrediter.getIdCompte());
			FacesContext.getCurrentInstance().addMessage(null, message);

		} catch (Exception e) {

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(),"");
			FacesContext.getCurrentInstance().addMessage(null, message);
			e.getStackTrace();

		}
		


		return "virements";
	}

	
	public Collection<Compte> getListeComptes(){
		return service.listerComptes();
	}
	
	

    public void onDebitSelect(SelectEvent event){
    	
    	this.selectedDebit =  (Compte)event.getObject();
    	//System.out.println(selectedDebit.getIdCompte());
    }
//    public void onDebitUnselect(UnselectEvent event)
//    {
//    	selectedDebit =  null;
//    }
    
    public void onCreditSelect(SelectEvent event){ 
    	this.selectedCredit =  (Compte)event.getObject();
    	//System.out.println(selectedCredit.getIdCompte());
    }
//    public void onCreditUnselect(UnselectEvent event)
//    {
//    	selectedCredit =  null;
//    }


	/* ----------------- Getters & Setters ----------------- */
	


	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}


	public Compte getSelectedDebit() {
		return selectedDebit;
	}


	public void setSelectedDebit(Compte selectedDebit) {
		this.selectedDebit = selectedDebit;
	}


	public Compte getSelectedCredit() {
		return selectedCredit;
	}


	public void setSelectedCredit(Compte selectedCredit) {
		this.selectedCredit = selectedCredit;
	}
	
	




}
