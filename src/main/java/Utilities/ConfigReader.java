package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	Properties pr;
public ConfigReader() throws IOException {
	FileInputStream fis = new FileInputStream("src/main/java/BasePackage/config.properties");
	pr = new Properties();
	pr.load(fis);
}

public String getProperty(String key) {
	return pr.getProperty(key);
	}
}
