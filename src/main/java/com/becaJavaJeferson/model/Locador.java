package com.becaJavaJeferson.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Locador{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;
    private Long cpf;
    private Long telefone;

    public Locador() {
    }


    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public Long getCpf() {
        return this.cpf;
    }

    public Long getTelefone() {
        return this.telefone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Locador)) return false;
        final Locador other = (Locador) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$nome = this.getNome();
        final Object other$nome = other.getNome();
        if (this$nome == null ? other$nome != null : !this$nome.equals(other$nome)) return false;
        final Object this$idade = this.getIdade();
        final Object other$idade = other.getIdade();
        if (this$idade == null ? other$idade != null : !this$idade.equals(other$idade)) return false;
        final Object this$cpf = this.getCpf();
        final Object other$cpf = other.getCpf();
        if (this$cpf == null ? other$cpf != null : !this$cpf.equals(other$cpf)) return false;
        final Object this$telefone = this.getTelefone();
        final Object other$telefone = other.getTelefone();
        if (this$telefone == null ? other$telefone != null : !this$telefone.equals(other$telefone)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Locador;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $nome = this.getNome();
        result = result * PRIME + ($nome == null ? 43 : $nome.hashCode());
        final Object $idade = this.getIdade();
        result = result * PRIME + ($idade == null ? 43 : $idade.hashCode());
        final Object $cpf = this.getCpf();
        result = result * PRIME + ($cpf == null ? 43 : $cpf.hashCode());
        final Object $telefone = this.getTelefone();
        result = result * PRIME + ($telefone == null ? 43 : $telefone.hashCode());
        return result;
    }

    public String toString() {
        return "Locador(id=" + this.getId() + ", nome=" + this.getNome() + ", idade=" + this.getIdade() + ", cpf=" + this.getCpf() + ", telefone=" + this.getTelefone() + ")";
    }
}
