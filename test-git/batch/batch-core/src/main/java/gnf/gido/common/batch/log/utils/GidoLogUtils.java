package gnf.gido.common.batch.log.utils;

import gnf.gido.common.batch.log.convert.Convert;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.batch.item.ExecutionContext;

/**
 * The Class GccbLogUtils.
 */
public class GidoLogUtils {

	private Map<Long, List<LogData>> logsData;

	private Map<String, Object> map;

	private final Object sync = new Object();

	/** The Constant VALUE_WITHOUT_FORMAT. */
	public static final String VALUE_WITHOUT_FORMAT = "ValueWithoutFormat";

	/**
	 * Instantiates a new gccb log utils.
	 */
	public GidoLogUtils() {
		logsData = new Hashtable<Long, List<LogData>>();
		map = new ConcurrentHashMap<String, Object>();
	}

	/**
	 * Adds the log.
	 * 
	 * @param key the key
	 * @param value the value
	 * @param idThread the id thread
	 */
	public void addLog(final String key, final String value, final Long idThread) {
		getLogsData(idThread).add(new LogData(key, value));
	}

	/**
	 * Adds the log title.
	 * 
	 * @param key the key
	 * @param value the value
	 * @param idThread the id thread
	 */
	public void addLogTitle(final String key, final String value, final Long idThread) {
		getLogsData(idThread).add(new LogData(key, value, true, false));
	}

	/**
	 * Adds the log separator.
	 * 
	 * @param idThread the id thread
	 */
	public void addLogSeparator(final Long idThread) {
		getLogsData(idThread).add(new LogData(null, null, false, true));
	}

	private List<LogData> getLogsData(final Long idThread) {
		if (logsData.containsKey(idThread)) {
			return logsData.get(idThread);
		}
		else {
			final List<LogData> list = new ArrayList<LogData>();
			logsData.put(idThread, list);
			return list;
		}
	}

	/**
	 * Flush log in execution context.
	 * 
	 * @param idThread the id thread
	 * @param executionContext the execution context
	 */
	@SuppressWarnings("unchecked")
	public void flushLogInExecutionContext(final long idThread, final ExecutionContext executionContext) {
		final List<LogData> logs = this.getLogsData(idThread);
		List<LogData> list = null;
		synchronized (sync) {
			if (!map.containsKey(Convert.LOG_PARAM_ARRAY)) {
				list = new ArrayList<LogData>();
			}
			else {
				list = (List<LogData>) map.get(Convert.LOG_PARAM_ARRAY);
			}

			list.addAll(logs);
			map.put(Convert.LOG_PARAM_ARRAY, list);

			logs.clear();
		}

	}

	/**
	 * Flush log in execution context.
	 * 
	 * @param executionContext the execution context
	 */
	@SuppressWarnings("unchecked")
	public void flushLogInExecutionContext(final ExecutionContext executionContext) {

		final Set<Long> listIdThreads = getLogsData().keySet();

		List<LogData> list = null;

		synchronized (sync) {
			if (!map.containsKey(Convert.LOG_PARAM_ARRAY)) {
				list = new ArrayList<LogData>();
			}
			else {
				list = (List<LogData>) map.get(Convert.LOG_PARAM_ARRAY);
			}

			for (final Long idThread : listIdThreads) {
				final List<LogData> logs = this.getLogsData(idThread);

				list.addAll(logs);

				logs.clear();
			}

			map.put(Convert.LOG_PARAM_ARRAY, list);
		}

	}

	/**
	 * Gets the logs data.
	 * 
	 * @return the logs data
	 */
	public Map<Long, List<LogData>> getLogsData() {
		return logsData;
	}

	/**
	 * Sets the logs data.
	 * 
	 * @param logsData the logs data
	 */
	public void setLogsData(final Map<Long, List<LogData>> logsData) {
		this.logsData = logsData;
	}

	/**
	 * Gets the map.
	 * 
	 * @return the map
	 */
	public Map<String, Object> getMap() {
		return map;
	}

	/**
	 * Sets the map.
	 * 
	 * @param map the map
	 */
	public void setMap(final Map<String, Object> map) {
		this.map = map;
	}

}
