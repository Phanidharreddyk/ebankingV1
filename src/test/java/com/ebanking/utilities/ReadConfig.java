package com.ebanking.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	File file;

	public ReadConfig() {
		File file = new File("./src/test/resources/Configuration/config.properties");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		pro = new Properties();
		try {
			pro.load(fr);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String getURL() {
		return pro.getProperty("baseURL");
	}

	public String getBrowser() {
		return pro.getProperty("browser");
	}

	public String getUsername() {
		return pro.getProperty("username");
	}

	public String getPassword() {
		return pro.getProperty("password");
	}
}
