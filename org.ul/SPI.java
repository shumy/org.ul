package org.ul.gl.spi;

public class SPI {
	public static SPIgl gl;
	
	public static final int GL_NONE 				= 0;
	
	public static final int GL_FALSE 				= 0;
	public static final int GL_TRUE 				= 1;
	
	public static final int GL_FLOAT 				= 5126;
	public static final int GL_FLOAT_VEC2 			= 35664;
	public static final int GL_FLOAT_VEC3 			= 35665;
	public static final int GL_FLOAT_VEC4 			= 35666;
	
	public static final int GL_FLOAT_MAT2 			= 35674;
	public static final int GL_FLOAT_MAT3 			= 35675;
	public static final int GL_FLOAT_MAT4 			= 35676;
	
	public static final int GL_INT 					= 5124;
	public static final int GL_UNSIGNED_INT 		= 5125;
	public static final int GL_INT_VEC2 			= 35667;
	public static final int GL_INT_VEC3 			= 35668;
	public static final int GL_INT_VEC4 			= 35669;
	
	public static final int GL_BYTE 				= 5120;
	public static final int GL_UNSIGNED_BYTE 		= 5121;
	public static final int GL_SHORT 				= 5122;
	public static final int GL_UNSIGNED_SHORT 		= 5123;
	
	
	public static final int GL_SAMPLER_2D 			= 35678;

	
	public static final int GL_SCISSOR_TEST 		= 3089;
	public static final int GL_DEPTH_TEST 			= 2929;
	
	public static final int GL_BLEND 				= 3042;
	public static final int GL_SRC_ALPHA 			= 770;
	public static final int GL_ONE_MINUS_SRC_ALPHA 	= 771;
	
	public static final int GL_CULL_FACE 			= 2884;
	public static final int GL_FRONT 				= 1028;
	public static final int GL_BACK 				= 1029;
	
	public static final int GL_LESS 				= 513;
	public static final int GL_EQUAL 				= 514;
	public static final int GL_LEQUAL 				= 515;
	public static final int GL_GREATER 				= 516;
	public static final int GL_NOTEQUAL 			= 517;
	public static final int GL_GEQUAL 				= 518;
	
	
	public static final int GL_DEPTH_BUFFER_BIT 	= 256;
	public static final int GL_COLOR_BUFFER_BIT 	= 16384;
	
	
	public static final int GL_FRAGMENT_SHADER 		= 35632;
	public static final int GL_VERTEX_SHADER 		= 35633;
	public static final int GL_COMPILE_STATUS 		= 35713;
	
	public static final int GL_LINK_STATUS 			= 35714;
	public static final int GL_VALIDATE_STATUS 		= 35715;
	public static final int GL_ACTIVE_UNIFORMS 		= 35718;
	public static final int GL_ACTIVE_ATTRIBUTES 	= 35721;
	
	public static final int GL_TEXTURE_2D 			= 3553;
	public static final int GL_TEXTURE0 			= 33984;
	
	
	public static final int GL_DEPTH_COMPONENT 		= 6402;
	public static final int GL_ALPHA 				= 6406;  
	public static final int GL_RGB 					= 6407;  
	public static final int GL_RGBA 				= 6408;  
	public static final int GL_LUMINANCE 			= 6409;  
	public static final int GL_LUMINANCE_ALPHA 		= 6410;
	
	public static final int GL_TEXTURE_WRAP_S 			= 10242;
	public static final int GL_TEXTURE_WRAP_T 			= 10243;
	public static final int GL_REPEAT 					= 10497;
	public static final int GL_CLAMP_TO_EDGE 			= 33071;
	public static final int GL_MIRRORED_REPEAT 			= 33648;
	
	public static final int GL_TEXTURE_MAG_FILTER 		= 10240;
	public static final int GL_TEXTURE_MIN_FILTER 		= 10241;
	public static final int GL_NEAREST 					= 9728;
	public static final int GL_LINEAR 					= 9729;
	public static final int GL_NEAREST_MIPMAP_NEAREST 	= 9984;
	public static final int GL_LINEAR_MIPMAP_NEAREST 	= 9985;
	public static final int GL_NEAREST_MIPMAP_LINEAR 	= 9986;
	public static final int GL_LINEAR_MIPMAP_LINEAR 	= 9987;
	
