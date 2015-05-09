package model.dao;

import java.util.List;
import model.pojo.Disciplina;
import model.pojo.Professor;
        
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */

public interface ProfessorDao {
    Boolean salvar (Professor professor);
    Boolean remover (Professor professor);
    int indiceProfessor (String cpf);
    Professor obterProfessor (String cpf);
    List<Professor> obterTodos ();
    Boolean adicionarDisciplina (Professor professor, Disciplina disciplina);
    Boolean removerDisciplina (Professor professor, Disciplina disciplina); 
}
