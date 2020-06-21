package com.dsid.viagem.demo.Models.Entities;


import com.dsid.viagem.demo.Models.IdClasses.EnderecoID;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Getter
@Entity
@Table(name="endereco")
@IdClass(EnderecoID.class)
@Setter
public class Endereco extends ChildTableEntity {



    @Id
    @Column
    private String cep;

    @Column(nullable = false)
    private Integer numero;

    @Id
    @ManyToOne
    @JoinColumn(name = "email")
    private Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco(){
        System.out.println();
    }
}
