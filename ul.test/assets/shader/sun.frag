#ifdef GL_ES
precision mediump float;
#endif

uniform float uTime;
uniform vec2 uResolution;

varying vec2 vTextureCoord;

vec2 p;

float rect() {
	vec2 v = abs(p) - vec2(0.3, 0.3);
  	float d = length(max(v, 0.0));
	return 3.0 - 15.0*d;
}

float line(vec2 p, vec2 s0, vec2 s1, float radius) {
	vec2 d = normalize(s1 - s0);
	float slen = distance(s0, s1);

	float d0 = max(abs(dot(p - s0, d.yx * vec2(-1.0, 1.0))), 0.0);
	float d1 = max(abs(dot(p - s0, d) - slen * 0.5) - slen * 0.5, 0.0);

		
	return step(length(vec2(d0, d1)), radius*30.0)*0.008/(length(vec2(d0, d1)));
		
}

void main(void) {
   float red, green = 0.0;
   float alpha = 1.0;
   p = vTextureCoord.xy;
   
   //p -= 0.5;
   //p *= i_scale;

   //float color = 1.0 + 0.2*sin(uTime) - (p.x*p.x + p.y*p.y);
   //float color = 10.0 - sqrt(p.x*p.x + p.y*p.y)*10.0;
   
   //glow line---------------------------------------------
   /*p *= 2.0;
   float green = 0.0;
   if(p.x < 1.0)
     green = p.x;
   else
     green = 2.0 - p.x;*/

   //glow circle-----------------------------------
   p -= 0.5;
   p *= 10.0;
   float r = 0.06*(p.x*p.x + p.y*p.y);
   if(r < 1.0)
   		red = r*r;
   else
		red = 2.0 - r*r;
   alpha = red;
	
   //glow star-------------------------------------
   /*float red = 0.0;
   p *= 2.0;
   if(p.x < 1.0)
     red = p.x;
   else
     red = 2.0 - p.x;
     
   if(p.y < 1.0)
     red *= p.y;
   else
     red *= 2.0 - p.y;*/
   
   //glow square-----------------------------------
   /*float red = 0.0;
   p -= 0.5;
   red = rect();*/
   
   
   //grid-------------------------------------------
   /*
   p *= 10.1;
   float mod_x = mod(p.x, 1.0);
   float mod_y = mod(p.y, 1.0);
 
   if(mod_x < 0.1) red += 0.2 + abs(mod_x);
   if(mod_y < 0.1) red += 0.2 + abs(mod_y);*/


   //grid 2-----------------------------------------
   /*p *= 20.0*3.1415;
   red   = 0.5*cos(p.x);
   green = 0.5*cos(p.y);
   */

   //right arrow--------------------------------------------------------
   /*p -= 0.5;
   p *= 10.0;
   float r = 0.08*(p.x*p.x + p.y*p.y);
   if(r < 1.0)
   		red = r;
   else
		red = 2.0 - r;

   green += line(p, vec2(-1.5, -2.0), vec2(1.0, -2.0), 10.0);
   green += line(p, vec2(-1.5, 2.0), vec2(1.0, 2.0), 10.0);
   
   green += line(p, vec2(-1.5, -2.0), vec2(-1.0, 0.0), 10.0);
   green += line(p, vec2(-1.5, 2.0), vec2(-1.0, 0.0), 10.0);

   green += line(p, vec2(1.0, -2.0), vec2(2.0, 0.0), 10.0);
   green += line(p, vec2(1.0, 2.0), vec2(2.0, 0.0), 10.0);*/

   gl_FragColor = vec4(red, green, 0.0, alpha);
}