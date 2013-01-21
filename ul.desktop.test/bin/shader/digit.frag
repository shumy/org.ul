#ifdef GL_ES
precision mediump float;
#endif

varying vec2 vTextureCoord;

vec2 p;

float box(vec2 v, vec4 rect, float intensity) {
    
    float trim = min(rect.z, rect.w) * 0.8;
    float minX = min(v.x - rect.x, rect.x + rect.z - v.x);
    float minY = min(v.y - rect.y, rect.y + rect.w - v.y);
    return ((minX > 0.0) && (minY > 0.0) && ((minX + minY) > trim))? intensity*(minX*minY): 0.0;
}

float digit(vec2 pos, vec2 size, int d) {
    vec2 v;
	v.xy = p - pos.xy;
	v.xy /= size.xy;
	
	float c = 0.0;

	if(d==0 || d==2 || d==3 || d==5 || d==6 || d==7 || d==8 || d==9)
		c += box(v, vec4(0.05, 0.9, 0.9, 0.1), 100.0);

	if(d==2 || d==3 || d==4 || d==5 || d==6 || d==8 || d==9)
		c += box(v, vec4(0.05, 0.45, 0.9, 0.1), 100.0);

	if(d==0 || d==2 || d==3 || d==5 || d==6 || d==8 || d==9)
		c += box(v, vec4(0.05, 0.0, 0.9, 0.1), 100.0);

	if(d==0 || d==2 || d==6 || d==8)
		c += box(v, vec4(0.0, 0.08, 0.1, 0.39), 100.0);
	
	if(d==0 || d==1 || d==3 || d==4 || d==5 || d==6 || d==7 || d==8 || d==9)
		c += box(v, vec4(0.9, 0.08, 0.1, 0.39), 100.0);

	if(d==0 || d==4 || d==5 || d==6 || d==8 || d==9)
		c += box(v, vec4(0.0, 0.52, 0.1, 0.39), 100.0);
	
	if(d==0 || d==1 || d==2 || d==3 || d==4 || d==7 || d==8 || d==9)
		c += box(v, vec4(0.9, 0.52, 0.1, 0.39), 100.0);


	return c;
}

void main(void) {
	p = vTextureCoord.xy;

	float c= 0.0;
	float alpha = 1.0;

	c += digit(vec2(0.5 - .21, 0.34), vec2(0.2, 0.35 ), 9);
	c += box(p, vec4(0.68 - .21, 0.32, 0.08, 0.08), 600.0);
	c += digit(vec2(0.75 - .21, 0.34), vec2(0.2, 0.35), 8);

	p -= 0.5;
	p *= 10.0;
	float red = 0.0;
	float r = 0.06*(p.x*p.x + p.y*p.y);
	if(r < 1.0)
		red = r*r;
	else
		red = 2.0 - r*r;

	gl_FragColor = vec4(red, c, 0.0, red+c);
}