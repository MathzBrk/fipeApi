package br.com.alura.fipeApi.fipeApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelos(List<Dados> modelos) {
}
