# bho-ui-automation-testing-for-windows

Important notes:
- Use node LTS and not current version
- Use Appium latest and not some older version
- Be admin on your Windows
- If on corpnet (office laptop/computer), make sure anti-virus is not blocking node and Appium installation. Work with your security team in case of issues

Install Appium using NPM (Appium CLI)
=================================
-> Commands to check if node and NPM are installed:
node -v
npm -v
-> Install node.js (NPM is included) from link - https://nodejs.org/en/download/
Important note: Use the LTS and not current version.
-> Command to install Appium using npm: npm install -g appium
-> Command to start Appium: appium
-> Command to uninstall Appium: npm uninstall -g appium


Install Appium using Appium Desktop
================================
-> Download and install Appium Desktop from https://appium.io


Install Appium Inspector
=====================
-> Download and install from https://github.com/appium/appium-inspector/releases


Install JAVA JDK and configure environment variables
============================================
-> Command to check if JAVA is already installed: java -version
-> JAVA JDK download link: https://www.oracle.com/technetwork/java/javase/downloads/index.html
Important note: Please use Java 8/11/15 for now. Don't use Java 16 or higher. The current Appium Java Client 7.6.0 is not compatible with Java 16+. You may use Java 16+ once Appium Java client 8.0.0 is released to the market.
-> Create JAVA_HOME system environment variable and set it to JDK path (without bin folder).
Edit PATH system environment variable and add %JAVA_HOME%\bin
Note: Usually JDK path is "C:\Program Files\Java\<your_jdk_version>"


Install Android Studio and configure environment variables
=================================================
-> Android Studio download link: https://developer.android.com/studio
-> Create ANDROID_HOME system environment variable and set it to SDK path.
Edit PATH system environment variable and add below,
%ANDROID_HOME%\platform-tools
%ANDROID_HOME%\tools
%ANDROID_HOME%\tools\bin


Verify installation using appium-doctor
=================================
Command to install appium-doctor: npm install -g appium-doctor
Command to get appium-doctor help: appium-doctor --help
Command to check Android setup: appium-doctor --android


Emulator Setup: Accelerate Performance
==================================
Launch Android Studio -> SDK Manager -> SDK Tools
Intel processor: Check "Intel x86 Emulator Accelerator (HAXM Installer)" and Apply
AMD processor: Check "Android Emulator Hypervisor Driver for AMD Processors (installer)" and Apply


Emulator Setup: Create AVD and start it
=================================
Open Android Studio -> Configure -> AVD Manager -> Create Virtual Device ->
Select Model -> Download Image for desired OS version if not already downloaded
-> Start AVD


Emulator Setup: Create Driver Session using Appium Desktop
===================================================
Download link for dummy app:
https://github.com/appium/appium/blob/master/sample-code/apps/ApiDemos-debug.apk


Real Device Setup: Enable USB debugging on Android mobile
==================================================
Note: Steps can differ based on the phone manufacturer!
-> Settings -> System -> About Phone -> Click Build Number 7-8 times
-> Settings -> Developer Options -> Enable USB Debugging
-> Permission pop-up: Check the box and press Allow to recognize the computer
-> run "adb devices" in CMD prompt to check if device is recognized



Important notes:
- Use node LTS and not current version
- Use Appium latest and not some older version
- Be admin on your MAC
- If on corpnet (office laptop/computer), make sure anti-virus is not blocking node and Appium installation. Work with your security team in case of issues

# bho-ui-automation-testing-for-macos

Install homebrew [package manager for macOS and is used to install software packages]
======================================================================================
Link: https://brew.sh/
Command: /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"


Install node and npm [Appium dependencies]
===============================================
Commands to check if node and npm are installed:
node -v
npm -v
Command to install node: brew install node [This will install npm as well]
Command to check node installation path: where node or which node


Install Appium server using NPM (Appium CLI)
===================================================
Command to install Appium: npm install –g appium
Command to check Appium version: appium -v
Command to check Appium installation path: where appium or which Appium


Install Appium server using Appium Desktop client
=======================================================
Download link: https://appium.io


Install Appium Inspector
=====================
-> Download and install from https://github.com/appium/appium-inspector/releases


Install Xcode
====================
Configure Apple ID in Account preferences
Install from App Store


Install Xcode command line tools
======================================
Command: xcode-select --install


