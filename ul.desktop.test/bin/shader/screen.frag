#ifdef GL_ES
precision mediump float;
#endif

uniform sampler2D uTexture;

varying vec2 vTextureCoord;

void main() {
	gl_FragColor = texture2D(uTexture, vTextureCoord);
	gl_FragColor.w = 1.0;
}