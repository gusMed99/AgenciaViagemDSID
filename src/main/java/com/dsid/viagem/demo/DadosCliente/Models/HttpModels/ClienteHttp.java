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

    private void limpaListas(){
        if(this.cartoesCliente!=null){
            for(Cartao c: cartoesCliente){
                c.setCliente(null);
            }
        }
        if(this.enderecosCliente!=null){
            for(Endereco c: enderecosCliente){
                c.setCliente(null);
            }
        }
        if(this.telefonesCliente!=null){
            for(TelefoneCliente c: telefonesCliente){
                c.setCliente(null);
            }
        }
    }


}
