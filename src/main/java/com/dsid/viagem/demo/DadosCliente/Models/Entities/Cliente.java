package com.dsid.viagem.demo.DadosCliente.Models.Entities;

import com.dsid.viagem.demo.DadosCliente.exceptions.CampoInvalidoException;
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

    @Column
    private String senha;

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

    public static class Builder{
        private String email;
        private String nome;
        private Date dataNascimento;
        private String nomeMae;
        private String cpf;
        private String senha;
        private List<TelefoneCliente> telefonesCliente;
        private List<Cartao> cartoesCliente;
        private List<Endereco> enderecosCliente;

        public Builder(String email) throws CampoInvalidoException {
            if(email!=null && (email.length()<4 || !email.contains("@") || !email.contains("."))) throw new CampoInvalidoException("email",email,"");
            this.email=email;
        }

        public Builder senha(String senha) throws CampoInvalidoException {
            if(senha!= null && senha.length()<8) throw new CampoInvalidoException("senha",senha,"Senha de conter pelo menos 8 caracteres");
            this.senha=senha;
            return this;
        }

        public Builder nome(String nome) throws CampoInvalidoException {
            if(nome.trim().length()<3 || !nome.chars().noneMatch(Character::isDigit)) throw new CampoInvalidoException("nome",nome,"");
            this.nome=nome;
            return this;
        }

        public Builder nomeMae(String nomeMae) throws CampoInvalidoException {
            if(nomeMae.trim().length()<3 || !nomeMae.chars().noneMatch(Character::isDigit)) throw new CampoInvalidoException("nomeMae",nomeMae,"");
            this.nomeMae=nomeMae;
            return this;
        }

        public Builder cpf(String cpf) throws CampoInvalidoException {
            if(cpf==null) return this;
            cpf=cpf.replace(".","");
            if((cpf.trim().length()!=11 || !(cpf.chars().allMatch(Character::isDigit)))) throw new CampoInvalidoException("cpf",cpf,"");
            this.cpf=cpf;
            return this;
        }

        public Builder dataNacimento(Date dataNascimento) throws CampoInvalidoException{
            if(dataNascimento==null) return this;
            if(dataNascimento.after(new Date())) throw new CampoInvalidoException("dataNascimento",dataNascimento.toString(),"Data de nascimento maior que a data atual");
            this.dataNascimento=dataNascimento;
            return this;
        }

        public Builder telefonesCliente(List<TelefoneCliente> telefoneClientes){
            this.telefonesCliente=telefoneClientes;
            return this;
        }

        public Builder enderecosCliente(List<Endereco> enderecosCliente){
            this.enderecosCliente=enderecosCliente;
            return this;
        }

        public Builder cartoesCliente(List<Cartao> cartoesCliente){
            this.cartoesCliente=cartoesCliente;
            return this;
        }

        public Cliente build() throws CampoInvalidoException {
            return new Cliente(this);
        }

    }

    private Cliente(Builder builder) throws CampoInvalidoException {
        if(builder.email==null) throw new CampoInvalidoException("email",email,"");
        if(builder.nome==null) throw new CampoInvalidoException("nome",nome,"");
        if(builder.cpf==null) throw new CampoInvalidoException("cpf",cpf,"");
        if(builder.dataNascimento==null) throw new CampoInvalidoException("dataNascimento",null,"");
        if(builder.senha==null) throw new CampoInvalidoException("senha",senha,"");
        if(builder.telefonesCliente==null) throw new CampoInvalidoException("telefonesCliente",null,"");
        this.email=builder.email;
        this.nome=builder.nome;
        this.cpf=builder.cpf;
        this.cartoesCliente=builder.cartoesCliente;
        this.dataNascimento=builder.dataNascimento;
        this.senha=builder.senha;
        this.enderecosCliente=builder.enderecosCliente;
        this.telefonesCliente=builder.telefonesCliente;
        this.nomeMae=builder.nomeMae;
    }
}
