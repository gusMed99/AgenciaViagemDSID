package com.dsid.viagem.demo.Controller;

import com.dsid.viagem.demo.PackageBuilder.models.Package;
import com.dsid.viagem.demo.PackageBuilder.service.SavePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComprasController {

    @Autowired
    private SavePackageService savePackageService;


    @PostMapping(path="/comprar",consumes = "application/json", produces = "application/json")
    public String comprarPacote(@RequestBody Package pacote, @RequestParam(required = true) String cpf) throws Exception {
        return this.savePackageService.savePackage(pacote,cpf);
    }
}