	public static final int GL_ARRAY_BUFFER 			= 34962;
	public static final int GL_ELEMENT_ARRAY_BUFFER 	= 34963;
	public static final int GL_FRAMEBUFFER 				= 36160;
	public static final int GL_RENDERBUFFER 			= 36161;
	
	public static final int GL_FRAMEBUFFER_COMPLETE 						= 36053;
	public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT 			= 36054;
	public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT 	= 36055;
	public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS 			= 36057;
	public static final int GL_FRAMEBUFFER_UNSUPPORTED 						= 36061;
	
	public static final int GL_MAX_RENDERBUFFER_SIZE 	= 34024;
	public static final int GL_RGBA4 					= 32854;
	public static final int GL_RGB5_A1 					= 32855;
	//public static final int GL_RGB565 					= 36194;
	public static final int GL_DEPTH_COMPONENT16 		= 33189;
	public static final int GL_STENCIL_INDEX8 			= 36168;
	
	public static final int GL_UNSIGNED_SHORT_4_4_4_4 	= 32819;
	public static final int GL_UNSIGNED_SHORT_5_5_5_1 	= 32820;
	
	public static final int GL_COLOR_ATTACHMENT0 		= 36064;
	public static final int GL_DEPTH_ATTACHMENT 		= 36096;
	public static final int GL_STENCIL_ATTACHMENT 		= 36128;
	
	public static final int GL_POINTS 					= 0;
	public static final int GL_LINES 					= 1;
	public static final int GL_LINE_LOOP 				= 2;
	public static final int GL_LINE_STRIP 				= 3;
	public static final int GL_TRIANGLES 				= 4;
	public static final int GL_TRIANGLE_STRIP 			= 5;
	public static final int GL_TRIANGLE_FAN 			= 6;
	
	
	public static final int GL_STREAM_DRAW 				= 35040;
	public static final int GL_STATIC_DRAW 				= 35044;
	public static final int GL_DYNAMIC_DRAW 			= 35048;
	  
	
	public static final int GL_UNPACK_ALIGNMENT 		= 3317;
	public static final int GL_PACK_ALIGNMENT 			= 3333;
	  
