package com.hive4bee.ansj.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@ToString(exclude="board")
@Entity
@Table(name="tbl_webreplies")
@EqualsAndHashCode(of="rno")
@NoArgsConstructor
@AllArgsConstructor
public class WebReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;
    private String replyText;
    private String replyer;

    @CreationTimestamp
    private LocalDateTime regdate;
    @UpdateTimestamp
    private LocalDateTime updatedate;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    private WebBoard board;

    public WebReply(Long rno, String replyText, String replyer, LocalDateTime regdate, LocalDateTime updatedate) {
        this.rno = rno;
        this.replyText = replyText;
        this.replyer = replyer;
        this.regdate = regdate;
        this.updatedate = updatedate;
    }
}