package com.benlai.qa.wms.web.page;

import org.openqa.selenium.WebElement;

import com.benlai.qa.wms.common.ElementsFarm;

public class LenPage {
	// 仓库管理新
	public WebElement getCangku() {
		WebElement element = ElementsFarm.getElement("//*[@id='navigation']/li[7]/a");
		return element;
	}

	// 新借货单维护
	public WebElement getLen() {
		WebElement element = ElementsFarm.getElement("//*[@id='../Stock/LendList_DBC_New.aspx']");
		return element;
	}

	// 新增借货单
	public WebElement getLeno() {
		WebElement element = ElementsFarm.getElement("//*[@id='form1']/div[3]/table/tbody/tr/td[1]/div");
		return element;
	}
	
	//库存查询
	public WebElement getInventory() {
		WebElement element=ElementsFarm.getElement("//*[@id='InventoryManager_DBC']");
		return element;

	}

}
