package com.benlai.qa.wms.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Putils {

	public static Properties readConfig() {
		Properties pps = new Properties();
		String PATH = "/config.properties";
		// pps.load(new FileInputStream(PATH));
		try {
			InputStream in = Putils.class.getResourceAsStream(PATH);
			pps.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pps;
	}

	public String getProperties(String key) {
		// 考虑命令行的方式的读取
		Properties properties = this.readConfig();
		String value = properties.getProperty(key, "");
		return value;
	}

	// 截图方法
	public static void snapshot(TakesScreenshot drivername, String filename) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name

		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		try {
			System.out.println("save snapshot path is:D:/" + filename);
			FileUtils.copyFile(scrFile, new File("D:\\" + filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished");
		}
	}

}
