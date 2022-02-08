package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.dtos.requests.patch.PatchLocacaoRequest;
import com.becaJavaJeferson.dtos.requests.posts.PostLocacaoRequest;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocacaoResponse;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocadorResponse;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetLocatarioResponse;
import com.becaJavaJeferson.dtos.responses.gets.ids.GetProdutoResponse;
import com.becaJavaJeferson.dtos.responses.gets.lists.GetLocacaoListResponse;
import com.becaJavaJeferson.dtos.responses.patch.PatchLocacaoResponse;
import com.becaJavaJeferson.dtos.responses.posts.PostLocacaoResponse;
import com.becaJavaJeferson.mappers.Locacao.*;
import com.becaJavaJeferson.model.Locacao;
import com.becaJavaJeferson.model.Locador;
import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.model.Produto;
import com.becaJavaJeferson.repositories.LocacaoRepository;
import com.becaJavaJeferson.services.LocacaoService;
import com.becaJavaJeferson.services.LocadorService;
import com.becaJavaJeferson.services.LocatarioService;
import com.becaJavaJeferson.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocacaoServiceImp implements LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final LocatarioService locatarioService;
    private final LocadorService locadorService;
    private final ProdutoService produtoService;
    private final MapperLocacaoRequest mapperLocacaoRequest;
    private final MapperLocacaoResponse mapperLocacaoResponse;
    private final MapperLocacaoPatchRequest mapperLocacaoPatchRequest;
    private final MapperLocacaoPatchResponse mapperLocacaoPatchResponse;
    private final MapperLocacaoGetResponse mapperLocacaoGetResponse;
    private final MapperLocacaoListGetResponse mapperLocacaoListGetResponse;


    //CREATE
    @Override
    public PostLocacaoResponse criar(PostLocacaoRequest postLocacaoRequest) {

        Locacao locacao = mapperLocacaoRequest.toModel(postLocacaoRequest);
        locacaoRepository.save(locacao);
        PostLocacaoResponse postLocacaoResponse = mapperLocacaoResponse.toResponse(locacao);
        postLocacaoResponse.setMensagem("Sua locação foi realizada com sucesso. Lembre-se de devolver em "+locacao.getDataDevolve().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        return postLocacaoResponse;

    }


    //READ
    @Override
    public List<GetLocacaoListResponse> listar(){
        List<Locacao> listaLocacoes = locacaoRepository.findAll();

        return listaLocacoes.stream().map(mapperLocacaoListGetResponse::toResponse).collect(Collectors.toList());
    }


    @Override
    public GetLocacaoResponse obter(Integer id){
        Locacao locacao = locacaoRepository.findById(id).get();

        if(locacao == null){
            throw new RuntimeException("O id da locação não foi encontrado");
        }

        return mapperLocacaoGetResponse.toResponse(locacao);
    }


    //UPDATE
    @Override
    public PatchLocacaoResponse atualizar(PatchLocacaoRequest patchLocacaoRequest, Integer id){
        Locacao locacaoObtida = locacaoRepository.findById(id).get();
        mapperLocacaoPatchRequest.atualizar(patchLocacaoRequest, locacaoObtida);


        if(locacaoObtida.getDataDevolve().isBefore(locacaoObtida.getDataAluguel())){
            throw new RuntimeException(("Você não pode devolver o produto em uma data antes do aluguel"));
        }

        locacaoRepository.save(locacaoObtida);

        PatchLocacaoResponse patchLocacaoResponse = mapperLocacaoPatchResponse.toResponse(locacaoObtida);
        patchLocacaoResponse.setMensagem("Locação atualizada com sucesso");

        return patchLocacaoResponse;
    }

    //Delete
    @Override
    public void deletar(Integer id){
        locacaoRepository.deleteById(id);

    }

}
