attribute vec3 aPosition;
attribute vec2 aTextureCoord;

varying vec2 vTextureCoord;

void main() {
	vTextureCoord = aTextureCoord;
    gl_Position = vec4(aPosition, 1.0);
}