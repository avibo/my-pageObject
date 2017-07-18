package infra.configuration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;

public enum TestConfig {

	INSTANCE;

	private String driverType;
	private String sutFile;

	TestConfig() {
		try {
			File tempFile = File.createTempFile("tempProp", ".properties");
			FileUtils.writeStringToFile(tempFile, ResourceUtils.getResourceAsString("config/configuration.properties"), "utf-8");
			Configuration prop = new PropertiesConfiguration(tempFile);
			tempFile.delete();
			driverType = prop.getString("DriverType");
			sutFile = prop.getString("SUTFile");
		} catch (ConfigurationException | IOException e) {
			e.printStackTrace();
		}
	}


	public String getDriverType() {
		return driverType;
	}

	public String getSUTFile() {
		return sutFile;
	}
}
