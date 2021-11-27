package main.java.com.company.resume.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import main.java.com.company.resume.controllerutil.ErrorUtil;

@WebFilter(filterName = "LoggedInFilter", urlPatterns =
{
    "*"
})
public class LoggedInFilter implements Filter
{

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException
    {
        HttpServletResponse response = (HttpServletResponse) sr1;
        HttpServletRequest request = (HttpServletRequest) sr;

        try
        {
            if (!request.getRequestURI().contains("/login") && 
                    !request.getRequestURI().contains("/error") && 
                    !request.getRequestURI().contains("/index") && 
                    request.getSession().getAttribute("loggedinadmin") == null)
                ErrorUtil.sendError(response, new IllegalArgumentException("Not found!"));
            else
                fc.doFilter(sr, sr1);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
