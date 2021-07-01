package com.hive4bee.ansj;

import com.hive4bee.ansj.domain.Member;
import com.hive4bee.ansj.persistence.BoardRepository;
import com.hive4bee.ansj.persistence.MemberRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootTest
@RunWith(SpringRunner.class)
@Log
public class JpaQueryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository repo;

    @Test
    public void test(){
        repo.list().forEach(item->log.info(item+""));
    }

    @Test
    public void test2(){
        IntStream.range(1, 200).forEach(i ->{
            Member member = new Member();
            member.setUid("uid"+i);
            member.setUname("name"+i);
            member.setUpw("pw"+i);
            memberRepository.save(member);
        });
    }
}
