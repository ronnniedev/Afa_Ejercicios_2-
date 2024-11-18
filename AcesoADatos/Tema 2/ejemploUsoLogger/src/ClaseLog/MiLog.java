package ClaseLog;

import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;


public class MiLog {
	
	private static FileHandler fileTxt;
	private SimpleFormatter formatterTxt;
	static final Logger logger = Logger.getLogger("MiLog");
	
	private static MiLog miLog;
	
	public MiLog() {
		try {
			formatterTxt = new SimpleFormatter();
			fileTxt = new FileHandler("Log.txt");			
			fileTxt.setFormatter(formatterTxt);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
    public static void guardarMensaje(Level nivel, String sms) {
    	if(miLog==null) {
    		miLog=new MiLog();
    	}
    	
    	logger.log(nivel, sms);
    	try {
    		logger.setUseParentHandlers(false);// ocultar la salida por pantalla
			logger.addHandler(fileTxt);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
}
