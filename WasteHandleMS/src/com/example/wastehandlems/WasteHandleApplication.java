package com.example.wastehandlems;

import android.app.Application;

public class WasteHandleApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
//		
//		ImageLoaderConfiguration imageLoaderConfig = new ImageLoaderConfiguration.Builder(
//                getApplicationContext())
//                .threadPoolSize(5)
//                .denyCacheImageMultipleSizesInMemory()  
//                .discCacheFileNameGenerator(new Md5FileNameGenerator()) 
//                .build();
//		ImageLoader.getInstance().init(imageLoaderConfig);
//		
//		String errorMessage = null;
//		try {
//			Log.e("", "RegistryConfiguration.init(this);");
//			RegistryConfiguration.init(this);
//		} catch(RegistryConfigurationException pce) {
//			errorMessage = String.format("Error in loading configuration: %s", pce.getMessage());
//			System.out.println(String.format("Error in loading configuration: %s", errorMessage));
//		}
	}
	
//	private static DisplayImageOptions defaultDisplayImageOptions;
//	public static DisplayImageOptions getDefaultDisplayImageOptions() {
//		if(defaultDisplayImageOptions==null){
//			defaultDisplayImageOptions=new DisplayImageOptions.Builder()
//			.showImageOnLoading(null)
//			.showImageForEmptyUri(null)
//			.showImageOnFail(null)
//			.cacheInMemory(true)
//			.cacheOnDisc(true)
//			.displayer(new FadeInBitmapDisplayer(500))
//			.build();
//		}
//		return defaultDisplayImageOptions;
//	}
}
