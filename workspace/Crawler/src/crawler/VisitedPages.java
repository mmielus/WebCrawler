package crawler;

import java.net.*;

/**
 * 
 * @author Michal
 *
 * Interface represents operations on visited pages.
 */
public interface VisitedPages {
	/**
	 * Method checks that the page ( argument ) was visited.
	 * 
	 * @param pageURL
	 *            page to check
	 * @return true - page was visited, false - page was not visited
	 */
	boolean pageAlreadyVisited(URL pageURL);

	/**
	 * Methods adds the page ( argument ) as visited.
	 *
	 * @param pageURL
	 *            page to add as visited
	 */
	void addVisitedPage(URL pageURL);
}