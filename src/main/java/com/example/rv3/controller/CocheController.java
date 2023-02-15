package com.example.rv3.controller;

import com.example.rv3.domain.Coche;
import com.example.rv3.service.CocheService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class CocheController {

    CocheService cocheService;

    @GetMapping("/coches")
    public ResponseEntity<Page<Coche>>
    listaCoches(@PageableDefault(size = 10, page = 0) Pageable pageable, @SearchSpec Specification<Coche> specs){
        Page<Coche> coches = cocheService.getCoches(pageable,specs);
        if(pageable.getPageNumber() > coches.getTotalPages()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(coches, HttpStatus.OK);
    }
}
