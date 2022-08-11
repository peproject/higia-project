package start.project.higia.middleware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserLogged  implements HandlerInterceptor  {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("user") != null) {
			request.getRequestDispatcher("/use").forward(request, response);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	       HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(
	  HttpServletRequest request,
	  HttpServletResponse response,
	  Object handler, Exception ex) throws Exception {
	   HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
