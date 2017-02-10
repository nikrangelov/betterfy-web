package betterfy.library;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

// http://stackoverflow.com/questions/2811769/adding-an-http-header-to-the-request-in-a-servlet-filter
// http://sandeepmore.com/blog/2010/06/12/modifying-http-headers-using-java/
// http://bijubnair.blogspot.de/2008/12/adding-header-information-to-existing.html
/**
 * allow adding additional header entries to a request
 * 
 * @author wf
 * 
 */
public class HeaderMapRequestWrapper extends HttpServletRequestWrapper {
	/**
	 * construct a wrapper for this request
	 * 
	 * @param request
	 */
	public HeaderMapRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	private Map<String, String> headerMap = new HashMap<String, String>();

	/**
	 * add a header with given name and value
	 * 
	 * @param name
	 * @param value
	 */
	public void addHeader(String name, String value) {
		headerMap.put(name, value);
	}

	@Override
	public String getHeader(String name) {
		String headerValue = super.getHeader(name);
		if (headerMap.containsKey(name)) {
			headerValue = headerMap.get(name);
		}
		return headerValue;
	}

	/**
	 * get the Header names
	 */
	@Override
	public Enumeration<String> getHeaderNames() {
		List<String> names = Collections.list(super.getHeaderNames());
		for (String name : headerMap.keySet()) {
			names.add(name);
		}
		return Collections.enumeration(names);
	}

	@Override
	public Enumeration<String> getHeaders(String name) {
		List<String> values = Collections.list(super.getHeaders(name));
		if (headerMap.containsKey(name)) {
			values.add(headerMap.get(name));
		}
		return Collections.enumeration(values);
	}

}