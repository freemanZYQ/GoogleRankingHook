package com.tools.hackandroid.gp;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class SharedLibraryFactory
{
	private static String[] libs;
	
	private static Set<String> exs;
	
	public static String[] getSharedLibs()
	{
		if(libs == null)
		{
			List<String> arrs = new Vector<String>();
			arrs.add("javax.obex");
			arrs.add("com.google.android.media.effects");
			arrs.add("com.android.future.usb.accessory");
			arrs.add("android.test.runner");
			arrs.add("com.google.widevine.software.drm");
			arrs.add("com.google.android.maps");
			arrs.add("com.android.nfc_extras");
			arrs.add("com.android.location.provider");
			arrs.add("com.google.android.gms");
			arrs.add("com.android.media.remotedisplay");
			arrs.add("com.android.mediadrm.signer");
			arrs.add("protobufs-2.3.0");
			arrs.add("com.quicinc.cneapiclient");
			
			arrs.add("com.qualcomm.qcrilhook");
			arrs.add("com.android.lge.lgsvcitems");
			arrs.add("com.google.android.camera2");
			/*arrs.add("qcom.fmradio");
			arrs.add("com.qualcomm.qcnvitems");
			arrs.add("com.qualcomm.location.vzw_library");
			
			arrs.add("com.motorola.gallery");
			arrs.add("com.motorola.frameworks.core.addon");
			arrs.add("com.motorola.motosignature");
			arrs.add("com.motorola.moodle.library");
			arrs.add("com.motorola.android.encryption");*/
			
			arrs.add("access.control");
			arrs.add("allshare");
			arrs.add("allsharelib");
			arrs.add("com.samsung.device");
			arrs.add("com.sec.android.app.minimode");
			arrs.add("com.sec.android.app.multiwindow");
			arrs.add("com.sec.android.mdm");
			arrs.add("kies_feature");
			arrs.add("libvtmanagerjar");
			arrs.add("org.simalliance.openmobileapi");
			arrs.add("sec_feature");
			arrs.add("sec_platform_library");
			arrs.add("sec_platform_library");
			arrs.add("sechardware");
			arrs.add("secmediarecorder");
			arrs.add("touchwiz");
			arrs.add("samsung_library_music");
			arrs.add("sec_feature");
			arrs.add("sec_platform_library");
			arrs.add("seccamera");
			arrs.add("sechardware");
			arrs.add("touchwiz");
			arrs.add("videowall");
			arrs.add("sws");
			arrs.add("svi");
			arrs.add("smatlib");
			arrs.add("smartfaceservice");
			arrs.add("sgi");
			arrs.add("secvision");
			arrs.add("secmediarecorder");
			
			libs = arrs.toArray(new String[]{});
		}
		return libs;
	}
	
	public static Set<String> getExtensions()
	{
		if(exs == null)
		{
			exs = Collections.synchronizedSet(new HashSet<String>());
			exs.add("GL_AMD_compressed_ATC_texture");
			exs.add("GL_AMD_performance_monitor");
			exs.add("GL_AMD_program_binary_Z400");
			exs.add("GL_APPLE_texture_2D_limited_npot");
			exs.add("GL_ARB_vertex_buffer_object");
			exs.add("GL_EXT_color_buffer_float");
			exs.add("GL_EXT_color_buffer_half_float");
			exs.add("GL_EXT_debug_label");
			exs.add("GL_EXT_debug_marker");
			exs.add("GL_EXT_discard_framebuffer");
			exs.add("GL_EXT_disjoint_timer_query");
			exs.add("GL_EXT_multisampled_render_to_texture");
			exs.add("GL_EXT_robustness");
			exs.add("GL_EXT_sRGB");
			exs.add("GL_EXT_sRGB_write_control");
			exs.add("GL_EXT_texture_filter_anisotropic");
			exs.add("GL_EXT_texture_format_BGRA8888");
			exs.add("GL_EXT_texture_sRGB_decode");
			exs.add("GL_EXT_texture_type_2_10_10_10_REV");
			exs.add("GL_NV_fence");
			exs.add("GL_OES_EGL_image");
			exs.add("GL_OES_EGL_image_external");
			exs.add("GL_OES_EGL_sync");
			exs.add("GL_OES_blend_equation_separate");
			exs.add("GL_OES_blend_func_separate");
			exs.add("GL_OES_blend_subtract");
			exs.add("GL_OES_compressed_ETC1_RGB8_texture");
			exs.add("GL_OES_compressed_paletted_texture");
			exs.add("GL_OES_depth24");
			exs.add("GL_OES_depth_texture");
			exs.add("GL_OES_depth_texture_cube_map");
			exs.add("GL_OES_draw_texture");
			exs.add("GL_OES_element_index_uint");
			exs.add("GL_OES_fbo_render_mipmap");
			exs.add("GL_OES_fragment_precision_high");
			exs.add("GL_OES_framebuffer_object");
			exs.add("GL_OES_get_program_binary");
			exs.add("GL_OES_matrix_palette");
			exs.add("GL_OES_packed_depth_stencil");
			exs.add("GL_OES_point_size_array");
			exs.add("GL_OES_point_sprite");
			exs.add("GL_OES_read_format");
			exs.add("GL_OES_rgb8_rgba8");
			exs.add("GL_OES_standard_derivatives");
			exs.add("GL_OES_stencil_wrap");
			exs.add("GL_OES_texture_3D");
			exs.add("GL_OES_texture_cube_map");
			exs.add("GL_OES_texture_env_crossbar");
			exs.add("GL_OES_texture_float");
			exs.add("GL_OES_texture_half_float");
			exs.add("GL_OES_texture_half_float_linear");
			exs.add("GL_OES_texture_mirrored_repeat");
			exs.add("GL_OES_texture_npot");
			exs.add("GL_OES_vertex_array_object");
			exs.add("GL_OES_vertex_half_float");
			exs.add("GL_OES_vertex_type_10_10_10_2");
			exs.add("GL_QCOM_alpha_test");
			exs.add("GL_QCOM_binning_control");
			exs.add("GL_QCOM_driver_control");
			exs.add("GL_QCOM_extended_get");
			exs.add("GL_QCOM_extended_get2");
			exs.add("GL_QCOM_perfmon_global_mode");
			exs.add("GL_QCOM_tiled_rendering");
			exs.add("GL_QCOM_writeonly_rendering");
		}
		return exs;
	}

}
