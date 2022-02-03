package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.dtos.requests.patch.PatchProdutoRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostProdutoRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocadorResponse;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetProdutoResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetProdutoListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchProdutoResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostProdutoResponse;
import com.becaJavaJeferson.model.Locador;
import com.becaJavaJeferson.model.Produto;
import com.becaJavaJeferson.repositories.ProdutoRepository;
import com.becaJavaJeferson.services.LocadorService;
import com.becaJavaJeferson.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoServiceImp implements ProdutoService {

    @Autowired
    private LocadorService locadorService;

    @Autowired
    private ProdutoRepository produtoRepository;

    //CREATE
    @Override
    public PostProdutoResponse criar(PostProdutoRequest postProdutoRequest){

        GetLocadorResponse locadorObtido = locadorService.obter(postProdutoRequest.getIdLocador());

        Locador locador = new Locador();
        locador.setId(locadorObtido.getId());
        locador.setNome(locadorObtido.getNome());
        locador.setIdade(locadorObtido.getIdade());
        locador.setCpf(locadorObtido.getCpf());
        locador.setTelefone(locadorObtido.getTelefone());

        Produto produto = new Produto();
        produto.setNome(postProdutoRequest.getNome());
        produto.setPreco(postProdutoRequest.getPreco());
        produto.setCategoria(postProdutoRequest.getCategoria());
        produto.setLocador(locador);

        if( produto.getNome().length() <= 3){
            throw new RuntimeException("O nome do produto não pode ter menos de 4 caracteres");

        }

        if(produto.getPreco().longValue() <= 0){
            throw new RuntimeException("Por favor digite um preço acima de 0");
        }

        Produto produtoSalvo = produtoRepository.save(produto);

        PostProdutoResponse postProdutoResponse = new PostProdutoResponse();
        postProdutoResponse.setMensagem(produtoSalvo.getNome() +" Cadastrado com Sucesso");

        return postProdutoResponse;

    }

    // READ
    @Override
    public List<GetProdutoListResponse> listar(){
        List<Produto> listaProdutos =  produtoRepository.findAll();
        List<GetProdutoListResponse> getProdutoListar = new ArrayList<>();

        listaProdutos.stream().forEach(produto -> getProdutoListar.add(new GetProdutoListResponse(produto)));

        return getProdutoListar;

    }

    @Override
    public GetProdutoResponse obter(Integer id){
        Produto produto = produtoRepository.findById(id).get();

        GetLocadorResponse getLocadorResponse = new GetLocadorResponse();
        getLocadorResponse(produto, getLocadorResponse);


        GetProdutoResponse getProdutoResponse = new GetProdutoResponse();
        getProdutoResponse(produto, getLocadorResponse, getProdutoResponse);

        if(produto == null){
            throw new RuntimeException("O id do produto não foi encontrado");
        }

        return getProdutoResponse;
    }

    private void getProdutoResponse(Produto produto, GetLocadorResponse getLocadorResponse, GetProdutoResponse getProdutoResponse) {
        getProdutoResponse.setId(produto.getId());
        getProdutoResponse.setNome(produto.getNome());
        getProdutoResponse.setCategoria(produto.getCategoria());
        getProdutoResponse.setPreco(produto.getPreco());
        getProdutoResponse.setLocador(getLocadorResponse);
    }

    private void getLocadorResponse(Produto produto, GetLocadorResponse getLocadorResponse) {
        getLocadorResponse.setId(produto.getLocador().getId());
        getLocadorResponse.setNome(produto.getLocador().getNome());
        getLocadorResponse.setIdade(produto.getLocador().getIdade());
        getLocadorResponse.setTelefone(produto.getLocador().getTelefone());
        getLocadorResponse.setCpf(produto.getLocador().getCpf());
    }

    // UPDATE
    @Override
    public PatchProdutoResponse atualizar(PatchProdutoRequest patchProdutoRequest, Integer id){

        Produto produtoObtido = produtoRepository.findById(id).get();
        produtoObtido.setNome( patchProdutoRequest.getNome() );
        produtoObtido.setPreco( patchProdutoRequest.getPreco() );
        produtoObtido.setCategoria( patchProdutoRequest.getCategoria() );


        if( patchProdutoRequest.getNome().length() <= 3){
            throw new RuntimeException("O nome do Produto não pode ter menos de 4 caracteres");
        }

        if(patchProdutoRequest.getPreco().longValue() <= 0){
            throw new RuntimeException("Por favor digite um preço acima de 0");
        }

        produtoRepository.save(produtoObtido);

        PatchProdutoResponse patchProdutoResponse = new PatchProdutoResponse();
        patchProdutoResponse.setMensagem("Produto "+produtoObtido.getNome()+" atualizado com sucesso");

        return patchProdutoResponse;
    }

    // DELETE
    @Override
    public void deletar(Integer id){

        produtoRepository.deleteById(id);
    }
}
