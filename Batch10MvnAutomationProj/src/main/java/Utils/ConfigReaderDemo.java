package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderDemo {
	
	public static void main(String[] args) {
		
		String path = IConstants.envPropsPath;
		File file = new File(path);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fr);
			String os =prop.getProperty("os");
			String browser =prop.getProperty("browser");
			String url =prop.getProperty("url");
			
			System.out.println(os+" "+browser+" "+url);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
