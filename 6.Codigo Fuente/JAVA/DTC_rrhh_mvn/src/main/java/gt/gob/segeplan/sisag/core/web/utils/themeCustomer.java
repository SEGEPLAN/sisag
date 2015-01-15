package gt.gob.segeplan.sisag.core.web.utils;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;


public class themeCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    private String tema = "ui-lightness";
    private Map<String, String> themes;

    public Map<String, String> getThemes() {
        themes = new TreeMap<String, String>();
        themes.put("black-tie", "black-tie");
        themes.put("blitzer", "blitzer");
        themes.put("bluesky", "bluesky");
        themes.put("casablanca", "casablanca");
        themes.put("cupertino", "cupertino");
       
        themes.put("excite-bike", "excite-bike");
        themes.put("flick", "flick");
        themes.put("glass-x", "glass-x");
        themes.put("hot-sneaks", "hot-sneaks");
        themes.put("humanity", "humanity");
        themes.put("none", "none");
        themes.put("redmond", "redmond");
        themes.put("rocket", "rocket");
        themes.put("pepper-grinder", "pepper-grinder");
        
        themes.put("ui-lightness", "ui-lightness");
        
        return themes;
    }

    public void setThemes(Map<String, String> themes) {
        this.themes = themes;
    }

    public themeCustomer() {
    }

    public void initTheme(String t){
        if(!t.contentEquals("start")){
            tema = "";
            tema = t;
        }
    }
    
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void cambiar() {
//         if(!temaAux.contentEquals("start")){
//            tema = "";
//            tema = temaAux;
//        }
        System.out.println("Tema seleccionado es: "+tema);
      
    }
    
}
