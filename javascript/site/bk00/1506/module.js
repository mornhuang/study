/**
 * Created by Morn on 2015/6/25.
 */

var name;

exports.setName = function(thyName) {
    name = thyName;
};

exports.sayHello = function() {
    console.log( 'Hello ' + name );
};