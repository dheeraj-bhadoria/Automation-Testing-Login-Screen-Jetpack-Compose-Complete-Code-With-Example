# Automation-Testing-Login-Screen-Jetpack-Compose-Complete-Code-With-Example
Automation-Testing-Login-Screen-Jetpack-Compose-Complete-Code-Example is available. JUnit Test cases written in kotlin for jetpack compose screen

![image description](https://github.com/dheeraj-bhadoria/Automation-Testing-Login-Screen-Jetpack-Compose-Complete-Code-With-Example/blob/main/automatedtestingcompose.png)

# Test case running in device 
![image description](https://github.com/dheeraj-bhadoria/Automation-Testing-Login-Screen-Jetpack-Compose-Complete-Code-With-Example/blob/main/automatedtestingcomposegif.gif)

# How to start test 
![image description](https://github.com/dheeraj-bhadoria/Automation-Testing-Login-Screen-Jetpack-Compose-Complete-Code-With-Example/blob/main/automatedtestingcomposeruntest.png)

# Continuous integration- Test cases with automatically runs when you commit build 
Following code in android.yml will execute all test case and its build - 
```groove
name: Android CI

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:

    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v3
    - name: set up JDK 11
      uses: actions/setup-java@v3
      with:
        java-version: '11'
        distribution: 'temurin'
        cache: gradle

    - name: Grant execute permission for gradlew
      run: chmod +x gradlew
    - name: Build with Gradle
      run: ./gradlew build
    - name: Run tests
      run: ./gradlew testDebugUnitTest
```
