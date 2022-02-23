package com.naveen.githubdemo.annotations;

import java.lang.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles
public @interface ApiTest {
    @AliasFor(
            annotation = ActiveProfiles.class,
            attribute = "profiles"
    )
    String[] activeProfiles() default {"test", "fast"};

    @AliasFor(
            annotation = SpringBootTest.class,
            attribute = "classes"
    )
    Class<?>[] config();
}

