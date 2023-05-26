group = "org.example"
version = "1.0-SNAPSHOT"

apply(plugin = "java-gradle-plugin")

repositories {
    mavenCentral()
    gradlePluginPortal()
}

configure<JavaPluginExtension> {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    "testImplementation"(platform("org.junit:junit-bom:5.9.1"))
    "testImplementation"("org.junit.jupiter:junit-jupiter")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

configure<GradlePluginDevelopmentExtension> {
    plugins {
        create("example") {
            id = "example"
            implementationClass = "org.example.TestPlugin"
        }
    }
}
