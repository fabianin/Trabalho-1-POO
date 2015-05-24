/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.dao.Dao;
import model.dao.ProfessorDaoImpl;
import model.dao.TurmaDaoImpl;
import model.pojo.Disciplina;
import model.pojo.Professor;

/**
 *
 * @author Pedro
 */
public class ProfessorView {
    //private Dao professorDao;
    private static Scanner scanner = new Scanner (System.in);
 
    
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE PROFESSORES\nCadastre um novo professor:\n");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        String cpf = this.validarId();
        if (cpf == null)
            return false;
        System.out.println("Departamento: ");
        String departamento = scanner.nextLine();
        Professor professor = new Professor (nome, cpf, departamento);
        return ProfessorDaoImpl.getInstancia().inserir(professor);
        //return this.professorDao.inserir(professor);
    }
    
    public void pesquisar () {
        System.out.println("PESQUISA DE PROFESSORES\nEntre com o CPF do professor: ");
        String cpf = scanner.nextLine();
        if(ProfessorDaoImpl.getInstancia().indice(cpf) >= 0)
            System.out.println(ProfessorDaoImpl.getInstancia().obter(cpf).toString());
        //if (this.professorDao.indice(cpf) != -1)
        //    System.out.println(this.professorDao.obter(cpf).toString());
        else
            System.out.println("PROFESSOR NÃO ENCONTRADO!\n"); 
    }
    
    public void remover(){
        System.out.println("REMOÇÃO DE PROFESSORES\nEntre com o CPF do Professor: ");
        String cpf = scanner.nextLine();
        if(ProfessorDaoImpl.getInstancia().remover(ProfessorDaoImpl.getInstancia().obter(cpf)))
        //if (professorDao.remover(professorDao.obter(cpf)))
            System.out.println("PROFESSSOR REMOVIDO COM SUCESSO!");                
        else
            System.out.println("PROFESSOR NÃO ENCONTRADO, REMOÇÃO NÃO EFETUADA!\n");
    }
    
    public void listar () {
            System.out.println("LISTA DE PROFESSORES DISPONÍVEIS\n");
            List<Professor> listaProfessor = (List<Professor>) ProfessorDaoImpl.getInstancia().obterTodos();
            //List<Professor> listaProfessor = (List<Professor>) (Professor) professorDao.obterTodos();
            for (Professor professor: listaProfessor)
                System.out.println(professor.toString() + "\n");    
    }
    
    public String validarId () {
        while (true) {
            System.out.println("CPF (''cancelar'' para cancelar): ");
            String id = scanner.nextLine();
            if (id.equals("cancelar"))
                break;
            if (ProfessorDaoImpl.getInstancia().indice(id) <= -1)
                return id;
            else
                System.out.println("\nUM(A) PROFESSOR(A) COM ESTE CPF JÁ ESTÁ CADASTRADO(A)!"
                        + " TENTE NOVAMENTE!\n");
        }
        return null;
    }

    public Boolean quantidadeDisciplina(){
        System.out.println("Informe o CPF do professor: ");
        Professor professor = (Professor) ProfessorDaoImpl.getInstancia().obter(scanner.nextLine());
        if(professor != null){
            System.out.println("A quantidade de disciplinas já lecionadas pelo(a) professsor(a) " + professor.getNome()
                       + " é " + professor.getDisciplina().size() + ".");
            return true;
        }
        System.out.println("\nNÃO EXISTE PROFESSOR(A) CADASTRADO(A) COM ESTE CPF!\n");
        return false;
    }    
}
