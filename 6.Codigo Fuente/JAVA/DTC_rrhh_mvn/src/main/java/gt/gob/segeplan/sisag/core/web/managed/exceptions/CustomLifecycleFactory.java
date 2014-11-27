package gt.gob.segeplan.sisag.core.web.managed.exceptions;

import java.io.Serializable;
import java.util.Iterator;

  import javax.faces.lifecycle.Lifecycle;
  import javax.faces.lifecycle.LifecycleFactory;
  import javax.faces.webapp.FacesServlet;

  /**
   * <code>CustomLifecycleFactory</code> enhances the standard JSF
   * <code>LifecycleFactory</code> with additional Lifecyle implementations that
   * can be activated with the <code>FacesServlet</code> init-param
   * {@value FacesServlet#LIFECYCLE_ID_ATTR}.
   * <p>
   * You can activate s specific Lifecycle implementation by configuring this
   * lifecycle id to be used by FacesServlet:
   * </p>
   * <ul>
   * <li>{@value #INTERCEPTING_LIFECYCLE_ID}</li>
   * </ul>
   *
   */
  public final class CustomLifecycleFactory extends LifecycleFactory implements Serializable{

    /**
     * The id of the intercepting lifecycle.
     */
    public static final String INTERCEPTING_LIFECYCLE_ID = "InterceptingLifecycle";

    /**
     * LifecycleFactory delegate.
     */
    private LifecycleFactory delegate;

    /**
     * Delegate injecting constructor.
     *
     * @param defaultFactory
     *          the injected delegate LifecycleFactory.
     */
    public CustomLifecycleFactory(LifecycleFactory defaultFactory) {
      delegate = defaultFactory;

      // 1. conseguir ciclo de vida predeterminado para ser envuelto por nuestro ciclo de vida
      Lifecycle defaultLifecycle = delegate.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

     // 2. regístrese interceptar la ejecución del ciclo de vida.
      addLifecycle(INTERCEPTING_LIFECYCLE_ID, new InterceptingLifecycle(defaultLifecycle));
    }

    @Override
    public void addLifecycle(String lifecycleId, Lifecycle lifecycle) {
      delegate.addLifecycle(lifecycleId, lifecycle);
    }

    @Override
    public Lifecycle getLifecycle(String lifecycleId) {
      return delegate.getLifecycle(lifecycleId);
    }

    @Override
    public Iterator<String> getLifecycleIds() {
      return delegate.getLifecycleIds();
    }

  }