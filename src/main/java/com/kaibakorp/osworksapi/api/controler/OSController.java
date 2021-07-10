package com.kaibakorp.osworksapi.api.controler;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.kaibakorp.osworksapi.api.rpmodel.OSInput;
import com.kaibakorp.osworksapi.api.rpmodel.OSRp;
import com.kaibakorp.osworksapi.domain.business.OSService;
import com.kaibakorp.osworksapi.domain.model.OSEntity;
import com.kaibakorp.osworksapi.domain.persistence.OSRepository;
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
@RequestMapping("/os")
public class OSController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OSRepository osRepository;
    @Autowired
    private OSService osService;

    @GetMapping
    public List<OSRp> list(){
        return toColllectionRp(osRepository.findAll());
    }

    @GetMapping("/{id}")
        public ResponseEntity<OSRp> buscarId(@PathVariable Long id) {
        Optional<OSEntity> os = osRepository.findById(id);
        if (os.isPresent()) {
            OSRp osRp = toModel(os.get());
            return ResponseEntity.ok(osRp);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OSRp addOS(@Valid @RequestBody OSInput osi){
        OSEntity os = toEntity(osi);
        return toModel(osService.addOS(os));
    }

    @PutMapping
    public ResponseEntity<OSEntity> updateOs(Long id, @Valid @RequestBody OSEntity os){
        return osService.atualizarOS(id,os);
    }

    @PostMapping("/{id}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finish(@PathVariable Long id){
        osService.finish(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id){
        return osService.removerOS(id);
    }

    private OSRp toModel(OSEntity os){
        return modelMapper.map(os,OSRp.class);
    }
    private  OSEntity toEntity(OSInput osi){
        return modelMapper.map(osi, OSEntity.class);

    }

    private List<OSRp> toColllectionRp(List<OSEntity> oss){
        return oss.stream()
                .map(os -> toModel(os))
                .collect(Collectors.toList());
    }
}
