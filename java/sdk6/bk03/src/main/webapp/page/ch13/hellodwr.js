/**
 *
 * Date: 2013-10-26 12:40
 */
// -------- Send Message------------
function sendMessage() {
    var name = document.getElementById("name").value;
    hello.hello(name, cb);
}

function cb(data) {
    document.getElementById("show").innerHTML = data;
}

// ------------ Get Bean --------------
function getBean() {
    var name = document.getElementById("name").value;
    hello.getBean(name, beanCb);
}

function beanCb(data) {
    document.getElementById("show").innerHTML =
        data.name + ", Hi. Bean Return."
}

// ------------ Send Object -------------------
function sendObject() {
    var nameValue = document.getElementById("name").value;
    hello.sendObj({name: nameValue}, cb);
}

// ------------ Get Object -------------------
function getObject() {
    var name = document.getElementById("name").value;
    hello.getObject(name, objCb);
}

function objCb(data) {
    document.getElementById("show").innerHTML =
        data.name + ", Hi. Obj Return."
}

// ----------------Get list -----------
function getBeanList() {
    hello.getPersonList(listCb);
}

function listCb(data) {
    var result = "";
    for (var i = 0; i < data.length; i++) {
        result += data[i].name + "<br/>"
    }
    document.getElementById("show").innerHTML = result;
}

// ----------------Get Array -----------
function getBeanArray() {
    hello.getPersonArray(arrayCb);
}

function arrayCb(data) {
    var result = "";
    for (var i = 0; i < data.length; i++) {
        result += data[i].name + "<br/>"
    }
    document.getElementById("show").innerHTML = result;
}

// ----------Get Map ------------
function getBeanMap() {
    hello.getPersonMap(mapCb);
}

function mapCb(data) {
    var result = "";
    for (var key in data) {
        result += "Key: " + key + ", value: " + data[key].name + "<br/>";
    }
    document.getElementById("show").innerHTML = result;
}

// ---------Send Bean List-------------
function sendBeanList() {
    var args = [
        {name: "a"},
        {name: "b"},
        {name: "c"}
    ];
    hello.sendList(args, function(data){
        document.getElementById("show").innerHTML = data;
    });
}

// --------Send Generic --------
function sendBeanListNoGeneric() {
    var args = [
        {name: "a"},
        {name: "b"},
        {name: "c"}
    ];
    hello.sendList(args, function(data){
        document.getElementById("show").innerHTML = data;
    });
}

// -----------Send Map ----------------
function sendBeanMap() {
    var args = {
        1: {name: "a"},
        2: {name: "b"},
        3: {name: "c"}
    };

    hello.sendMap(args, function(data){
        document.getElementById("show").innerHTML = data;
    });
}