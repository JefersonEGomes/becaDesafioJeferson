package com.becaJavaJeferson.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Locacao {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataAluguel;
    private LocalDate dataDevolve;

    @ManyToOne
    private Locatario locatario;

    @OneToOne
    private Produto produto;

    public Locacao() {
    }


    public Integer getId() {
        return this.id;
    }

    public LocalDate getDataAluguel() {
        return this.dataAluguel;
    }

    public LocalDate getDataDevolve() {
        return this.dataDevolve;
    }

    public Locatario getLocatario() {
        return this.locatario;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public void setDataDevolve(LocalDate dataDevolve) {
        this.dataDevolve = dataDevolve;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Locacao)) return false;
        final Locacao other = (Locacao) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$dataAluguel = this.getDataAluguel();
        final Object other$dataAluguel = other.getDataAluguel();
        if (this$dataAluguel == null ? other$dataAluguel != null : !this$dataAluguel.equals(other$dataAluguel))
            return false;
        final Object this$dataDevolve = this.getDataDevolve();
        final Object other$dataDevolve = other.getDataDevolve();
        if (this$dataDevolve == null ? other$dataDevolve != null : !this$dataDevolve.equals(other$dataDevolve))
            return false;
        final Object this$locatario = this.getLocatario();
        final Object other$locatario = other.getLocatario();
        if (this$locatario == null ? other$locatario != null : !this$locatario.equals(other$locatario)) return false;
        final Object this$produto = this.getProduto();
        final Object other$produto = other.getProduto();
        if (this$produto == null ? other$produto != null : !this$produto.equals(other$produto)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Locacao;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $dataAluguel = this.getDataAluguel();
        result = result * PRIME + ($dataAluguel == null ? 43 : $dataAluguel.hashCode());
        final Object $dataDevolve = this.getDataDevolve();
        result = result * PRIME + ($dataDevolve == null ? 43 : $dataDevolve.hashCode());
        final Object $locatario = this.getLocatario();
        result = result * PRIME + ($locatario == null ? 43 : $locatario.hashCode());
        final Object $produto = this.getProduto();
        result = result * PRIME + ($produto == null ? 43 : $produto.hashCode());
        return result;
    }

    public String toString() {
        return "Locacao(id=" + this.getId() + ", dataAluguel=" + this.getDataAluguel() + ", dataDevolve=" + this.getDataDevolve() + ", locatario=" + this.getLocatario() + ", produto=" + this.getProduto() + ")";
    }
}


