package com.nocountry.grupo10.controller;

import com.nocountry.grupo10.DTO.Request.FixedTermAccount;
import com.nocountry.grupo10.model.entity.AppUser;
import com.nocountry.grupo10.service.FixedTermAccountInterface;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/fixedTermAccount")
public class FixedTermAccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixedTermAccountController.class);

    @Autowired
    FixedTermAccountInterface service;

    @Autowired
    AppUser client;

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> toList() {
//        return new ResponseEntity<>(FixedTermAccountInterface.toList(), HttpStatus.OK);
//
//    }

        @GetMapping("/{id}")
        public ResponseEntity<?> search
        (@PathVariable
        String id
        
            ) {
		
		return service.findByDni(id).map(s -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(s))
                    .defaultIfEmpty(ResponseEntity.notFound().build());

        }

        @PostMapping
        public ResponseEntity<?> save
        (@RequestBody
        AccountDto accountDto
        
            ) {
		
		LOGGER.info("accountDto ---> " + accountDto.toString());

            return service.save(accountDto)
                    .map(s -> ResponseEntity.created(URI.create("/api/fixedTermAccount".concat(s.getId())))
                    .contentType(MediaType.APPLICATION_JSON).body(s))
                    .defaultIfEmpty(new ResponseEntity<FixedTermAccount>(HttpStatus.NOT_FOUND));

        }

        @PutMapping("/{id}")
        public ResponseEntity<?> update
        (@RequestBody
        FixedTermAccount FixedTermAccount,
                
        @PathVariable String id
        
            ) {
		
		
		LOGGER.info("Controller ----> " + FixedTermAccount.toString());

            return service.update(FixedTermAccount, id)
                    .map(s -> ResponseEntity.created(URI.create("/api/fixedTermAccount".concat(s.getId())))
                    .contentType(MediaType.APPLICATION_JSON).body(s))
                    .defaultIfEmpty(ResponseEntity.notFound().build());

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete
        (@PathVariable
        String id
        
            ) {

		return service.findById(id).flatMap(s -> {
                return service.delete(s).then(Mono.just(new ResponseEntity<Void>(HttpStatus.ACCEPTED)));
            }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));

        }

        //OPERACIONES QUE CONSUMEN SERVICIO
        @GetMapping("/dni/{dni}")
        public FixedTermAccount searchByDni
        (@PathVariable
        String dni
        
            ) {
				
		return service.findByDni(id);

        }

        @GetMapping("/account/{numberAccount}")
        public ResponseEntity<FixedTermAccount> searchByNumAccount
        (@PathVariable
        String numberAccount
        
            ) {
		
		LOGGER.info("NUMERO DE CUENTA :--->" + numberAccount);

            return service.findByNumAccount(numberAccount).map(s -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(s))
                    .defaultIfEmpty(ResponseEntity.notFound().build());

        }
    }
