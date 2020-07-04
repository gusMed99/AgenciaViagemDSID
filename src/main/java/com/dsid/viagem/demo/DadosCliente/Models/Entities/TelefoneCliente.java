package com.dsid.viagem.demo.DadosCliente.Models.Entities;

import com.dsid.viagem.demo.DadosCliente.Models.IdClasses.TelefoneClienteId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
//@IdClass(TelefoneClienteId.class)
@Entity
@Table(name="telefone",uniqueConstraints = @UniqueConstraint(columnNames = {"telefone", "idCliente","ddd"}))
public class TelefoneCliente extends ChildTableEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String idTelefone;


    @Column(nullable = false, length = 12)
    String telefone;

    @Column(nullable = false, length = 3)
    String ddd;


    @ManyToOne
    @JoinColumn(name = "idCliente")
    Cliente cliente;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(String idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
