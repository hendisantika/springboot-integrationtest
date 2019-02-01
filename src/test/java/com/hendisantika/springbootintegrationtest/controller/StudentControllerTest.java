package com.hendisantika.springbootintegrationtest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-integrationtest
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-02-01
 * Time: 08:16
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    @LocalServerPort
    private int port;

    // This is required only if testRetrieveStudent is tested without testCreateStudent() which creates student records.
//    @Before
//    public void setup() {
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//        restTemplate.exchange(createURLWithPort("/students"), HttpMethod.POST, entity, String.class);
//
//    }
    @Test
    public void testCreateStudent() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/students"), HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        assertTrue(actual.contains("/students"));
    }

    @Test
    public void testRetrieveStudent() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/students/1"), HttpMethod.GET, entity, String.class);

        String expected = "{\"id\":1,\"name\":\"Uzumaki Naruto\",\"description\":\"Class 10\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}