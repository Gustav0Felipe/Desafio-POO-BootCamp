package desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHoraria;
    
    public Curso(){

    }
    public Curso(String titulo){
        this.titulo = titulo;
    }
    public Curso(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
    }   
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        
        return getTitulo() + ":" + '\'' + getDescricao() + '\'' +
        " duração: " + cargaHoraria + " horas";
    }
    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }
}
