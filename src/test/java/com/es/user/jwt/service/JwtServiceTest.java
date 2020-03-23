package com.es.user.jwt.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@Rollback
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class JwtServiceTest {

    @Autowired
    JwtService jwtService;

    @Test
    public void jwtTest() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("id", "10001");
        map.put("name", "zhangsan");
        String token = jwtService.createToken(map);
        System.out.println(token);
        Map<String, String> res = jwtService.verifyToken(token);
        Assertions.assertTrue(Objects.nonNull(res));
    }

}
