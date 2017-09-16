package crawler;

import java.net.*;

/**
 * 
 * @author Michal
 *
 *         Queue contains pages which we want visit.
 */
public interface DownloadQueue {
	/**
	 * Method adds page to visit at the end of queue.
	 *
	 * @param pageURL
	 *            page to visit
	 */
	public void addPage(URL pageURL);

	/**
	 * Method returns information about queue is empty or not
	 * 
	 * @return true - kolejka pusta, false - w przeciwnym razie
	 */
	boolean isEmpty();

	/**
	 * Method returns first page in queue which we want to visit and delete it
	 * from queue.
	 * 
	 * @return page to visit
	 */
	URL getNextPage();
}