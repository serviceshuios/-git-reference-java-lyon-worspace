package pjsf1.jsf.exos;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@SessionScoped
public class MbInject implements Serializable{

	private static final long serialVersionUID = 1L;

	public MbInject(){
	}
	
	@Inject
	private MbInjected mbInjected;

	@Inject
	private ClientService clientService;

//	public void setMbInjected(MbInjected mBInjected){
//		this.mbInjected = mBInjected;
//	}
	
	private String data = "data from inject";

	public String getData() {
		
		mbInjected.show();
		
		//return mbInjected.getInjectedData();
		
		return "data from MbInject " + clientService.getNombre();

	}

	public String getEditValue() {
		return editValue;
	}
	public void setEditValue(String editValue) {
		this.editValue = editValue;
	}
	public String getSpinnerValue() {
		return spinnerValue;
	}
	public void setSpinnerValue(String spinnerValue) {
		this.spinnerValue = spinnerValue;
	}

	String editValue = "";
	String spinnerValue = "";
	
	
}