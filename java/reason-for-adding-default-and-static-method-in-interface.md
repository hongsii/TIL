# Java 8에서 인터페이스에 default, static 메소드가 추가된 이유

Java 8부터 인터페이스에 default, static 메소드를 정의할 수 있게 되었다.

## default method

기존에는 인터페이에서는 메소드 선언만 가능하고 내용을 구현할 수 없었다. default 키워드를 사용하면 인터페이스에서 메소드의 내용을 구현할 수 있게 해준다.

``` java
interface FooInterface {

  default String getName() {
    return "foo";
  }
}
```

default 메소드의 장점은 인터페이스에 메소드를 선언할 경우 모든 구현체가 해당 메소드를 구현해야 했다. default 메소드를 사용하면 구현체에서 굳이 메소드를 구현할 필요가 없고, 새롭게 구현할 필요가 있는 경우에만 오버라이딩을 통해 해결 가능하다. 이처럼 **구현체에 직접적인 구현 없이도 새로운 메소드를 추가할 수 있게 되면서 이미 존재하는 인터페이스에 새로운 기능이 추가되야할 때 이전 버전의 인터페이스와 호환성을 높일 수 있다**는 장점이 있다.  
그리고 인터페이스의 경우 모든 구현체가 메소드 구현해야 하기 때문에 중복된 메소드가 생기는 경우가 존재했는데, default 메소드를 사용하면 중복된 메소드를 제거할 수 있다.  

## static method

인터페이스에선 static 메소드를 구현할 수 없었지만, static 메소드를 구현할 수 있게 되었다.  
인터페이스의 팩토리 메소드가 필요하면 새로운 팩토리 클래스를 만들어야 했지만, static 메소드가 추가됨으로써 별도의 클래스를 추가하지 않고 팩토리 메소드를 사용할 수 있게 되었다. **static 메소드는 인터페이스가 필요한 Util 메소드를 편리하게 만들게 도와준다.**

# 참고

* [The Java™ Tutorials - Interfaces and Inheritance](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html)
* [StackOverflow - Reason for adding default and static methods in interfaces
Ask Question](https://stackoverflow.com/questions/29997052/reason-for-adding-default-and-static-methods-in-interfaces)
