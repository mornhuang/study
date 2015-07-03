var http = require( 'http' );

http.createServer( function(req, res) {
    res.writeHead( 200, {'Content-Type': 'text/html'} );
    res.write( '<h1>Node.JS</h1>' );
    res.end( '<p>Hello World</p>' );
 }).listen( 3000 );

console.log( 'Http server is listening at port 3000' );