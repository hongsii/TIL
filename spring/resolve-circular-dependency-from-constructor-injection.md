# 묵시적 생성자 주입시 순환 참조 해결하는 법

아래와 같이 `CircularAService`, `CircularBService` 2개가 서로 생성자로 순환 참조

``` java
@Service
public class CircularAService {

	private final CircularBService circularBService;

	public CircularAService(CircularBService circularBService) {
		this.circularBService = circularBService;
	}
}
```

``` java
@Service
public class CircularBService {

	private final CircularAService circularAService;

	public CircularBService(CircularAService circularAService) {
		this.circularAService = circularAService;
	}
}
```

애플리케이션을 실행하게 되면 빈이 생성될 때, 순환 참조로 인해 에러가 발생

```
***************************
APPLICATION FAILED TO START
***************************

Description:

The dependencies of some of the beans in the application context form a cycle:

┌─────┐
|  circularAService defined in file [/Users/hong/IdeaProjects/spring-boot-test/target/classes/io/github/hongsii/springboottest/service/CircularAService.class]
↑     ↓
|  circularBService defined in file [/Users/hong/IdeaProjects/spring-boot-test/target/classes/io/github/hongsii/springboottest/service/CircularBService.class]
└─────┘
```

순환 참조하는 클래스 중 하나에 `@Lazy` 어노테이션을 사용하면 해결할 수 있음

``` java
@Service
public class CircularBService {

	private final CircularAService circularAService;

    // @Lazy 선언
	public CircularBService(@Lazy CircularAService circularAService) {
		this.circularAService = circularAService;
	}
}
```

