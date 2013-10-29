/**************************** BaseClass ***/
// 属性
function Rectangle(w, h) {
	this.width = w;
	this.height = h;
}

// 方法
Rectangle.prototype.area = function() {return this.width * this.height;}

/***************************** SubClass1 *********/
//属性
function PositionedRectangle(x, y, w, h) {
	Rectangle.call(this, w, h);
	
	this.x = x;
	this.y = y;
}

PositionedRectangle.prototype = new Rectangle();
delete PositionedRectangle.prototype.width;
delete PositionedRectangle.prototype.height;
PositionedRectangle.prototype.constructor = PositionedRectangle;

//方法
PositionedRectangle.prototype.contains = function(x, y) {
	return (x > this.x && x < this.x + this.width &&
			y > this.y && y < this.y + this.height);
}

/***************************** SubClass2 *********/
PositionedRectangle2.prototype.superclass = Rectangle;
function PositionedRectangle2(x, y, w, h) {
	this.superclass(w, h)
	this.x = x;
	this.y = y;
}

/******************************** 测试代码 ********/
var r = new PositionedRectangle(2, 2, 2, 2);
print(r.contains(3, 3));
print(r.area());
print(r.x + "," + r.y + "," + r.width + "," + r.height);
print(r instanceof PositionedRectangle &&
	  	r instanceof Rectangle &&
	  	r instanceof Object);
alert("aa");

var r2= new PositionedRectangle2(2, 2, 2, 2);
alert("bb");









