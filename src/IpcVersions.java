

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.xml.bind.*;

import org.apache.log4j.Logger;

import AllipcClassificationSymbol.WIPOSymbolsOfVersion;
import AllipcClassificationSymbol.WIPOSymbolsOfVersion.Classifications;
import AllipcClassificationSymbol.WIPOSymbolsOfVersion.Classifications.Classification;
import AllipcVersion.Versions;
import IndividualSymbolDescription.WIPOSymbolDescription;



public class IpcVersions {
	static List<CF_IPC_CLASS> cfIpcClasstablerowlist	=	null;
	static  String  defaultIpcUrl	=	"";
	static JAXBContext jaxbVersionsContext 	=	null;
	static JAXBContext jaxbSymbolsOfVersionContext 	=	null;
	static	Unmarshaller	versionUnmarshaller		=	null;
	static	Unmarshaller	symbolsOfVersionUnmarshaller		=	null;
	static int numberOfVersions;
	static List<Float> versionList	=	null;
	static List<URL> allSymbolsOfVersionURLList	=	null;
	static InputStreamReader in;
	BufferedReader buff ;
	static List<URL> versionClassificationList	=	new ArrayList<URL>();
	static	Versions	versionObject	=	null;
	static	WIPOSymbolsOfVersion	wipoSymbolsOfVersionObject	=	null;
	static String ipcEdition	= null;
	static List<URL> individualSymbolURLlist	= new ArrayList<URL>();
	static	List<String> symbolList	= new ArrayList<String>();
	static	String exportFileVersion	=	"";	
	static String exportId	=	"";
	static String notes		=	"";
	static String language	=	"";
	 static String ipcUtilityFolder;
	 static HashMap<String, String> symbolDescriptionMap = new HashMap<String, String>();
	 static String isIpasVersion270;
	 static String ipcEditionFor270	=	null;
	 static Logger logger	=	Logger.getLogger("IpcVersions.class");

