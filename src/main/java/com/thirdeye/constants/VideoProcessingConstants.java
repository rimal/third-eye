package com.thirdeye.constants;

public class VideoProcessingConstants {

  public static final String MOTION_DETECTOR_INI_TEMPLATE = ";\n" +
      "; Motion Detector configuration file\n" +
      ";\n" +
      "\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "; Logging related\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "\n" +
      "[logging]\n" +
      "\n" +
      "; Logging level DEBUG, INFO, WARNING, ERROR, CRITICAL.\n" +
      "\n" +
      "level = DEBUG\n" +
      "\n" +
      "; Logging formatter.\n" +
      "\n" +
      "formatter = %%(asctime)s %%(levelname)-8s Test: %%(module)s %%(message)s\n" +
      "\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "; Camera related\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "\n" +
      "[camera]\n" +
      "\n" +
      "; Camera name used for recording dir name.\n" +
      "\n" +
      "name = test\n" +
      "\n" +
      "; Set OpenCV VideoCapture properties. This will only be set if codeferm.videocapture is used.\n" +
      ";\n" +
      "; videoCaptureProperties = ((cv2.CAP_PROP_FRAME_WIDTH, 1280), (cv2.CAP_PROP_FRAME_HEIGHT, 720))\n" +
      "; videoCaptureProperties = None (for no properties)\n" +
      "\n" +
      "videoCaptureProperties = None\n" +
      "\n" +
      "; Frame grabber class:\n" +
      ";\n" +
      "; codeferm.mjpegclient  = Socket based MJPEG streaming frame grabber using cv2.imdecode\n" +
      "; codeferm.videocapture = OpenCV cv2.VideoCapture wrapper\n" +
      "\n" +
      "framePlugin = codeferm.videocapture\n" +
      "\n" +
      "; Detection class (leave blank for motion detector only):\n" +
      ";\n" +
      "; codeferm.pedestriandet = pedestrian detector\n" +
      "; codeferm.cascadedet = haar cascade detector\n" +
      "; codeferm.houghcirclesdet = hough circles detector\n" +
      "\n" +
      "detectPlugin = codeferm.pedestriandet\n" +
      "\n" +
      "; videoloop plugins use videoloop events to trigger various tasks\n" +
      ";\n" +
      "; codeferm.scpfiles = SCP files to remote server including local file clean up\n" +
      "; codeferm.healthcheck = Simple health check that can be monitored externally\n" +
      "; codeferm.healthcheckmqtt = Send health message to MQTT topic\n" +
      ";\n" +
      "; Examples:\n" +
      ";\n" +
      "; videoloopPlugins = (\"codeferm.scpfiles\", \"codeferm.healthcheck\",)\n" +
      "; videoloopPlugins = None (for no plugins)\n" +
      "\n" +
      "videoloopPlugins = (\"codeferm.healthcheck\",)\n" +
      "\n" +
      "; Video URL\n" +
      ";\n" +
      "; Examples:\n" +
      ";\n" +
      "; Local mjpg-streamer running http://localhost:8080/?action=stream\n" +
      ";\n" +
      "; Remote http://trackfield.webcam.oregonstate.edu/mjpg/video.mjpg \n" +
      ";\n" +
      "; MJPEG basic auth http://username:password@192.168.1.99/cgi/mjpg/mjpg.cgi\n" +
      ";\n" +
      "; File ../resources/walking.mp4\n" +
      "\n" +
      "url = ${{url}}\n" +
      "\n" +
      "; Socket timeout in seconds (only used for mjpegclient)\n" +
      ";\n" +
      "; Use socketTimeout = 0 to leave default value intact.\n" +
      "\n" +
      "socketTimeout = 10\n" +
      "\n" +
      "; Use to resize image for better detection/performance\n" +
      "\n" +
      "resizeWidthDiv = 640\n" +
      "\n" +
      "; FPS sample interval in seconds (how often to calculate FPS for debug logging).\n" +
      ";\n" +
      "; This is also the frequency the health check runs if enabled. \n" +
      "\n" +
      "fpsInterval = 5.0\n" +
      "\n" +
      "; Camera FPS. Set to 0 to use frame plugin FPS.\n" +
      "\n" +
      "fps = 0\n" +
      "\n" +
      "; Maximum frame buffer\n" +
      "\n" +
      "frameBufMax = 100\n" +
      "\n" +
      "; Video fourcc\n" +
      "\n" +
      "fourcc = XVID\n" +
      "\n" +
      "; File extension for the recorded video avi (or other container supported by cv2.VideoWriter)\n" +
      "\n" +
      "recordFileExt = avi\n" +
      "\n" +
      "; Directory where videos are saved.\n" +
      "\n" +
      "recordDir = ~/motion\n" +
      "\n" +
      "; Mark motion ROI\n" +
      "\n" +
      "mark = True\n" +
      "\n" +
      "; Save frames that are detected\n" +
      "\n" +
      "saveFrames = True\n" +
      "\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "; Motion related\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "\n" +
      "[motion]\n" +
      "\n" +
      "; A bit mask image of pixels to ignore. Only white pixels are considered for\n" +
      "; motion analysis (black pixels are ignored). The image size should be the\n" +
      "; same as frameResizeWidth x frameResizeHeight. Leave blank for no mask.\n" +
      "\n" +
      "ignoreMask = /Users/rahul/project/hackathon/motiondetector/resources/mask.png\n" +
      "\n" +
      "; Blurring kernel size for blur operation.\n" +
      "\n" +
      "kSize = (8,8)\n" +
      "\n" +
      "; Weight of the input image for accumulateWeighted operation.\n" +
      "\n" +
      "alpha = 0.03\n" +
      "\n" +
      "; Threshold for Threshold Binary operation.\n" +
      "\n" +
      "blackThreshold = 25\n" +
      "\n" +
      "; Percentage of change required to reset reference image\n" +
      "\n" +
      "maxChange = 50.0\n" +
      "\n" +
      "; Percent of image change to trigger motion (must be less than maxChange).\n" +
      "\n" +
      "startThreshold = 1.0\n" +
      "\n" +
      "; Percent of image change to trigger non-motion (must be less than startThreshold).\n" +
      "\n" +
      "stopThreshold = 0.0\n" +
      "\n" +
      "; Number of times dilate is applied.\n" +
      "\n" +
      "dilateAmount = 15\n" +
      "\n" +
      "; Number of times erosion is applied.\n" +
      "\n" +
      "erodeAmount = 10\n" +
      "\n" +
      "; Save history image of video file for making ignore mask\n" +
      "\n" +
      "historyImage = True\n" +
      "\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "; Pedestrian related (works best with 640x480 resized frame)\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "\n" +
      "[pedestrian]\n" +
      "\n" +
      "; If you specify your own detector file then it will be used instead of cv2.HOGDescriptor_getDefaultPeopleDetector()\n" +
      "; \n" +
      "\n" +
      "detectorFile =\n" +
      "; ../resources/default_detector.yml\n" +
      "\n" +
      "; Threshold for the distance between features and SVM classifying plane. To get\n" +
      "; a higher hit-rate (and more false alarms, respectively), decrease the hitThreshold.\n" +
      ";\n" +
      "; Default = 0.0\n" +
      "\n" +
      "hitThreshold = 0.0\n" +
      "\n" +
      "; Window stride. It must be a multiple of block stride.\n" +
      ";\n" +
      "; Default = (8, 8)\n" +
      "\n" +
      "winStride = (4, 4)\n" +
      "\n" +
      "; Padding size.\n" +
      ";\n" +
      "; Default = (32, 32)\n" +
      "\n" +
      "padding = (8, 8)\n" +
      "\n" +
      "; Coefficient of the detection window increase. Parameter specifying how much\n" +
      "; the image size is reduced at each image scale.\n" +
      ";\n" +
      "; Default = 1.05\n" +
      "\n" +
      "scale0 = 1.05\n" +
      "\n" +
      "; Minimum weight returned by detectMultiScale to filter out false hits\n" +
      "\n" +
      "minHogWeight = 0.2\n" +
      "\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "; Haar Cascade related\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "\n" +
      "[cascade]\n" +
      "\n" +
      "; Haar Cascade XML classifier file\n" +
      "\n" +
      "cascadeFile = ~/opencv/data/haarcascades/haarcascade_fullbody.xml\n" +
      "\n" +
      "; How much the image size is reduced at each image scale.\n" +
      "\n" +
      "scaleFactor = 1.3\n" +
      "\n" +
      "; How many neighbors each candidate rectangle should have to retain it.\n" +
      "\n" +
      "minNeighbors = 0\n" +
      "\n" +
      "; Minimum width in order to detect (check classifier xml for best size)\n" +
      "\n" +
      "minWidth = 14\n" +
      "\n" +
      "; Minimum height in order to detect (check classifier xml for best size)\n" +
      "\n" +
      "minHeight = 28\n" +
      "\n" +
      "; Minimum weight calculated by filterByWeight to filter out false hits\n" +
      "\n" +
      "minCascadeWeight = 0\n" +
      "\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "; Hough Circles related\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "\n" +
      "[hough]\n" +
      "\n" +
      "; Detection method to use. Currently, the only implemented method is CV_HOUGH_GRADIENT, which is basically 21HT, described in Yuen90.\n" +
      "; cv2.HOUGH_STANDARD, cv2.HOUGH_PROBABILISTIC, cv2.HOUGH_MULTI_SCALE or cv2.HOUGH_GRADIENT\n" +
      "\n" +
      "methodType = cv2.HOUGH_GRADIENT\n" +
      "\n" +
      "; Inverse ratio of the accumulator resolution to the image resolution. For example, if dp=1 , the accumulator has the same resolution as the input image. If dp=2 , the accumulator has half as big width and height.\n" +
      "\n" +
      "dp = 1\n" +
      "\n" +
      "; Minimum distance between the centers of the detected circles. If the parameter is too small, multiple neighbor circles may be falsely detected in addition to a true one. If it is too large, some circles may be missed.\n" +
      "\n" +
      "minDist = 20\n" +
      "\n" +
      "; First method-specific parameter. In case of CV_HOUGH_GRADIENT , it is the higher threshold of the two passed to the Canny() edge detector (the lower one is twice smaller).\n" +
      "\n" +
      "param1 = 30\n" +
      "\n" +
      "; Second method-specific parameter. In case of CV_HOUGH_GRADIENT , it is the accumulator threshold for the circle centers at the detection stage. The smaller it is, the more false circles may be detected. Circles, corresponding to the larger accumulator values, will be returned first.\n" +
      "\n" +
      "param2 = 100\n" +
      "\n" +
      "; Minimum circle radius.\n" +
      "\n" +
      "minRadius = 0\n" +
      "\n" +
      "; Maximum circle radius.\n" +
      "\n" +
      "maxRadius = 100\n" +
      "\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "; SCP related\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "\n" +
      "[scp]\n" +
      "\n" +
      "; Host name\n" +
      "\n" +
      "hostName = localhost\n" +
      "\n" +
      "; User name\n" +
      " \n" +
      "userName = test\n" +
      "\n" +
      "; Remote server's dir\n" +
      "\n" +
      "remoteDir = ~/Downloads/scptest\n" +
      "\n" +
      "; Command timeout in seconds\n" +
      "\n" +
      "timeout = 600\n" +
      "\n" +
      "; Delete source file after copy to remote\n" +
      "\n" +
      "deleteSource = False\n" +
      "\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "; Health check related\n" +
      ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;\n" +
      "\n" +
      "[health]\n" +
      "\n" +
      "; File used for health check. External process can monitor file's mtime for updates\n" +
      "\n" +
      "fileName = ~/motion/health.txt\n" +
      "\n" +
      "; Leave blank for no MQTT messages even if codeferm.healthcheckmqtt used\n" +
      "\n" +
      "mqttHost =\n" +
      "\n" +
      "; Port\n" +
      "\n" +
      "mqttPort = 9999\n" +
      "\n" +
      "; Topic\n" +
      "\n" +
      "mqttTopic = testTopic        \n";
}