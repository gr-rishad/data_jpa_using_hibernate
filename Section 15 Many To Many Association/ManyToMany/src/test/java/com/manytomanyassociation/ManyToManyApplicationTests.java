package com.manytomanyassociation;

import com.manytomanyassociation.entity.Programmer;
import com.manytomanyassociation.entity.Project;
import com.manytomanyassociation.repository.ProgrammersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
class ManyToManyApplicationTests {

    private ProgrammersRepository programmersRepository;

    @Autowired
    public ManyToManyApplicationTests(ProgrammersRepository programmersRepository) {
        this.programmersRepository = programmersRepository;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateProgrammer() {
        Programmer programmer = new Programmer();
        programmer.setName("John");
        programmer.setSal(1000);

        Set<Project> projects = new HashSet<>();
        Project project = new Project();
        project.setName("Hibernate Project");

        projects.add(project);
        programmer.setProjects(projects);

        programmersRepository.save(programmer);
    }

    @Test
    @Transactional
    public void testFindProgrammer() {

        Optional<Programmer> programmer = programmersRepository.findById(1);
        System.out.println(programmer.get());
        System.out.println(programmer.get().getProjects());
    }

}
