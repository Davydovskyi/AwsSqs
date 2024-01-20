package edu.jcourse.awsawq.poller;

import edu.jcourse.awsawq.dto.NotificationDto;
import edu.jcourse.awsawq.entity.Notification;
import edu.jcourse.awsawq.mapper.NotificationMapper;
import edu.jcourse.awsawq.repository.NotificationRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationsSQSPoller {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @SqsListener(value = "${sqs.notifications.queue.name}")
    public void receiveMessages(@Payload NotificationDto message) {
        log.info("Received message: {}", message);
        Notification notification = notificationMapper.toEntity(message);
        notificationRepository.save(notification).subscribe();
    }
}