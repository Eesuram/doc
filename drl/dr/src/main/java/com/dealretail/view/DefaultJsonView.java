/**
 * 
 */
package com.dealretail.view;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.RequestContext;

/**
 * @author
 *
 */
@Component
public class DefaultJsonView  implements View {
	
	
	private static final String BINDING_RESULT_KEY = "org.springframework.validation.BindingResult";
	public static final String WEB_APPLICATION_CONTEXT_ATTRIBUTE = RequestContext.class.getName() + ".CONTEXT";

	public void render(Map map, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		
		List<String> bindingResults = new ArrayList<String>();
		Iterator i = map.keySet().iterator();
		while (i.hasNext()) {
			String keyName = (String) i.next();
            if (StringUtils.isNotBlank(keyName) && keyName.indexOf(BINDING_RESULT_KEY) != -1) {
                bindingResults.add(keyName);
            }
		}
		
		for (String key : bindingResults) {
			map.remove(key);
		}

		JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setIgnoreTransientFields(true);
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONObject jsonObject = JSONObject.fromObject(map, jsonConfig);		
        httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter writer = httpServletResponse.getWriter();
		writer.write(jsonObject.toString());
	}

	public String getContentType() {
		return null;
	}
}

