package pjsf1.jsf.exos;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="mbeanresult", eager=true)
@SessionScoped
public class MBeanResult {


	public MBeanResult(){
		System.out.println("MBeanResult constructeur");
	}
	
	String dataResult = "";
	
	public String getDataResult(){
		return dataResult;
	}

	public void setDataResult(String dataResult){
		System.out.println("setting dataResult : "+dataResult);
		this.dataResult = dataResult;
	}

}
