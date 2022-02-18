package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import com.example.test.model.MutableSetup;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringRestApiAndJpaApplicationTests {

	@Test
	void Testing() {
		MutableSetup setup = new MutableSetup();
		setup.setId(UUID.randomUUID().toString());
		setup.setName("john David Cabal");
		setup.setSection("3BSIT-6C");

		
		assertNotNull(setup);
		assertEquals("john David Cabal", setup.getName());
	}

}