	/*
	// Field descriptor #8 I
	  public static final int GL_ACTIVE_TEXTURE = 34016;
	  
	  // Field descriptor #8 I
	  public static final int GL_DEPTH_BUFFER_BIT = 256;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_BUFFER_BIT = 1024;
	  
	  // Field descriptor #8 I
	  public static final int GL_COLOR_BUFFER_BIT = 16384;
	  
	  // Field descriptor #8 I
	  public static final int GL_FALSE = 0;
	  
	  // Field descriptor #8 I
	  public static final int GL_TRUE = 1;
	  
	  // Field descriptor #8 I
	  public static final int GL_POINTS = 0;
	  
	  // Field descriptor #8 I
	  public static final int GL_LINES = 1;
	  
	  // Field descriptor #8 I
	  public static final int GL_LINE_LOOP = 2;
	  
	  // Field descriptor #8 I
	  public static final int GL_LINE_STRIP = 3;
	  
	  // Field descriptor #8 I
	  public static final int GL_TRIANGLES = 4;
	  
	  // Field descriptor #8 I
	  public static final int GL_TRIANGLE_STRIP = 5;
	  
	  // Field descriptor #8 I
	  public static final int GL_TRIANGLE_FAN = 6;
	  
	  // Field descriptor #8 I
	  public static final int GL_ZERO = 0;
	  
	  // Field descriptor #8 I
	  public static final int GL_ONE = 1;
	  
	  // Field descriptor #8 I
	  public static final int GL_SRC_COLOR = 768;
	  
	  // Field descriptor #8 I
	  public static final int GL_ONE_MINUS_SRC_COLOR = 769;
	  
	  // Field descriptor #8 I
	  public static final int GL_SRC_ALPHA = 770;
	  
	  // Field descriptor #8 I
	  public static final int GL_ONE_MINUS_SRC_ALPHA = 771;
	  
	  // Field descriptor #8 I
	  public static final int GL_DST_ALPHA = 772;
	  
	  // Field descriptor #8 I
	  public static final int GL_ONE_MINUS_DST_ALPHA = 773;
	  
	  // Field descriptor #8 I
	  public static final int GL_DST_COLOR = 774;
	  
	  // Field descriptor #8 I
	  public static final int GL_ONE_MINUS_DST_COLOR = 775;
	  
	  // Field descriptor #8 I
	  public static final int GL_SRC_ALPHA_SATURATE = 776;
	  
	  // Field descriptor #8 I
	  public static final int GL_FUNC_ADD = 32774;
	  
	  // Field descriptor #8 I
	  public static final int GL_BLEND_EQUATION = 32777;
	  
	  // Field descriptor #8 I
	  public static final int GL_BLEND_EQUATION_RGB = 32777;
	  
	  // Field descriptor #8 I
	  public static final int GL_BLEND_EQUATION_ALPHA = 34877;
	  
	  // Field descriptor #8 I
	  public static final int GL_FUNC_SUBTRACT = 32778;
	  
	  // Field descriptor #8 I
	  public static final int GL_FUNC_REVERSE_SUBTRACT = 32779;
	  
	  // Field descriptor #8 I
	  public static final int GL_BLEND_DST_RGB = 32968;
	  
	  // Field descriptor #8 I
	  public static final int GL_BLEND_SRC_RGB = 32969;
	  
	  // Field descriptor #8 I
	  public static final int GL_BLEND_DST_ALPHA = 32970;
	  
	  // Field descriptor #8 I
	  public static final int GL_BLEND_SRC_ALPHA = 32971;
	  
	  // Field descriptor #8 I
	  public static final int GL_CONSTANT_COLOR = 32769;
	  
	  // Field descriptor #8 I
	  public static final int GL_ONE_MINUS_CONSTANT_COLOR = 32770;
	  
	  // Field descriptor #8 I
	  public static final int GL_CONSTANT_ALPHA = 32771;
	  
	  // Field descriptor #8 I
	  public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 32772;
	  
	  // Field descriptor #8 I
	  public static final int GL_BLEND_COLOR = 32773;
	  
	  // Field descriptor #8 I
	  public static final int GL_ARRAY_BUFFER = 34962;
	  
	  // Field descriptor #8 I
	  public static final int GL_ELEMENT_ARRAY_BUFFER = 34963;
	  
	  // Field descriptor #8 I
	  public static final int GL_ARRAY_BUFFER_BINDING = 34964;
	  
	  // Field descriptor #8 I
	  public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965;
	  
	  // Field descriptor #8 I
	  public static final int GL_STREAM_DRAW = 35040;
	  
	  // Field descriptor #8 I
	  public static final int GL_STATIC_DRAW = 35044;
	  
	  // Field descriptor #8 I
	  public static final int GL_DYNAMIC_DRAW = 35048;
	  
	  // Field descriptor #8 I
	  public static final int GL_BUFFER_SIZE = 34660;
	  
	  // Field descriptor #8 I
	  public static final int GL_BUFFER_USAGE = 34661;
	  
	  // Field descriptor #8 I
	  public static final int GL_CURRENT_VERTEX_ATTRIB = 34342;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRONT = 1028;
	  
	  // Field descriptor #8 I
	  public static final int GL_BACK = 1029;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRONT_AND_BACK = 1032;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_2D = 3553;
	  
	  // Field descriptor #8 I
	  public static final int GL_CULL_FACE = 2884;
	  
	  // Field descriptor #8 I
	  public static final int GL_BLEND = 3042;
	  
	  // Field descriptor #8 I
	  public static final int GL_DITHER = 3024;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_TEST = 2960;
	  
	  // Field descriptor #8 I
	  public static final int GL_DEPTH_TEST = 2929;
	  
	  // Field descriptor #8 I
	  public static final int GL_SCISSOR_TEST = 3089;
	  
	  // Field descriptor #8 I
	  public static final int GL_POLYGON_OFFSET_FILL = 32823;
	  
	  // Field descriptor #8 I
	  public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 32926;
	  
	  // Field descriptor #8 I
	  public static final int GL_SAMPLE_COVERAGE = 32928;
	  
	  // Field descriptor #8 I
	  public static final int GL_NO_ERROR = 0;
	  
	  // Field descriptor #8 I
	  public static final int GL_INVALID_ENUM = 1280;
	  
	  // Field descriptor #8 I
	  public static final int GL_INVALID_VALUE = 1281;
	  
	  // Field descriptor #8 I
	  public static final int GL_INVALID_OPERATION = 1282;
	  
	  // Field descriptor #8 I
	  public static final int GL_OUT_OF_MEMORY = 1285;
	  
	  // Field descriptor #8 I
	  public static final int GL_CW = 2304;
	  
	  // Field descriptor #8 I
	  public static final int GL_CCW = 2305;
	  
	  // Field descriptor #8 I
	  public static final int GL_LINE_WIDTH = 2849;
	  
	  // Field descriptor #8 I
	  public static final int GL_ALIASED_POINT_SIZE_RANGE = 33901;
	  
	  // Field descriptor #8 I
	  public static final int GL_ALIASED_LINE_WIDTH_RANGE = 33902;
	  
	  // Field descriptor #8 I
	  public static final int GL_CULL_FACE_MODE = 2885;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRONT_FACE = 2886;
	  
	  // Field descriptor #8 I
	  public static final int GL_DEPTH_RANGE = 2928;
	  
	  // Field descriptor #8 I
	  public static final int GL_DEPTH_WRITEMASK = 2930;
	  
	  // Field descriptor #8 I
	  public static final int GL_DEPTH_CLEAR_VALUE = 2931;
	  
	  // Field descriptor #8 I
	  public static final int GL_DEPTH_FUNC = 2932;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_CLEAR_VALUE = 2961;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_FUNC = 2962;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_FAIL = 2964;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_PASS_DEPTH_FAIL = 2965;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_PASS_DEPTH_PASS = 2966;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_REF = 2967;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_VALUE_MASK = 2963;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_WRITEMASK = 2968;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_BACK_FUNC = 34816;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_BACK_FAIL = 34817;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 34818;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 34819;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_BACK_REF = 36003;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_BACK_VALUE_MASK = 36004;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_BACK_WRITEMASK = 36005;
	  
	  // Field descriptor #8 I
	  public static final int GL_VIEWPORT = 2978;
	  
	  // Field descriptor #8 I
	  public static final int GL_SCISSOR_BOX = 3088;
	  
	  // Field descriptor #8 I
	  public static final int GL_COLOR_CLEAR_VALUE = 3106;
	  
	  // Field descriptor #8 I
	  public static final int GL_COLOR_WRITEMASK = 3107;
	  
	  // Field descriptor #8 I
	  public static final int GL_UNPACK_ALIGNMENT = 3317;
	  
	  // Field descriptor #8 I
	  public static final int GL_PACK_ALIGNMENT = 3333;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_TEXTURE_SIZE = 3379;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_VIEWPORT_DIMS = 3386;
	  
	  // Field descriptor #8 I
	  public static final int GL_SUBPIXEL_BITS = 3408;
	  
	  // Field descriptor #8 I
	  public static final int GL_RED_BITS = 3410;
	  
	  // Field descriptor #8 I
	  public static final int GL_GREEN_BITS = 3411;
	  
	  // Field descriptor #8 I
	  public static final int GL_BLUE_BITS = 3412;
	  
	  // Field descriptor #8 I
	  public static final int GL_ALPHA_BITS = 3413;
	  
	  // Field descriptor #8 I
	  public static final int GL_DEPTH_BITS = 3414;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_BITS = 3415;
	  
	  // Field descriptor #8 I
	  public static final int GL_POLYGON_OFFSET_UNITS = 10752;
	  
	  // Field descriptor #8 I
	  public static final int GL_POLYGON_OFFSET_FACTOR = 32824;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_BINDING_2D = 32873;
	  
	  // Field descriptor #8 I
	  public static final int GL_SAMPLE_BUFFERS = 32936;
	  
	  // Field descriptor #8 I
	  public static final int GL_SAMPLES = 32937;
	  
	  // Field descriptor #8 I
	  public static final int GL_SAMPLE_COVERAGE_VALUE = 32938;
	  
	  // Field descriptor #8 I
	  public static final int GL_SAMPLE_COVERAGE_INVERT = 32939;
	  
	  // Field descriptor #8 I
	  public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 34466;
	  
	  // Field descriptor #8 I
	  public static final int GL_COMPRESSED_TEXTURE_FORMATS = 34467;
	  
	  // Field descriptor #8 I
	  public static final int GL_DONT_CARE = 4352;
	  
	  // Field descriptor #8 I
	  public static final int GL_FASTEST = 4353;
	  
	  // Field descriptor #8 I
	  public static final int GL_NICEST = 4354;
	  
	  // Field descriptor #8 I
	  public static final int GL_GENERATE_MIPMAP_HINT = 33170;
	  
	  // Field descriptor #8 I
	  public static final int GL_BYTE = 5120;
	  
	  // Field descriptor #8 I
	  public static final int GL_UNSIGNED_BYTE = 5121;
	  
	  // Field descriptor #8 I
	  public static final int GL_SHORT = 5122;
	  
	  // Field descriptor #8 I
	  public static final int GL_UNSIGNED_SHORT = 5123;
	  
	  // Field descriptor #8 I
	  public static final int GL_INT = 5124;
	  
	  // Field descriptor #8 I
	  public static final int GL_UNSIGNED_INT = 5125;
	  
	  // Field descriptor #8 I
	  public static final int GL_FLOAT = 5126;
	  
	  // Field descriptor #8 I
	  public static final int GL_FIXED = 5132;
	  
	  // Field descriptor #8 I
	  public static final int GL_DEPTH_COMPONENT = 6402;
	  
	  // Field descriptor #8 I
	  public static final int GL_ALPHA = 6406;
	  
	  // Field descriptor #8 I
	  public static final int GL_RGB = 6407;
	  
	  // Field descriptor #8 I
	  public static final int GL_RGBA = 6408;
	  
	  // Field descriptor #8 I
	  public static final int GL_LUMINANCE = 6409;
	  
	  // Field descriptor #8 I
	  public static final int GL_LUMINANCE_ALPHA = 6410;
	  
	  // Field descriptor #8 I
	  public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 32819;
	  
	  // Field descriptor #8 I
	  public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 32820;
	  
	  // Field descriptor #8 I
	  public static final int GL_UNSIGNED_SHORT_5_6_5 = 33635;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAGMENT_SHADER = 35632;
	  
	  // Field descriptor #8 I
	  public static final int GL_VERTEX_SHADER = 35633;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_VERTEX_ATTRIBS = 34921;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 36347;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_VARYING_VECTORS = 36348;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 35661;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 35660;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 34930;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 36349;
	  
	  // Field descriptor #8 I
	  public static final int GL_SHADER_TYPE = 35663;
	  
	  // Field descriptor #8 I
	  public static final int GL_DELETE_STATUS = 35712;
	  
	  // Field descriptor #8 I
	  public static final int GL_LINK_STATUS = 35714;
	  
	  // Field descriptor #8 I
	  public static final int GL_VALIDATE_STATUS = 35715;
	  
	  // Field descriptor #8 I
	  public static final int GL_ATTACHED_SHADERS = 35717;
	  
	  // Field descriptor #8 I
	  public static final int GL_ACTIVE_UNIFORMS = 35718;
	  
	  // Field descriptor #8 I
	  public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 35719;
	  
	  // Field descriptor #8 I
	  public static final int GL_ACTIVE_ATTRIBUTES = 35721;
	  
	  // Field descriptor #8 I
	  public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 35722;
	  
	  // Field descriptor #8 I
	  public static final int GL_SHADING_LANGUAGE_VERSION = 35724;
	  
	  // Field descriptor #8 I
	  public static final int GL_CURRENT_PROGRAM = 35725;
	  
	  // Field descriptor #8 I
	  public static final int GL_NEVER = 512;
	  
	  // Field descriptor #8 I
	  public static final int GL_LESS = 513;
	  
	  // Field descriptor #8 I
	  public static final int GL_EQUAL = 514;
	  
	  // Field descriptor #8 I
	  public static final int GL_LEQUAL = 515;
	  
	  // Field descriptor #8 I
	  public static final int GL_GREATER = 516;
	  
	  // Field descriptor #8 I
	  public static final int GL_NOTEQUAL = 517;
	  
	  // Field descriptor #8 I
	  public static final int GL_GEQUAL = 518;
	  
	  // Field descriptor #8 I
	  public static final int GL_ALWAYS = 519;
	  
	  // Field descriptor #8 I
	  public static final int GL_KEEP = 7680;
	  
	  // Field descriptor #8 I
	  public static final int GL_REPLACE = 7681;
	  
	  // Field descriptor #8 I
	  public static final int GL_INCR = 7682;
	  
	  // Field descriptor #8 I
	  public static final int GL_DECR = 7683;
	  
	  // Field descriptor #8 I
	  public static final int GL_INVERT = 5386;
	  
	  // Field descriptor #8 I
	  public static final int GL_INCR_WRAP = 34055;
	  
	  // Field descriptor #8 I
	  public static final int GL_DECR_WRAP = 34056;
	  
	  // Field descriptor #8 I
	  public static final int GL_VENDOR = 7936;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERER = 7937;
	  
	  // Field descriptor #8 I
	  public static final int GL_VERSION = 7938;
	  
	  // Field descriptor #8 I
	  public static final int GL_EXTENSIONS = 7939;
	  
	  // Field descriptor #8 I
	  public static final int GL_NEAREST = 9728;
	  
	  // Field descriptor #8 I
	  public static final int GL_LINEAR = 9729;
	  
	  // Field descriptor #8 I
	  public static final int GL_NEAREST_MIPMAP_NEAREST = 9984;
	  
	  // Field descriptor #8 I
	  public static final int GL_LINEAR_MIPMAP_NEAREST = 9985;
	  
	  // Field descriptor #8 I
	  public static final int GL_NEAREST_MIPMAP_LINEAR = 9986;
	  
	  // Field descriptor #8 I
	  public static final int GL_LINEAR_MIPMAP_LINEAR = 9987;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_MAG_FILTER = 10240;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_MIN_FILTER = 10241;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_WRAP_S = 10242;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_WRAP_T = 10243;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE = 5890;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_CUBE_MAP = 34067;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_BINDING_CUBE_MAP = 34068;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 34069;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 34070;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 34071;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 34072;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 34073;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 34074;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 34076;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE0 = 33984;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE1 = 33985;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE2 = 33986;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE3 = 33987;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE4 = 33988;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE5 = 33989;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE6 = 33990;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE7 = 33991;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE8 = 33992;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE9 = 33993;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE10 = 33994;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE11 = 33995;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE12 = 33996;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE13 = 33997;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE14 = 33998;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE15 = 33999;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE16 = 34000;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE17 = 34001;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE18 = 34002;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE19 = 34003;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE20 = 34004;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE21 = 34005;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE22 = 34006;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE23 = 34007;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE24 = 34008;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE25 = 34009;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE26 = 34010;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE27 = 34011;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE28 = 34012;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE29 = 34013;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE30 = 34014;
	  
	  // Field descriptor #8 I
	  public static final int GL_TEXTURE31 = 34015;
	  
	  // Field descriptor #8 I
	  public static final int GL_REPEAT = 10497;
	  
	  // Field descriptor #8 I
	  public static final int GL_CLAMP_TO_EDGE = 33071;
	  
	  // Field descriptor #8 I
	  public static final int GL_MIRRORED_REPEAT = 33648;
	  
	  // Field descriptor #8 I
	  public static final int GL_FLOAT_VEC2 = 35664;
	  
	  // Field descriptor #8 I
	  public static final int GL_FLOAT_VEC3 = 35665;
	  
	  // Field descriptor #8 I
	  public static final int GL_FLOAT_VEC4 = 35666;
	  
	  // Field descriptor #8 I
	  public static final int GL_INT_VEC2 = 35667;
	  
	  // Field descriptor #8 I
	  public static final int GL_INT_VEC3 = 35668;
	  
	  // Field descriptor #8 I
	  public static final int GL_INT_VEC4 = 35669;
	  
	  // Field descriptor #8 I
	  public static final int GL_BOOL = 35670;
	  
	  // Field descriptor #8 I
	  public static final int GL_BOOL_VEC2 = 35671;
	  
	  // Field descriptor #8 I
	  public static final int GL_BOOL_VEC3 = 35672;
	  
	  // Field descriptor #8 I
	  public static final int GL_BOOL_VEC4 = 35673;
	  
	  // Field descriptor #8 I
	  public static final int GL_FLOAT_MAT2 = 35674;
	  
	  // Field descriptor #8 I
	  public static final int GL_FLOAT_MAT3 = 35675;
	  
	  // Field descriptor #8 I
	  public static final int GL_FLOAT_MAT4 = 35676;
	  
	  // Field descriptor #8 I
	  public static final int GL_SAMPLER_2D = 35678;
	  
	  // Field descriptor #8 I
	  public static final int GL_SAMPLER_CUBE = 35680;
	  
	  // Field descriptor #8 I
	  public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 34338;
	  
	  // Field descriptor #8 I
	  public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 34339;
	  
	  // Field descriptor #8 I
	  public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 34340;
	  
	  // Field descriptor #8 I
	  public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 34341;
	  
	  // Field descriptor #8 I
	  public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 34922;
	  
	  // Field descriptor #8 I
	  public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 34373;
	  
	  // Field descriptor #8 I
	  public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975;
	  
	  // Field descriptor #8 I
	  public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 35738;
	  
	  // Field descriptor #8 I
	  public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 35739;
	  
	  // Field descriptor #8 I
	  public static final int GL_COMPILE_STATUS = 35713;
	  
	  // Field descriptor #8 I
	  public static final int GL_INFO_LOG_LENGTH = 35716;
	  
	  // Field descriptor #8 I
	  public static final int GL_SHADER_SOURCE_LENGTH = 35720;
	  
	  // Field descriptor #8 I
	  public static final int GL_SHADER_COMPILER = 36346;
	  
	  // Field descriptor #8 I
	  public static final int GL_SHADER_BINARY_FORMATS = 36344;
	  
	  // Field descriptor #8 I
	  public static final int GL_NUM_SHADER_BINARY_FORMATS = 36345;
	  
	  // Field descriptor #8 I
	  public static final int GL_LOW_FLOAT = 36336;
	  
	  // Field descriptor #8 I
	  public static final int GL_MEDIUM_FLOAT = 36337;
	  
	  // Field descriptor #8 I
	  public static final int GL_HIGH_FLOAT = 36338;
	  
	  // Field descriptor #8 I
	  public static final int GL_LOW_INT = 36339;
	  
	  // Field descriptor #8 I
	  public static final int GL_MEDIUM_INT = 36340;
	  
	  // Field descriptor #8 I
	  public static final int GL_HIGH_INT = 36341;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER = 36160;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER = 36161;
	  
	  // Field descriptor #8 I
	  public static final int GL_RGBA4 = 32854;
	  
	  // Field descriptor #8 I
	  public static final int GL_RGB5_A1 = 32855;
	  
	  // Field descriptor #8 I
	  public static final int GL_RGB565 = 36194;
	  
	  // Field descriptor #8 I
	  public static final int GL_DEPTH_COMPONENT16 = 33189;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_INDEX = 6401;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_INDEX8 = 36168;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER_WIDTH = 36162;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER_HEIGHT = 36163;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 36164;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER_RED_SIZE = 36176;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER_GREEN_SIZE = 36177;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER_BLUE_SIZE = 36178;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER_ALPHA_SIZE = 36179;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER_DEPTH_SIZE = 36180;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER_STENCIL_SIZE = 36181;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051;
	  
	  // Field descriptor #8 I
	  public static final int GL_COLOR_ATTACHMENT0 = 36064;
	  
	  // Field descriptor #8 I
	  public static final int GL_DEPTH_ATTACHMENT = 36096;
	  
	  // Field descriptor #8 I
	  public static final int GL_STENCIL_ATTACHMENT = 36128;
	  
	  // Field descriptor #8 I
	  public static final int GL_NONE = 0;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER_COMPLETE = 36053;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS = 36057;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061;
	  
	  // Field descriptor #8 I
	  public static final int GL_FRAMEBUFFER_BINDING = 36006;
	  
	  // Field descriptor #8 I
	  public static final int GL_RENDERBUFFER_BINDING = 36007;
	  
	  // Field descriptor #8 I
	  public static final int GL_MAX_RENDERBUFFER_SIZE = 34024;
	  
	  // Field descriptor #8 I
	  public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286;
	  */
}
