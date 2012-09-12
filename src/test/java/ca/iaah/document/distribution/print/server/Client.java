package ca.iaah.document.distribution.print.server;

import java.io.File;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class Client {

	public static void main(String[] args) throws ClientProtocolException, IOException  {
		File testFile = new File("C:/dev/test.ps");
		
	//    System.out.print(Request.Get("http://localhost:8080/printers").execute().returnContent().asString());
		System.out.print(Request.Get("http://localhost:8080/printers")
				.addHeader("Accept", ContentType.APPLICATION_XML.toString()).execute().returnContent().asString());
//		Request.Post("http://localhost:8080/iagsrvprn01SHARPMXM350NPCL6Infrastructure/print").bodyFile(testFile,ContentType.APPLICATION_OCTET_STREAM).execute();
	}
	
	public static void testPost(){
		
	}
	

}
