#编译相应的平台
APP_ABI := all
#APP_ABI := armeabi-v7a x86 mips

#支持的android sdk版本 
#APP_PLATFORM := android-10

#http://www.open-open.com/bbs/view/1319209398468
#下面这句应该是支持c++stl模块，如c++的vector/string等,有四个选项
	#system - 使用默认最小的C++运行库，这样生成的应用体积小，内存占用小，但部分功能将无法支持
	#stlport_static - 使用STLport作为静态库，这项是Android开发网极力推荐的
	#stlport_shared - STLport 作为动态库，这个可能产生兼容性和部分低版本的Android固件，目前不推荐使用。
	#gnustl_static  - 使用 GNU libstdc++ 作为静态库
	
APP_STL := stlport_static

#支持C++异常处理的
LOCAL_CPPFLAGS += -frtti -fexceptions
APP_CPPFLAGS := -frtti -fexceptions -O2 -mfpu=neon -mfloat-abi=softfp  -std=c++11 
#LOCAL_ARM_NEON := true
