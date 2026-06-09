package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	
	Properties prop;
	String value;
	FileInputStream fis;
	
	
	public String getConfigValue(String key)
	{
	try {
		prop =new Properties();
		fis = new FileInputStream("src/test/java/configs/config.properties");
		prop.load(fis);
		value =(String) prop.get(key);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(fis!=null)
		{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	}
	return value;
	}

}
