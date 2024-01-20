package edu.jcourse.awsawq.service;

import edu.jcourse.awsawq.dto.RecipientDto;
import edu.jcourse.awsawq.entity.Recipient;
import edu.jcourse.awsawq.mapper.RecipientMapper;
import edu.jcourse.awsawq.repository.NotificationRepository;
import edu.jcourse.awsawq.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RecipientService {

    private final RecipientRepository recipientRepository;
    private final NotificationRepository notificationRepository;
    private final RecipientMapper recipientMapper;

    public Mono<RecipientDto> findRecipientByUid(String uid) {
        return Mono.zip(recipientRepository.findById(uid),
                        notificationRepository.findAllByRecipientUid(uid).collectList())
                .map(tuple -> {
                    Recipient recipient = tuple.getT1();
                    recipient.setNotifications(tuple.getT2());
                    return recipientMapper.toDto(recipient);
                });
    }
}