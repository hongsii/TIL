# Gradle 언어인 Groovy에서 작은따옴표(')와 큰따옴표(")의 차이

둘다 문자열을 나타낼 때 사용할 수 있음.

``` groovy
def name = 'Foo'
def name = "Foo"
```

다만, 차이점은 큰따옴표(`"`)는 `String interpolation`을 지원한다는 것이다.

## String interpolation

```
interpolation

명사
1. [U] 써넣음; [C] 써넣은 어구[사항]
2. [수학]보간법(補間法), 내삽법(內揷法)
```

단어뜻 그대로 문자열 리터럴에 변수값을 삽입하는 기능이다. `${}`을 사용하면 해당 위치에 값을 넣어 문자열로 만들 수 있다.

``` groovy
def name = 'Foo'
def message = "Hello ${name}"

assert message.toString() == 'Hello Foo'
```

