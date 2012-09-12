package ca.iaah.document.distribution.print.server;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class TCLauncher {

	/**
	 * @param args
	 * @throws ServletException
	 * @throws LifecycleException
	 * @throws IOException
	 */
	public static void main(String[] args) throws LifecycleException {
		
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);

		Context ctx = tomcat.addContext("/", new File(".").getAbsolutePath());


		Wrapper servletAdaptor = Tomcat.addServlet(ctx, "ServletAdaptor","com.sun.jersey.spi.container.servlet.ServletContainer");
		servletAdaptor.addInitParameter("javax.ws.rs.Application", "ca.iaah.document.distribution.print.server.ApplicationConfig");
		ctx.addServletMapping("/*", "ServletAdaptor");

		tomcat.start();
		tomcat.getServer().await();
	}

}
