package models;

public class Curso {
    private String curso;
    Double nota1, nota2, media;

    public Curso(String curso, Double nota1, Double nota2, Double media) {
        this.curso = curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
}
