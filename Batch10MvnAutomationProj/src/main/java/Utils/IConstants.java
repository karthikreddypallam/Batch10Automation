package Utils;

public interface IConstants {
	
	String projPath = System.getProperty("user.dir");
	
	String chromeDriverPathMAC = projPath+"/src/main/resources/drivers/mac/chromedriver";
	String chromeDriverPathWin10 = projPath+"/src/main/resources/drivers/windows/chromedriver.exe";
	
	String geckoDriverPathMAC = projPath+"/src/main/resources/drivers/mac/geckodriver";
	String geckoDriverPathWin10 = projPath+"/src/main/resources/drivers/windows/geckodriver.exe";

	String envPropsPath = projPath+"/src/test/resources/env.properties";
}
