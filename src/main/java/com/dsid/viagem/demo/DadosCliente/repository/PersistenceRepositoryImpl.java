package com.dsid.viagem.demo.DadosCliente.repository;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersistenceRepositoryImpl implements PersistenceRepository {

    @Autowired
    JpaInterface jpaInterface;

    @Override
    public boolean insertData(Cliente cliente) {
        if(this.clienteExiste(cliente)) return false;
        this.populaLists(cliente);
        jpaInterface.save(cliente);
        return true;
    }

    private boolean clienteExiste(Cliente cliente){
        return jpaInterface.existsById(cliente.getEmail());
    }

    private void populaLists(Cliente cliente){
        if(cliente.getEnderecosCliente()!=null){
            for(Endereco e: cliente.getEnderecosCliente()){
                e.setCliente(cliente);
            }
        }
        if(cliente.getTelefonesCliente()!=null){
            for(TelefoneCliente telefoneCliente: cliente.getTelefonesCliente()){
                telefoneCliente.setCliente(cliente);
            }
        }
        if(cliente.getCartoesCliente()!=null){
            for(Cartao cartao: cliente.getCartoesCliente()){
                cartao.setCliente(cliente);
            }
        }

    }

    @Override
    public boolean deleteData(Cliente cliente) {
        return false;
    }

    @Override
    public Cliente getEntity(String email) {
        List<Cliente> clienteList= jpaInterface.clientsByEmail(email);
        if(clienteList.size()>0) return clienteList.get(0);
        return null;
    }

    @Override
    public boolean updateEntity(Cliente cliente) {
        return false;
    }
}
