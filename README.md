# kotlin-gradle-skelton
コトリンのグレードルを使ったスケルトンです

# gradle install 
```console
$ sdk install gradle
```

# build 
When you want to build with local binary.
```consle
$ ./gradlew run
```
When you want to build with installed binary.
```consle
$ gradle run
```
# If you want args
add these lines to your build.gradle
```console
run {
  if (project.hasProperty('args')) {    // "args" というプロパティが渡されていたら
    args project.args.split('\\s+')   // 空白文字で split して、 run タスクの args オプションにセットする
  }
}
```
and, run like this.
```console
$ gradle --stacktrace -Pargs="ARE" 2>&1
```

# When error
Change open-jdk to oracle-jdk
```consle
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt-get install oracle-java8-installer
```
change default jdk
```console
$ update-alternatives --config java
```
