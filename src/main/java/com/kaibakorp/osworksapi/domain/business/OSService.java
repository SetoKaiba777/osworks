package com.kaibakorp.osworksapi.domain.business;

import com.kaibakorp.osworksapi.api.rpmodel.CommentEntity;
import com.kaibakorp.osworksapi.domain.exception.DontFoundEntityException;
import com.kaibakorp.osworksapi.domain.model.ClienteEntity;
import com.kaibakorp.osworksapi.domain.model.OSEntity;
import com.kaibakorp.osworksapi.domain.enum_class.OSstatus;
import com.kaibakorp.osworksapi.domain.exception.ServiceException;
import com.kaibakorp.osworksapi.domain.persistence.ClienteRepository;
import com.kaibakorp.osworksapi.domain.persistence.CommentRepository;
import com.kaibakorp.osworksapi.domain.persistence.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;

@Transactional
@Service
public class OSService {
    @Autowired
    private OSRepository osRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CommentRepository commentRepository;

    public OSEntity addOS(OSEntity entity) {
        ClienteEntity cliente = clienteRepository.findById(entity.getCliente().getId()).orElseThrow(()->new ServiceException ("Invalid Id User, try again"));
        entity.setCliente(cliente);
        entity.setStatus(OSstatus.OPEN);
        entity.setOpenDate(OffsetDateTime.now());
        return osRepository.save(entity);
    }

    public void finish(Long osId){
            OSEntity os = osRepository.findById(osId).
                    orElseThrow(()-> new DontFoundEntityException("Id not found in database!"));
            os.finish();
            osRepository.save(os);
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
    public CommentEntity addCommentEntity(Long OSId, String description){

        OSEntity os = osRepository.findById(OSId).
                orElseThrow(()-> new DontFoundEntityException("Id not found in database!"));

        CommentEntity commenty = new CommentEntity();
        commenty.setSendDateTime(OffsetDateTime.now());
        commenty.setDescrption(description);
        commenty.setOs(os);
        return commentRepository.save(commenty);
    }
}
