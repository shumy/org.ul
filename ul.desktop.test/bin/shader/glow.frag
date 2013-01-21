#ifdef GL_ES
precision highp float;
#endif

uniform sampler2D uSceneTexture;
uniform sampler2D uGlowTexture;
uniform int uBlendMode;

varying vec2 vTextureCoord;

void main() {
    vec4 sceneTexel = texture2D(uSceneTexture, vTextureCoord);
    vec4 glowTexel = texture2D(uGlowTexture, vTextureCoord);

    if(uBlendMode == 0) {
        gl_FragColor = min(glowTexel + sceneTexel, 1.0);
    } else if(uBlendMode == 1) {
        gl_FragColor = clamp((glowTexel + sceneTexel) - (glowTexel * sceneTexel), 0.0, 1.0);
        gl_FragColor.w = 1.0;
    } else {
        // Show just the glow map
        gl_FragColor = glowTexel;
    }
}