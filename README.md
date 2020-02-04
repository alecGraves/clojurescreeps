# Welcome to ClojureScreeps!
ClojureScreeps is a [Screeps](https://screeps.com/) AI written in [clojure(script)](https://clojurescript.org/)! 
This project is inspired by Rich Hickey's talk ["Simple Made Easy"](https://www.infoq.com/presentations/Simple-Made-Easy/). In this project, the goal is simple design with

## Getting Sarted
### Building
This project is tested with org.clojure/clojurescript version 1.10.597
#### Windows
1. Install Java and make sure java bin is in your `%PATH%` environment variable.
1. Download a cljs.jar [from this page](https://github.com/clojure/clojurescript/releases)
into the git page
    1. You can also download my copy [from my dropbox](https://www.dropbox.com/s/6zqu2oun6p86kmn/cljs.jar?dl=1)
3. run `java -cp "cljs.jar;src" cljs.main  -co build_opts.edn -c` in command prompt
#### Other Systems
1. You can just [install Clojure](https://clojure.org/guides/getting_started)
2. run `clj --main cljs.main -co build_opts.edn -c` in terminal
