package com.ebanking.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ebanking.testCases.BaseClass;

public class Screenshot extends BaseClass{

	public void getScreenshot(String screenshotPath)
	{
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(screenshotPath);
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
