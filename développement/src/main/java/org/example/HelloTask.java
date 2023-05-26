package org.example;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public abstract class HelloTask extends DefaultTask {
    @Input()
    abstract Property<String> getText();

    @TaskAction
    public void sayHello() {
        System.out.println("hello " + getText());
    }
}
