package are.you.ok.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.web.filter.authc.UserFilter;

public class LoginUserFilter extends UserFilter {
	
	

	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
	
		return false;

	}


	
	
	
}
