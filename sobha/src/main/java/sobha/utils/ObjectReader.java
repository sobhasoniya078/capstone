package sobha.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectReader {
	private static Properties pro;

	public static Properties objectRead() throws IOException {
		if (pro == null) {
			pro = new Properties();
			try {
				FileInputStream reader = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\objectrepository\\object.properties");
				pro.load(reader);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pro;

	}

	

}
