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
@RequestMapping("/api/v1/notifications")
public class NotificationRestControllerV1 {

    private final NotificationService notificationService;

    @GetMapping("/{uid}")
    public Mono<NotificationDto> findNotificationByUid(@PathVariable String uid) {
        return notificationService.findNotificationByUid(uid);
    }
}