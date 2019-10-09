# Vue CLI

> 3.x 버전을 기반으로 작성된 글

## 설치

Node.js 버전 **8.9** 이상 설치 가능 (추천 버전은 8.11.0+)  
여러 버전의 Node를 사용해야 한다면 nvm 으로 버전 관리

### NVM (Node Version Manager) 설치

Mac은 `brew` 를 사용해 설치할 수 있음

``` shell
$ brew install nvm
```

`zsh` 를 사용 중이면 플러그인을 통해 손쉽게 설치 가능

``` shell
$ git clone [https://github.com/lukechilds/zsh-nvm](https://github.com/lukechilds/zsh-nvm) ~/.oh-my-zsh/custom/plugins/zsh-nvm
$ plugins+=(zsh-nvm)
```

설치가 완료되면 nvm 을 통해 최신 버전의 노드 설치

``` shell
$ nvm install node
``` 

## Vue-CLI 설치

``` shell
$ npm install -g @vue/cli
```

## 사용법

### Vue 프로젝트 생성

프로젝트 생성 방법은 2가지가 존재

1. CLI
2. GUI

#### CLI

`create` 옵션으로 프로젝트를 생성할 수 있음

``` shell
# 새로운 디렉토리에 프로젝트 생성
$ vue create 프로젝트명

# 또는 이미 존재하는 디렉토리로 이동해 생성하는 방법
$ vue create .
```

명령어를 입력하면 아래와 같은 설정 화면 표시

``` shell
Vue CLI v3.11.0
? Please pick a preset: (Use arrow keys)
❯ default (babel, eslint)
  Manually select features
```

#### GUI

로컬 웹을 통해 프로젝트를 생성할 수 있음

``` shell
$ vue ui
```


---

## 참고

* [Vue CLI Guide](https://cli.vuejs.org/guide/installation.html)
* [Github - nvm](https://github.com/nvm-sh/nvm)
* [Github - zsh-nvm](https://github.com/lukechilds/zsh-nvm)
