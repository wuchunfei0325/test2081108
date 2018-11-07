package com.benlai.qa.wms.common;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsFarm {
	// 定位元素
	public static WebElement getElement(final String xpah) {
		WebElement element = Driver.getDriver().findElement(By.xpath(xpah));
		waitForElementToLoad(Driver.getDriver(), 50, By.xpath(xpah));
		return element;
	}

	// 超时方法
	public static void waitForElementToLoad(WebDriver driver, int timeOut, final By By) {
		try {
			(new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					WebElement element = driver.findElement(By);
					return element.isDisplayed();

				}
			});
		} catch (Exception e) {
			// Assert.fail("超时!! " + timeOut + " 秒之后还没找到元素 [" + By + "]");
			System.out.println("超时！！" + timeOut + "秒之后还没找到元素[" + By + "]");

		}
	}

	// 定位下拉框元素
	public static void getSelectElement(String xpah, String text) {

		Select select = new Select(getElement(xpah));
		select.selectByVisibleText(text);
	}

	// 默认iframe
	public void defaultcontent() {
		Driver.getDriver().switchTo().defaultContent();
	}

	// 切换iframe
	public void switchtoframe(String iframe) {
		Driver.getDriver().switchTo().frame(iframe);
	}

	// 句柄
	public String current_handle() {
		return Driver.getDriver().getWindowHandle();
	}

	WebDriver newWindow = null;

	// 所有句柄
	public WebDriver switch_handles() {
		Set<String> all_handles = Driver.getDriver().getWindowHandles();
		// 循环判断，把当前句柄从所有句柄中移除，剩下的就是你想要的新窗口
		Iterator<String> it = all_handles.iterator();
		while (it.hasNext()) {
			if (current_handle() == it.next())
				continue;
			// 跳入新窗口,并获得新窗口的driver - newWindow
			newWindow = Driver.getDriver().switchTo().window(it.next());
		}
		return newWindow;

	}
}
