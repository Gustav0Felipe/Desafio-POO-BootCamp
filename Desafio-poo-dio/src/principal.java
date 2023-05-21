import java.time.LocalDate;
import desafio.dominio.Bootcamp;
import desafio.dominio.Curso;
import desafio.dominio.Dev;
import desafio.dominio.Mentoria;
import desafio.dominio.Opcoes;
public class principal {
    public static void main(String[] args) {

    Curso cursoJava = new Curso("java Basico", "descrição java basico");
    cursoJava.setCargaHoraria(8);

    Curso cursoJava2 = new Curso("Java Developer", "descrição Java Developer");
    cursoJava2.setCargaHoraria(4); 

    Mentoria mentoriaJava = new Mentoria("Mentoria de java", "descrição mentoria de java" );
    mentoriaJava.setData(LocalDate.now()); 

    Curso cursoPython = new Curso("Python Basico", "descrição Python Basico");
    cursoPython.setCargaHoraria(8);

    Curso cursoPython2 = new Curso("Python Developer", "descrição Python Developer");
    cursoPython2.setCargaHoraria(4); 

    Mentoria mentoriaPython = new Mentoria("Mentoria de Python", "descrição mentoria de Python");
    mentoriaPython.setData(LocalDate.now()); 

    Bootcamp bootPython = new Bootcamp("Python", "Descrição bootcamp Python");
    bootPython.getConteudos().add(cursoPython);
    bootPython.getConteudos().add(cursoPython2);
    bootPython.getConteudos().add(mentoriaPython);

    Bootcamp bootJava = new Bootcamp("Java", "Descrição bootcamp java");
    bootJava.getConteudos().add(cursoJava);
    bootJava.getConteudos().add(cursoJava2);
    bootJava.getConteudos().add(mentoriaJava);

    Opcoes opcao = new Opcoes();
    opcao.addBoot(bootJava);
    opcao.addBoot(bootPython);

    Dev devGustavo = new Dev("Gustavo");
    devGustavo.inscrever();
    devGustavo.chamarMenu();
    }
}