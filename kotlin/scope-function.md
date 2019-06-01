# Scope Functions

코틀린에는 **객체의 컨텍스트(context)에서 코드 블록을 실행**할 수 있는 5가지의 스코프 함수가 있다.

* `let`
* `run`
* `with`
* `apply`
* `also`

스코프 함수는 매우 비슷한 구조여서 각 함수별 차이를 이해하는 것이 중요하다.

## Context

스코프 함수에서 객체를 사용하려면 크게 람다ㅇ

# run, with 차이

* run : externsion function
* with : normal function


# run, let 차이

* run은 대상 클래스가 this, let은 대상 클래스가 람다의 파라미터인 it으로 표시
* let 의 장점 ? 주어진 파라미터의 함수/프로퍼티인지 외부의 함수/프로퍼티인지 명확히 구분할 수 있다 (IDE가 해줌)
* this를 사용하는 것보다 it이 더 직관적이고 더 쓰기 편하다(짧아서..?)
* 더 나은 네이밍으로 설정할 수 있다

``` kotlin
str?.let {
    nonNullStr -> println("$nonNullStr")
}
```

# let, also의 차이

## 참고

* [Scope Functions - Kotlin Reference](https://kotlinlang.org/docs/reference/scope-functions.html)
* [Mastering Kotlin standard functions: run, with, let, also and apply](https://medium.com/@elye.project/mastering-kotlin-standard-functions-run-with-let-also-and-apply-9cd334b0ef84)
