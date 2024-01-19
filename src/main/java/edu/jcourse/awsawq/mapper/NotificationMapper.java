package edu.jcourse.awsawq.mapper;

import edu.jcourse.awsawq.dto.NotificationDto;
import edu.jcourse.awsawq.entity.Notification;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    NotificationDto toDto(Notification notification);

    @InheritInverseConfiguration
    Notification toEntity(NotificationDto notificationDto);
}