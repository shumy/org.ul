#ifdef GL_ES
precision mediump float;
#endif

uniform sampler2D uTexture1;
uniform sampler2D uTexture2;

uniform float uTime;

varying vec2 vTextureCoord;

void main() {
	gl_FragColor = mix(texture2D(uTexture1, vTextureCoord), texture2D(uTexture2, vTextureCoord), (sin(uTime) + 1.0)/2.0);
}