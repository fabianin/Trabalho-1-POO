package view;

import java.util.List;
import java.util.Scanner;
import model.dao.AtividadeDaoImpl;
import model.dao.Dao;
import model.dao.TurmaDaoImpl;
import model.pojo.Atividade;
import model.pojo.Turma;

public class AtividadeView {
    
    private static Scanner scanner = new Scanner (System.in);

    public Boolean cadastrar () {
        System.out.println("CADASTRO DE ATIVIDADES");
        System.out.println("Turma:");
        Turma turma = (Turma) this.obterCadastrado(TurmaDaoImpl.getInstancia());
        if(turma == null)
            return false;
        System.out.println("\nCadastre uma nova atividade:\n");
        String id = this.validarId();
        if (id == null)
            return false;
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.println("Data(DD/MM/AAAA): ");
        String data = scanner.nextLine();
        System.out.println("Valor: ");
        Double valor = scanner.nextDouble();
        scanner.nextLine();
        Atividade atividade = new Atividade (id, nome, tipo, data, valor, turma);
        turma.getAtividade().add(atividade);
        return AtividadeDaoImpl.getInstancia().inserir(atividade);
    }
    
    public String validarId () {
        while (true) {
            System.out.println("ID (''cancelar'' para cancelar): ");
            String id = scanner.nextLine();
            if (id.equals("cancelar"))
                break;
            if (AtividadeDaoImpl.getInstancia().indice(id) <= -1)
                return id;
            else
                System.out.println("\nUMA ATIVIDADE COM ESTE ID JÁ ESTÁ CADASTRADA! TENTE NOVAMENTE!\n");
        }
        return null;
    }
    
    public Object obterCadastrado (Dao dao) {
        while (true) {
            System.out.println("ID (''cancelar'' para cancelar): ");
            String entrada = scanner.nextLine();
            if (entrada.equals("cancelar"))
                break;
            Object objeto = dao.obter(entrada);
            if (objeto != null)
                return objeto;
            else
                System.out.println("ITEM NÃO CADASTRADO! TENTE NOVAMENTE.\n");
        }
        return null;
    }
}
