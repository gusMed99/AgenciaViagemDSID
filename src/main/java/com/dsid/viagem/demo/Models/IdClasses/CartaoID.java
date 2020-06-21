package com.dsid.viagem.demo.Models.IdClasses;


import com.dsid.viagem.demo.Models.Entities.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@Getter
@Setter
public class CartaoID implements Serializable {
    String numeroCartao;
    Cliente cliente;

    @Override
    public int hashCode() {
        return Integer.parseInt(this.cliente.hashCode()+""+this.numeroCartao.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        CartaoID cartaoID=(CartaoID)o;
        return (cartaoID.cliente.equals(this.cliente) && cartaoID.numeroCartao.equals(this.numeroCartao));
    }
}
