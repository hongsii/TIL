# vim-surround 정리

[vim-surround](https://github.com/tpope/vim-surround)는 괄호, 따옴표, HTML 태그 등을 손쉽게 감싸주는 플러그인

다음과 같이 `"`로 감싼 문장이 있을 때, `'`로 바꾸고 싶다면 바꾸고 싶은 내용에 커서를 두고 `cs"'` 를 입력

```
"Hello, World!"
```

단축키를 입력하면 아래와 같이 플러그인이 변경시켜줌

```
'Hello, World!'
```


## 설치

[링크](https://github.com/tpope/vim-surround#installation)를 참고  
그 외, Vundle과 같은 플러그인 매니저를 사용한다면 아래의 내용을 플러그인 리스트에 추가

``` shell
Plugin 'tpope/vim-surround'
```

