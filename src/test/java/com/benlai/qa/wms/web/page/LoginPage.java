package com.benlai.qa.wms.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.benlai.qa.wms.common.Driver;
import com.benlai.qa.wms.common.ElementsFarm;

public class LoginPage {
	
	/**
	 * 用户名
	 * @return
	 */
	public WebElement getUserName(){
		WebElement element=ElementsFarm.getElement("//*[@id='txtUid']");
		return element;
	}
	
	/**
	 * 口令
	 * @return
	 */
	public WebElement getPassword(){
		WebElement element=ElementsFarm.getElement("//*[@id='txtPwd']");
		return element;
	}
	
	/**
	 * 姓名
	 * @return
	 */
	public WebElement getRealName(){
		WebElement element=ElementsFarm.getElement("//*[@id='txtUserName']");
		return element;
	}

	/**
	 * 登陆按钮
	 * @return
	 */
	public WebElement getLogin(){
		WebElement element=ElementsFarm.getElement("//*[@id='btnLogin']");
		return element;
	}

}
