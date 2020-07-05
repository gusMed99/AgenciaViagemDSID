package com.dsid.viagem.demo.PackageBuilder.repository;

import com.dsid.viagem.demo.PackageBuilder.models.entities.PackageEntity;

import java.util.List;

public interface PackagePersistence {
    public String savePackage(PackageEntity packageEntity);
    public List<PackageEntity> getPackages(String idCliente);
}
