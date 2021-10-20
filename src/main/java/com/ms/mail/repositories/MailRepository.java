package com.ms.mail.repositories;

import com.ms.mail.models.MailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<MailModel, Long> {

}
