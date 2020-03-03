FROM debian:stable AS build

RUN ulimit -n 2048 && \
	apt-get update && \
	apt-get -y install --no-install-recommends wget

# download clojurescript jar
RUN cd /usr/local/bin && \
    wget --no-check-certificate https://github.com/clojure/clojurescript/releases/download/r1.10.597/cljs.jar

# set up final cljs environment
FROM debian:stable AS clojurescreeps_builder

RUN ulimit -n 2048 && \
	apt-get update && \
	apt-get -y install --no-install-recommends default-jre && \
	apt-get clean && \
	apt-get autoclean && \
	rm -rf /var/lib/apt/lists/*

COPY --from=build /usr/local/bin/cljs.jar /usr/local/bin
COPY build_clojurescreeps.sh /usr/local/bin
RUN chmod +x /usr/local/bin/build_clojurescreeps.sh
ENTRYPOINT ["/usr/local/bin/build_clojurescreeps.sh"]
