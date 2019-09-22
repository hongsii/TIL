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


---

## 참고

* [Vue CLI Guide](https://cli.vuejs.org/guide/installation.html)
* [Github - nvm](https://github.com/nvm-sh/nvm)
* [Github - zsh-nvm](https://github.com/lukechilds/zsh-nvm)
