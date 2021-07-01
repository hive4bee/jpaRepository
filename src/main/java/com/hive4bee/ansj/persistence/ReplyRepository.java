package com.hive4bee.ansj.persistence;

import com.hive4bee.ansj.domain.WebReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ReplyRepository extends JpaRepository<WebReply, Long> {
}
