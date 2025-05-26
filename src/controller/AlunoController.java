package controller;

import model.Aluno;
import model.AlunoDAO;
import model.RemocaoAlunoDAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class AlunoController {
    private List<Aluno> listaAlunos = new ArrayList<>();
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private final String csvFile = "ListagemAlunos.txt";

        public Aluno criarAluno(String matricula, String nome, int idade, String dataNascimento, String telefone, String cpf) throws ParseException {
        Aluno a = new Aluno();
        a.setMatricula(matricula);
        a.setNome(nome);
        a.setIdade(idade);
        a.setDataNasc(sdf.parse(dataNascimento));
        a.setTelefone(telefone);
        a.setCpf(cpf);
        return a;
    }
    public void salvarAluno(Aluno a) throws Exception {
        for (Aluno al : listaAlunos) {
            if (al.getMatricula().equals(a.getMatricula())) {
                throw new Exception("Matrícula já cadastrada!");
            }
        }
        listaAlunos.add(a);
        salvarEmCSV();
    }

    public Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno a : listaAlunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public void removerAluno(String matricula) {
        Aluno alvo = buscarAlunoPorMatricula(matricula);
        if (alvo != null) {
            AlunoDAO dao = new RemocaoAlunoDAO();
            listaAlunos = dao.removerAluno(listaAlunos, alvo);
            salvarEmCSV();
        }
    }

    public Aluno getAlunoMaisNovo() {
        return listaAlunos.stream()
                .max(Comparator.comparing(Aluno::getDataNasc))
                .orElse(null);
    }

    public Aluno getAlunoMaisVelho() {
        return listaAlunos.stream()
                .min(Comparator.comparing(Aluno::getDataNasc))
                .orElse(null);
    }

    public void inserirAlunoNaPosicao(int posicao, Aluno aluno) {
        if (aluno != null && posicao >= 0 && posicao <= listaAlunos.size()) {
            listaAlunos.add(posicao, aluno);
            salvarEmCSV();
        }
    }

    public List<Aluno> getTodosAlunos() {
        return listaAlunos;
    }

   
   
      private void salvarEmCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(csvFile))) {
            for (Aluno a : listaAlunos) {
                pw.printf("%s; %s; %d; %s; %s; %s%n",
                 a.getMatricula(), a.getNome(), a.getIdade(),
                 sdf.format(a.getDataNasc()), a.getTelefone(), a.getCpf());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    }
    