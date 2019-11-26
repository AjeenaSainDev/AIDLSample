package com.example.aidlsampleapp;

/**
 * Created by Ajeena on 30-10-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 */
public class Events {
    public static class FragmentActivityMessage {

        private String message;

        public FragmentActivityMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static class ActivityFragmentMessage {

        private String message;

        public ActivityFragmentMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    public static  class  Initalize{
        private String message;

        public Initalize(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

}
