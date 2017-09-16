package crawler;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author Michal
 * 
 *         Class represents visited pages.
 */
public class VisitedArrayList implements VisitedPages {
	ArrayList<URL> listWithVisitedPages = new ArrayList<URL>();

	public boolean pageAlreadyVisited(URL pageURL) {
		Iterator<URL> it = listWithVisitedPages.iterator();
		while (it.hasNext()) {
			if (it.next() == pageURL) {
				return true;
			} else
				return false;
		}
		return false;
	}

	public void addVisitedPage(URL pageURL) {
		listWithVisitedPages.add(pageURL);
	}

}
