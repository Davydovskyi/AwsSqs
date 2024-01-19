package edu.jcourse.awsawq.mapper;

import edu.jcourse.awsawq.dto.RecipientDto;
import edu.jcourse.awsawq.entity.Recipient;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipientMapper {

    RecipientDto toDto(Recipient recipient);

    @InheritInverseConfiguration
    Recipient toEntity(RecipientDto recipientDto);
}