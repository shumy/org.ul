#ifdef GL_ES
precision mediump float;
#endif

uniform float uTexelSize;
uniform sampler2D uTexture;

uniform int uOrientation;
uniform int uBlurAmount;
uniform float uBlurStrength;

varying vec2 vTextureCoord;

float gaussian(float x, float deviation) {
    return (1.0 / sqrt(2.0 * 3.141592 * deviation)) * exp(-((x * x) / (2.0 * deviation)));  
}

vec2 calculateOffset(float offset) {
    float texelOffset = offset * uTexelSize;
    if(uOrientation == 0)
    	return vec2(texelOffset, 0.0);
    else
    	return vec2(0.0, texelOffset);
}

void main() {
	vec4 colour = vec4(0.0);

    float halfBlur = float(uBlurAmount) * 0.5;
    
    // gaussian deviation
    float strength = 1.0 - uBlurStrength;
    float deviation = halfBlur * 0.35;
    deviation *= deviation;
    
    for(int i = 0; i < uBlurAmount; ++i) {
        float offset = float(i) - halfBlur;
        colour += texture2D(uTexture, vTextureCoord + calculateOffset(offset)) * gaussian(offset * strength, deviation);
    }
    
    gl_FragColor = clamp(colour, 0.0, 1.0);
    gl_FragColor.w = 1.0;
}
     