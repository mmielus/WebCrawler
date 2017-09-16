package crawler;

/**
 * 
 * @author Michal
 *
 *         Class represents exceptions throws in main application.
 */
@SuppressWarnings("serial")
public class DownloaderException extends Exception {

	public DownloaderException() {
		super();
	}

	public DownloaderException(String message) {
		super(message);
	}

}
