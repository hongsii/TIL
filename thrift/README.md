# brew 없이 맥에서 thrift 설치하기

Thrift 0.11 버전을 설치해야하는데 `brew` 는 0.9 / 0.12 두 가지 버전만 지원함.

* 설치 순서는 [Apache Thrift OS X Setup](https://thrift.apache.org/docs/install/os_x)에서 따라 진행

* Thrift build 전 bison 버전이 낮아서 실행이 안되기 때문에 bison 설치

``` shell
brew install bison
brew link bison --force
```

* Thrift build가 끝나면 `thrift -version` 으로 설치 확인
* 그래도 빌드가 안된다면 openssl 을 설치해본다.

``` shell
brew install openssl
brew link openssl --force
```

## 참고
* [ApacheThriftInstall.md](https://gist.github.com/amura2406/21310acfd5d4d8b8bcd176bccceb26d6)
