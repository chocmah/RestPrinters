package ca.iaah.document.distribution.print;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LocalPrinter {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return name;
	}

}
