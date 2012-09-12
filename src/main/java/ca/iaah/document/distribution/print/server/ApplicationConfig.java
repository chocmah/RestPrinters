package ca.iaah.document.distribution.print.server;

import javax.ws.rs.ApplicationPath;

import com.sun.jersey.api.core.PackagesResourceConfig;

@ApplicationPath("/*") 
public class ApplicationConfig  extends PackagesResourceConfig {
	 public ApplicationConfig() {
	        super("ca.iaah.document.distribution.print");
	    }
}
