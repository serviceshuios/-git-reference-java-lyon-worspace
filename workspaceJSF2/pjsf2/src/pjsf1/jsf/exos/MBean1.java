package pjsf2.jsf.exos;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="mbean1", eager=true)
@SessionScoped
public class MBean1 {

	private String message = "Hello ";
	private int compteur = 0;
	//final static int CONSTANTE = 10;
	
	public MBean1(){
		System.out.println("MBean1 constructeur");
	}
	
	public String getMessage(){
		compteur ++;
		return message + compteur + " data = "+data + " data2 = "+data2;
	}
	
	private String data = "";
	
	public String getData(){
		return data;
	}

	public void setData(String data){
		System.out.println("setting data : "+data);
		this.data = data;
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage("laForm:inputData", new FacesMessage("messageInputData"));
	}

	private String data2 = "";
	
	public String getData2(){
		return data2;
	}

	public void setData2(String data2){
		System.out.println("setting data2 : "+data2);
		this.data2 = data2;
	}
	
	public String getLesDeux(){
		return data + data2 ;
	}
	
	public String goConditionnel(){
		
		if(data.length()>10) return "jsf3result2";
		
		else return "jsf3result";
	}
	
	public String testErreur(){
		/*
		if(data.length()>10) return "jsf3result2";
		
		else return "jsf3result";
		*/
		System.out.println("testerreur");
		return "erreur";
	}
}
