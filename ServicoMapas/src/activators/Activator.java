package activators;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

import servlets.MapaChamadoServlet;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	static BundleContext getContext() {
		return context;
	}
	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		ServiceReference<HttpService> sr = context.getServiceReference(HttpService.class);
		HttpService http = context.getService(sr);
		
		if (http != null) {
			http.registerServlet("/mapachamado", new MapaChamadoServlet(), null, null);
			System.out.println("Servlet registrado");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
