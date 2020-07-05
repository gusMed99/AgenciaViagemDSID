package com.dsid.viagem.demo.PackageBuilder.repository;

import com.dsid.viagem.demo.PackageBuilder.models.entities.PackageEntity;

public interface PackagePersistence {
    public String savePackage(PackageEntity packageEntity);
    public PackageEntity getPackages(String cpfCliente);
}
