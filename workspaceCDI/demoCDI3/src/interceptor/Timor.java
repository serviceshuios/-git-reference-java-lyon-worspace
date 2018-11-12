package interceptor;

import java.util.Date;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Timed
public class Timor {

	@AroundInvoke
	public Object getTime(InvocationContext context) throws Exception{
		System.out.println("AVANT");
		Date d1 = new Date();
		Object retVal = context.proceed();
		System.out.println("APRES");
		Date d2 = new Date();
		long time1=d1.getTime();
		long time2=d2.getTime();
		long diff = time2 - time1;
		System.out.println("temps de traitement = "+diff+ " millisecondes");
		return retVal;
	}
}
