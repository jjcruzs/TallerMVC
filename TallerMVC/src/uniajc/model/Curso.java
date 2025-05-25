package uniajc.model;

public class Curso {
    private int codCurso;
    private String nomCurso;

    public Curso(int codCurso, String nomCurso) {
        this.codCurso = codCurso;
        this.nomCurso = nomCurso;
    }

    public int getCodCurso() { return codCurso; }
    public String getNomCurso() { return nomCurso; }

    @Override
    public String toString() {
        return nomCurso;  
    }
}
