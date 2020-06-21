package com.dsid.viagem.demo.Models.Entities;


import com.dsid.viagem.demo.Models.IdClasses.EnderecoID;
import com.dsid.viagem.demo.exceptions.CampoInvalidoException;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
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

    private Endereco(Builder builder) throws CampoInvalidoException {
        if(builder.cliente==null) throw new CampoInvalidoException("cliente","","");
        if(builder.cep==null) throw new CampoInvalidoException("cep",cep,"Preencha o cep");
        if(builder.numero==null) throw new CampoInvalidoException("numero"," ","Preecnha o numero");
        this.cliente=builder.cliente;
        this.cep=builder.cep;
        this.numero=builder.numero;
    }

    public static class Builder{

        private String cep;

        private Integer numero;


        private Cliente cliente;

        public Builder(Cliente cliente){
            this.cliente=cliente;
        }

        public Builder numero(Integer numero){
            this.numero=numero;
            return this;
        }

        public Builder cep(String cep) throws CampoInvalidoException{
            if(cep==null) return this;
            cep=cep.replace(".","").replace("-","").trim();
            if(cep.length()!=8 || !cep.chars().allMatch(Character::isDigit)) throw new CampoInvalidoException("cep",cep,"");
            this.cep=cep;
            return this;
        }

        public Endereco build() throws CampoInvalidoException {
            return new Endereco(this);
        }
    }
}
