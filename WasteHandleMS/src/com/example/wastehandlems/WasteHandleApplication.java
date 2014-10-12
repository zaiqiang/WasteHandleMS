package com.example.wastehandlems;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.app.Application;
import android.util.Log;

public class WasteHandleApplication extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
		ImageLoaderConfiguration imageLoaderConfig = new ImageLoaderConfiguration.Builder(
                getApplicationContext())
                .threadPoolSize(5)
                .denyCacheImageMultipleSizesInMemory()  
                .discCacheFileNameGenerator(new Md5FileNameGenerator()) 
                .build();
		ImageLoader.getInstance().init(imageLoaderConfig);
		
		String errorMessage = null;
		try {
			WasteHandleConfiguration.init(this);
		} catch(WasteHandleCofigurationException pce) {
			errorMessage = String.format("Error in loading configuration: %s", pce.getMessage());
			System.out.println(String.format("Error in loading configuration: %s", errorMessage));
		}
	}
	
	private static DisplayImageOptions defaultDisplayImageOptions;
	public static DisplayImageOptions getDefaultDisplayImageOptions() {
		if(defaultDisplayImageOptions==null){
			defaultDisplayImageOptions=new DisplayImageOptions.Builder()
			.showImageForEmptyUri(R.drawable.ic_empty)
			.showImageOnFail(R.drawable.ic_error)
			.cacheInMemory(true)
			.cacheOnDisc(true)
			.displayer(new RoundedBitmapDisplayer(20))
			.build();
		}
		return defaultDisplayImageOptions;
	}
}
