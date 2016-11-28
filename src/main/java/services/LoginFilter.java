package services;

import domain.Entities.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("*.xhtml")
public class LoginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/faces/login.xhtml");
        Usuario usuario  = null;
        HttpSession sess = (HttpSession) req.getSession(false);
        
        if(sess != null){
            usuario = (Usuario) sess.getAttribute("usuario");
        }
        
        if(usuario == null){
                    dispatcher.forward(request, response);

        }else{
           chain.doFilter(request, response);
        }
        
    }

    @Override
    public void destroy() {

    }
}