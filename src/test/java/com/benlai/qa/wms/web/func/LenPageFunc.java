package com.benlai.qa.wms.web.func;

import com.benlai.qa.wms.web.page.LenPage;

public class LenPageFunc {
	public LenPage getLenpage(){
		LenPage lenpage=new LenPage();
		return lenpage;
		
	}
	//点击仓库管理（新）
	public LenPageFunc ClickCanku(){
		this.getLenpage().getCangku().click();
		return this;
	}
	//点击借货单维护
	public LenPageFunc ClickLen(){
		this.getLenpage().getLen().click();
		return this;
	}
	//点击新增借货单
	public LenPageFunc ClickLeno(){
		this.getLenpage().getLeno().click();
		return this;
	}
	//点击库存查询
	public LenPageFunc ClickInventory(){
		this.getLenpage().getInventory().click();
		return this;
	}

}
