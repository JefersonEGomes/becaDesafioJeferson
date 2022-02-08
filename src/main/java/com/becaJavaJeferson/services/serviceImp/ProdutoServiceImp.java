package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.dtos.requests.patch.PatchProdutoRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostProdutoRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetProdutoResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetProdutoListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchProdutoResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostProdutoResponse;
import com.becaJavaJeferson.mappers.Produto.*;
import com.becaJavaJeferson.model.Produto;
import com.becaJavaJeferson.repositories.ProdutoRepository;
import com.becaJavaJeferson.services.LocadorService;
import com.becaJavaJeferson.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImp implements ProdutoService {


    private final LocadorService locadorService;
    private final MapperProdutoRequest mapperProdutoRequest;
    private final MapperProdutoResponse mapperProdutoResponse;
    private final MapperProdutoGetResponse mapperProdutoGetResponse;
    private final MapperProdutoPathRequest mapperProdutoPathRequest;
    private final MapperProdutoPathResponse mapperProdutoPathResponse;
    private final MapperProdutoListGetResponse mapperProdutoListGetResponse;


    private final ProdutoRepository produtoRepository;

    //CREATE
    @Override
    public PostProdutoResponse criar(PostProdutoRequest postProdutoRequest){

        Produto produto = mapperProdutoRequest.toModel(postProdutoRequest);
        produtoRepository.save(produto);
        PostProdutoResponse postProdutoResponse = mapperProdutoResponse.toResponse(produto);
        postProdutoResponse.setMensagem(produto.getNome() +" Cadastrado com Sucesso");
        return postProdutoResponse;

    }

    // READ
    @Override
    public List<GetProdutoListResponse> listar(){
        List<Produto> listaProdutos =  produtoRepository.findAll();

        return listaProdutos.stream().map(mapperProdutoListGetResponse::toResponse).collect(Collectors.toList());

    }

    @Override
    public GetProdutoResponse obter(Integer id){
        Produto produto = produtoRepository.findById(id).get();


        if(produto == null){
            throw new RuntimeException("O id do produto não foi encontrado");
        }

        return mapperProdutoGetResponse.toResponse(produto);
    }

//    private void getProdutoResponse(Produto produto, GetLocadorResponse getLocadorResponse, GetProdutoResponse getProdutoResponse) {
//        getProdutoResponse.setId(produto.getId());
//        getProdutoResponse.setNome(produto.getNome());
//        getProdutoResponse.setCategoria(produto.getCategoria());
//        getProdutoResponse.setPreco(produto.getPreco());
//        getProdutoResponse.setLocador(getLocadorResponse);
//    }
//
//    private void getLocadorResponse(Produto produto, GetLocadorResponse getLocadorResponse) {
//        getLocadorResponse.setId(produto.getLocador().getId());
//        getLocadorResponse.setNome(produto.getLocador().getNome());
//        getLocadorResponse.setIdade(produto.getLocador().getIdade());
//        getLocadorResponse.setTelefone(produto.getLocador().getTelefone());
//        getLocadorResponse.setCpf(produto.getLocador().getCpf());
//    }

    // UPDATE
    @Override
    public PatchProdutoResponse atualizar(PatchProdutoRequest patchProdutoRequest, Integer id){
        Produto produtoObtido = produtoRepository.findById(id).get();
        mapperProdutoPathRequest.atualizar(patchProdutoRequest, produtoObtido);

        produtoRepository.save(produtoObtido);

        PatchProdutoResponse patchProdutoResponse = mapperProdutoPathResponse.toResponse(produtoObtido);
        patchProdutoResponse.setMensagem("Produto "+produtoObtido.getNome()+" atualizado com sucesso");

        return patchProdutoResponse;
    }

    // DELETE
    @Override
    public void deletar(Integer id){

        produtoRepository.deleteById(id);
    }
}