Install xcpretty [to make Xcode output reasonable]
========================================================
Command to install xcpretty: gem install xcpretty


Install Carthage [dependency manager, required for WebDriverAgent]
==================================================================
Command to install Carthage: brew install Carthage


Install Appium-doctor and check Appium setup
===================================================
Command to install Appium doctor: npm install -g appium-doctor
Command to get help: appium-doctor --h
Command to check setup for iOS: appium-doctor --ios


Build UIKitCatalog app for simulator
===========================================
Download link: https://github.com/appium/ios-uicatalog
Command to get simulator name: xcodebuild -showsdks
Command to build app for the simulator: xcodebuild -sdk <simulator_name>
Command to build UIKitCatalog app for simulator: npm install


Start session with UIKitCatalog app using Appium Desktop/Appium CLI
=========================================================================
Command to get UDID: xcrun simctl list
Command to get UDID: xcrun xctrace list devices
XCode option to get UDID: XCode -> Window -> Devices and Simulators -> Simulators -> Select the simulator in the left pane. In the right pane, "Identifier" will be the UDID.


=================================================================
Real device setup
=================================================================

Getting UDID
=============
Command to install ios-deploy: npm install -g ios-deploy
Command to get UDID: ios-deploy -c
OR
Command to get UDID: xcrun simctl list [May show real devices as well]
Command to get UDID: xcrun xctrace list devices [May show real devices as well]
XCode option to get UDID: XCode -> Window -> Devices and Simulators -> Devices -> Select the device in the left pane. In the right pane, "Identifier" will be the UDID.


1. Code signing WebDriverAgent: Basic (automatic/manual) configuration.
   ======================================================================

Step 1. Enroll for Developer program
- Create Apple account: https://developer.apple.com
- Enable two factor authentication: https://appleid.apple.com/account/manage
- Click Join the Apple Developer program
- Click Enroll
- Click Start Your Enrollment

Step 2. Register device UDID on the developer portal (this can be done from Xcode as well)

Step 3. Add your Apple ID (paid developer account) to XCode and download the certificate (if required, create new certificate on the developer portal)

Step 4. Generate UIKitCatalog IPA:
- Download UIKitCatalog app from https://github.com/appium/ios-uicatalog
- Launch project and code sign using Xcode managed provisioning profile
- Confirm wild card provisioning profile is created in the developer account
- (select generic iOS device) Archive app to generate IPA

Step 5. Create session with app using Appium Desktop server as well as CLI server
- Launch Appium Desktop, open inspector session, Set desired capabilities
  "xcodeOrgId": "your team id"
  "xcodeSigningId": "iPhone Developer"
- Launch Appium Desktop, open inspector session, point to CLI server, Set desired capabilities
  "xcodeOrgId": "your team id"
  "xcodeSigningId": "iPhone Developer"

2. Code signing WebDriverAgent: Full manual configuration path
   ==============================================================
   Step 1. Add your Apple ID to XCode and download the certificate

Step 2. Find WebDriverAgent project
We will use Appium CLI version for test execution and point Appium Desktop to use CLI server for inspecting the app.
In terminal, execute command:
$ where appium or which Appium
/path/where/installed/bin/appium
WebDriverAgent project path:
Appium CLI:/path/where/installed/lib/node_modules/appium/node_modules/appium-webdriveragent
Appium Desktop: /Applications/Appium.app/Contents/Resources/app/node_modules/appium/node_modules/appium-webdriveragent

Step 3. Navigate to WebDriverAgent project path in terminal and run below command to setup the project

mkdir -p Resources/WebDriverAgent.bundle
./Scripts/bootstrap.sh -d

Step 4. Open WebDriverAgent.xcodeproj in Xcode. For both the WebDriverAgentLib and WebDriverAgentRunner targets, select "Automatically manage signing" in the "General" tab, and then select your Development Team. This should also auto select Signing Certificate.

Step 5. Manually change the bundle id for the target by going into the "Build Settings" tab, and changing the "Product Bundle Identifier" from com.facebook.WebDriverAgentRunner to
something that Xcode will accept (something really unique!)

Step 6. Command to build the project:
xcodebuild -project WebDriverAgent.xcodeproj -scheme WebDriverAgentRunner -destination 'id=<udid>' test -allowProvisioningUpdates

Step 7. Create session with app using Appium Inspector pointing to CLI server