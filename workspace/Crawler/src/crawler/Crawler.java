package crawler;

import java.net.*;
import java.util.regex.Pattern;

//import logger.Logger;

import java.io.*;
import java.util.regex.*;

/**
 * The application find and write to txt document all pages found in HTML source
 * code. Initially, user has to give website address as argument.The application
 * starts working on this page.
 * 
 * @author Michal
 *
 */
public class Crawler extends MyQueue {

	public static void main(String[] args) throws Exception {

		MyQueue listWithPages = new MyQueue();
		Logger myTestLog = new Logger(new FileOutputStream("logs.txt"), "information");
		openWeb(args[0], listWithPages, myTestLog);

		getAnotherPage(listWithPages, myTestLog);

	}

	public static void findAllWeb(String regex, String line, MyQueue listWithPages, Logger myTestLog) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		Pattern httppattern = Pattern.compile("^http.*");
		Matcher httpmatcher;
		if (matcher.find()) {
			httpmatcher = httppattern.matcher(matcher.group(1));
			while (httpmatcher.find()) {
				try {
					URL u = new URL(httpmatcher.group(0));
					listWithPages.addPage(u);
					myTestLog.log("information", u.toString());
				} catch (Exception e) {
					System.out.println("Error page");
				}
			}
		}

	}

	public static void openWeb(String url, MyQueue listWithPages, Logger myTestLog) {
		try {
			URL u = new URL(url);

			InputStream is = u.openStream();
			getStringFromInputStream(is, listWithPages, myTestLog);

		} catch (Exception e) {
			System.out.println("error");
		}
	}

	public static void getAnotherPage(MyQueue listWithPages, Logger myTestLog) {
		while (listWithPages.isEmpty() == false) {
			URL page = listWithPages.getNextPage();

			if (listWithPages.pageAlreadyVisited(page) == false) {
				listWithPages.addVisitedPage(page);

				openWeb(page.toString(), listWithPages, myTestLog);

			}

		}
	}

	public static String getStringFromInputStream(InputStream is, MyQueue listWithPages, Logger myTestLog) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				findAllWeb("<[aA] [^>]*[hH][rR][eE][fF]=\"([^\"]+)\"", line, listWithPages, myTestLog);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}
}
