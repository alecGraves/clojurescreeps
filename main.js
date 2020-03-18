require("./clojurescreeps");

module.exports.loop = function(){
    Memory = clojurescreeps.core.screeps_loop(Game, Memory);
};
