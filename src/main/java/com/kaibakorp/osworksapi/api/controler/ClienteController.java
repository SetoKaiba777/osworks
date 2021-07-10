package com.kaibakorp.osworksapi.api.controler;

import com.kaibakorp.osworksapi.api.rpmodel.ClienteEntityInput;
import com.kaibakorp.osworksapi.api.rpmodel.ClienteRp;
import com.kaibakorp.osworksapi.api.rpmodel.OSRp;
import com.kaibakorp.osworksapi.domain.business.ClienteService;
import com.kaibakorp.osworksapi.domain.model.ClienteEntity;
import com.kaibakorp.osworksapi.domain.model.OSEntity;
import com.kaibakorp.osworksapi.domain.persistence.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteRp> listar(){
        return toColllectionRp(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteRp> buscar(Long id) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            ClienteRp clienteRp = toModel(cliente.get());
            return ResponseEntity.ok(clienteRp);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteRp add(@Valid @RequestBody ClienteEntityInput clienteInput){
        ClienteEntity cliente = toEntity(clienteInput);
        return toModel(clienteService.addCliente(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> update(@PathVariable Long id,@Valid  @RequestBody ClienteEntity cliente){
        return clienteService.atualizarCliente(id,cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return clienteService.removerCliente(id);
    }

    private ClienteRp toModel(ClienteEntity cliente){
        return modelMapper.map(cliente,ClienteRp.class);
    }

    private ClienteEntity toEntity(ClienteEntityInput cliente){
        return modelMapper.map(cliente,ClienteEntity.class);
    }

    private List<ClienteRp> toColllectionRp(List<ClienteEntity> clientes){
        return clientes.stream()
                .map(cliente -> toModel(cliente))
                .collect(Collectors.toList());
    }
}
