package br.com.alura.fipeApi.fipeApi.main;

import br.com.alura.fipeApi.fipeApi.model.*;
import br.com.alura.fipeApi.fipeApi.service.ConsumirApi;
import br.com.alura.fipeApi.fipeApi.service.ConverterDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private String endereco;
    private Scanner scanner = new Scanner(System.in);
    private ConsumirApi consumirApi = new ConsumirApi();
    private ConverterDados converterDados = new ConverterDados();
    private final String ENDERECO_BASE = "https://parallelum.com.br/fipe/api/v1/";



    public void exibirMenu(){
        System.out.println("***OPCÕES***");
        System.out.println("CARROS  MOTOS  CAMINHOES");
        System.out.println("Digite a opção que deseja: ");

        var tipoVeiculo = scanner.nextLine().toLowerCase();

        if (tipoVeiculo.contains("car")) {
            tipoVeiculo = "carros";
        } else if (tipoVeiculo.contains("mot")) {
            tipoVeiculo = "motos";
        } else if (tipoVeiculo.contains("cami")) {
            tipoVeiculo = "caminhoes";
        } else {
            System.out.println("Opção inválida! Digite algo próximo de alguma opção válida!!");
        }

        endereco = ENDERECO_BASE + tipoVeiculo + "/marcas";

        var json = consumirApi.obterDados(endereco);
        System.out.println(json);

        var dadosMarcas = converterDados.obterLista(json, Dados.class);
        dadosMarcas.stream()
                .sorted(Comparator.comparing(Dados::nome));

        List<Marcas> marcas = dadosMarcas.stream()
                .map(d -> new Marcas(d))
                .collect(Collectors.toList());

        marcas.forEach(System.out::println);

        System.out.println("Digite o código da Marca que deseja: ");
        int codigoMarca = scanner.nextInt();
        scanner.nextLine();


        endereco = ENDERECO_BASE + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos";
        json = consumirApi.obterDados(endereco);
        System.out.println(json);

        var dadosModelos = converterDados.obterDados(json, DadosModelos.class);


        dadosModelos.modelos().stream()
                        .sorted(Comparator.comparing(Dados::codigo))
                                .forEach(System.out::println);

        System.out.println("Digite um trecho do carro a ser buscado: ");
        var nomeVeiculo = scanner.nextLine();

        List<Dados> modelosFiltrados = dadosModelos.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados: ");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite o código do modelo que deseja saber os anos: ");
        var codigoModelo = scanner.nextLine();
//
//
        endereco = ENDERECO_BASE + tipoVeiculo + "/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";
        json = consumirApi.obterDados(endereco);

        List<Dados> anos = converterDados.obterLista(json, Dados.class);

        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumirApi.obterDados(enderecoAnos);
            Veiculo veiculo = converterDados.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veiculos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);









    }
}
