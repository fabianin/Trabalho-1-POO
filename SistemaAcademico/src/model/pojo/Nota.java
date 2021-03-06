package model.pojo;

import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nota implements Comparable<Nota>, Comparator<Nota>, Serializable {    
    @Id
    private String id;
    private Double nota;
    private Aluno aluno;
    private Atividade atividade;
 
    public Nota() {
    }
    
    public Nota (String id, Double nota, Aluno aluno, Atividade atividade){
        this.id = id;
        this.nota = nota;
        this.aluno = aluno;
        this.atividade = atividade;
    }
    
    public String getId (){
        return id;
    }
    
    public Double getNota(){
        return nota;
    }
    
    public void setNota(Double nota){
        this.nota = nota;
    }
    
    public Aluno getAluno(){
        return aluno;
    }
    
    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }
    
    public Atividade getAtividade(){
        return atividade;
    }
    
    public void setAtividade(Atividade atividade){
        this.atividade = atividade;
    }
    
    @Override
    public int compareTo (Nota nota){
        return this.id.compareTo(nota.id);
    }
    
    @Override
    public int compare (Nota nota1, Nota nota2) {
        return nota1.aluno.compareTo(nota2.aluno);
    }
    
    @Override
    public String toString () {
        return ("ID: " + this.id + "\nNotas: " + this.nota + "\nAluno: " 
                + this.aluno.getNome() + "\nAtividade: " + atividade.getNome() 
                + "("+atividade.getTipo()+")" + "\n");
    }    
}
