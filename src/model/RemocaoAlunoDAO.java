package model;

import java.util.Iterator;
import java.util.List;

public class RemocaoAlunoDAO implements AlunoDAO {
    @Override
    public List<Aluno> removerAluno(List<Aluno> alunos, Aluno a) {
        Iterator<Aluno> it = alunos.iterator();
        while (it.hasNext()) {
            if (it.next().getMatricula().equals(a.getMatricula())) {
                it.remove();
                break;
            }
        }
        return alunos;
    }
}
