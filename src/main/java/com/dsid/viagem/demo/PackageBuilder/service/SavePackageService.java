package com.dsid.viagem.demo.PackageBuilder.service;

import com.dsid.viagem.demo.DadosCliente.Models.Entities.Cliente;
import com.dsid.viagem.demo.DadosCliente.repository.PersistenceRepository;
import com.dsid.viagem.demo.PackageBuilder.models.Package;
import com.dsid.viagem.demo.PackageBuilder.models.entities.PackageEntity;
import com.dsid.viagem.demo.PackageBuilder.repository.PackagePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavePackageService {

    @Autowired
    private PackagePersistence packagePersistence;

    @Autowired
    private PersistenceRepository dadosCliente;

    public String savePackage(Package pacote, String cpf,String checkin) throws Exception {
        Cliente cliente=this.dadosCliente.getEntityByCpf(cpf);
        if(cliente==null) throw new Exception("Cliente nao cadastrado");
        PackageEntity packageEntity= new PackageEntity(pacote,cliente,checkin);
        return this.packagePersistence.savePackage(packageEntity);
    }

    public List<PackageEntity> getHistorical(String cpf) throws Exception {
        Cliente cliente= this.dadosCliente.getEntityByCpf(cpf);
        if(cliente==null) throw new Exception("Cliente nao cadastrado");
        List<PackageEntity> packageEntityList =packagePersistence.getPackages(cliente.getIdCliente());
        for(PackageEntity packageEntity: packageEntityList){
            packageEntity.setCliente(null);
        }
        return packageEntityList;
    }
}
