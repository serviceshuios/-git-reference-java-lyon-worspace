package interceptor;

import java.util.Scanner;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Connected
public class Connector {
	
	@AroundInvoke
	public Object connect(InvocationContext context) throws Exception {
		Scanner clavier = new Scanner(System.in);
		System.out.println("Saisir le login :");
		String login = clavier.next();
		System.out.println("Saisir le pass :");
		String pass = clavier.next();
		clavier.close();
		
		if(login.equalsIgnoreCase("root") && pass.equalsIgnoreCase("root"))
		{
			System.out.println("CONNECTE");
			return context.proceed();
		}
		else {
			System.out.println("ERREUR DE CONNEXION");
			return null;
		}
		
	}
}
