package desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Set;



public class Opcoes {

    static Set<Bootcamp> boots = new LinkedHashSet<Bootcamp>();

    public void addBoot(Bootcamp boot) {
        boots.add(boot);
    }
    private static class optionHolder{
        public static Opcoes opt = new Opcoes();
    }
    private Opcoes(){
        super();
    }
    public static Opcoes getInstancia(){
        return optionHolder.opt;
    }

} 