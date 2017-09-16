package crawler;

/**
 * Interface represents message importance
 */
public interface LoggerInterface {

	/**
	 * If throws "error", method gets message give as argument
	 * 
	 * @param message
	 *            message to deliver
	 */
	void error(String message);

	/**
	 * If throws "warning". method gets message give as argument
	 * 
	 * @param message
	 *            message to deliver
	 */
	void warning(String message);

	/**
	 * If throws "info". method gets message give as argument
	 * 
	 * @param message
	 *            message to deliver
	 */
	void info(String message);

	/**
	 * Method check what level of importance error occured and deliver message
	 * 
	 * @param level
	 *            level importance
	 * @param message
	 *            message to deliver
	 */
	void log(String level, String message);

	/**
	 * Method filters errors which we want to show
	 * 
	 * @param levelLog
	 *            errors which we dont want to show
	 */
	void filtr(String... levelLog);
}
