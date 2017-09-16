package crawler;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Logger implements LoggerInterface {

	private String levelLog;
	private PrintWriter output;
	boolean checker = false;
	String[] levelLogTab = new String[3];

	public Logger(OutputStream output, String levelLog) {
		try {
			this.output = new PrintWriter(new OutputStreamWriter(output, "UTF-8"));
			this.levelLog = levelLog;
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

	public String createDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	@Override
	public void filtr(String... levelLog) {
		for (int i = 0; i < levelLog.length; i++) {
			levelLogTab[i] = levelLog[i];
		}
	}

	/**
	 * Metoda pomocnicza sprawdzajaca czy w programie podano jakis blad do
	 * filtrowania
	 * 
	 * @param levelLog
	 *            podany blad
	 */
	public void check(String levelLog) {
		for (int i = 0; i < levelLogTab.length; i++) {
			if (levelLogTab[i] == levelLog) {
				output.println(levelLogTab[i] + "filtered");
				checker = true;
			}

		}

	}

	@Override
	public void error(String message) {
		output.println("ERROR " + message + createDate());
	}

	@Override
	public void warning(String message) {
		output.println("WARNING " + message + createDate());
	}

	@Override
	public void info(String message) {
		output.println("INFORMATION " + message + createDate());
	}

	@Override
	public void log(String level, String message) {
		if (level == "error") {
			check(level);
			if (checker == false)
				error(message);
			checker = false;
		} else if (level == "warning") {
			check(level);
			if (checker == false)
				warning(message);
			checker = false;
		} else if (level == "information") {
			check(level);
			if (checker == false)
				info(message);
			checker = false;
		}
		output.flush();
	}

}