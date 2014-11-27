package gt.gob.segeplan.sisag.core.web.utils;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 *
 * @author layala
 */
public class SesionFiltroBean implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet.");
        //log.info("ingresa a init()");
        //String complemento=filterConfig.getInitParameter("pComplemento");
        //log.info("pComplemento: "+complemento);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest r = (HttpServletRequest) request;

        HttpSession session = ((HttpServletRequest) request).getSession();
  
        String strSesion = null;

        strSesion = session.getAttribute("sesion") == null ? "no" : "si";
        request.setCharacterEncoding("UTF-8");
        if (strSesion.equals("no")) {
            if (r.getRequestURL().toString().contains("/sinaf/faces/resetPwd.xhtml")) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("../faces/resetPwd.xhtml");
                dispatcher.forward(request, response);
            } 
            
            else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("../faces/login.xhtml");
                dispatcher.forward(request, response);
            }
        } else {
            ArrayList<String> lstMenu = (ArrayList<String>) session.getAttribute("LstMenu");
            
                int ban = 0;
                String url = r.getRequestURL().toString();
                for (int i = 0; i < lstMenu.size(); i++) {
                    System.out.println("lstMenu.get(i)" + lstMenu.get(i));
                    if (url.contains(lstMenu.get(i))) {
                        ban = 1;
                        break;
                    }
                }
                if (ban > 0) {
                    chain.doFilter(request, response);
                } else {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/faces/noPrivilegio.xhtml");
                        dispatcher.forward(request, response);
                    }
        }

        
    }

    @Override
    public void destroy() {
    }
}