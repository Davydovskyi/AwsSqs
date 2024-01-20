package edu.jcourse.awsawq.rest;

import edu.jcourse.awsawq.dto.NotificationDto;
import edu.jcourse.awsawq.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/notifications")
public class NotificationRestControllerV2 {

    private final NotificationService notificationService;

    @GetMapping("/{uid}")
    public Mono<NotificationDto> findNotificationByUid(@PathVariable String uid) {
        return notificationService.findNotificationWithRecipientByUid(uid);
    }
}