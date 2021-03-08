package com.hive4bee.ansj.persistence;

import com.hive4bee.ansj.domain.WebBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<WebBoard, Long>, CustomBoard {

}
