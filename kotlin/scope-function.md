# Scope Functions

코틀린에는 **객체의 컨텍스트(context)에서 코드 블록을 실행**할 수 있는 5가지의 스코프 함수가 있다.

* `let`
* `run`
* `with`
* `apply`
* `also`

스코프 함수는 매우 비슷한 구조여서 각 함수별 차이를 이해하는 것이 중요하다.

## 컨텍스트 (Context)

스코프 함수는 2가지의 컨텍스트가 존재한다.

1. `this` : 객체를 람다 리시버로 사용
2. `it` : 객체를 람다의 파리미터로 전달

### this

객체를 람다 리시버로 사용하면 해당 람다에서는 `this` 컨텍스트를 사용할 수 있다. 이렇게 동작하는 스코프 함수는 `run`, `with`, `apply` 가 있다. 일반적인 객체의 `this` 키워드와 동일하며, 해당 객체의 프로퍼티, 함수 등에 접근할 수 있다. `this` 는 생략 가능하다. 생략을 함으로써 코드가 더 간결해질 수 있으나, 람다 외부의 객체나 함수를 사용하게 되면 객체 내부의 것인지 외부의 것인지 헷갈릴 수 있다. 그래서 `this` 컨텍스트를 사용하는 스코프 함수는 리시버의 멤버만 사용할 때 사용하는 것이 좋다.

### it



## 참고

* [Scope Functions - Kotlin Reference](https://kotlinlang.org/docs/reference/scope-functions.html)
* [Mastering Kotlin standard functions: run, with, let, also and apply](https://medium.com/@elye.project/mastering-kotlin-standard-functions-run-with-let-also-and-apply-9cd334b0ef84)
