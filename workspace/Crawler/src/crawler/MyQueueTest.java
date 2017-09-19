package crawler;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class MyQueueTest{

	MyQueue tester = new MyQueue();
    URL url;
	
   
	
	@Test
	public void testIsEmpty() {
		try{
			url = new URL("http://www.onet.pl");
		}catch(Exception e){
			
		}
		assertTrue(tester.isEmpty());
		tester.addPage(url);
		assertFalse(tester.isEmpty());
	}
	@Test
	public void testGetNextPage() {
		try{
			url = new URL("http://www.onet.pl");
		}catch(Exception e){
			
		}
		assertNull(tester.getNextPage());
		tester.addPage(url);
		assertNotNull(tester.getNextPage());

	}

	@Test
	public void testDownloadPage() throws DownloaderException {
		assertNotNull(tester.downloadPage("http://www.onet.pl"));
	}

	@Test
	public void testPageAlreadyVisited() {
		try{
			url = new URL("http://www.onet.pl");
		}catch(Exception e){
			
		}
		assertFalse(tester.pageAlreadyVisited(url));
		tester.addVisitedPage(url);
		assertTrue(tester.pageAlreadyVisited(url));
	}


}
