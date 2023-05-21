
package desafio.dominio;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.swing.JOptionPane;


public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private List<Bootcamp> bootList = new LinkedList<Bootcamp>();

    public Dev(String nome){
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcampEscolhido){
        this.conteudosInscritos.addAll(bootcampEscolhido.getConteudos());
        bootcampEscolhido.getDevsInscritos().add(this);
      
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else{
            System.err.println("Você não esta matriculado em nenhum conteudo.");
        }
    }

    
    public void inscrever(){
        for(Bootcamp i : Opcoes.boots){
            bootList.add(i);
        }
        Bootcamp[] bootArray = bootList.toArray(new Bootcamp[0]);
        int escolha = JOptionPane.showOptionDialog(null, "em qual bootcamp quer se inscrever "
        + this.nome + "?", "Inscrição", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, bootArray, 
        null );
        inscreverBootcamp(bootArray[escolha]);

    }
    public void mostrarConteudosInscritos(){
        Iterator<Conteudo> contInscrito = conteudosInscritos.iterator();
        while(contInscrito.hasNext()){
            System.out.println(contInscrito.next() + "\n");
        }
    }
    public void mostrarConteudosConcluidos(){
        Iterator<Conteudo> contConcluido = conteudosConcluidos.iterator();
        while(contConcluido.hasNext()){
            System.out.println(contConcluido.next() + "\n");
        }
    }

    public double calcularTotalXp(){
        return this.conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
    }
 

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }
   
    @Override
    public boolean equals(Object obj) {
       
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
   
        return super.hashCode();
    }
    public void chamarMenu(){
        List<String> nomesConcluidos = new LinkedList<>();
        while(true){
            List<Conteudo> inscritosList = new LinkedList<>();
            for(Conteudo i : this.conteudosInscritos){
                inscritosList.add(i);
                }
            
            Conteudo[] conteudoArray = inscritosList.toArray(new Conteudo[0]);
           
            int opcao;

            if(conteudoArray.length != 0){ 
                String [] menuOpcoes = {"Concluir " + conteudoArray[0].getTitulo(), "Ver Conteudos Concluidos", "CalcularXP", "Sair"};
                
                opcao = JOptionPane.showOptionDialog(null, "MENU", "Selecione uma das opções: ",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuOpcoes, 
                null );        
                    }
            else{
                String[] menuOpcoes2 = {"Finalizado ", "Ver Conteudos Concluidos", "CalcularXP", "Sair"};
                opcao = JOptionPane.showOptionDialog(null, "MENU", "Selecione uma das opções: ",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, menuOpcoes2, 
                null );  
                if(opcao == 0)
                    break;
            }
            if(opcao == 0){
                nomesConcluidos.add(conteudoArray[0].getTitulo());
                progredir();
            }
            if(opcao == 1){
                System.out.println("Conteudos concluidos de Gustavo: \n");
                mostrarConteudosConcluidos();
                JOptionPane.showMessageDialog(null, nomesConcluidos);
            }
            if(opcao == 2){
                System.out.println("XP: " + calcularTotalXp());
                JOptionPane.showMessageDialog(null, "XP: " + calcularTotalXp());
            }
            if(opcao == 3)
            break;
                
        }
    }
}