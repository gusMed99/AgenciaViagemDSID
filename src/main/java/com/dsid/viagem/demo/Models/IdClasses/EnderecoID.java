package com.dsid.viagem.demo.Models.IdClasses;

import com.dsid.viagem.demo.Models.Entities.Cliente;
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
    private String cep;

    @Override
    public boolean equals(Object o) {
        EnderecoID id= (EnderecoID)o;
        if(cliente.equals(this.cliente) && id.cep==this.cep) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.cep.hashCode()+""+this.cliente.getEmail().hashCode());
    }


}
