package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.model.Produto;
import com.becaJavaJeferson.repositories.ProdutoRepository;
import com.becaJavaJeferson.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImp implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //CREATE
    @Override
    public Produto criar(Produto produto){

        if( produto.getNome().length() <= 3){
            throw new RuntimeException("O nome do produto não pode ter menos de 4 caracteres");

        }

        if(produto.getPreco().longValue() <= 0){
            throw new RuntimeException("Por favor digite um preço acima de 0");
        }

        Produto produtoSalvo = produtoRepository.save(produto);

        return produtoSalvo;

    }

    // READ
    @Override
    public List<Produto> listar(){
        List<Produto> listaProdutos =  produtoRepository.findAll();

        return listaProdutos;

    }

    @Override
    public Produto obter(Integer id){
        Produto produto = produtoRepository.findById(id).get();

        if(produto == null){
            throw new RuntimeException("O id do produto não foi encontrado");
        }

        return produto;
    }

    // UPDATE
    @Override
    public Produto atualizar(Produto produto, Integer id){
        Produto produtoObtido = this.obter(id);
        produtoObtido.setNome( produto.getNome() );
        produtoObtido.setPreco( produto.getPreco() );
        produtoObtido.setCategoria( produto.getCategoria() );
        produtoObtido.setLocador( produto.getLocador() );

        if( produto.getNome().length() <= 3){
            throw new RuntimeException("O nome do Produto não pode ter menos de 4 caracteres");
        }

        if(produto.getPreco().longValue() <= 0){
            throw new RuntimeException("Por favor digite um preço acima de 0");
        }

        produtoRepository.save(produtoObtido);
        return produtoObtido;
    }

    // DELETE
    @Override
    public void deletar(Integer id){
        produtoRepository.deleteById(id);


    }
}
