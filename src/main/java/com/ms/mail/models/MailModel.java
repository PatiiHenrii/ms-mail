package com.ms.mail.models;

import com.ms.mail.enums.StatusMail;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_MAIL")
public class MailModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mailId;
    private String ownerRef;
    private String mailFrom;
    private String mailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateMail;
    private StatusMail statusMail;
}


