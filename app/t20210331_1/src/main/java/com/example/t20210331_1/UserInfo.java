package com.example.t20210331_1;

import java.io.Serializable;

class UserInfo implements Serializable {
    String name;
    String phone;
    int subject = 0;
}

class UserCheck{
    static final String POSITION = "position";
    static final String USER_INFO = "user_info";
    static final int REQUEST_CODE_USER_INFO1 = 2;
    static final int REQUEST_CODE_USER_INFO2 = 21;
    static final int RESULT_C0DE_USER_INFO = 3;
    static final int RESULT_C0DE_USER_NOTIFY = 4;
    static final int RESULT_C0DE_USER_REMOVE = 5;

    static final String REQUEST_CODE_RADIO = "radio";
    static final int RADIO_CODE_BTN_DEFAULT = 10;
    static final int RADIO_CODE_BTN_ONE = 11;
    static final int RADIO_CODE_BTN_TWO = 12;
    static final int RADIO_CODE_BTN_THREE = 13;
    static final int RADIO_CODE_BTN_FOUR = 14;
}