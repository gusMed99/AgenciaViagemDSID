package com.dsid.viagem.demo.DadosCliente.Models.IdClasses;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@Setter
@Getter
public class TelefoneClienteId implements Serializable {
   String telefone;
   String ddd;
   Cliente cliente;

    @Override
    public boolean equals(Object o) {
        TelefoneClienteId t=(TelefoneClienteId)o;
        return(t.ddd.equals(this.ddd) && t.telefone.equals(this.telefone) && this.cliente.equals(t.cliente));
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.cliente.hashCode()+""+this.telefone.hashCode()+""+this.ddd.hashCode());
    }
}
