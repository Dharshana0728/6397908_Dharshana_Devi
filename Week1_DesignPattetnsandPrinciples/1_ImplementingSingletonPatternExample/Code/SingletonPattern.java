public class SingletonPattern {

    static class Logger {
        private static Logger singleInstance = null;

        private Logger() {
            System.out.println("Logger instance created.");
        }

        public static Logger getInstance() {
            if (singleInstance == null) {
                singleInstance = new Logger();
            }
            return singleInstance;
        }

        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("Hello from logger 1!");

        Logger logger2 = Logger.getInstance();
        logger2.log("Hello again from logger 2!");

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("Different Logger instances exist.");
        }
    }
}