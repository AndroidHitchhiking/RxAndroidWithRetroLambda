# HelloRxAndRetro
An Android example project to show basic guide in RxAndroid with Retro lambda.

####Setup Rx Android and Retro lambda in App
------------
•	Must have java 8 and java 7.
Add the below line in project level build.gradle file

dependencies {

    // Retro Lambd
    classpath 'me.tatarka:gradle-retrolambda:3.2.4'
   
}


Add RxAndroid dependency and supported lines in App level build.gradle file 


Must be at top after apply plugin: 'com.android.application'

    apply plugin: 'me.tatarka.retrolambda' 



In android{} section add below line as it is with your java 8 and java 7 path


compileOptions {

    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
}

packagingOptions {

    exclude 'META-INF/DEPENDENCIES'
    exclude 'META-INF/NOTICE'
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/LICENSE.txt'
    exclude 'META-INF/NOTICE.txt'
}

retrolambda {

    jdk "C:/Program Files/Java/jdk1.8.0_45" //your java 8 path till jdk
    oldJdk "C:/Program Files (x86)/Java/jdk1.7.0_71" // your java 7 path till jdk
    javaVersion JavaVersion.VERSION_1_7
    println("***************** ---------- *******************")
    println("JAVA_HOME: " + System.getenv("JAVA_HOME"))
    println("JAVA7_HOME: " + System.getenv("JAVA7_HOME"))
    println("JAVA8_HOME: " + System.getenv("JAVA8_HOME"))
    println("***************** ---------- *******************")
}


dependencies {

        compile 'io.reactivex:rxandroid:1.1.0'
}




