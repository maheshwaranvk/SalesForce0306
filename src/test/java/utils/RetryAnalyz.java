package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyz implements IRetryAnalyzer {

	int maxRetry = 3;
	int retryCount = 0;
	public boolean retry(ITestResult result) {
		if(!result.isSuccess() && retryCount<maxRetry) // this is to check where the code is failed and the retryCount is less than maxRetry

		{

		retryCount++;

		return true;

		}

		return false;

		}

	
}
