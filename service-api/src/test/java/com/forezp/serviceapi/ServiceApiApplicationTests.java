package com.forezp.serviceapi;

import com.forezp.serviceapi.service.UseServiceHi;
import com.forezp.serviceapi.service.impl.UserServiceHiImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(value = "ServiceApiApplication")
public class ServiceApiApplicationTests {
	@Autowired
	private UseServiceHi useServiceHi;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testHiApi() {
		try {
			useServiceHi.useServiceHiByRibbon("hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
