package crawler;

/**
 * Interface is use to download data from website.
 */
public interface WWWPageDownloader {
	/**
	 * Function gets data from page give as argument and returns it as string.
	 * 
	 * @param pageURL
	 *            page to download
	 * @return string include page data (in html)
	 * @throws DownloaderException
	 *             if data from page cannot be download  
	 *             (page to download does not exist, error I/O during download data)
	 *
	 */
	String downloadPage(String pageURL) throws DownloaderException;
}