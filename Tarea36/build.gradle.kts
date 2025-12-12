plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    // Implementación de Angus Mail (el motor)
    implementation("org.eclipse.angus:angus-mail:2.0.2")

    // API de Jakarta Mail (las interfaces)
    implementation("jakarta.mail:jakarta.mail-api:2.1.2")
}