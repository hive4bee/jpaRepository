package com.hive4bee.ansj.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name="tbl_members")
@EqualsAndHashCode(of="uid")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    private String uid;
    private String upw;
    private String uname;

    @CreationTimestamp
    private Timestamp regdate;
    @UpdateTimestamp
    private Timestamp updatedate;
}