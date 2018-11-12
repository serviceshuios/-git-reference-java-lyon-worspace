package pjsf1.jsf.exos;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class MbInjected implements Serializable{

	private static final long serialVersionUID = 2L;

	public MbInjected(){
		System.out.println("Injected bean created");
	}

	public void show() {
		System.out.println("show from injected");
	}
	
	public String getInjectedData(){
		return "Hello injected";
	}

}