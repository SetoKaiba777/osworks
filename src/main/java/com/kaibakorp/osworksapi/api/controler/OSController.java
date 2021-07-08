package com.kaibakorp.osworksapi.api.controler;

import com.kaibakorp.osworksapi.domain.business.OSService;
import com.kaibakorp.osworksapi.domain.entity.OSEntity;
import com.kaibakorp.osworksapi.domain.persistence.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/os")
public class OSController {

    @Autowired
    private OSRepository osRepository;
    @Autowired
    private OSService osService;

    @GetMapping
    public List<OSEntity> list(){
        return osRepository.findAll();
    }

    @GetMapping("/{id}")
        public ResponseEntity<OSEntity> buscar(@PathVariable Long id){
            return osService.buscarOS(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public OSEntity addOS(@Valid @RequestBody OSEntity os){
        return osService.addOS(os);
    }

    @PutMapping
    public ResponseEntity<OSEntity> updateOs(Long id, @Valid @RequestBody OSEntity os){
        return osService.atualizarOS(id,os);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(Long id){
        return osService.removerOS(id);
    }
}
