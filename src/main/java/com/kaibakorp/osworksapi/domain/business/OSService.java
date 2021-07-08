package com.kaibakorp.osworksapi.domain.business;

import com.kaibakorp.osworksapi.domain.entity.ClienteEntity;
import com.kaibakorp.osworksapi.domain.entity.OSEntity;
import com.kaibakorp.osworksapi.domain.entity.OSstatus;
import com.kaibakorp.osworksapi.domain.exception.ServiceException;
import com.kaibakorp.osworksapi.domain.persistence.ClienteRepository;
import com.kaibakorp.osworksapi.domain.persistence.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Optional;

@Transactional
@Service
public class OSService {
    @Autowired
    private OSRepository osRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public OSEntity addOS(OSEntity entity) {
        ClienteEntity cliente = clienteRepository.findById(entity.getCliente().getId()).orElseThrow(()->new ServiceException ("Invalid Id User, try again"));
        entity.setCliente(cliente);
        entity.setStatus(OSstatus.OPEN);
        entity.setOpenDate(OffsetDateTime.now());
        return osRepository.save(entity);
    }

    public ResponseEntity<OSEntity> buscarOS(Long id) {
        Optional<OSEntity> os = osRepository.findById(id);
        if(os.isPresent()){
            return ResponseEntity.ok(os.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<OSEntity> atualizarOS(Long id, OSEntity os) {
        if (!clienteRepository.existsById(id))
            return ResponseEntity.notFound().build();
        os.setId(id);
        os = osRepository.save(os);
        return ResponseEntity.ok(os);
    }
    public ResponseEntity<Void> removerOS(Long id){
        if (!osRepository.existsById(id))
            return ResponseEntity.notFound().build();
        osRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
