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
import com.becaJavaJeferson.model.Locacao;
import com.becaJavaJeferson.model.Locador;
import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.model.Produto;
import com.becaJavaJeferson.repositories.LocacaoRepository;
import com.becaJavaJeferson.services.LocacaoService;
import com.becaJavaJeferson.services.LocadorService;
import com.becaJavaJeferson.services.LocatarioService;
import com.becaJavaJeferson.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Retirar o ID

@Service
public class LocacaoServiceImp implements LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private LocatarioService locatarioService;

    @Autowired
    private LocadorService locadorService;

    @Autowired
    private ProdutoService produtoService;

    //CREATE
    @Override
    public PostLocacaoResponse criar(PostLocacaoRequest postLocacaoRequest) {
        GetLocatarioResponse locatarioObtido = locatarioService.obter(postLocacaoRequest.getIdLocatario());
        Locatario locatario = new Locatario();
        locatario.setId(locatarioObtido.getId());
        locatario.setNome(locatarioObtido.getNome());
        locatario.setIdade(locatarioObtido.getIdade());
        locatario.setTelefone(locatarioObtido.getTelefone());
        locatario.setCpf(locatarioObtido.getCpf());


        GetLocadorResponse locadorObtido = locadorService.obter(postLocacaoRequest.getIdProduto());
        Locador locador = new Locador();
        locador.setId(locadorObtido.getId());
        locador.setNome(locadorObtido.getNome());
        locador.setIdade(locadorObtido.getIdade());
        locador.setTelefone(locadorObtido.getTelefone());
        locador.setCpf(locadorObtido.getCpf());


        GetProdutoResponse produtoObtido = produtoService.obter(postLocacaoRequest.getIdProduto());
        Produto produto = new Produto();
        produto.setId(produtoObtido.getId());
        produto.setNome(produtoObtido.getNome());
        produto.setCategoria(produtoObtido.getCategoria());
        produto.setPreco(produtoObtido.getPreco());
        produto.setLocador(locador);


        Locacao locacao = new Locacao();
        locacao.setDataDevolve(postLocacaoRequest.getDataDevolve());
        locacao.setDataAluguel(postLocacaoRequest.getDataAluguel());
        locacao.setLocatario(locatario);
        locacao.setProduto(produto);

        if (locacao.getProduto().getLocador().getCpf().equals(locacao.getLocatario().getCpf())){
            throw new RuntimeException(("Você não pode realizar uma locação com você mesmo"));
        }

        if(locacao.getDataDevolve().isBefore(locacao.getDataAluguel())){
            throw new RuntimeException(("Você não pode devolver o produto em uma data antes do aluguel"));
        }


        PostLocacaoResponse postLocacaoResponse = new PostLocacaoResponse();
        postLocacaoResponse.setMensagem("Sr(a) "+locatarioObtido.getNome()+" sua locação do produto "+produtoObtido.getNome()+" foi realizada com sucesso. Lembre-se" +
                " de devolver em "+locacao.getDataDevolve().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        Locacao locacaoSalva = locacaoRepository.save(locacao);
        return postLocacaoResponse;
    }

    //READ
    @Override
    public List<GetLocacaoListResponse> listar(){
        List<Locacao> listaLocacoes = locacaoRepository.findAll();
        List<GetLocacaoListResponse> getLocacaoListar = new ArrayList<>();

        listaLocacoes.stream().forEach(locacao -> getLocacaoListar.add(new GetLocacaoListResponse(locacao)));

        return getLocacaoListar;
    }


    @Override
    public GetLocacaoResponse obter(Integer id){
        Locacao locacao = locacaoRepository.findById(id).get();

        GetLocadorResponse getLocadorResponse = new GetLocadorResponse();
        getLocadorResponse(locacao, getLocadorResponse);

        GetLocatarioResponse getLocatarioResponse = new GetLocatarioResponse();
        getLocatarioResponse(locacao, getLocatarioResponse);

        GetProdutoResponse getProdutoResponse = new GetProdutoResponse();
        getProdutoResponse.setId(locacao.getProduto().getId());
        getProdutoResponse.setNome(locacao.getProduto().getNome());
        getProdutoResponse.setCategoria(locacao.getProduto().getCategoria());
        getProdutoResponse.setPreco(locacao.getProduto().getPreco());
        getProdutoResponse.setGetLocadorResponse(getLocadorResponse);

        GetLocacaoResponse getLocacaoResponse = new GetLocacaoResponse();
        getLocacaoResponse.setId(locacao.getId());
        getLocacaoResponse.setDataAluguel(locacao.getDataAluguel());
        getLocacaoResponse.setDataDevolve(locacao.getDataDevolve());
        getLocacaoResponse.setGetLocatarioResponse(getLocatarioResponse);
        getLocacaoResponse.setGetProdutoResponse(getProdutoResponse);

        if(locacao == null){
            throw new RuntimeException("O id da locação não foi encontrado");
        }

        return getLocacaoResponse;
    }

    private void getLocatarioResponse(Locacao locacao, GetLocatarioResponse getLocatarioResponse) {
        getLocatarioResponse.setId(locacao.getLocatario().getId());
        getLocatarioResponse.setNome(locacao.getLocatario().getNome());
        getLocatarioResponse.setIdade(locacao.getLocatario().getIdade());
        getLocatarioResponse.setTelefone(locacao.getLocatario().getTelefone());
        getLocatarioResponse.setCpf(locacao.getLocatario().getCpf());
    }

    private void getLocadorResponse(Locacao locacao, GetLocadorResponse getLocadorResponse) {
        getLocadorResponse.setId(locacao.getProduto().getLocador().getId());
        getLocadorResponse.setNome(locacao.getProduto().getLocador().getNome());
        getLocadorResponse.setIdade(locacao.getProduto().getLocador().getIdade());
        getLocadorResponse.setTelefone(locacao.getProduto().getLocador().getTelefone());
        getLocadorResponse.setCpf(locacao.getProduto().getLocador().getCpf());
    }

    //UPDATE
    @Override
    public PatchLocacaoResponse atualizar(PatchLocacaoRequest patchLocacaoRequest, Integer id){

        Locacao locacaoObtida = locacaoRepository.findById(id).get();
        locacaoObtida.setDataAluguel( patchLocacaoRequest.getDataAluguel());
        locacaoObtida.setDataDevolve( patchLocacaoRequest.getDataDevolve());

//        if (locacao.getProduto().getLocador().getCpf().equals(locacao.getLocatario().getCpf())){
//            throw new RuntimeException(("Você não pode realizar uma locação com você mesmo"));
//        }
//
//        if(locacao.getDataAluguel().isBefore(locacao.getDataDevolve())){
//            throw new RuntimeException(("Você não pode devolver o produto em uma data antes do aluguel"));
//        }

        locacaoRepository.save(locacaoObtida);

        PatchLocacaoResponse patchLocacaoResponse = new PatchLocacaoResponse();
        patchLocacaoResponse.setMensagem("Locação atualizada com sucesso");

        return patchLocacaoResponse;
    }

    //Delete
    @Override
    public void deletar(Integer id){
        locacaoRepository.deleteById(id);

    }
}
