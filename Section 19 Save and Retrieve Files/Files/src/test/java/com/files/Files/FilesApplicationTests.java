package com.files.Files;

import com.files.Files.entities.Image;
import com.files.Files.repository.ImageRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Optional;

@SpringBootTest
class FilesApplicationTests {

    private ImageRepo imageRepo;

    @Autowired
    public FilesApplicationTests(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testSaveImage() throws IOException {

        Image image = new Image();
        image.setId(1);
        image.setName("suraBaqura.PNG");

        File file = new File("C:/Users/Rishad/Desktop/suraBaqura.PNG");
        byte fileContent[] = new byte[(int) file.length()];
        FileInputStream inputStream = new FileInputStream(file);
        inputStream.read(fileContent);

        image.setData(fileContent);
        imageRepo.save(image);
        inputStream.close();
    }

    @Test
    public void testReadImage() {
        Optional<Image> image = imageRepo.findById(1L);
        File file = new File("C:/Users/Rishad/Desktop/CV/" + image.get().getName());
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(image.get().getData());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
