package br.com.alura.fipeApi.fipeApi.service;

import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
