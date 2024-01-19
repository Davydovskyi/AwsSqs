package edu.jcourse.awsawq.repository;

import edu.jcourse.awsawq.entity.Notification;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface NotificationRepository extends R2dbcRepository<Notification, String> {
}