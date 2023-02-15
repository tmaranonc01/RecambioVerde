package com.example.rv3.controller;

import com.example.rv3.domain.Pieza;
import com.example.rv3.payload.response.Response;
import com.example.rv3.service.PiezaService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class PiezaController {

    PiezaService piezaService;

    @GetMapping("/piezas")
    public ResponseEntity<Page<Pieza>>
    listaPiezas(@PageableDefault(size = 10, page = 0) Pageable pageable, @SearchSpec Specification<Pieza> specs){
        Page<Pieza> piezas = piezaService.getPiezas(pageable,specs);
        if (pageable.getPageNumber() > piezas.getTotalPages()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(piezas,HttpStatus.OK);
    }

    @GetMapping("/piezas/{id}")
    public ResponseEntity<Pieza> findById(@PathVariable Long id){
        Optional<Pieza> pieza = piezaService.findById(id);
        return new ResponseEntity<>(pieza.get(), HttpStatus.OK);
    }

    @DeleteMapping("/piezas/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Response> deletePieza(@PathVariable Long id){
        piezaService.deleteById(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @PutMapping("/piezas/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Pieza> updateById(@RequestBody Pieza nuevaPieza){
        Pieza pieza = new ModelMapper().map(nuevaPieza,Pieza.class);
        piezaService.updateById(nuevaPieza, nuevaPieza.getId());
        return new ResponseEntity<>(pieza, HttpStatus.OK);
    }
}
