# How to contribute

## 環境構築

### Gradle の導入

1. [Installing Gradle](https://docs.gradle.org/current/userguide/installation.html) を参考にインストールする。
1. 導入した Gradle を確認する。

    ```sh
    $ gradle --version

    ------------------------------------------------------------
    Gradle 6.8.3
    ------------------------------------------------------------

    Build time:   2021-02-22 16:13:28 UTC
    Revision:     9e26b4a9ebb910eaa1b8da8ff8575e514bc61c78

    Kotlin:       1.4.20
    Groovy:       2.5.12
    Ant:          Apache Ant(TM) version 1.10.9 compiled on September 27 2020
    JVM:          15.0.2 (Oracle Corporation 15.0.2+7)
    OS:           Mac OS X 11.2.1 x86_64
    ```

### Spring Boot CLI の導入

1. CLI をインストールする。

    ```sh
    $ brew tap spring-io/tap
    $ brew install spring-boot
    ```

1. 導入した CLI を確認する。

    ```sh
    $ spring --version
    Spring CLI v2.4.4
    ```

### コンテナ作成

1. Web Application の jar を作成する。

    ```sh
    $ gradle build
    ```

1. コンテナを作成する。

    ```sh
    $ docker-compose build
    ```

## 開発の始め方

1. コンテナを起動する。

    ```sh
    $ docker-compose up
    ```

1. ブラウザで以下のURLにアクセスする。

    `http://localhost:7650`
