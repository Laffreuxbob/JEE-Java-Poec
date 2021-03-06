package fr.epsi.rennes.poec.bob.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AgeServiceUnitTest {

    @Autowired
    private AgeService service;

    @Test
    public void age(){
        // given
        String ageString = "1995-07-24";

        // when
        int age = service.age(ageString);

        // then
        assertEquals(26, age);
    }
}
