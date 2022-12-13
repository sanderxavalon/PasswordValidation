package com.sanderxavalon.passwordvalidation;

import com.sanderxavalon.passwordvalidation.core.validation.MaxAndMinPasswordValidator;
import com.sanderxavalon.passwordvalidation.service.ConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class PasswordValidationApplicationTests {

	@Autowired
	ConfigService configService;

	@Test
	void contextLoads() {
	}

}
