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

-----------

프로젝트를 정의하거나 사용할 때는 `:` 으로 경로를 구분한다.

``` gradle
# settings.gradle
rootProject.name = 'multi-module'

include 'api', 'domain', 'services:testService'
```

디펜던시를 설정할 때 `project(...)` 로 다른 프로젝트를 포함할 수 있다.

``` gradle
dependencies {
    project('multi-module:api')
    project(':api') // 상대 경로 형태로 쓸 수 있다.
}
```

-----------


* multi module 빌드 순서

루트 프로젝트 buld.gradle에 allprojects, subprojects, project 선언

* allprojects로 루트 프로젝트 실행
* 다음 서브 프로젝트 실행 allprojects -> subprojects -> project 순으로 실행


루트 프로젝트 buld.gradle에 allprojects, subprojects 선언
subproject에 build.gradle 존재

* allprojects로 루트 프로젝트 실행
* 다음 서브 프로젝트 실행 allprojects -> subprojects -> subproject build.gradle 순으로 실행

-----------

* Gradle 3.0 이후론 기존 의존성 설정 함수가 deprecated 되었음
    * `compile` -> `implementation` 또는 `api`
        * 바뀐 2개의 차이점?
            * 테스트해보고 적기!
    * `testCompile` -> `testImplementation`
    * `debugCompile` -> `debugImplementation`


* [참고)(https://docs.gradle.org/current/userguide/multi_project_builds.html)
