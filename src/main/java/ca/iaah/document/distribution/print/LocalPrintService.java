package ca.iaah.document.distribution.print;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 * 
 * @author Charles Maheu
 *
 */
public class LocalPrintService {

	
	private final static String SPECIAL_CARACTER_REMOVER_REGEX = "[^a-zA-Z0-9]+";
	
	/**
	 * 
	 * @param is
	 * @throws LocalPrintServiceException 
	 * @throws PrintException
	 */
	public static void print(String printerName, InputStream is) throws LocalPrintServiceException {
		DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		Doc myDoc = new SimpleDoc(is, psInFormat, null);  


		javax.print.PrintService[] services =  PrintServiceLookup.lookupPrintServices(psInFormat, null);

		for (int i = 0; i < services.length; i++) {
			
			String localPrinterName = services[i].getName().replaceAll(SPECIAL_CARACTER_REMOVER_REGEX,"");
			if(printerName.equals(localPrinterName)){
				PrintService service = services[i];
				DocPrintJob job = service.createPrintJob();
				try {
					job.print(myDoc, null);
				} catch (PrintException e) {
					throw new LocalPrintServiceException(e);
				}
				return;
			}
		}
		
		throw new LocalPrintServiceException("Unable to lookup for printer ["+printerName +"]" );
	}
	
	/**
	 * Return the a string array containing the name of all printer available.
	 * 
	 * @return
	 */
	public static List<LocalPrinter> lookupPrinters(){
		
		List<LocalPrinter> results = new ArrayList<LocalPrinter>();
		
		DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
		
		javax.print.PrintService[] services =  PrintServiceLookup.lookupPrintServices(psInFormat, null);
		

		for (int i = 0; i < services.length; i++) {
			
			LocalPrinter printer = new LocalPrinter();
			printer.setName(services[i].getName().replaceAll(SPECIAL_CARACTER_REMOVER_REGEX,""));

			results.add(printer);

		}
		return results;
	}

}
