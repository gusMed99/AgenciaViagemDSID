package com.dsid.viagem.demo.PackageBuilder.repository;

import com.dsid.viagem.demo.PackageBuilder.models.entities.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaInterfacePackage extends JpaRepository<PackageEntity,String> {
}
