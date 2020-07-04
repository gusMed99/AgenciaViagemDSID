package com.dsid.viagem.demo.DadosCliente.Models.Entities;


import com.dsid.viagem.demo.DadosCliente.Models.IdClasses.EnderecoID;
import com.dsid.viagem.demo.DadosCliente.exceptions.CampoInvalidoException;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Getter
@Entity
@Table(name="endereco", uniqueConstraints = @UniqueConstraint(columnNames = {"cep", "idCliente","numero","complemento"}))
//@Table(name = "endereco")
//@IdClass(EnderecoID.class)
@Setter
public class Endereco extends ChildTableEntity {


    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String idEndereco;

    @Column(length = 8)
    private String cep;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = true)
    private String complemento;


    @ManyToOne
    @JoinColumn(name = "idCliente")
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

    public String getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(String idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cliente getCliente() {
        return cliente;
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
