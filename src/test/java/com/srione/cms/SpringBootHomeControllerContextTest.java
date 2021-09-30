package com.srione.cms;

import com.srione.cms.Home.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringBootHomeControllerContextTest {

    @Autowired
    HomeController homeController;

    @Test
    public void contextLoadsForHomeController() {
        assertThat(homeController).isNotNull();
    }

}
