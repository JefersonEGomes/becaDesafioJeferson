package com.becaJavaJeferson.services.serviceImp;

import com.becaJavaJeferson.dtos.requests.posts.PostLocacaoRequest;
import com.becaJavaJeferson.dtos.responses.posts.PostLocacaoResponse;
import com.becaJavaJeferson.model.Locacao;
import com.becaJavaJeferson.model.Locatario;
import com.becaJavaJeferson.model.Produto;
import com.becaJavaJeferson.repositories.LocacaoRepository;
import com.becaJavaJeferson.services.LocacaoService;
import com.becaJavaJeferson.services.LocatarioService;
import com.becaJavaJeferson.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LocacaoServiceImp implements LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private LocatarioService locatarioService;

    @Autowired
    private ProdutoService produtoService;

    //CREATE

    public PostLocacaoResponse criar(PostLocacaoRequest postLocacaoRequest) {
        Locatario locatarioObtido = locatarioService.obter(postLocacaoRequest.getIdLocatario());
        Produto produtoObtido = produtoService.obter(postLocacaoRequest.getIdProduto());

        Locacao locacao = new Locacao();
        locacao.setDataDevolve(postLocacaoRequest.getDataDevolve());
        locacao.setDataAluguel(postLocacaoRequest.getDataAluguel());
        locacao.setLocatario(locatarioObtido);
        locacao.setProduto(produtoObtido);

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
    public List<Locacao> listar(){
        List<Locacao> listaLocacoes = locacaoRepository.findAll();

        return listaLocacoes;
    }


    @Override
    public Locacao obter(Integer id){
        Locacao locacao = locacaoRepository.findById(id).get();

        if(locacao == null){
            throw new RuntimeException("O id da locação não foi encontrado");
        }

        return locacao;
    }

    //UPDATE
    @Override
    public Locacao atualizar(Locacao locacao,Integer id){
        Locacao locacaoObtida = this.obter(id);
        locacaoObtida.setDataAluguel( locacao.getDataAluguel());
        locacaoObtida.setDataDevolve( locacao.getDataDevolve());
        locacaoObtida.setProduto( locacao.getProduto());
        locacaoObtida.setLocatario( locacao.getLocatario());

        if (locacao.getProduto().getLocador().getCpf().equals(locacao.getLocatario().getCpf())){
            throw new RuntimeException(("Você não pode realizar uma locação com você mesmo"));
        }

        if(locacao.getDataAluguel().isBefore(locacao.getDataDevolve())){
            throw new RuntimeException(("Você não pode devolver o produto em uma data antes do aluguel"));
        }

        locacaoRepository.save(locacaoObtida);
        return locacaoObtida;
    }

    //Delete
    @Override
    public void deletar(Integer id){
        locacaoRepository.deleteById(id);

    }
}
