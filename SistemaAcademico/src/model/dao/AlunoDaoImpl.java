/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Aluno;
import model.pojo.Nota;
import model.pojo.Turma;


/**
 *
 * @author Filipe
 */
public class AlunoDaoImpl implements AlunoDao {
    
    private List<Aluno> listaAluno;
    
    @Override
    public Boolean salvar (Aluno aluno) {
        if (!this.contemAluno(aluno.getCpf()))
           return this.listaAluno.add(aluno);
        return false;
    }
    
    @Override
    public Boolean remover(Aluno aluno){
        if(this.contemAluno(aluno.getCpf())) 
            return this.listaAluno.remove(aluno);
        return false;
    }
    
    @Override
    public Boolean contemAluno (String cpf) {
        //ORDENAR LISTA DE TURMAS PELO ID E APLICAR BUSCA BINÁRIA BASEADA NESTE.
        return false;
    }
    
     @Override
    public Turma obterAluno (String cpf) {
        if (this.contemAluno(cpf))
            return this.listaAluno.get(this.listaAluno.indexOf(/*?????*/));
        return null;
    }
    
    @Override
    public List<Aluno> obterTodos () {
        return listaAluno;
    }
    
    /*Pois o professor pode lançar duas notas de valores diferentes para um
    aluno para a mesma atividade*/
    @Override
    public Boolean adicaoValida(Aluno aluno, Nota nota) {
        return (!aluno.getNota().contains(nota));
    }
    
    @Override
    public void adicionaNota(Aluno aluno, Nota nota){
        aluno.getNota().add(nota);
    }
    
    @Override
    public Nota retornaNota (Aluno aluno, Nota nota) {
       if(aluno.getNota().contains(nota))
            return aluno.getNota().get(aluno.getNota().indexOf(nota)); // elemento nota na lista de nota 
       else
            return null; 
    }

    @Override
    public Double NotaFinal(Aluno aluno, Turma turma){
        Double somaNotas = 0.0;
        for(Nota notaConsultada: aluno.getNota())
            if(notaConsultada.getAtividade().getTurma().equals(turma))
                somaNotas += notaConsultada.getNota();
    return somaNotas;
    }
    
    
    
}