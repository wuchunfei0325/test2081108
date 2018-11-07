package com.benlai.qa.wms.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Driver {
	
	
	static WebDriver driver ;
	//静态方法
	public static WebDriver getDriver(){
		return driver;
	}
	
	public static WebDriver initDriver(){
		Putils propertyUtils=new Putils();
		String browserType=propertyUtils.getProperties("browserType");
		if("ie".equals(browserType.trim())){
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
	        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	        driver = new InternetExplorerDriver(ieCapabilities);
		}else if("chrome".equals(browserType.trim())){
			driver= new ChromeDriver();
		}else if("ff".equals(browserType.trim())){
				driver= new FirefoxDriver();
		}else{
			driver= new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	
	
	

}
