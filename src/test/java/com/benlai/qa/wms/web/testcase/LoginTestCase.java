package com.benlai.qa.wms.web.testcase;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.benlai.qa.wms.common.DBC;
import com.benlai.qa.wms.common.Driver;
import com.benlai.qa.wms.common.ElementsFarm;
import com.benlai.qa.wms.common.ExcelDataProvider;
import com.benlai.qa.wms.common.Putils;
import com.benlai.qa.wms.web.func.LenPageFunc;
import com.benlai.qa.wms.web.func.LoginPageFunc;
import com.benlai.qa.wms.web.func.PoPageFunc;
import com.benlai.qa.wms.web.page.PoPage;
import com.gargoylesoftware.htmlunit.javascript.host.URL;
import com.thoughtworks.selenium.webdriven.commands.Click;

public class LoginTestCase {

	ElementsFarm element = new ElementsFarm();

	@BeforeClass
	public void beforeClass() {
		Driver.initDriver();
		System.out.println("Before class LoginTestCase");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After class LoginTestCase");
	}

	@Test(enabled=false)
	//从config.properties中读取用户名、密码、真实姓名
	public void login() {
		Putils pp=new Putils();
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get(pp.getProperties("url"));
		LoginPageFunc loginPageFunc = new LoginPageFunc(); 
		loginPageFunc
		           .inputUserName(pp.getProperties("name"))
		           .inputPassword(pp.getProperties("psd"))
		           .inputRealName(pp.getProperties("realname"))
		           .clickLoginButton();
	}
	@Test
    //从excel中读取用户名、密码、真实姓名
    public void login2(){
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().get(ExcelDataProvider.readExcel().get(0));
		LoginPageFunc loginPageFunc = new LoginPageFunc(); 
		loginPageFunc
		           .inputUserName(ExcelDataProvider.readExcel().get(1))
		           .inputPassword(ExcelDataProvider.readExcel().get(2))
		           .inputRealName(ExcelDataProvider.readExcel().get(3))
		           .clickLoginButton();
		
	}

}
