package Test.TestCase.Practicethree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ParseProperties {
	private Properties pro = new Properties();
	String value = null;
	
	public ParseProperties(String propertiespath) {
		this.loadProperties(propertiespath);
		
	}
	
	private void loadProperties(String propertiespath) {
		try {
			InputStream in = new FileInputStream(propertiespath);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			pro.load(br);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getValue(String keyname) {
		value = pro.getProperty(keyname).trim();
		System.out.println(value);
		/*try {
			value = new String(value.getBytes("ISO-8859-1"));
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		return value;
	}
	
	public static void main(String[] args) {
		String filepath = System.getProperty("user.dir")+"/tools/locator.properties";
		ParseProperties p = new ParseProperties(filepath);
		System.out.println(p.getValue("unreadLink"));
		
	}

}
