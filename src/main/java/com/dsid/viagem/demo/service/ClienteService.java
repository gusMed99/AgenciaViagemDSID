package com.dsid.viagem.demo.service;

import com.dsid.viagem.demo.Models.Entities.Cliente;
import com.dsid.viagem.demo.Models.HttpModels.ClienteHttp;
import com.dsid.viagem.demo.exceptions.CampoInvalidoException;
import com.dsid.viagem.demo.repository.PersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
