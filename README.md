# libmuse
_NOTE: This is an unofficial version of the Android library for interfacing with the Muse EEG headset._

The [Muse](https://www.muse-project.org/) headset is a research-grade, low-cost EEG headset that is designed to be used by researchers and clinicians in the field of EEG research. The Muse headset is a low-cost, wireless headset that can be worn on the head, or worn on the chest. The Muse headset is designed to be used by researchers and clinicians in the field of EEG research.

Muse has officially discontinued support for the Android and iOS SDKs and is no longer being actively developed.

## About the Muse SDK: <a name = "about-the-muse-sdk"></a>
The Muse SDK is a set of libraries and tools that allow you to connect to the Muse headset and use its EEG data. It was developed by [Muse Labs](https://www.muse-project.org/) for the Muse 1 headset. It has not been tested on the newer Muse 2 headset and Muse S headset and is not garaunteed to work on these devices.

## Getting Started: <a name = "getting-started"></a>
To get started:
 - Check out the examples in the `examples` folder
 - Check out the [Muse SDK documentation](https://siddhantattavar.github.io/libmuse/)

To run the sample Android App, use the instructions from [this guide](https://sites.google.com/a/interaxon.ca/muse-developer-site/libmuse/android-development).

### Option 1: Using Android Studio (Recommended) <a name = "option-1-using-android-studio"></a>
 - Clone this repository: `git clone https://github.com/SiddhantAttavar/libmuse.git`
 - Install [Android Studio](https://developer.android.com/studio)
 - Open the SDK Manager in Android Studio by going to `Tools -> Android -> SDK Manager`.
 - Select packages and install them:
	 - Android SDK Platform-Tools (Rev 21)
	 - Android SDK Build-Tools (21.1.2)
	 - Android Build Tools (Rev 19)
	 - Android 5.0.1 (API 21) -> SDK Platform
	 - Android 4.4.2 (API 19)
 - Go to `File -> Import Project ...`
 - Navigate to `yourInstallDir/libmuse/examples/TestLibMuseAndroid/AndroidManifest.xml`.
Select the file and open it. Click through all the defaults for importing
 - Select `AndroidManifest.xml`. Now go to `Build -> Make Project`. You should see `BUILD SUCCESSFUL`
 - Enable USB debugging in the `Settings -> Developer Options -> USB Debugging` menu
 - Plug the Android device into your computer
 - Go to `Run -> Run app`. You should see the example app appear on your Android device.  You will need to place the Muse on your head in order to see the `Muse Elements` numbers start to appear.


### Option 2: Using Eclipse <a name = "option-2-using-eclipse"></a>
- Clone this repository: `git clone https://github.com/SiddhantAttavar/libmuse.git`
 - Install [Eclipse](https://www.eclipse.org/)
 - Install the [Eclipse Android ADT](https://developer.android.com/sdk/installing/installing-adt.html) plugin
 - Go to `File -> Import ...` and select `Android -> Add Existing Android Code into Workspace`. Browse to `yourInstallDir/libmuse/examples/TestLibMuseAndroid`. Click `Finish`.
 - Go to `Project -> Clean` and click `OK` in the popup
 - Enable USB debugging in the `Settings -> Developer Options -> USB Debugging` menu
 - Plug the Android device into your computer
 - Click `Run->Run As->Android Application`
 - Select your device on the screen that appears. You should see the example app appear on your Android device. You will need to place the Muse on your head in order to see the `Muse Elements` numbers start to appear.