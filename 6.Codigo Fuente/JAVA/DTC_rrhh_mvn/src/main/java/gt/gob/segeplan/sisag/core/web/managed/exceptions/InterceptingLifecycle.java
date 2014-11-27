package gt.gob.segeplan.sisag.core.web.managed.exceptions;

import java.io.Serializable;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.Lifecycle;




  public class InterceptingLifecycle extends Lifecycle implements Serializable{

    private Lifecycle wrapped;

    public InterceptingLifecycle(Lifecycle standardLifecycle) {
      wrapped = standardLifecycle;
    }

    Lifecycle getWrapped() {
      return wrapped;
    }

    @Override
        public void addPhaseListener(PhaseListener listener) {
      System.out.println("addPhaseListener(" + listener + ")");
      getWrapped().addPhaseListener(listener);
    }


    @Override
        public void execute(FacesContext context) throws FacesException {
      try {
        System.out.println("execute(...)");
        getWrapped().execute(context);
      } catch (FacesException intercepted) {
        System.out.println("===>>> Intercepted Throwable from execute()");
        FacesContext.getCurrentInstance().renderResponse();
        throw intercepted;
      }
    }

    @Override
    public PhaseListener[] getPhaseListeners() {
      return getWrapped().getPhaseListeners();
    }

    @Override
    public void removePhaseListener(PhaseListener listener) {
      getWrapped().removePhaseListener(listener);
    }

   
    @Override
    public void render(FacesContext context) throws FacesException {
      try {
        System.out.println("render(...)");
        getWrapped().render(context);
      } catch (FacesException intercepted) {
        System.out.println("===>>> Intercepted Throwable from render()");
        throw intercepted;
      }
    }

  }