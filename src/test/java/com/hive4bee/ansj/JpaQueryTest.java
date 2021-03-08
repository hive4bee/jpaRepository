package com.hive4bee.ansj;

import com.hive4bee.ansj.persistence.BoardRepository;
import com.hive4bee.ansj.persistence.BoardRepositoryImpl;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Log
public class JpaQueryTest {

    @Autowired
    private BoardRepository repo;

//    @Autowired
//    private BoardRepositoryImpl repo2;

    @Test
    public void test(){
        repo.list().forEach(item->log.info(item+""));
    }

    @Test
    public void test2(){

    }
}
