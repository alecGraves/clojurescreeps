java -cp "cljs.jar;src" cljs.main  -co build_opts.edn -c && more +1 clojurescreeps.js > tmp.js && del clojurescreeps.js && timeout 1 && rename tmp.js clojurescreeps.js
