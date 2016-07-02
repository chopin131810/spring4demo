package hello.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * This class will gets the original view name returned from the handler's method and replaces it with the layout name
 * (ex: templates/layout/master.html). The original view is placed in the model as a view variable, so it can be used 
 * in the layout file. Should override postHandle method to ensure it is executed before rendering the view.<br/>
 * Should add this interceptor in MvcConfig class
 * @author banhbaochay
 *
 */
public class ThymeleafLayoutInterceptor extends HandlerInterceptorAdapter {
	private static final String DEFAULT_LAYOUT = "layout/master";
	private static final String DEFAULT_VIEW_ATTRIBUTE_NAME = "view";
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView == null || !modelAndView.hasView()) {
			return;
		}
		String originalView = modelAndView.getViewName();
		// Fix a minor bug of master layout with redirect/forward
		if (isRedirectOrForward(originalView)) return;
		
		modelAndView.setViewName(DEFAULT_LAYOUT);
		modelAndView.addObject(DEFAULT_VIEW_ATTRIBUTE_NAME, originalView);
	}
	
	/**
	 * Check redirect/forward
	 * @param viewName
	 * @return
	 */
	private boolean isRedirectOrForward(String viewName) {
		return viewName.startsWith("redirect:") || viewName.startsWith("forward:");
	}
}
