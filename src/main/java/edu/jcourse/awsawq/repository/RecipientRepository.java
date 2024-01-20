package edu.jcourse.awsawq.repository;

import edu.jcourse.awsawq.entity.Recipient;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface RecipientRepository extends R2dbcRepository<Recipient, String> {
}