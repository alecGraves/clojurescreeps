require("./clojurescreeps");

module.exports.loop = function(){
    clojurescreeps.core.screeps_loop(Game, Memory);
};
