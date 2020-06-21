package com.dsid.viagem.demo.Models.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="Cliente")
public class Cliente {

    @Id
    private String email;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Date dataNascimento;
    @Column
    private String nomeMae;
    @Column(nullable = false, precision = 11)
    private String cpf;

    @OneToMany(cascade = ALL, targetEntity = TelefoneCliente.class, mappedBy = "cliente")
    private List<TelefoneCliente> telefonesCliente;

    @OneToMany(cascade = ALL, targetEntity = Cartao.class, mappedBy = "cliente")

    private List<Cartao> cartoesCliente;

    @OneToMany(cascade = ALL, targetEntity = Endereco.class, mappedBy = "cliente")

    private List<Endereco> enderecosCliente;

    @Override
    public boolean equals(Object o) {
        Cliente c=(Cliente)o;
        if(c.getEmail().equals(this.getEmail())) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.email.hashCode();
    }
}
