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
