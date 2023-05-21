package desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Set;



public class Opcoes {

    static Set<Bootcamp> boots = new LinkedHashSet<Bootcamp>();

    public void addBoot(Bootcamp boot) {
        boots.add(boot);
    } 
} 