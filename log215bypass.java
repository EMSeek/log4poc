import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.config.Configurator;

public class log215bypass {
    private static final Logger logger = LogManager.getLogger(log4poc.class);

    public static void main(String[] args) {
        //The default trusturlcodebase of the higher version JDK is false
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        //LogManager.getRootLogger().setLevel(Level.TRACE);
        Configurator.setAllLevels(LogManager.getRootLogger().getName(), Level.ALL);

if (args[0].toLowerCase().equals("trace")) {
            logger.trace(args[1]);
        } else if (args[0].toLowerCase().equals("debug")) {
            logger.debug(args[1]);
        } else if(args[0].toLowerCase().equals("info")) {
            logger.info(args[1]);
        } else if (args[0].toLowerCase().equals("warn")) {
            logger.warn(args[1]);
        } else if (args[0].toLowerCase().equals("error")) {
            logger.error(args[1]);
        } else if (args[0].toLowerCase().equals("fatal")) {
            logger.fatal(args[1]);
        } else if(args[0].equals("printf")) { 
            //This should bypass -Dlog4j2.formatMsgNoLookup
            logger.printf(Level.ERROR, "%1$s", args[1]);
}
    }
}
