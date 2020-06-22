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
    @JoinColumn(name = "email")
    Cliente cliente;
}
