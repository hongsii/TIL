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

객체를 람다 파라미터로 전달해 `it` 을 사용할 수 있다. 이렇게 동작하는 스코프 함수는 `let`, `also` 가 있다. 람다 내에서 파라미터의 이름을 지정하지 않으면 `it` 키워드로 객체를 사용할 수 있으며, 필요하다면 파라미터명을 지정할 수도 있다. `it` 컨텍스트를 사용하는 스코프 함수는 함수의 파라미터로만 사용할 때 사용하는 것이 좋다. 또한, 람다 내에서 변수를 여러개 사용할 경우에도 사용하면 좋다.

## 참고

* [Scope Functions - Kotlin Reference](https://kotlinlang.org/docs/reference/scope-functions.html)
* [Mastering Kotlin standard functions: run, with, let, also and apply](https://medium.com/@elye.project/mastering-kotlin-standard-functions-run-with-let-also-and-apply-9cd334b0ef84)

---


* [the tldr; on Kotlin’s let, apply, also, with and run functions](https://proandroiddev.com/the-tldr-on-kotlins-let-apply-also-with-and-run-functions-6253f06d152b)

* [Kotlin: Don’t just use LET for null check](https://medium.com/@elye.project/kotlin-dont-just-use-let-7e91f544e27f)

* [examining-kotlins-also-apply-let-run-and-with-intentions](https://dzone.com/articles/examining-kotlins-also-apply-let-run-and-with-intentions)
