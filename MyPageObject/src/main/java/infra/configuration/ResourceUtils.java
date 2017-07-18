package infra.configuration;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.google.common.io.ByteStreams;

public class ResourceUtils {

	public static String getResourceAsString(String resourceName) throws IOException {
		@SuppressWarnings("deprecation")
		String content = IOUtils.toString(ResourceUtils.class.getClassLoader().getResourceAsStream(resourceName));
		return content;
	}
	
	public static byte[] getResournceAsByteArray(String resourceName){
		try {
			return ByteStreams.toByteArray(ResourceUtils.class.getClassLoader().getResourceAsStream(resourceName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getResourceFilePath(String resourceFile) {
		return System.getProperty("user.dir") + "\\src\\main\\resources\\" + resourceFile;
	}

}
