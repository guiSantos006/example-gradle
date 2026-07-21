import org.gradle.internal.impldep.com.amazonaws.event.DeliveryMode

plugins {
    id("java")
    checkstyle
}

group = "br.com.gui"
version = "1.0-SNAPSHOT"
val mapstructVersion = "1.6.3"
val lombokVersion = "1.18.46"
val lombokMapstructBinding = "0.2.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    implementation("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBinding")

    compileOnly("org.projectlombok:lombok:$lombokVersion")

    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBinding")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Checkstyle>().configureEach {
    reports{
        xml.required = true
        html.required = true
    }
}

tasks.checkstyleMain {
    source =fileTree("src/main/java")
}