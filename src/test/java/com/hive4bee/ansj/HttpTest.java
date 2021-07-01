package com.hive4bee.ansj;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HttpTest {

    @Autowired
    private HttpService httpService;

    @Test
    public void httpGetTest(){
        httpService.get("https://jsonplaceholder.typicode.com/users");
//        httpService.get("https://nowon2.gdnet.co.kr/api/external_ese?access_token=fccc8185-8e44-4f88-b22e-c80b364ab596");
    }
}
