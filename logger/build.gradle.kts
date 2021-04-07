plugins {
//    `maven-publish` // we can publish compiled 'logger' jar artifact to local maven repository
    kotlin("jvm") /*version "1.4.32"*/ // we need to specify version explicitly only if 'logger' is separate project (e.g. when we use 'includeBuild')
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

// uncomment following lines to publish 'logger' jar to local maven repository with command 'gradle :logger:publishToMavenLocal'
//group = "com.example.demo"
//version = "0.0.1"

//publishing {
//    publications {
//        create<MavenPublication>("maven") {
//            from(components["java"])
//        }
//    }
//}
