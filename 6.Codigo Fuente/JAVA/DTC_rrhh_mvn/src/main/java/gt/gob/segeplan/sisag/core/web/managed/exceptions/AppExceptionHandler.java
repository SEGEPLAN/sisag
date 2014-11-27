/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.web.managed.exceptions;

import java.io.IOException;

import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

@WebServlet("/AppExceptionHandler")

public class AppExceptionHandler extends HttpServlet implements Serializable{


    @Override
    protected void doGet(HttpServletRequest request,

            HttpServletResponse response) throws ServletException, IOException {

        processError(request, response);

    }

 

    @Override
    protected void doPost(HttpServletRequest request,

            HttpServletResponse response) throws ServletException, IOException {

        processError(request, response);

    }

    private void processError(HttpServletRequest request,

            HttpServletResponse response) throws IOException {

        // Analyze the servlet exception

        Throwable throwable = (Throwable) request

                .getAttribute("javax.servlet.error.exception");

        Integer statusCode = (Integer) request

                .getAttribute("javax.servlet.error.status_code");

        String servletName = (String) request

                .getAttribute("javax.servlet.error.servlet_name");

        if (servletName == null) {

            servletName = "Unknown";

        }

        String requestUri = (String) request

                .getAttribute("javax.servlet.error.request_uri");

        if (requestUri == null) {

            requestUri = "Unknown";

        }


        // Set response content type

          response.setContentType("text/html");


          PrintWriter out = response.getWriter();

          out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
"      xmlns:h=\"http://java.sun.com/jsf/html\"\n" +
"      xmlns:f=\"http://java.sun.com/jsf/core\"\n" +
"      xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n" +
"      xmlns:p=\"http://primefaces.org/ui\"\n" +
"      ><head><title>Exception/Error Details</title></head><body>");

          if(statusCode != 500){

              out.write("<h3>Error Details</h3>");

              out.write("<strong>Status Code</strong>:"+statusCode+"<br>");

              out.write("<strong>Requested URI</strong>:"+requestUri);

          }else{

              out.write("<h3>Exception Details</h3>");

              out.write("<ul><li>Servlet Name:"+servletName+"</li>");

              out.write("<li>Exception Name:"+throwable.getClass().getName()+"</li>");

              out.write("<li>Requested URI:"+requestUri+"</li>");

              out.write("<li>Exception Message:"+throwable.getMessage()+"</li>");

              out.write("</ul>");

          }

 

          out.write("<br><br>");
 out.write("<h:form> ");
  out.write("<p:commandButton id=\"btn_desac\" value=\"Procesar\" action=\"#{usuarios.relogin}\"  ajax=\"false\"/> ");
          
 out.write("</h:form>");
          out.write("</body></html>");

    }

}