package com.dev.backend.service;

import com.dev.backend.entity.Categoria;
import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CategoriaRepository;
import com.dev.backend.repository.CidadeRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepositoy cidadeRepositoy;

    public List<Cidade> buscarTodas(){
        return cidadeRepositoy.findAll();
    }

    public Cidade inserir(Cidade cidade){
        cidade.setDataCriacao(new Date());
        Cidade cidadeNova = cidadeRepositoy.saveAndFlush(cidade);
        return cidadeNova;
    }

    public Cidade alterar(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        return cidadeRepositoy.saveAndFlush(cidade);
    }

    public void excluir(Long id){
        Cidade cidade = cidadeRepositoy.findById(id).get();
        cidadeRepositoy.delete(cidade);
    }



}
