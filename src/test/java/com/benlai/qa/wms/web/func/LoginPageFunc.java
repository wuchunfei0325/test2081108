package com.benlai.qa.wms.web.func;

import com.benlai.qa.wms.web.page.LoginPage;

public class LoginPageFunc {
	
	/**
	 * 登陆页面
	 * @return
	 */
	public LoginPage getLoginPage(){
		LoginPage loginPage=new LoginPage();
		return loginPage;
	}
	
	/**
	 * 输入用户名
	 * @param userName
	 * @return
	 */
	public LoginPageFunc inputUserName(String userName){
		this.getLoginPage().getUserName().sendKeys(userName);
		return this;
	}
	
	/**
	 * 输入密码
	 * @param password
	 * @return
	 */
	public LoginPageFunc inputPassword(String password){
		this.getLoginPage().getPassword().sendKeys(password);
		return this;
	}

	/**
	 * 输入姓名
	 * @param realName
	 * @return
	 */
	public LoginPageFunc inputRealName(String realName){
		this.getLoginPage().getRealName().sendKeys(realName);
		return this;
	}
	
	/**
	 * 点击登陆
	 * @return
	 */
	public LoginPageFunc clickLoginButton(){
		this.getLoginPage().getLogin().click();
		return this;
	}
	
	
}
