package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property_Reader {
	
	public static Properties prop;

	public static void loadPropertyFile()
	{
		String path = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
		//System.out.println(path);
		try {
			FileReader reader = new FileReader(path);
			prop = new Properties();
			prop.load(reader);
			
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static String getPropertyFromKey(String key)
	{
		String str = prop.getProperty(key);
		
		return str;
	}
	
	

}
