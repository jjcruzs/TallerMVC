package uniajc.model;

public class Calificaciones {

    private int codEstudiante;
    private int codCurso;
    private float nota;

    public Calificaciones(int codEstudiante, int codCurso, float nota) { 
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
}
