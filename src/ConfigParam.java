

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigParam {
	
	private static Properties prop	=	null;
	
	private  static String propertyFileName	=	null;
	
	ConfigParam(String fileName){
		
		
	propertyFileName=fileName	;
	initialise();
		
	}
	public  void initialise() {
		
		FileReader fr = null;
		try {
			
			
			fr = new FileReader(propertyFileName);
		
			prop	=	new Properties();
			
			prop.load(fr);

			fr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	public String getProperty(String property) {
		
		String proper="";
		//if(prop==null)
			
		proper	=		prop.getProperty(property);
		return proper;
		
		
		
	}
	
	
		public static void main(String[] args) {
			
			String ipcEdition	=	"";
			String isIpasVersion270	=	"";
			String chand	=	"";
			
			ConfigParam pm=new ConfigParam("ipc.properties");
			ipcEdition	=	pm.getProperty("ipc.edition");
			isIpasVersion270	=	pm.getProperty("is.ipas.version.270");
			System.out.println(ipcEdition);
			System.out.println(isIpasVersion270);
			
			if(isIpasVersion270.equalsIgnoreCase("yes")){
				
				pm=new ConfigParam("editionMapping.properties");
				
				 chand	=	pm.getProperty("chandani");
			}
			
			System.out.println(chand);
			
			
		//	ConfigParam pm=new ConfigParam("editionMapping.properties");
			
		//	System.out.println(pm.getProperty(ipcEdition));
		//	System.out.println(pm.getProperty("ipc.utility.folder"));
		}
	

}
