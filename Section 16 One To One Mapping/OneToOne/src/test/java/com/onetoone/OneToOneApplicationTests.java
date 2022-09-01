package com.onetoone;

import com.onetoone.entity.License;
import com.onetoone.entity.Person;
import com.onetoone.repository.LicenseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class OneToOneApplicationTests {

    @Autowired
    private LicenseRepository licenseRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateLicense() License license = new License();
        license.setType("CAR");
        license.setValidForm(LocalDate.now());
        license.setValidTo(LocalDate.now());

        Person person= new Person();
        person.setFirstName("Golam Rabbani");
        person.setLastName("Rishad");
        person.setAge(27);

        license.setPerson(person);
        licenseRepository.save(license);
    }

}
