# プロジェクトの準備

実際は不要な処理だが、メモとして残しておく。


## JDK の導入

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

## jEnv の導入

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

## Spring Boot の導入

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
