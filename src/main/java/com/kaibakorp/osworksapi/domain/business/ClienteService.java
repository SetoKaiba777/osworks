package com.kaibakorp.osworksapi.domain.business;
import com.kaibakorp.osworksapi.domain.model.ClienteEntity;
import com.kaibakorp.osworksapi.domain.exception.ServiceException;
import com.kaibakorp.osworksapi.domain.persistence.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity addCliente(ClienteEntity entity) {
        ClienteEntity clienteExisits = clienteRepository.findByEmail(entity.getEmail());
        if(clienteExisits!= null && !clienteExisits.equals(entity)){
            throw new ServiceException("This email is already registered");
        }
        return clienteRepository.save(entity);
    }

    public ResponseEntity<ClienteEntity> atualizarCliente(Long id, ClienteEntity cliente) {
        if (!clienteRepository.existsById(id))
            return ResponseEntity.notFound().build();
        cliente.setId(id);
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }
    public ResponseEntity<Void> removerCliente(Long id){
        if (!clienteRepository.existsById(id))
            return ResponseEntity.notFound().build();
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
