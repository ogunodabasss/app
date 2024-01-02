package com.example.backend;

import com.example.backend.utils.RequestUtil;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

	//@Test
	void test1() {

		{
			Map<String, String> parameters = new HashMap<>();
			parameters.put("param1", "val");
			parameters.put("param2", "val2");
			var str =RequestUtil.getRequest("http://example.com",parameters);
			System.out.println(str);
		}
		{
			System.err.println(System.getenv("google.api.key"));
			if (!System.getenv("google.api.key").equals("null")) {
				Map<String, String> parameters = new HashMap<>();
				parameters.put("keyword", "cruise");
				parameters.put("location", "41.006277%2C38.810009");
				parameters.put("radius", "1500");
				parameters.put("type", "restaurant");
				parameters.put("key", System.getenv("google.api.key"));
				var str = RequestUtil.getRequest(
						"https://maps.googleapis.com/maps/api/place/nearbysearch/json",parameters);
				System.out.println(str);
			}
		}
	}

}
