package com.example.springboot;

import rife.bld.WebProject;

import java.util.List;

import static rife.bld.dependencies.Repository.MAVEN_CENTRAL;
import static rife.bld.dependencies.Scope.compile;
import static rife.bld.dependencies.Scope.test;

public class ApplicationBuild extends WebProject {
    public ApplicationBuild() {
        pkg = "com.example.demo";
        name = "DemoApplication";
        mainClass = "com.example.springboot.Application";
        version = version(0, 1, 0);

        javaRelease = 17;

        repositories = List.of(MAVEN_CENTRAL);

        scope(compile)
                .include(dependency("org.springframework.boot", "spring-boot-starter",
                        version(3, 1, 5)))
                .include(dependency("org.springframework.boot", "spring-boot-starter-actuator",
                        version(3, 1, 5)))
                .include(dependency("org.springframework.boot", "spring-boot-starter-web",
                        version(3, 1, 5)));
        scope(test)
                .include(dependency("org.springframework.boot", "spring-boot-starter-test",
                        version(3, 1, 5)))
                .include(dependency("org.junit.jupiter", "junit-jupiter",
                        version(5, 10, 0)))
                .include(dependency("org.junit.platform", "junit-platform-console-standalone",
                        version(1, 10, 0)));
    }

    public static void main(String[] args) {
        new ApplicationBuild().start(args);
    }
}