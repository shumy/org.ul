#ifdef GL_ES
precision mediump float;
#endif

const int size = 5;
const int doubleSize = 2*size;

uniform int uOrientation;
uniform sampler2D uTexture;
 
varying vec2 vTexCoord;
varying vec2 vBlurTexCoords[doubleSize];
 
void main() {
    gl_FragColor = vec4(0.0);
        
    for(int i=0; i<size; ++i)
    	gl_FragColor += texture2D(uTexture, vBlurTexCoords[i])*(1+i);
    
    for(int i=size; i<doubleSize; ++i)
    	gl_FragColor += texture2D(uTexture, vBlurTexCoords[i])*(doubleSize-i);

    if(uOrientation == 0)
		gl_FragColor *= 0.015;
    else
		gl_FragColor *= 0.6;
}