	public static void init(){
		
		try {
			jaxbVersionsContext	=			JAXBContext.newInstance(Versions.class);
			jaxbSymbolsOfVersionContext	=	JAXBContext.newInstance(WIPOSymbolsOfVersion.class);
			
			versionUnmarshaller			=	jaxbVersionsContext.createUnmarshaller();
			symbolsOfVersionUnmarshaller=	jaxbSymbolsOfVersionContext.createUnmarshaller();

			versionList	=	new ArrayList<Float>();
			allSymbolsOfVersionURLList	=	new ArrayList<URL>();
			cfIpcClasstablerowlist		=	new ArrayList<CF_IPC_CLASS>();
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
			
			
			
			
			private static void parseSpecificSymbolsOfVersion() {
				
				int numfound	=	0;
				
			//	for(URL symbolsOfVersionURL :allSymbolsOfVersionURLList){
				URL individualSymbolURL	= null;
				
				try {
					
					URL symbolsOfVersionURL	=	allSymbolsOfVersionURLList.get(0);
					wipoSymbolsOfVersionObject	=	(WIPOSymbolsOfVersion)	symbolsOfVersionUnmarshaller.unmarshal(symbolsOfVersionURL);
					Classifications individualClassfications=wipoSymbolsOfVersionObject.getClassifications();
					
					individualClassfications.getClassification();
					
			
					//http://localhost:9093/wopublish-services/classifications/ipc/2015.01&fq=group:SYMBOL
					
					symbolsOfVersionURL	=new URL(symbolsOfVersionURL.toString()+"&rows="+individualClassfications.getNumFound());
				
					wipoSymbolsOfVersionObject	=	(WIPOSymbolsOfVersion)	symbolsOfVersionUnmarshaller.unmarshal(symbolsOfVersionURL);
					 individualClassfications=wipoSymbolsOfVersionObject.getClassifications();
					Iterator symbolItr	=	 individualClassfications.getClassification().iterator();
					Classification classification	;
					
					while(symbolItr.hasNext()){
						
						classification	=		(Classification) symbolItr.next();
					//	System.out.println("classification.getLevel().toString()::"+classification.getLevel().toString());
						//http://localhost:9093/wopublish-services/classifications/ipc/2015.01/A01B?tree=false
						if(classification.getLevel().toString().equalsIgnoreCase("SYMBOL")){
						individualSymbolURL	= new URL(allSymbolsOfVersionURLList.get(0).toString().replace("&fq=group:SYMBOL", "")+"/"+classification.getSymbol().toString().replace('/', ' ')+"?tree=false");
					//	individualSymbolURL	= new URL(allSymbolsOfVersionURLList.get(0).toString().replace("&fq=group:SYMBOL", "")+"/"+classification.getSymbol().toString().replaceAll(" ", "").replaceAll("/", "")+"?tree=false");
						individualSymbolURLlist.add(individualSymbolURL);
						symbolList.add(classification.getSymbol().toString());
						
				
						}
				//	System.out.println("num found"+wipoSymbolsOfVersionObject.getClassifications().getNumFound());
				
				} 
					System.out.println("--------All Symbols Of IPC Edition::"+ipcEdition+":: ---------" );
					
					System.out.println(symbolList);
					
					System.out.println("--------Individual Symbol Description URL List---------" );
					
					System.out.println(individualSymbolURLlist);
					
				}catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
	
	
	
	
	private static void parseSpecificVersion() {
		
		try {
			boolean versionMatched	=	false;
			 versionObject	=				(Versions) versionUnmarshaller.unmarshal(new URL( defaultIpcUrl ));
			 versionList	=			versionObject.getEditions();
					 System.out.println("-----------------------------------------" );
			
					 
					 
					 
			 for(Float individualVersion:versionList){

				 if(individualVersion== Float.parseFloat(ipcEdition)){
				 
				 System.out.println("ipcEdition.trim())::"+ipcEdition.trim());
					 versionMatched	=	true;
					 
					 String individualVersionString	=	String.valueOf(individualVersion) ;
					 if(individualVersionString.split("\\.")[1].length()==1){
					 
						 individualVersionString	=	 individualVersionString+"0";
					 
					 }
					 System.out.println("individualVersionString::"+individualVersionString);
					 
					 allSymbolsOfVersionURLList.add(new URL(defaultIpcUrl+individualVersionString+"&fq=group:SYMBOL"));
					 
					 break;
					 
				 }
				 
			
				 
				 
			 }
		
			 if(!versionMatched){
				 
				 System.out.println("Please specify valid IPC edition");
					System.out.println("-----------------------------------------" );
				 System.out.println("Valid IPC Editions are:::"+versionList);
				 System.exit(0);
			 }
			 
			 
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
//			public static void readLogconfig(){
//				
//				
//			}
//				
	
	
			public static void main(String[] args) {
				
				IpcVersions	ipcObj	=	new IpcVersions();
			//	readLogconfig();
				
				logger.debug("In main method");
				
				
				
				
				File dirIpcXml=null;
				File dirLog=null;
				File frLog=null;
			
				File frIpcXml=null;
				PrintStream orig = System.out;
		        PrintStream ps =null;
						
				FileOutputStream fos = null;
				
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
				Date date = new Date();
			//	System.out.println(dateFormat.format(date)); //20140806 155948
				
				EXPORT.TABLE	table =new EXPORT.TABLE();
				EXPORT	export= new EXPORT();
		//		System.out.println("Generation IPC xml file for edition::"+ipcEdition+"..........");
				
	
				
				init();
				readProperty();
				System.out.println("Generation IPC xml file for edition::"+ipcEdition+"..........");
				
				//Log
				try {
					 if(isIpcVersion270())
					 {
						 dirLog = new File(ipcUtilityFolder+"\\IPC270\\log");
						 
						 
					 }else{
						 dirLog = new File(ipcUtilityFolder+"\\log");
															
					 }
					 
					 dirLog.mkdirs();
						
					 frLog = new File(dirLog, "log"+dateFormat.format(date)+".txt");
					try {
						frLog.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					fos	=	new FileOutputStream(frLog);
					ps = new PrintStream(fos);
					System.setOut(ps);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("--------------Properties---------------------------" );
				System.out.println("ipcUtilityFolder::"+ipcUtilityFolder);
				System.out.println("ipcEdition::"+ipcEdition);
				System.out.println("exportFileVersion::"+exportFileVersion);
				System.out.println("exportId::"+exportId);
				System.out.println("notes::"+notes);
				System.out.println("language::"+language);
				System.out.println("defaultIpcUrl::"+defaultIpcUrl);
				System.out.println("isIpasVersion270::"+isIpasVersion270);
			//	ipcEditionFor270
				
				parseSpecificVersion();	
				parseSpecificSymbolsOfVersion();
				
				ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
				
				for(int i=0;i<individualSymbolURLlist.size();i++){
					URL individualURL	=	individualSymbolURLlist.get(i);
					Task t= new Task(ipcObj,i+"task",individualURL);
					System.out.println("task created::"+i);
					
					executor.execute(t);

				}
				

				executor.shutdown();

				
				while (!executor.isTerminated()) {
					
						        }
			
			System.out.println("All threads have finished their job");
				

				
			//	parseSymbolDescription();
				
			table	=	parseSymbols();
				
				
				export.setNOTES(notes);
				export.setLANGUAGE(language);
				export.setEXPORTID(exportId);
				export.setVERSION(exportFileVersion);
				export.setTABLE(table);
				
		
				
		

				
				try {
					
					 if(isIpcVersion270())
					 {
						 
						 dirIpcXml = new File(ipcUtilityFolder+"\\IPC270\\IpcClassificationXML");
						 
					 }else{
						 dirIpcXml = new File(ipcUtilityFolder+"\\IpcClassificationXML");
															
					 }
					
					dirIpcXml.mkdirs();
					frIpcXml = new File(dirIpcXml, "IPC"+ipcEdition+".xml");
					
					try {
						frIpcXml.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					JAXBContext jaxbContext1 = JAXBContext.newInstance( EXPORT.class );
					
		            Marshaller jaxbMarshaller = jaxbContext1.createMarshaller();
	
		 
	
		            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
	
		 
	
		            jaxbMarshaller.marshal( export, frIpcXml );
	
		        //    jaxbMarshaller.marshal( export, System.out );
			
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//resetting standard output stream to console

				System.setOut(orig); 
				
			
				
				System.out.println("Processing Completed!!!");
				System.out.println("Please check  IPC xml file for edition::"+ipcEdition+":: generated in IpcClassificationUtility folder");
				System.out.println("Please check processed details in log file generated in IpcClassificationUtility folder");
				
		
}



			public  void parseSymbolDescription(URL individualSymbolUrl) {
				
				JAXBContext jaxbIndividualSymbolContext 	=	null;
				try {
					jaxbIndividualSymbolContext	=	JAXBContext.newInstance(WIPOSymbolDescription.class);
				} catch (JAXBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("");
				
		
			String ipc_name	=	"";
			String sectionClassSclassDescription="";
			String symbolDescription	="";
			String symbol	="";
				//	URL individualSymbolUrl	=individualSymbolURLlist.get(i);
					List<WIPOSymbolDescription.Classification.Heading> heading = new  ArrayList<WIPOSymbolDescription.Classification.Heading>();
					try {
					Unmarshaller	individualSymbolUnmarshaller		=	null;
					WIPOSymbolDescription	wipoSymbolDescriptionObject	=	null; 
						individualSymbolUnmarshaller	=				jaxbIndividualSymbolContext.createUnmarshaller();
						wipoSymbolDescriptionObject		=				(WIPOSymbolDescription) individualSymbolUnmarshaller.unmarshal(individualSymbolUrl);
						
						 symbolDescription	=	wipoSymbolDescriptionObject.getClassification().getDescription();
						 symbol				=	wipoSymbolDescriptionObject.getClassification().getSymbol();
						 System.out.println("symbol::"+symbol);
					//	System.out.println("symbolDescription::"+symbolDescription); 
						
								heading=		wipoSymbolDescriptionObject.getClassification().getHeading();
								Iterator<WIPOSymbolDescription.Classification.Heading> itr	=	heading.iterator();
				//code commented				
								
//						while(itr.hasNext())
//						{
//							
//							WIPOSymbolDescription.Classification.Heading indHeading	=	itr.next();
//							sectionClassSclassDescription	=	sectionClassSclassDescription + indHeading.getDescription().getContent().toString().substring(1, indHeading.getDescription().getContent().toString().length()-1);
//						//	System.out.println("ind:::"+indHeading.getDescription().getContent().toString().substring(1, indHeading.getDescription().getContent().toString().length()-1));
//						}
//					
//						System.out.println("whole description:"+sectionClassSclassDescription+symbolDescription);
								
								
			//////////////////////////////////////////////////////////////					
						ipc_name	=	symbolDescription;
						synchronized (this) {
						symbolDescriptionMap.put(symbol, ipc_name);
						}
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						
						e.printStackTrace();
					//	individualSymbolUnmarshaller.getUnmarshallerHandler().endDocument();
					}
			//	}
			}







			private static  EXPORT.TABLE parseSymbols() {
			
				EXPORT.TABLE	 table	= new EXPORT.TABLE();
			//	URL individualSymbolURL	=	individualSymbolURLlist.get(0);
				
				//	wipoSymbolDescriptionObject	=				(WIPOSymbolDescription) individualSymbolUnmarshaller.unmarshal( individualSymbolURL);
				
					
				
					System.out.println("--------------:::::::Going to parse Symbol:::::::::------------------------");
				
					//System.out.println("symbolList::"+symbolList);
					
					table.setNAME("CF_CLASS_IPC");
					
					
					boolean first	=	false;
			
					for(String individualSymbol:symbolList){
						System.out.println("individualSymbol::"+individualSymbol);
						EXPORT.TABLE.ROW cfIpcClass = new EXPORT.TABLE.ROW();	
				
					
					// Row Version by default 1
					cfIpcClass.setROWVERSION( Byte.valueOf("1"));
					
					// Section Code
					cfIpcClass.setIPCSECTIONCODE(individualSymbol.substring(0, 1));
					System.out.println("SectionCode:::"+individualSymbol.substring(0, 1));
				//	 Class code
					cfIpcClass.setIPCCLASSCODE(individualSymbol.substring(1, 3));
					System.out.println("setClassCode:::"+individualSymbol.substring(1, 3));	
					// Subclass code
					cfIpcClass.setIPCSUBCLASSCODE(individualSymbol.substring(3, 4));
					System.out.println("setSubClassCode:::"+individualSymbol.substring(3, 4));
					
					String groupCode	=	"";
					String subGroupCode	=	"";
					String ipc_name="";
						
						if(!first){
							
							System.out.println("Creating first row that contains description of  subclass");
							
		
								 groupCode	=	"000";
							
								 subGroupCode	=	"00000";
								
													//
						
						
							//String ipc_name="";
							ipc_name	=	symbolDescriptionMap.get(individualSymbol);
//							if(ipc_name==null){
//								
//								ipc_name	=	"demo";
//								
//							}
						
						
							
								
							
							
							
						
							first=true;
						}
						
						else{
					
				
			
			
				
				if(individualSymbol.contains("/")){

					
					 groupCode	=	individualSymbol.split("/")[0].trim();
					groupCode	=	groupCode.substring(groupCode.indexOf(' ')).trim();
					 subGroupCode	=	individualSymbol.split("/")[1].trim();
					
					
			
					
				}
				
				
			
			
				ipc_name	=	symbolDescriptionMap.get(individualSymbol);
//				if(ipc_name==null){
//					
//					ipc_name	=	"demo";
//					
//				}
			
				
			
				
					}
						
					
					cfIpcClass.setIPCGROUPCODE(groupCode);
					System.out.println("groupCode::"+groupCode);
					cfIpcClass.setIPCSUBGROUPCODE(subGroupCode);
					System.out.println("subGroupCode::"+subGroupCode);
					
					System.out.println("--------------- symbols---------------------------------------");
					if(isIpcVersion270())
					{
						cfIpcClass.setIPCEDITIONCODE(ipcEditionFor270);
					}
					else{
						cfIpcClass.setIPCEDITIONCODE(ipcEdition);
					}
					
					}
				return table;
				
			}



			private static void readProperty() {
			
				ConfigParam	config	=	new ConfigParam("ipc.properties");
				
				ipcUtilityFolder	=	config.getProperty("ipc.utility.folder");
				
				ipcEdition	=		config.getProperty("ipc.edition");
				
				exportFileVersion	=	config.getProperty("export.file.version");
				
				exportId	=	config.getProperty("export.id");
				
				notes		=	config.getProperty("notes");
				
				language	=	config.getProperty("ipc.language");
				
				defaultIpcUrl	=	config.getProperty("wipo.publish.ipc.url");
				
				isIpasVersion270	=	config.getProperty("is.ipas.version.270");
				
					if(isIpasVersion270==null){
					
					System.out.println("Please update the value of isIpasVersion270 in ipc.properties");
					
					
					}
				
				if(isIpcVersion270()){
					
					config				=	new ConfigParam("editionMapping.properties");
					ipcEditionFor270	=	config.getProperty(ipcEdition.trim());
					
				
					if(ipcEditionFor270==null||ipcEditionFor270.isEmpty()){
						
						System.out.println("Please update the value of::"+ipcEdition+ ":: in editionMapping.properties");
					}
					
				}
				
					
		}
		
			public static boolean isIpcVersion270(){
				
				
			
				if(isIpasVersion270.equalsIgnoreCase("y")||isIpasVersion270.equalsIgnoreCase("yes")){
					
					return true;
										
				}
					return false;
			}
		
	}




	
	
	


