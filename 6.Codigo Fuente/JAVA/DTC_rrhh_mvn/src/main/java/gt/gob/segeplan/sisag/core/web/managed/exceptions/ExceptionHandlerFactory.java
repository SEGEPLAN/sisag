/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.web.managed.exceptions;

import java.io.Serializable;
import javax.faces.context.ExceptionHandler;

public class ExceptionHandlerFactory extends javax.faces.context.ExceptionHandlerFactory implements Serializable{

    private javax.faces.context.ExceptionHandlerFactory parent;

    public ExceptionHandlerFactory(javax.faces.context.ExceptionHandlerFactory parent) {
        this.parent = parent;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        ExceptionHandler result = parent.getExceptionHandler();
        result = new CustomExceptionHandler(result);
        return result;
    }

}