package org.webrtc;

public class SimulcastVideoEncoder extends WrappedNativeVideoEncoder {

    static native long nativeCreateEncoder(VideoEncoderFactory primary, VideoEncoderFactory fallback, VideoCodecInfo info);

    VideoEncoderFactory primary;
    VideoEncoderFactory fallback;
    VideoCodecInfo info;

    public SimulcastVideoEncoder(VideoEncoderFactory primary, VideoEncoderFactory fallback, VideoCodecInfo info) {
        Logging.d("ENOMOTO", "SimulcastVideoEncoder start");
        this.primary = primary;
        this.fallback = fallback;
	this.info = info;
        Logging.d("ENOMOTO", "SimulcastVideoEncoder end");
    }

    @Override
    @CalledByNative
    public long createNativeVideoEncoder() {
        Logging.d("ENOMOTO", "createNativeVideoEncoder called");
        return nativeCreateEncoder(primary, fallback, info);
    }

    @Override
    @CalledByNative
    public boolean isHardwareEncoder() {
        Logging.d("ENOMOTO", "isHardwareEncoder called");
        return false;
    }

}

