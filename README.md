# Teaching JAVA

[![Build Status](https://travis-ci.com/piopon/teaching-java.svg?branch=master)](https://travis-ci.com/piopon/teaching-java)
[![codecov](https://codecov.io/gh/piopon/teaching-java/branch/master/graph/badge.svg)](https://codecov.io/gh/piopon/teaching-java)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

Code examples for JAVA tutorials which are used and explained on my web page.

#### Usage
Powered by Maven framework. Build from command line by typing below commands:
```text
mvn clean verify
mvn compile
mvn test
```
Alternatively open project in your favourite IDE, wait for all dependencies to be downloaded and run `main()` method from `src/main/java/pl.smtc/Main.java` file.
An examples menu will open with available user input.

![Main examples menu](src/main/resources/documentation/readme_menu.png?raw=true "Main examples menu")

#### Contents
Currently implemented and available examples are:
* Java basics: control flow, operators and primitive types, etc.
* Recursion examples: explained by real-life algorithms
* Concurrency examples: threads creation sync, stop and most common issues
* Math, search and sort algorithms
* Design patterns: behavioral, creational and structural

####License
Teaching JAVA examples are made available under the GNU GPL-3.0 License. See the
[LICENSE](LICENSE)
file for more information.