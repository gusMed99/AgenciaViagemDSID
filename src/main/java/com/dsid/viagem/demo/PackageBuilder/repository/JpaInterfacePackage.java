package com.dsid.viagem.demo.PackageBuilder.repository;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cliente;
import com.dsid.viagem.demo.PackageBuilder.models.Package;
import com.dsid.viagem.demo.PackageBuilder.models.entities.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaInterfacePackage extends JpaRepository<PackageEntity,String> {
    @Query(value = "SELECT * FROM package WHERE cliente_id_cliente = :idCliente", nativeQuery = true)
    List<PackageEntity> getPackagesByClient(@Param("idCliente") String idCliente);
}
