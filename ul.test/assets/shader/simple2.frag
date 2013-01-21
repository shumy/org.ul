uniform float time;
uniform ivec2 resolution;

void main( void ) {
	vec2 uPos = ( gl_FragCoord.xy / resolution.xy );
	uPos.x -= 0.5;
	
	float vertColor = 0.0;
	for( float i = 0.0; i < 10.0; ++i ) {
		float t = time/10. * (i + 0.9);
	
		uPos.x += sin( (uPos.y + t)* 10. ) * 0.1;
	
		float fTemp = abs(1.0 / uPos.x / 1000.0);
		vertColor += fTemp;
	}
	
	vec4 color = vec4( vertColor*2., vertColor, vertColor , 1.0 );
	gl_FragColor = color;
}