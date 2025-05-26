package model;

import java.util.List;

public interface AlunoDAO {
    List<Aluno> removerAluno(List<Aluno> alunos, Aluno a);
}
