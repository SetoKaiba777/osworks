package com.kaibakorp.osworksapi.controler;

import com.kaibakorp.osworksapi.business.ClienteService;
import com.kaibakorp.osworksapi.entity.ClienteEntity;
import com.kaibakorp.osworksapi.persistence.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteEntity> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> buscar(@PathVariable Long id){
        return clienteService.buscarCliente(id);
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteEntity add(@Valid @RequestBody ClienteEntity cliente){
        return clienteService.addCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> update(@PathVariable Long id,@Valid  @RequestBody ClienteEntity cliente){
        return clienteService.atualizarCliente(id,cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return clienteService.removerCliente(id);
    }
}
