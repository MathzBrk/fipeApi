package br.com.alura.fipeApi.fipeApi.model;

public class Ano {
    private int ano;
    private String codigo;

    public Ano(Dados dadosAno){
        // Extrai o ano da string "2015 Gasolina" assumindo que o ano está no início.
        String[] partes = dadosAno.nome().split(" ");
        this.ano = Integer.parseInt(partes[0]);
        this.codigo = dadosAno.codigo();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
