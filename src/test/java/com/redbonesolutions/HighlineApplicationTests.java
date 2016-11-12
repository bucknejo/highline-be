package com.redbonesolutions;

import com.redbonesolutions.highline.HighlineApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = HighlineApplication.class)
public class HighlineApplicationTests {

	@Test
	public void contextLoads() {
	}

}
