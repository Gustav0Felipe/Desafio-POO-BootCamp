package desafio.dominio;

import java.time.LocalDate;
public class Mentoria extends Conteudo{ 

    private LocalDate data;
    public Mentoria(){

    }
    public Mentoria(String titulo){
        this.titulo = titulo;
    }
    public Mentoria(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
    }   
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    } 
    @Override
    public double calcularXp() {
      return XP_PADRAO + 20d;
    }
    public String toString() {
        
        return getTitulo() + ":" + '\''+ getDescricao()
        + '\'' + " "+ getData();
    }
}
