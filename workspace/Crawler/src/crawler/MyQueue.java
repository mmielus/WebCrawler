package crawler;

import java.io.BufferedReader;
import java.util.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class MyQueue implements DownloadQueue, WWWPageDownloader, VisitedPages {

	Queue<URL> listWithPages = new ArrayDeque<URL>();
	ArrayList<URL> listWithVisitedPages = new ArrayList<URL>();

	public boolean isEmpty() {
		if (listWithPages.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addPage(URL pageURL) {
		listWithPages.add(pageURL);
	}

	public URL getNextPage() {
		URL result = listWithPages.poll();
		return result;
	}

	public String downloadPage(String pageURL) throws DownloaderException {
		BufferedReader br = null;
		String result = "";
		String line;
		try {
			URL u = new URL(pageURL);
			try {
				InputStream is = u.openStream();
				br = new BufferedReader(new InputStreamReader(is));
				while ((line = br.readLine()) != null)
					result = result + "\n" + line;
			} catch (Exception e) {
				throw new DownloaderException("Error cannot connect with page");
			}

		} catch (Exception e) {
			throw new DownloaderException("Page does not exist");
		}
		return result;
	}

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
