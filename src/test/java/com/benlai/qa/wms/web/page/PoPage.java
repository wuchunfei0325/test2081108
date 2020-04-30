package com.benlai.qa.wms.web.page;

import org.openqa.selenium.WebElement;

import com.benlai.qa.wms.common.Driver;
import com.benlai.qa.wms.common.ElementsFarm;

public class PoPage {
	/*
	 * 采购管理
	 */
	public WebElement getpo(){
		WebElement element=ElementsFarm.getElement("//*[@id='po']");
		return element;
	}
	/*
	 * 采购单维护
	 */


	//没有写代码

}
