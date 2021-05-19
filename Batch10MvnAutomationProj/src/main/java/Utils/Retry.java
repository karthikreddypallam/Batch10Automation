package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int retryCount = 0;
	int maxRetry = 3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(retryCount<maxRetry) {
			retryCount++; 
			return true;
		}
		return false;
	}

}
