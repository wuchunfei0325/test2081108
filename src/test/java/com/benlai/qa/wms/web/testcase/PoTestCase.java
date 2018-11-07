package com.benlai.qa.wms.web.testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.benlai.qa.wms.common.Driver;
import com.benlai.qa.wms.common.ElementsFarm;

public class PoTestCase {
	@BeforeClass
	public void BeforeClass() throws InterruptedException {
		Driver.initDriver();
		LoginTestCase ll=new LoginTestCase();
		ll.login();
		
	}
	@AfterClass
	public void AfterClass(){
		System.out.println("After class PoTestCase,继续执行");
		
	}
	ElementsFarm element=new ElementsFarm();
	@Test
	public void GetCai() throws InterruptedException{
		element.defaultcontent();
		element.switchtoframe("leftFrame");
		
		ElementsFarm.getElement("//*[@id='po']").click();
		ElementsFarm.getElement("//*[@id='POList_DBC']").click();
		
		element.defaultcontent();
		element.switchtoframe("frame_173");
				
		String current_handle=element.current_handle();
		ElementsFarm.getElement("//*[@id='toolbar']/tbody/tr/td[1]/div/table/tbody/tr/td").click();
		
		element.defaultcontent();
		element.switchtoframe("popFrame");
		ElementsFarm.getSelectElement("//*[@id='ucStockZone_ddlStock']", "BJ正常销售仓");
		Thread.sleep(2000);
		ElementsFarm.getSelectElement("//*[@id='ucStockZone_ddlZone']", "BJ拣货区");
		Thread.sleep(100);
		ElementsFarm.getElement("//*[@id='ucVendor_lnkSearch']").click();
		
		Thread.sleep(2000);
		element.switch_handles().findElement(By.xpath("//*[@id='txtVendorName']")).sendKeys("北京");
		element.switch_handles().findElement(By.xpath("//*[@id='btnSearch']")).click();		
		
		/*WebElement table=element.getElement("//*[@id='DataGrid1']/tbody");
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		Thread.sleep(3000);
		String text0="202203";
		String text1="202203";
		String text2="北京中天久隆商贸有限公司";
		System.out.println("找到供应商元素了111111");	
		for(WebElement row:rows){
			List<WebElement> cols=row.findElements(By.tagName("td"));			
				if ((cols.get(0).getText().equals(text0))&& (cols.get(1).getText().equals(text1) )
						&& 
					(cols.get(2).getText().equals(text2) )) {
					System.out.println("找到供应商元素了");	
					Driver.getDriver().findElement(By.linkText(text2)).click();
					break;
				}	
		}*/
		
		element.switch_handles().findElement(By.xpath("//*[@id='DataGrid1']/tbody/tr[2]/td[3]/a")).click();
		
		Driver.getDriver().switchTo().window(current_handle);
		element.defaultcontent();
		element.switchtoframe("popFrame");
		element.getSelectElement("//*[@id='ddlInventoryType']", "临期商品");
		element.getElement("//*[@id='divSaveNew']/table/tbody/tr/td").click();
		
		Thread.sleep(2000);
		//String current_handle2=element.current_handle();
		element.getElement("//*[@id='toolbar']/tbody/tr/td[1]/div/table/tbody/tr/td").click();		
		Thread.sleep(1000);
		element.getElement("//*[@id='ucProduct_btnSearchSingle']").click();
		//Driver.getDriver().manage().window().maximize();
		element.switch_handles().findElement(By.xpath("//*[@id='txt-ProductName']")).sendKeys("wcf三码");
		element.switch_handles().findElement(By.xpath("//*[@id='btn-search']")).click();
		
		WebElement table=element.getElement("//*[@id='DataGrid-table']/div/table");
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		Thread.sleep(3000);
		String text3="华北";
		String text4="B2C";
		String text5="临期渠道";
		String text6="wcf三码";
		for(WebElement row:rows){
			List<WebElement> cols=row.findElements(By.tagName("td"));
			/*for(WebElement col:cols){
				int r=cols.size();
				cols.get(r).getText();
				String[] Text=new String[r];	*/			
				if ((cols.get(0).getText().equals(text3)) && (cols.get(1).getText().equals(text4))
						&& 
					(cols.get(2).getText().equals(text5)) && (cols.get(3).getText().equals(text6))) {
					System.out.println("找到元素了22222");	
					Driver.getDriver().findElement(By.linkText(text6)).click();
					break;
				}				
			
			/*for(int i=0;i<rows.size();i++){
				if (rows.get(i).getText().contains(text0)&&rows.get(i).getText().contains(text1)
						&&rows.get(i).getText().contains(text2)&&rows.get(i).getText().contains(text3)) {
					Driver.getDriver().findElement(By.linkText(text3)).click();
					
				}
			}*/
			
		}
		//element.switch_handles().findElement(By.xpath("//*[@id='DataGrid-table']/div/table/tbody[2]/tr[1]/td[5]/div/a")).click();
		Driver.getDriver().switchTo().window(current_handle);
		 
		element.defaultcontent();
		element.switchtoframe("popFrame");
		element.getElement("//*[@id='btnLoadDefaultPurchasePrice']").click();
		element.getElement("//*[@id='txtQuantity']").sendKeys("100");
		
		element.getElement("//*[@id='btnSaveOption']").click();

		
		
	}

}
