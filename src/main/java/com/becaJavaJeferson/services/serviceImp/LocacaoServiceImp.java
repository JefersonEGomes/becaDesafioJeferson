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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Retirar o ID

@Service
@RequiredArgsConstructor
public class LocacaoServiceImp implements LocacaoService {

    private final LocacaoRepository locacaoRepository;

    private final LocatarioService locatarioService;

    private final LocadorService locadorService;

    private final ProdutoService produtoService;

    //CREATE
    @Override
    public PostLocacaoResponse criar(PostLocacaoRequest postLocacaoRequest) {


        GetLocatarioResponse locatarioObtido = locatarioService.obter(postLocacaoRequest.getIdLocatario());
        Locatario locatario = new Locatario();
        locatarioObtidoMethod(locatarioObtido, locatario);


        GetLocadorResponse locadorObtido = locadorService.obter(postLocacaoRequest.getIdProduto());
        Locador locador = new Locador();
        locadorObtidoMethod(locadorObtido, locador);


        GetProdutoResponse produtoObtido = produtoService.obter(postLocacaoRequest.getIdProduto());
        Produto produto = new Produto();
        produtoObtidoMethod(locador, produtoObtido, produto);


        Locacao locacao = new Locacao();
        locacaoMethod(postLocacaoRequest, locatario, produto, locacao);

        if (locacao.getProduto().getLocador().getCpf().equals(locacao.getLocatario().getCpf())){
            throw new RuntimeException(("Você não pode realizar uma locação com você mesmo"));
        }

        if(locacao.getDataDevolve().isBefore(locacao.getDataAluguel())){
            throw new RuntimeException(("Você não pode devolver o produto em uma data antes do aluguel"));
        }

        locacaoRepository.save(locacao);

        PostLocacaoResponse postLocacaoResponse = new PostLocacaoResponse();
        postLocacaoResponse.setMensagem("Sr(a) "+locatarioObtido.getNome()+" sua locação do produto "+produtoObtido.getNome()+" foi realizada com sucesso. Lembre-se" +
                " de devolver em "+locacao.getDataDevolve().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));


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
        getProdutoResponse(locacao, getLocadorResponse, getProdutoResponse);

        GetLocacaoResponse getLocacaoResponse = new GetLocacaoResponse();
        getLocacaoResponse(locacao, getLocatarioResponse, getProdutoResponse, getLocacaoResponse);

        if(locacao == null){
            throw new RuntimeException("O id da locação não foi encontrado");
        }

        return getLocacaoResponse;
    }


    //UPDATE
    @Override
    public PatchLocacaoResponse atualizar(PatchLocacaoRequest patchLocacaoRequest, Integer id){

        Locacao locacaoObtida = locacaoRepository.findById(id).get();
        locacaoObtida.setDataAluguel( patchLocacaoRequest.getDataAluguel());
        locacaoObtida.setDataDevolve( patchLocacaoRequest.getDataDevolve());


        if(locacaoObtida.getDataDevolve().isBefore(locacaoObtida.getDataAluguel())){
            throw new RuntimeException(("Você não pode devolver o produto em uma data antes do aluguel"));
        }

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
    // Create Methods
    private void produtoObtidoMethod(Locador locador, GetProdutoResponse produtoObtido, Produto produto) {
        produto.setId(produtoObtido.getId());
        produto.setNome(produtoObtido.getNome());
        produto.setCategoria(produtoObtido.getCategoria());
        produto.setPreco(produtoObtido.getPreco());
        produto.setLocador(locador);
    }

    private void locadorObtidoMethod(GetLocadorResponse locadorObtido, Locador locador) {
        locador.setId(locadorObtido.getId());
        locador.setNome(locadorObtido.getNome());
        locador.setIdade(locadorObtido.getIdade());
        locador.setTelefone(locadorObtido.getTelefone());
        locador.setCpf(locadorObtido.getCpf());
    }

    private void locatarioObtidoMethod(GetLocatarioResponse locatarioObtido, Locatario locatario) {
        locatario.setId(locatarioObtido.getId());
        locatario.setNome(locatarioObtido.getNome());
        locatario.setIdade(locatarioObtido.getIdade());
        locatario.setTelefone(locatarioObtido.getTelefone());
        locatario.setCpf(locatarioObtido.getCpf());
    }

    private void locacaoMethod(PostLocacaoRequest postLocacaoRequest, Locatario locatario, Produto produto, Locacao locacao) {
        locacao.setDataDevolve(postLocacaoRequest.getDataDevolve());
        locacao.setDataAluguel(postLocacaoRequest.getDataAluguel());
        locacao.setLocatario(locatario);
        locacao.setProduto(produto);
    }


    // Read Methods
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

    private void getLocacaoResponse(Locacao locacao, GetLocatarioResponse getLocatarioResponse, GetProdutoResponse getProdutoResponse, GetLocacaoResponse getLocacaoResponse) {

        getLocacaoResponse.setDataAluguel(locacao.getDataAluguel());
        getLocacaoResponse.setDataDevolve(locacao.getDataDevolve());
        getLocacaoResponse.setLocatario(getLocatarioResponse);
        getLocacaoResponse.setProduto(getProdutoResponse);
    }

    private void getProdutoResponse(Locacao locacao, GetLocadorResponse getLocadorResponse, GetProdutoResponse getProdutoResponse) {
        getProdutoResponse.setId(locacao.getProduto().getId());
        getProdutoResponse.setNome(locacao.getProduto().getNome());
        getProdutoResponse.setCategoria(locacao.getProduto().getCategoria());
        getProdutoResponse.setPreco(locacao.getProduto().getPreco());
        getProdutoResponse.setLocador(getLocadorResponse);
    }

}
