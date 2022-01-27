package com.becaJavaJeferson.services;

import com.becaJavaJeferson.model.Locador;
import com.becaJavaJeferson.model.Produto;
import com.becaJavaJeferson.repository.ProdutoInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProdutoService implements ProdutoInterface {
    //CREATE
    public Produto criar(Produto produto){

        Random randomId = new Random();
        produto.setId(randomId.nextInt(1000));

        if( produto.getNome().length() <= 3){
            throw new RuntimeException("O nome do produto não pode ter menos de 4 caracteres");

        }

        if(produto.getPreco().longValue() <= 0){
            throw new RuntimeException("Por favor digite um preço acima de 0");
        }

        return produto;

    }

    // READ

    public List<Produto> listar(){
        // Instancia para Teste
        Locador locador1 = new Locador();
        locador1.setId(1);
        locador1.setNome("João");
        locador1.setIdade(22);
        locador1.setCpf(12345678900L);
        locador1.setTelefone(81945678900L);

        Locador locador2 = new Locador();
        locador2.setId(2);
        locador2.setNome("Roberto");
        locador2.setIdade(34);
        locador2.setCpf(90087654321L);
        locador2.setTelefone(81909876543L);

        Locador locador3 = new Locador();
        locador3.setId(3);
        locador3.setNome("Elias");
        locador3.setIdade(52);
        locador3.setCpf(56912300000L);
        locador3.setTelefone(81912345678L);

        Produto prod1 = new Produto();
        prod1.setId(1);
        prod1.setNome("Controle Xbox");
        prod1.setCategoria("Tecnologia");
        prod1.setPreco(250.00);
        prod1.setId(58);
        prod1.setLocador(locador1);


        Produto prod2 = new Produto();
        prod2.setId(2);
        prod2.setNome("Bicicleta");
        prod2.setCategoria("Veículo");
        prod2.setPreco(320.00);
        prod2.setLocador(locador2);

        Produto prod3 = new Produto();
        prod3.setId(3);
        prod3.setNome("Bola de Futebol");
        prod3.setCategoria("Esportes");
        prod3.setPreco(50.00);
        prod3.setLocador(locador3);


        return List.of(
                prod1,
                prod2,
                prod3
        );

    }


    public Produto obter(Integer id){
        // Instancia para Teste
        Locador locador1 = new Locador();
        locador1.setId(1);
        locador1.setNome("João");
        locador1.setIdade(22);
        locador1.setCpf(12345678900L);
        locador1.setTelefone(81945678900L);

        Produto prod1 = new Produto();
        prod1.setId(id);
        prod1.setNome("Controle Xbox");
        prod1.setCategoria("Tecnologia");
        prod1.setPreco(250.00);
        prod1.setLocador(locador1);
        prod1.setId(58);

        return prod1;
    }

    // UPDATE

    public Produto atualizar(Produto produto, Integer id){
        produto.setId(id);

        if( produto.getNome().length() <= 3){
            throw new RuntimeException("O nome do Produto não pode ter menos de 4 caracteres");
        }

        if(produto.getPreco().longValue() <= 0){
            throw new RuntimeException("Por favor digite um preço acima de 0");
        }

        return produto;
    }

    // DELETE

    public void deletar(Integer id){


    }
}
