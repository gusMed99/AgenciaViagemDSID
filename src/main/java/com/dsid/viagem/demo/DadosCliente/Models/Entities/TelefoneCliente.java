package com.dsid.viagem.demo.DadosCliente.Models.Entities;

import com.dsid.viagem.demo.DadosCliente.Models.IdClasses.TelefoneClienteId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@IdClass(TelefoneClienteId.class)
@Entity
@Table(name="telefone")
public class TelefoneCliente extends ChildTableEntity {
    @Id
    @Column
    String telefone;
    @Id
    @Column(nullable = false, precision = 3)
    String ddd;

    @Id
    @ManyToOne
    @JoinColumn(name = "email")
    Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
