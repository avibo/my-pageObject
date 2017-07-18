package infra.configuration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;

public enum TestSUT {

	INSTANCE;

	private Configuration prop;

	TestSUT() {
		try {
			File tempFile = File.createTempFile("tempTestSUT", ".properties");
			FileUtils.writeStringToFile(tempFile,
					ResourceUtils.getResourceAsString("config/" + TestConfig.INSTANCE.getSUTFile()), "utf-8");
			prop = new PropertiesConfiguration(tempFile);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return prop.getString(key);
	}
}
