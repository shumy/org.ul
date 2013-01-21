const int size = 5;
const int doubleSize = 2*size;

uniform float uTexelSize;
uniform int uOrientation;

attribute vec3 aPosition;
attribute vec2 aTextureCoord;

varying vec2 vTextCoord;
varying vec2 vBlurTexCoords[doubleSize];

void main(){
    gl_Position = vec4(aPosition, 1.0);
    vTextCoord = aTextureCoord;
    
    float val = -uTexelSize*size;
    if(uOrientation == 0) {
    	for(int i=0; i<doubleSize; ++i) {
    		vBlurTexCoords[i] = vTextCoord + vec2(val, 0.0);
    		val += uTexelSize;
    	}
    } else {
    	for(int i=0; i<doubleSize; ++i) {
    		vBlurTexCoords[i] = vTextCoord + vec2(0.0, val);
    		val += uTexelSize;
    	}
    }
}