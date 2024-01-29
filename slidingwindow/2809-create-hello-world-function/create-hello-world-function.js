/**
 * @return {Function}
 */
var createHelloWorld = function() {
    var str ="Hello World"
    return function(...args) {
        return str;
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */