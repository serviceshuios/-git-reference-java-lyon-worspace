package pjsf1.jsf.exos;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="mbinjectedservice", eager=true)
@ApplicationScoped
public class MBInjectedServiceImpl implements MBInjectedService{
	
	public MBInjectedServiceImpl(){
		System.out.println("Injected Service bean created");
	}

	public void show() {
		System.out.println("show injected service");
	}
	
	public String getInjectedData(){
		return "Hello injected service";
	}

	public String getInjectedData2(){
		return "Hello injected service 2";
	}
}
