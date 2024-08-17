package br.com.alura.fipeApi.fipeApi.model;

public class Marcas {
    private int codigo;
    private String nome;

    @Override
    public String toString() {
        return "Marcas{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Marcas(Dados dadosMarcas) {
        this.codigo = Integer.parseInt(dadosMarcas.codigo());
        this.nome = dadosMarcas.nome();
    }
}
