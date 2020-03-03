# Welcome to ClojureScreeps!
ClojureScreeps is a [Screeps](https://screeps.com/) AI written in [clojure(script)](https://clojurescript.org/)! 
This project is inspired by Rich Hickey's talk ["Simple Made Easy"](https://www.infoq.com/presentations/Simple-Made-Easy/).

In this project, the goals are:

1. Survival of the Colony!
2. Simplicity.

## Getting Sarted
### Building
This project is tested with [org.clojure/clojurescript version 1.10.597](https://github.com/clojure/clojurescript/releases/download/r1.10.597/cljs.jar)

#### Docker
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

#### Windows
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

### Building the Docker Container Manually
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
