package com.hive4bee.ansj;


import com.hive4bee.ansj.domain.Member;
import com.hive4bee.ansj.persistence.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
//@DataJpaTest
public class TestModule {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void test(){
        List<Member> list = memberRepository.findAll();
        list.forEach(System.out::println);
    }
}
