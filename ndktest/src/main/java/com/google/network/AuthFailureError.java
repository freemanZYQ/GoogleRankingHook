package com.google.network;

/**
 * Created by apple on 16/10/5.
 */
public class AuthFailureError extends VolleyError {




        public AuthFailureError(NetworkResponse response) {
            super(response);
        }

        public AuthFailureError(String message) {
            super(message);
        }

        public AuthFailureError(String message, Exception reason) {
            super(message, reason);
        }


        @Override
        public String getMessage() {

            return super.getMessage();
        }

}
