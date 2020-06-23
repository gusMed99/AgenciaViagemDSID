package com.dsid.viagem.demo.DadosCliente.Models.IdClasses;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnderecoID implements Serializable {
    private Cliente cliente;
    private String idEndereco;


    @Override
    public boolean equals(Object o) {
        EnderecoID id= (EnderecoID)o;
        if(cliente.equals(this.cliente) && id.idEndereco==this.idEndereco) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.idEndereco.hashCode()+""+this.cliente.getEmail().hashCode());
    }


}
