package com.benlai.qa.wms.web.func;

import com.benlai.qa.wms.web.page.PoPage;

public class PoPageFunc {
	
	public PoPage getPoPage(){
		PoPage popage=new PoPage();
		return popage;
		
	}
	public PoPageFunc ClickPo(){
		this.getPoPage().getpo().click();
		return this;
	}
	
	
	
}
