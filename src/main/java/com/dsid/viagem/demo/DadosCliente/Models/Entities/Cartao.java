package com.dsid.viagem.demo.DadosCliente.Models.Entities;

import com.dsid.viagem.demo.DadosCliente.Models.IdClasses.CartaoID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="cartao")
@IdClass(CartaoID.class)
public class Cartao {
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Id
    @Column
    String numeroCartao;


    @Column(nullable = false)
    String cvv;

     @Column
    Date dataValidade;

     @Column(nullable = false)
    String nomeTitular;

     @Column
    String apelido;

    @Id
    @ManyToOne
    @JoinColumn(name = "idCliente")
    Cliente cliente;
}
