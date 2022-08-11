package start.project.higia.middleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class UserConfigLogged implements WebMvcConfigurer {

	@Autowired
	private UserLogged interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
				.addPathPatterns(new String[] { "/", "/doctor/**", "/doctor", "/user", "/user/**" });

	}
}