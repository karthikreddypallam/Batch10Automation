package Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop = null;
	
	public void readConfig() {
		prop = new Properties();
		try {
			prop.load(new FileReader(new File(IConstants.envPropsPath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getURL() {
		return prop.getProperty("url");
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getOS() {
		return prop.getProperty("os");
	}

}
