package edu.jcourse.awsawq.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.StringUtils;

import java.util.List;

@Data
@ToString(exclude = {"notifications"})
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table("recipients")
public class Recipient implements Persistable<String> {

    @Id
    private String id;
    @Column("channel")
    private String channel;
    @Column("address")
    private String address;
    @Column("full_name")
    private String fullName;

    @Transient
    private List<Notification> notifications;

    @Override
    public boolean isNew() {
        return !StringUtils.hasText(id);
    }
}
