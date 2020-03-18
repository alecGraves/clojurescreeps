# Welcome to ClojureScreeps!
ClojureScreeps is a [Screeps](https://screeps.com/) AI written in [clojure(script)](https://clojurescript.org/)! 
This project is inspired by Rich Hickey's talk ["Simple Made Easy"](https://www.infoq.com/presentations/Simple-Made-Easy/).

In this project, the goals are:

1. Survival of the Colony!
2. Simplicity.

## Build
Clojurescript needs to be compiled into javascript so screeps can execute it.
This section covers how to do it on different platforms 🚀

### Docker (cross-platform)
I made a minimal-ish docker container that has the build tools for cljs. To use it,
just install docker and run the following command from this folder:

_Windows:_
```bat
docker run --rm -itv %cd%:/clojurescreeps alecgraves/clojurescreeps:build
```
_Linux:_
```bash
docker run --rm -itv $(pwd):/clojurescreeps alecgraves/clojurescreeps:build
```

#### Building the Docker Image
Building the docker container manually:
```
cd docker
docker image build -t clojurescreepsbuilder .
```

Uploading the container (for me):
```bash
docker tag clojurescreepsbuilder alecgraves/clojurescreeps:build
docker push alecgraves/clojurescreeps:build
```

### Windows
1. Install Java and make sure java bin is in your `%PATH%` environment variable.
2. Download a cljs.jar [from this page](https://github.com/clojure/clojurescript/releases)
into the git page
    1. You can also download the copy [from my dropbox](https://www.dropbox.com/s/6zqu2oun6p86kmn/cljs.jar?dl=1)
3. Run the build command in command prompt
```bat
java -cp "cljs.jar;src" cljs.main -co build_opts.edn -c
```
4. Delete the fist line shebang (#) so screeps js interpreter does not error out:
```bat
more +1 clojurescreeps.js > tmp.js && del clojurescreeps.js && timeout 1 && rename tmp.js clojurescreeps.js
```


## Test 
This screeps AI is developed with tdd to help keep simple design in the forefront.
This section covers how to run the tests ✔
#### Windows
1. Install clojurescript, following the install instructions for the Windows Build section
2. Install NodeJS it is in your PATH
2. Run the tests:
```
java -cp "cljs.jar;src" cljs.main -co build_opts_test.edn -c && node tests.js
```

### REPL
Clojure is designed to take advantage of a Read-Eval-Print-Loop (REPL) environment.
The REPL environment lets you easily test out code modifications without having to recompile.
Here we cover how to run the clojurescript REPL 🔥
#### Windows
```
java -cp "cljs.jar;src" cljs.main --compile clojurescreeps.core --repl
```


