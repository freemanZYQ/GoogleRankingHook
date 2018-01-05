package com.baidu.mobads;

import com.baidu.mobads.VideoAdView.VideoDuration;
import com.baidu.mobads.VideoAdView.VideoSize;

public class VideoAdRequest {
    private VideoDuration a;
    private boolean b;
    private VideoSize c;

    public class Builder {
        private VideoDuration a;
        private boolean b = false;
        private VideoSize c;

        public VideoAdRequest build() {
            return new VideoAdRequest();
        }

        public Builder isShowCountdown(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setVideoDuration(VideoDuration videoDuration) {
            this.a = videoDuration;
            return this;
        }

        public Builder setVideoSize(VideoSize videoSize) {
            this.c = videoSize;
            return this;
        }
    }

    private VideoAdRequest(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
    }

    protected int getVideoDuration() {
        return this.a == null ? VideoDuration.DURATION_15_SECONDS.getValue() : this.a.getValue();
    }

    protected int getVideoHeight() {
        if (this.c == null) {
            this.c = VideoSize.SIZE_16x9;
        }
        return this.c.getHeight();
    }

    protected int getVideoWidth() {
        if (this.c == null) {
            this.c = VideoSize.SIZE_16x9;
        }
        return this.c.getWidth();
    }

    protected boolean isShowCountdown() {
        return this.b;
    }
}
