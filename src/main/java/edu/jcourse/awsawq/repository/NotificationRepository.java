package edu.jcourse.awsawq.repository;

import edu.jcourse.awsawq.entity.Notification;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface NotificationRepository extends R2dbcRepository<Notification, String> {

    Flux<Notification> findAllByRecipientUid(String recipientUid);
}