package oculus;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/** place extensions to settings here */
public enum OptionalSettings {
	
	emailalerts, emailaddress, emailpassword, developer, reboot, loginnotify, holdservo, sonar;

	/** get basic settings */
	public static Properties createDeaults(){
		Properties config = FactorySettings.createDeaults();
		config.setProperty(developer.toString(), "false");
		config.setProperty(reboot.toString(), "false");
		config.setProperty(loginnotify.toString(), "false");
		config.setProperty(holdservo.toString(), "false");
		return config;
	}

	/** */
	public static Properties createBasicDeveloper(){
		Properties config = FactorySettings.createDeaults();
		config.setProperty(developer.toString(), "true");
		config.setProperty(reboot.toString(), "true");
		config.setProperty(loginnotify.toString(), "true");
		config.setProperty(holdservo.toString(), "true");
		return config;
	}
	
	/** get an gmail */
	public static Properties createDeveloper(String email, String pass){
		Properties config = FactorySettings.createDeaults();
		config.setProperty(emailaddress.toString(), email);
		config.setProperty(emailpassword.toString(), pass);
		config.setProperty(emailalerts.toString(), "true");
		config.setProperty(developer.toString(), "true");
		config.setProperty(reboot.toString(), "true");
		config.setProperty(loginnotify.toString(), "true");
		config.setProperty(holdservo.toString(), "true");
		return config;
	}
	
	/** add in settings */
	public static Properties appendDeveloper(Properties config, String email, String pass){
		config.setProperty(emailaddress.toString(), email);
		config.setProperty(emailpassword.toString(), pass);
		config.setProperty(emailalerts.toString(), "true");
		config.setProperty(developer.toString(), "true");
		config.setProperty(reboot.toString(), "true");
		config.setProperty(loginnotify.toString(), "true");
		config.setProperty(holdservo.toString(), "true");
		return config;
	}
	


	
	/** write to file in the order set in enum */
	public static void CreateFile(FileWriter file, Properties props){
		
		// write optional 
		
		
		
		// write factory 
		for (FactorySettings settings : FactorySettings.values()) {
			try {
				file.append(settings.toString() + " " 
					+ props.getProperty(settings.toString()) + "\r\n");
				
			} catch (IOException e) {
				try {
					file.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	@Override
	public String toString() {
		return super.toString();
	}
}