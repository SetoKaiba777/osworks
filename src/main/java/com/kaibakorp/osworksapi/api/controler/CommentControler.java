package com.kaibakorp.osworksapi.api.controler;

import com.kaibakorp.osworksapi.api.rpmodel.CommentEntity;
import com.kaibakorp.osworksapi.api.rpmodel.CommentInput;
import com.kaibakorp.osworksapi.api.rpmodel.CommentRp;
import com.kaibakorp.osworksapi.domain.business.OSService;
import com.kaibakorp.osworksapi.domain.exception.DontFoundEntityException;
import com.kaibakorp.osworksapi.domain.model.OSEntity;
import com.kaibakorp.osworksapi.domain.persistence.OSRepository;
import io.micronaut.http.annotation.Post;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/os/{id}/comments")
public class CommentControler {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OSService osService;

    @Autowired
    private OSRepository osRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentRp addComment(@PathVariable Long id, @Valid @RequestBody CommentInput commentInput){
        CommentEntity comment = osService.addCommentEntity(id,commentInput.getDescrption());
        return toModel(comment);
    }

    @GetMapping
    public List<CommentRp> listar(@PathVariable Long id){
        OSEntity os = osRepository.findById(id).orElseThrow(()->new DontFoundEntityException("Don't found this Service Order"));
        return toCollectionModel(os.getComments());
    }


    private CommentRp toModel(CommentEntity comment){
        return modelMapper.map(comment, CommentRp.class);
    }

    private List<CommentRp> toCollectionModel(List<CommentEntity> comment){
        return comment.stream()
                .map(commentEntity -> toModel(commentEntity))
                .collect(Collectors.toList());
    }
}
