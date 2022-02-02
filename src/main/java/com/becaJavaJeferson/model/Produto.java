package com.becaJavaJeferson.model;

import javax.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String categoria;
    private Double preco;

    @OneToOne
    private Locador locador;

    public Produto() {
    }


    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public Double getPreco() {
        return this.preco;
    }

    public Locador getLocador() {
        return this.locador;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setLocador(Locador locador) {
        this.locador = locador;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Produto)) return false;
        final Produto other = (Produto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$nome = this.getNome();
        final Object other$nome = other.getNome();
        if (this$nome == null ? other$nome != null : !this$nome.equals(other$nome)) return false;
        final Object this$categoria = this.getCategoria();
        final Object other$categoria = other.getCategoria();
        if (this$categoria == null ? other$categoria != null : !this$categoria.equals(other$categoria)) return false;
        final Object this$preco = this.getPreco();
        final Object other$preco = other.getPreco();
        if (this$preco == null ? other$preco != null : !this$preco.equals(other$preco)) return false;
        final Object this$locador = this.getLocador();
        final Object other$locador = other.getLocador();
        if (this$locador == null ? other$locador != null : !this$locador.equals(other$locador)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Produto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $nome = this.getNome();
        result = result * PRIME + ($nome == null ? 43 : $nome.hashCode());
        final Object $categoria = this.getCategoria();
        result = result * PRIME + ($categoria == null ? 43 : $categoria.hashCode());
        final Object $preco = this.getPreco();
        result = result * PRIME + ($preco == null ? 43 : $preco.hashCode());
        final Object $locador = this.getLocador();
        result = result * PRIME + ($locador == null ? 43 : $locador.hashCode());
        return result;
    }

    public String toString() {
        return "Produto(id=" + this.getId() + ", nome=" + this.getNome() + ", categoria=" + this.getCategoria() + ", preco=" + this.getPreco() + ", locador=" + this.getLocador() + ")";
    }
}
