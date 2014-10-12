package com.example.wastehandlems;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;






import android.content.res.AssetManager;
import android.util.Log;


public class WasteHandleConfiguration {

	private static final String PROPERTIES_FILENANE = "wastehandle.properties";
	private static final String PROPERTIES_WHMS_PROJECT_FOLDER_NAME = "WHMS_project_folder_name";
	
	
	
	
	public static WasteHandleConfiguration instance;
	private String WasteHandleProjectFolderName="aaaa";
	
	public static WasteHandleConfiguration getInstance(){
		return instance;
	}
	
	private WasteHandleConfiguration(){}
	
	public static void init(WasteHandleApplication wasteHandleApplication) throws WasteHandleCofigurationException{
		PropertiesLoader propertiesLoader = new PropertiesLoader(wasteHandleApplication.getAssets());
		instance = new WasteHandleConfiguration();
		String projectFolderName = propertiesLoader.getPropertyAsString(PROPERTIES_WHMS_PROJECT_FOLDER_NAME);
		instance.WasteHandleProjectFolderName = projectFolderName;
	} 
	
	public String getProjectFolderName() {
		return WasteHandleProjectFolderName;
	}
	
	private static class PropertiesLoader {
		private Properties properties;
		public PropertiesLoader(AssetManager assetManager) throws WasteHandleCofigurationException{
					InputStream inStream  = null;
					properties = new Properties();
					try {
						inStream = assetManager.open(PROPERTIES_FILENANE);
						properties.load(inStream);
					} catch(IOException ioe) {
						ioe.printStackTrace(System.err);
						throw new WasteHandleCofigurationException(String.format("Cannot load properties files %s: %s", PROPERTIES_FILENANE, ioe.getMessage()));
					} finally {
						if(inStream != null) {
							try {
								inStream.close();
							} catch(IOException ioe) {
								// ignore this exception as no further action is required
							}
						}
					}
		}
		
		
		public String getPropertyAsString(String propertyName) throws WasteHandleCofigurationException {
					String propertyValue = properties.getProperty(propertyName);
					if(propertyValue == null) {
						throw new WasteHandleCofigurationException(String.format("Missing property %s in properties file %s", propertyName, WasteHandleConfiguration.PROPERTIES_FILENANE));
					}
					
					return propertyValue;
		}
	}
}
