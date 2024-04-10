package com.chinempc.ResumeAPI;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

//@SpringBootTest
@JsonTest
class ResumeApiApplicationTests {

	@Value("classpath:data/data.json")
	Resource data;

	@Autowired
	ObjectMapper objectMapper;

	String json;

}
