* buildscript

외부 라이브러리를 사용해 빌드 시 추가하는 곳
자바 컴파일 클래스 패스와 동일한 방식이라 생각하면 됨
멀티 프로젝트 빌드 시, 루트 프로젝트의 빌드 스크립트 디펜던시를 모든 하위 프로젝트에서 사용 가능하다.

``` groovy
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath group: 'commons-codec', name: 'commons-codec', version: '1.2'
    }
}
```

* multi module 빌드 순서

루트 프로젝트 buld.gradle에 allprojects, subprojects, project 선언

* allprojects로 루트 프로젝트 실행
* 다음 서브 프로젝트 실행 allprojects -> subprojects -> project 순으로 실행


루트 프로젝트 buld.gradle에 allprojects, subprojects 선언
subproject에 build.gradle 존재

* allprojects로 루트 프로젝트 실행
* 다음 서브 프로젝트 실행 allprojects -> subprojects -> subproject build.gradle 순으로 실행


* [참고)(https://docs.gradle.org/current/userguide/multi_project_builds.html)
