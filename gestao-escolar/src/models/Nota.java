package models;

public class Nota {
    private Integer idNota;
    private Integer idDisciplina;
    private Integer idAluno;
    private Integer nota1;
    private Integer nota2;
    private Integer nota3;
    private Integer nota4;
    private Integer media;

    public Nota() {
    }

    public Nota(Integer idNota, Integer idDisciplina, Integer idAluno) {
        this.idNota = idNota;
        this.idDisciplina = idDisciplina;
        this.idAluno = idAluno;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getNota1() {
        return nota1;
    }

    public void setNota1(Integer nota1) {
        this.nota1 = nota1;
    }

    public Integer getNota2() {
        return nota2;
    }

    public void setNota2(Integer nota2) {
        this.nota2 = nota2;
    }

    public Integer getNota3() {
        return nota3;
    }

    public void setNota3(Integer nota3) {
        this.nota3 = nota3;
    }

    public Integer getNota4() {
        return nota4;
    }

    public void setNota4(Integer nota4) {
        this.nota4 = nota4;
    }

    public Integer getMedia() {
        return media;
    }

    public void setMedia(Integer media) {
        this.media = media;
    }

}
