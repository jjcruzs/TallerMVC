package uniajc.model;

public class Matricula {

    private int codEstudiante;
    private int codCurso;
    private float nota;

    public Matricula(int codEstudiante, int codCurso, float nota) {
        this.codEstudiante = codEstudiante;
        this.codCurso = codCurso;
        this.nota = nota;
    }

    public int getCodEstudiante() {
        return codEstudiante;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
