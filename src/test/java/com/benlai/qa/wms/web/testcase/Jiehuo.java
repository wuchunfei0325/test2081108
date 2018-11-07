package com.benlai.qa.wms.web.testcase;

import org.testng.annotations.Test;

import com.benlai.qa.wms.common.DBC;
import com.benlai.qa.wms.common.Driver;
import com.benlai.qa.wms.common.ElementsFarm;
import com.benlai.qa.wms.common.ExcelDataProvider;
import com.benlai.qa.wms.common.Putils;
import com.benlai.qa.wms.web.func.LenPageFunc;

import org.testng.annotations.BeforeClass;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;

public class Jiehuo {
	ElementsFarm element = new ElementsFarm();

	@Test
	public void f() throws SQLException {
		// 从数据库中读取商品的库存
		int accountQty = (Integer) DBC.Query_Inventory().get(0);
		int availableQty = (Integer) DBC.Query_Inventory().get(1);
		int salableQty = (Integer) DBC.Query_Inventory().get(2);
		int allocatedQty = (Integer) DBC.Query_Inventory().get(3);
		// 切换frame
		element.defaultcontent();
		element.switchtoframe("leftFrame");
		LenPageFunc lenPageFunc = new LenPageFunc();
		// 点击仓库管理（新）
		lenPageFunc.ClickCanku();

		/*
		 * 添加借货单
		 */
		// 等待时间

		// 隐式等待 是全局的（所有的元素）
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 点击接货单维护
		lenPageFunc.ClickLen();

		// 切换frame
		element.defaultcontent();
		element.switchtoframe("frame_100376");
		// 点击新增借货单
		lenPageFunc.ClickLeno();
		// 库区
		element.defaultcontent();
		element.switchtoframe("popFrame");

		// 通过excel读取元素（元素的xpth在excel中）
		ElementsFarm.getSelectElement(ExcelDataProvider.readExcel().get(4), "BJ正常销售仓");
		ElementsFarm.getSelectElement("//*[@id='ucStockZone_ddlZone']", "BJ拣货区");
		// 借出人
		ElementsFarm.getElement("//*[@id='ucUser_txtUserID']").sendKeys("admin");
		// 渠道s
		ElementsFarm.getSelectElement("//*[@id='UcSaleChannel_ddlChannel']", "B2C");
		ElementsFarm.getSelectElement("//*[@id='UcSaleChannel_ddlSaleChannel']", "C网零售");
		// 保存借货单
		ElementsFarm.getElement("//*[@id='divSaveNew']/table/tbody/tr/td").click();
		ElementsFarm.getElement("//*[@id='btnOK']").click();
		// 添加商品
		ElementsFarm.getElement("//*[@id='toolbar']/tbody/tr/td[1]/div/table/tbody/tr/td").click();
		ElementsFarm.getElement("//*[@id='ucProductBigSKU_txtProductSysNo']").sendKeys("60869");
		ElementsFarm.getElement("//*[@id='btn_date']").click();
		ElementsFarm.getElement("//*[@id='main_grid2_ctl03_txtOptQty']").sendKeys("3");
		// 截图
		Putils.snapshot((TakesScreenshot) Driver.getDriver(), "添加商品.png");

		String element2 = ElementsFarm.getElement("//*[@id='main_grid2_ctl03_txtOptQty']").getText();
		System.out.println("借货单添加商品的库存：" + element2);

		ElementsFarm.getElement("//*[@id='btnSaveOption']").click();
		ElementsFarm.getElement("//*[@id='Table1']/tbody/tr/td[10]/div/table/tbody/tr/td").click();
		// 添加商品后的库存
		int accountQty2 = (Integer) DBC.Query_Inventory().get(0);
		int availableQty2 = (Integer) DBC.Query_Inventory().get(1);
		int salableQty2 = (Integer) DBC.Query_Inventory().get(2);
		int allocatedQty2 = (Integer) DBC.Query_Inventory().get(3);

		element.defaultcontent();
		element.switchtoframe("leftFrame");

		if ((accountQty2 == accountQty) && (availableQty - availableQty2 == 3) && (salableQty - salableQty2 == 3)
				&& (allocatedQty2 - allocatedQty == 3))
			System.out.println("库存变化正确");
		else
			System.out.println("库存变化不正确");
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		Driver.initDriver();
		LoginTestCase ll = new LoginTestCase();
		ll.login2();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Afterclass Jiehuo");
	}

}
