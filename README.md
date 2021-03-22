# Java sample API
SpringでサンプルのAPIを作る
## Versions

- 🍎 Apple macOS Big Sur バージョン 11.2.1
- ☕️
```sh
$ java -version
openjdk version "15.0.2" 2021-01-19
OpenJDK Runtime Environment (build 15.0.2+7)
OpenJDK 64-Bit Server VM (build 15.0.2+7, mixed mode, sharing)
```

## 環境構築

### JDK の導入

1. Homebrew を更新する。

    ```sh
    $ brew update
    ```

1. JDK をインストールする。
    - Oracle から DL でもいいけど、アカウントを作ったり、ネットワークセキュリティ的に面倒くさいので OpenJDK を使う。

    ```sh
    $ brew install openjdk@8 openjdk@11 openjdk
    ```

1. インストール後のメッセージを参考にシンボリックリンクを作成する。
1. 導入した JDK を確認する。

    ```sh
    $ /usr/libexec/java_home -V
    Matching Java Virtual Machines (6):
    15.0.2 (x86_64) "UNDEFINED" - "OpenJDK 15.0.2" /usr/local/Cellar/openjdk/15.0.2/libexec/openjdk.jdk/Contents/Home
    11.0.10 (x86_64) "UNDEFINED" - "OpenJDK 11.0.10" /usr/local/Cellar/openjdk@11/11.0.10/libexec/openjdk.jdk/Contents/Home
    1.8.281.09 (x86_64) "Oracle Corporation" - "Java" /Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home
    1.8.0_282 (x86_64) "UNDEFINED" - "OpenJDK 8" /usr/local/Cellar/openjdk@8/1.8.0+282/libexec/openjdk.jdk/Contents/Home
    1.8.0_281 (x86_64) "Oracle Corporation" - "Java SE 8" /Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Contents/Home
    1.8.0_221 (x86_64) "Oracle Corporation" - "Java SE 8" /Library/Java/JavaVirtualMachines/jdk1.8.0_221.jdk/Contents/Home
    ```

1. 端末を再起動する。

### jEnv の導入

1. [jEnv](https://github.com/jenv/jenv) を参考にインストールする。
1. `add` コマンドを使ってインストールした JDK を jEnv に追加する。
1. 追加した JDK を確認する。
    - この場合は `openjdk64-15.0.2` を使うことにしている。

    ```sh
    $ jenv versions
      system
      1.8
      1.8.0.282
      11
      11.0
      11.0.10
      15
      15.0
      15.0.2
      openjdk64-1.8.0.282
      openjdk64-11.0.10
    * openjdk64-15.0.2 (set by /Users/path/to/.java-version)
    ```

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

### Spring Boot の導入

1. [spring initializer](https://start.spring.io/) を使って初期ソースコードを生成する。

    | Key | Value |
    | --- | --- |
    | Project | Gradle Project |
    | Language | Java |
    | Spring Boot | 2.4.4 |
    | Group | dev.shintani |
    | Artifact | demo |
    | Name | demo |
    | Description | Demo project for Spring Boot |
    | Package name | dev.shintani.demo |
    | Packaging | Jar |
    | Java | 15 |
    | Dependencies | Lombok / Spring Web |

※ Dependencies: DB関連のライブラリを入れるかもしれない。

### コンテナ作成

1. Web Application の jar を作成する。

    ```sh
    $ gradle build
    ```


1. コンテナを作成する。

    ```sh
    $ docker-compose build
    ```

## 開発する場合はこちら

[CONTRIBUTING.md](/CONTRIBUTING.md)

## 参考

- [【前編】Spring Bootってなにがいいの](https://licensecounter.jp/devops-hub/blog/spring-boot1/)
