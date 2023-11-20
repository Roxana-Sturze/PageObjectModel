package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.internal.IResultListener;

public class TestNgListener implements IResultListener{

	@Override
	public void onTestStart(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("Started method " + result.getMethod().getMethodName());
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		Log.info("Started time :" + timestamp);
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");
		Log.info("Passed test case " + result.getMethod().getMethodName());
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		Log.info("Pass time :" + timestamp);
		Log.info("+++++++++++++++++++++++++++++++++++++++++++++");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.error("+++++++++++++++++++++++++++++++++++++++++++++");
		Log.error("Failed test case " + result.getMethod().getMethodName());
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		Log.error("Failed time " + timestamp);
		Log.error(result.getThrowable());
		Log.error("+++++++++++++++++++++++++++++++++++++++++++++");
	}

}
