package ca.iaah.document.distribution.print.server;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.lang3.StringUtils;

import ca.iaah.document.distribution.print.LocalPrintService;
import ca.iaah.document.distribution.print.LocalPrintServiceException;
import ca.iaah.document.distribution.print.LocalPrinter;

/**
 * 
 * @author Charles Maheu
 *
 */
@Path("/")
public class PrintServerRest {
	
	@GET
	@Produces("text/html")
	public String getIndex() {
		
		return "Print service is up!";
	}
	
	@GET
	@Path("/printers")
	@Produces("text/html")
	public String getPrinters() {
		
		String printers = StringUtils.join(LocalPrintService.lookupPrinters(), ", ");
		return "Printer available : " + printers;
	}
	
	@GET
	@Path("/printers")
	@Produces({"application/json", "application/xml"})
	public List<LocalPrinter> getLocalPrinters() {
		
		return LocalPrintService.lookupPrinters();
	}
	
	@POST
	@Path("/{printerName}/print")
	@Consumes("application/octet-stream")
	@Produces("text/plain")
	public String printFile(@PathParam("printerName")String printerName, InputStream printFile){
		
		try {
			LocalPrintService.print(printerName,printFile);
		} catch (LocalPrintServiceException e) {
			return "Erreur! " + e.getMessage();
		}
		return "Success file received!";
	}

}
