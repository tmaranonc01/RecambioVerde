package com.example.rv3.controller;

import com.example.rv3.domain.Pedido;
import com.example.rv3.service.PedidoService;
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
public class PedidoController {

    PedidoService pedidoService;

    @GetMapping("/pedidos")
    public ResponseEntity<Page<Pedido>>
    listaPedidos(@PageableDefault(size = 10, page = 0) Pageable pageable, @SearchSpec Specification<Pedido> specs){
        Page<Pedido> pedidos = pedidoService.getPedidos(pageable, specs);
        if (pageable.getPageNumber() > pedidos.getTotalPages()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pedidos,HttpStatus.OK);
    }
}
