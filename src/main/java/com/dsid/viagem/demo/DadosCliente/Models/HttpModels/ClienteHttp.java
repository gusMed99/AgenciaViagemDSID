package com.dsid.viagem.demo.DadosCliente.Models.HttpModels;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cartao;
import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cliente;
import com.dsid.viagem.demo.DadosCliente.Models.Entities.Endereco;
import com.dsid.viagem.demo.DadosCliente.Models.Entities.TelefoneCliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClienteHttp {

    private String email;

    private String nome;

    private Date dataNascimento;

    private String nomeMae;

    private String cpf;


    private String senha;


    private List<TelefoneCliente> telefonesCliente;



    private List<Cartao> cartoesCliente;



    private List<Endereco> enderecosCliente;

    public ClienteHttp(Cliente cliente){
        this.email=cliente.getEmail();
        this.dataNascimento=cliente.getDataNascimento();
        this.nome=cliente.getNome();
        this.nomeMae=cliente.getNomeMae();
        this.cpf=cliente.getCpf();

        this.cartoesCliente=cliente.getCartoesCliente();
        this.enderecosCliente=cliente.getEnderecosCliente();
        this.telefonesCliente=cliente.getTelefonesCliente();
        this.limpaListas();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<TelefoneCliente> getTelefonesCliente() {
        return telefonesCliente;
    }

    public void setTelefonesCliente(List<TelefoneCliente> telefonesCliente) {
        this.telefonesCliente = telefonesCliente;
    }

    public List<Cartao> getCartoesCliente() {
        return cartoesCliente;
    }

    public void setCartoesCliente(List<Cartao> cartoesCliente) {
        this.cartoesCliente = cartoesCliente;
    }

    public List<Endereco> getEnderecosCliente() {
        return enderecosCliente;
    }

    public void setEnderecosCliente(List<Endereco> enderecosCliente) {
        this.enderecosCliente = enderecosCliente;
    }

    private void limpaListas(){
        if(this.cartoesCliente!=null){
            for(Cartao c: cartoesCliente){
                c.setCliente(null);
            }
        }
        if(this.enderecosCliente!=null){
            for(Endereco c: enderecosCliente){
                c.setCliente(null);
                c.setIdEndereco(null);
            }
        }
        if(this.telefonesCliente!=null){
            for(TelefoneCliente c: telefonesCliente){
                c.setCliente(null);
                c.setIdTelefone(null);
            }
        }
    }


}
