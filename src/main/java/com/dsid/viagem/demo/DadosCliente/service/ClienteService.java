package com.dsid.viagem.demo.DadosCliente.service;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cliente;
import com.dsid.viagem.demo.DadosCliente.Models.HttpModels.ClienteHttp;
import com.dsid.viagem.demo.DadosCliente.exceptions.CampoInvalidoException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends AbstractService{



    public boolean cadastraCliente(ClienteHttp clienteHttp) throws CampoInvalidoException {
        Cliente cliente= new Cliente.Builder(clienteHttp.getEmail()).
                nome(clienteHttp.getNome()).
                nomeMae(clienteHttp.getNomeMae()).
                cpf(clienteHttp.getCpf()).
                senha(clienteHttp.getSenha()).
                dataNacimento(clienteHttp.getDataNascimento()).
                telefonesCliente(clienteHttp.getTelefonesCliente()).
                cartoesCliente(clienteHttp.getCartoesCliente()).
                enderecosCliente(clienteHttp.getEnderecosCliente()).
                build();
        return repository.insertData(cliente);
    }

    public ClienteHttp loginCliente(ClienteHttp request){
        Cliente cliente= repository.getEntity(request.getEmail());
        if(cliente!=null && cliente.getSenha().equals(request.getSenha())){
            cliente.setSenha(null);
            return new ClienteHttp(cliente);
        }
        else{
            return null;
        }
    }
}
