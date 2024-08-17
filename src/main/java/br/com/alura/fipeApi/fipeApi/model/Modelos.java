package br.com.alura.fipeApi.fipeApi.model;

public class Modelos {
    private int codigo;
    private String nome;
    private String marca;
    private Integer ano;

    public Modelos(Dados dadosModelos, Marcas dadosMarcas, Integer ano){
        this.codigo = Integer.parseInt(dadosModelos.codigo());
        this.nome = dadosModelos.nome();
        this.marca = dadosMarcas.getNome();
        this.ano = ano;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Modelos{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
