package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managedBean.identityBean;

@WebFilter("/pages/Admin/*")
public class AdminZoneSecurity implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		identityBean identity = (identityBean) req.getSession().getAttribute("identityB");
		Boolean letGo = false;
		if (identity!=null &&
				identity.getIdentifieduser()!=null &&
					identity.hasRole("admin")
		) {
			letGo = true;
		}
		if(letGo){
			chain.doFilter(request, response);
		}else{
			resp.sendRedirect(req.getContextPath() + "/pages/login.jsf");
		}
	}

	@Override
	public void destroy() {
	}

}