package edu.jcourse.awsawq.rest;

import edu.jcourse.awsawq.dto.RecipientDto;
import edu.jcourse.awsawq.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recipients")
public class RecipientRestControllerV1 {

    private final RecipientService recipientService;

    @GetMapping("/{uid}")
    public Mono<RecipientDto> findRecipientByUid(@PathVariable String uid) {
        return recipientService.findRecipientByUid(uid);
    }
}