package com.dsid.viagem.demo.PackageBuilder.repository;

import com.dsid.viagem.demo.PackageBuilder.models.entities.PackageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PackagePersistenceImpl implements PackagePersistence {

    @Autowired
    private JpaInterfacePackage jpaInterfacePackage;

    @Override
    public String savePackage(PackageEntity packageEntity) {
        PackageEntity entity=jpaInterfacePackage.save(packageEntity);
        return entity.getPackageId();
    }

    @Override
    public List<PackageEntity> getPackages(String idCliente) {
        return this.jpaInterfacePackage.getPackagesByClient(idCliente);
    }
}
