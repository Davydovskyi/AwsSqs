package edu.jcourse.awsawq.service;

import edu.jcourse.awsawq.dto.NotificationDto;
import edu.jcourse.awsawq.mapper.NotificationMapper;
import edu.jcourse.awsawq.repository.NotificationRepository;
import edu.jcourse.awsawq.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final RecipientRepository recipientRepository;
    private final NotificationMapper notificationMapper;

    public Mono<NotificationDto> findNotificationByUid(String uid) {
        return notificationRepository.findById(uid)
                .map(notificationMapper::toDto);
    }

    public Mono<NotificationDto> findNotificationWithRecipientByUid(String uid) {
        return notificationRepository.findById(uid)
                .flatMap(notification -> recipientRepository.findById(notification.getRecipientUid())
                        .map(recipient -> {
                            notification.setRecipient(recipient);
                            return notificationMapper.toDto(notification);
                        }));
    }
}