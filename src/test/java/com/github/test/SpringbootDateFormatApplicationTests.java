package com.github.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringbootDateFormatApplicationTests {
	 	@LocalServerPort
	    private int port;
	    @Autowired
	    private TestRestTemplate restTemplate;
	 
	/**
	 *this should be suceess I think ,because I set <code>@DateTimeFormat(pattern = "yyyyMMdd")</code>.
	 *but it is failure;
	 * */
	@Test
	public void DateFormatTest1() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "?date=20191031",
                String.class)).contains("success");
	}
	/**
	 *  it is success what I get instead;
	 * */
	@Test
	public void DateFormatTest2() {
			assertThat(this.restTemplate.getForObject("http://localhost:" + port + "?date=2019103100",
	                String.class)).contains("success");
		}
}
