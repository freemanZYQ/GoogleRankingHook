package com.tools.hackandroid.gp;


public final class CheckIn {
  private CheckIn() {}
  public static final class AndroidCheckinRequest extends
      com.google.protobuf.micro.MessageMicro {
    public AndroidCheckinRequest() {}

    // optional string imei = 1;
    public static final int IMEI_FIELD_NUMBER = 1;
    private boolean hasImei;
    private String imei_ = "";
    public String getImei() { return imei_; }
    public boolean hasImei() { return hasImei; }
    public AndroidCheckinRequest setImei(String value) {
      hasImei = true;
      imei_ = value;
      return this;
    }
    public AndroidCheckinRequest clearImei() {
      hasImei = false;
      imei_ = "";
      return this;
    }

    // optional int64 id = 2;
    public static final int ID_FIELD_NUMBER = 2;
    private boolean hasId;
    private long id_ = 0L;
    public long getId() { return id_; }
    public boolean hasId() { return hasId; }
    public AndroidCheckinRequest setId(long value) {
      hasId = true;
      id_ = value;
      return this;
    }
    public AndroidCheckinRequest clearId() {
      hasId = false;
      id_ = 0L;
      return this;
    }

    // optional string digest = 3;
    public static final int DIGEST_FIELD_NUMBER = 3;
    private boolean hasDigest;
    private String digest_ = "";
    public String getDigest() { return digest_; }
    public boolean hasDigest() { return hasDigest; }
    public AndroidCheckinRequest setDigest(String value) {
      hasDigest = true;
      digest_ = value;
      return this;
    }
    public AndroidCheckinRequest clearDigest() {
      hasDigest = false;
      digest_ = "";
      return this;
    }

    // optional .AndroidCheckinProto checkin = 4;
    public static final int CHECKIN_FIELD_NUMBER = 4;
    private boolean hasCheckin;
    private AndroidCheckinProto checkin_ = null;
    public boolean hasCheckin() { return hasCheckin; }
    public AndroidCheckinProto getCheckin() { return checkin_; }
    public AndroidCheckinRequest setCheckin(AndroidCheckinProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasCheckin = true;
      checkin_ = value;
      return this;
    }
    public AndroidCheckinRequest clearCheckin() {
      hasCheckin = false;
      checkin_ = null;
      return this;
    }

    // optional string desiredBuild = 5;
    public static final int DESIREDBUILD_FIELD_NUMBER = 5;
    private boolean hasDesiredBuild;
    private String desiredBuild_ = "";
    public String getDesiredBuild() { return desiredBuild_; }
    public boolean hasDesiredBuild() { return hasDesiredBuild; }
    public AndroidCheckinRequest setDesiredBuild(String value) {
      hasDesiredBuild = true;
      desiredBuild_ = value;
      return this;
    }
    public AndroidCheckinRequest clearDesiredBuild() {
      hasDesiredBuild = false;
      desiredBuild_ = "";
      return this;
    }

    // optional string locale = 6;
    public static final int LOCALE_FIELD_NUMBER = 6;
    private boolean hasLocale;
    private String locale_ = "";
    public String getLocale() { return locale_; }
    public boolean hasLocale() { return hasLocale; }
    public AndroidCheckinRequest setLocale(String value) {
      hasLocale = true;
      locale_ = value;
      return this;
    }
    public AndroidCheckinRequest clearLocale() {
      hasLocale = false;
      locale_ = "";
      return this;
    }

    // optional int64 loggingId = 7;
    public static final int LOGGINGID_FIELD_NUMBER = 7;
    private boolean hasLoggingId;
    private long loggingId_ = 0L;
    public long getLoggingId() { return loggingId_; }
    public boolean hasLoggingId() { return hasLoggingId; }
    public AndroidCheckinRequest setLoggingId(long value) {
      hasLoggingId = true;
      loggingId_ = value;
      return this;
    }
    public AndroidCheckinRequest clearLoggingId() {
      hasLoggingId = false;
      loggingId_ = 0L;
      return this;
    }

    // optional string marketCheckin = 8;
    public static final int MARKETCHECKIN_FIELD_NUMBER = 8;
    private boolean hasMarketCheckin;
    private String marketCheckin_ = "";
    public String getMarketCheckin() { return marketCheckin_; }
    public boolean hasMarketCheckin() { return hasMarketCheckin; }
    public AndroidCheckinRequest setMarketCheckin(String value) {
      hasMarketCheckin = true;
      marketCheckin_ = value;
      return this;
    }
    public AndroidCheckinRequest clearMarketCheckin() {
      hasMarketCheckin = false;
      marketCheckin_ = "";
      return this;
    }

    // repeated string macAddr = 9;
    public static final int MACADDR_FIELD_NUMBER = 9;
    private java.util.List<String> macAddr_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getMacAddrList() {
      return macAddr_;
    }
    public int getMacAddrCount() { return macAddr_.size(); }
    public String getMacAddr(int index) {
      return macAddr_.get(index);
    }
    public AndroidCheckinRequest setMacAddr(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  macAddr_.set(index, value);
      return this;
    }
    public AndroidCheckinRequest addMacAddr(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (macAddr_.isEmpty()) {
        macAddr_ = new java.util.ArrayList<String>();
      }
      macAddr_.add(value);
      return this;
    }
    public AndroidCheckinRequest clearMacAddr() {
      macAddr_ = java.util.Collections.emptyList();
      return this;
    }

    // optional string meid = 10;
    public static final int MEID_FIELD_NUMBER = 10;
    private boolean hasMeid;
    private String meid_ = "";
    public String getMeid() { return meid_; }
    public boolean hasMeid() { return hasMeid; }
    public AndroidCheckinRequest setMeid(String value) {
      hasMeid = true;
      meid_ = value;
      return this;
    }
    public AndroidCheckinRequest clearMeid() {
      hasMeid = false;
      meid_ = "";
      return this;
    }

    // repeated string accountCookie = 11;
    public static final int ACCOUNTCOOKIE_FIELD_NUMBER = 11;
    private java.util.List<String> accountCookie_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getAccountCookieList() {
      return accountCookie_;
    }
    public int getAccountCookieCount() { return accountCookie_.size(); }
    public String getAccountCookie(int index) {
      return accountCookie_.get(index);
    }
    public AndroidCheckinRequest setAccountCookie(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  accountCookie_.set(index, value);
      return this;
    }
    public AndroidCheckinRequest addAccountCookie(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (accountCookie_.isEmpty()) {
        accountCookie_ = new java.util.ArrayList<String>();
      }
      accountCookie_.add(value);
      return this;
    }
    public AndroidCheckinRequest clearAccountCookie() {
      accountCookie_ = java.util.Collections.emptyList();
      return this;
    }

    // optional string timeZone = 12;
    public static final int TIMEZONE_FIELD_NUMBER = 12;
    private boolean hasTimeZone;
    private String timeZone_ = "";
    public String getTimeZone() { return timeZone_; }
    public boolean hasTimeZone() { return hasTimeZone; }
    public AndroidCheckinRequest setTimeZone(String value) {
      hasTimeZone = true;
      timeZone_ = value;
      return this;
    }
    public AndroidCheckinRequest clearTimeZone() {
      hasTimeZone = false;
      timeZone_ = "";
      return this;
    }

    // optional fixed64 securityToken = 13;
    public static final int SECURITYTOKEN_FIELD_NUMBER = 13;
    private boolean hasSecurityToken;
    private long securityToken_ = 0L;
    public long getSecurityToken() { return securityToken_; }
    public boolean hasSecurityToken() { return hasSecurityToken; }
    public AndroidCheckinRequest setSecurityToken(long value) {
      hasSecurityToken = true;
      securityToken_ = value;
      return this;
    }
    public AndroidCheckinRequest clearSecurityToken() {
      hasSecurityToken = false;
      securityToken_ = 0L;
      return this;
    }

    // optional int32 version = 14;
    public static final int VERSION_FIELD_NUMBER = 14;
    private boolean hasVersion;
    private int version_ = 0;
    public int getVersion() { return version_; }
    public boolean hasVersion() { return hasVersion; }
    public AndroidCheckinRequest setVersion(int value) {
      hasVersion = true;
      version_ = value;
      return this;
    }
    public AndroidCheckinRequest clearVersion() {
      hasVersion = false;
      version_ = 0;
      return this;
    }

    // repeated string otaCert = 15;
    public static final int OTACERT_FIELD_NUMBER = 15;
    private java.util.List<String> otaCert_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getOtaCertList() {
      return otaCert_;
    }
    public int getOtaCertCount() { return otaCert_.size(); }
    public String getOtaCert(int index) {
      return otaCert_.get(index);
    }
    public AndroidCheckinRequest setOtaCert(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  otaCert_.set(index, value);
      return this;
    }
    public AndroidCheckinRequest addOtaCert(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (otaCert_.isEmpty()) {
        otaCert_ = new java.util.ArrayList<String>();
      }
      otaCert_.add(value);
      return this;
    }
    public AndroidCheckinRequest clearOtaCert() {
      otaCert_ = java.util.Collections.emptyList();
      return this;
    }

    // optional string serialNumber = 16;
    public static final int SERIALNUMBER_FIELD_NUMBER = 16;
    private boolean hasSerialNumber;
    private String serialNumber_ = "";
    public String getSerialNumber() { return serialNumber_; }
    public boolean hasSerialNumber() { return hasSerialNumber; }
    public AndroidCheckinRequest setSerialNumber(String value) {
      hasSerialNumber = true;
      serialNumber_ = value;
      return this;
    }
    public AndroidCheckinRequest clearSerialNumber() {
      hasSerialNumber = false;
      serialNumber_ = "";
      return this;
    }

    // optional string esn = 17;
    public static final int ESN_FIELD_NUMBER = 17;
    private boolean hasEsn;
    private String esn_ = "";
    public String getEsn() { return esn_; }
    public boolean hasEsn() { return hasEsn; }
    public AndroidCheckinRequest setEsn(String value) {
      hasEsn = true;
      esn_ = value;
      return this;
    }
    public AndroidCheckinRequest clearEsn() {
      hasEsn = false;
      esn_ = "";
      return this;
    }

    // optional .DeviceConfigurationProto deviceConfiguration = 18;
    public static final int DEVICECONFIGURATION_FIELD_NUMBER = 18;
    private boolean hasDeviceConfiguration;
    private DeviceConfigurationProto deviceConfiguration_ = null;
    public boolean hasDeviceConfiguration() { return hasDeviceConfiguration; }
    public DeviceConfigurationProto getDeviceConfiguration() { return deviceConfiguration_; }
    public AndroidCheckinRequest setDeviceConfiguration(DeviceConfigurationProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasDeviceConfiguration = true;
      deviceConfiguration_ = value;
      return this;
    }
    public AndroidCheckinRequest clearDeviceConfiguration() {
      hasDeviceConfiguration = false;
      deviceConfiguration_ = null;
      return this;
    }

    // repeated string macAddrType = 19;
    public static final int MACADDRTYPE_FIELD_NUMBER = 19;
    private java.util.List<String> macAddrType_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getMacAddrTypeList() {
      return macAddrType_;
    }
    public int getMacAddrTypeCount() { return macAddrType_.size(); }
    public String getMacAddrType(int index) {
      return macAddrType_.get(index);
    }
    public AndroidCheckinRequest setMacAddrType(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  macAddrType_.set(index, value);
      return this;
    }
    public AndroidCheckinRequest addMacAddrType(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (macAddrType_.isEmpty()) {
        macAddrType_ = new java.util.ArrayList<String>();
      }
      macAddrType_.add(value);
      return this;
    }
    public AndroidCheckinRequest clearMacAddrType() {
      macAddrType_ = java.util.Collections.emptyList();
      return this;
    }

    // optional int32 fragment = 20;
    public static final int FRAGMENT_FIELD_NUMBER = 20;
    private boolean hasFragment;
    private int fragment_ = 0;
    public int getFragment() { return fragment_; }
    public boolean hasFragment() { return hasFragment; }
    public AndroidCheckinRequest setFragment(int value) {
      hasFragment = true;
      fragment_ = value;
      return this;
    }
    public AndroidCheckinRequest clearFragment() {
      hasFragment = false;
      fragment_ = 0;
      return this;
    }

    // optional string userName = 21;
    public static final int USERNAME_FIELD_NUMBER = 21;
    private boolean hasUserName;
    private String userName_ = "";
    public String getUserName() { return userName_; }
    public boolean hasUserName() { return hasUserName; }
    public AndroidCheckinRequest setUserName(String value) {
      hasUserName = true;
      userName_ = value;
      return this;
    }
    public AndroidCheckinRequest clearUserName() {
      hasUserName = false;
      userName_ = "";
      return this;
    }

    // optional int32 userSerialNumber = 22;
    public static final int USERSERIALNUMBER_FIELD_NUMBER = 22;
    private boolean hasUserSerialNumber;
    private int userSerialNumber_ = 0;
    public int getUserSerialNumber() { return userSerialNumber_; }
    public boolean hasUserSerialNumber() { return hasUserSerialNumber; }
    public AndroidCheckinRequest setUserSerialNumber(int value) {
      hasUserSerialNumber = true;
      userSerialNumber_ = value;
      return this;
    }
    public AndroidCheckinRequest clearUserSerialNumber() {
      hasUserSerialNumber = false;
      userSerialNumber_ = 0;
      return this;
    }

    public final AndroidCheckinRequest clear() {
      clearImei();
      clearId();
      clearDigest();
      clearCheckin();
      clearDesiredBuild();
      clearLocale();
      clearLoggingId();
      clearMarketCheckin();
      clearMacAddr();
      clearMeid();
      clearAccountCookie();
      clearTimeZone();
      clearSecurityToken();
      clearVersion();
      clearOtaCert();
      clearSerialNumber();
      clearEsn();
      clearDeviceConfiguration();
      clearMacAddrType();
      clearFragment();
      clearUserName();
      clearUserSerialNumber();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasImei()) {
        output.writeString(1, getImei());
      }
      if (hasId()) {
        output.writeInt64(2, getId());
      }
      if (hasDigest()) {
        output.writeString(3, getDigest());
      }
      if (hasCheckin()) {
        output.writeMessage(4, getCheckin());
      }
      if (hasDesiredBuild()) {
        output.writeString(5, getDesiredBuild());
      }
      if (hasLocale()) {
        output.writeString(6, getLocale());
      }
      if (hasLoggingId()) {
        output.writeInt64(7, getLoggingId());
      }
      if (hasMarketCheckin()) {
        output.writeString(8, getMarketCheckin());
      }
      for (String element : getMacAddrList()) {
        output.writeString(9, element);
      }
      if (hasMeid()) {
        output.writeString(10, getMeid());
      }
      for (String element : getAccountCookieList()) {
        output.writeString(11, element);
      }
      if (hasTimeZone()) {
        output.writeString(12,"Asia/Shanghai" );
      }
      if (hasSecurityToken()) {
        output.writeFixed64(13, getSecurityToken());
      }
      if (hasVersion()) {
        output.writeInt32(14, getVersion());
      }
      for (String element : getOtaCertList()) {
        output.writeString(15, element);
      }
      if (hasSerialNumber()) {
        output.writeString(16, getSerialNumber());
      }
      if (hasEsn()) {
        output.writeString(17, getEsn());
      }
      if (hasDeviceConfiguration()) {
        output.writeMessage(18, getDeviceConfiguration());
      }
      for (String element : getMacAddrTypeList()) {
        output.writeString(19, element);
      }
      if (hasFragment()) {
        output.writeInt32(20, getFragment());
      }
      if (hasUserName()) {
        output.writeString(21, getUserName());
      }
      if (hasUserSerialNumber()) {
        output.writeInt32(22, getUserSerialNumber());
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasImei()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(1, getImei());
      }
      if (hasId()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt64Size(2, getId());
      }
      if (hasDigest()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(3, getDigest());
      }
      if (hasCheckin()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeMessageSize(4, getCheckin());
      }
      if (hasDesiredBuild()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(5, getDesiredBuild());
      }
      if (hasLocale()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(6, getLocale());
      }
      if (hasLoggingId()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt64Size(7, getLoggingId());
      }
      if (hasMarketCheckin()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(8, getMarketCheckin());
      }
      {
        int dataSize = 0;
        for (String element : getMacAddrList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getMacAddrList().size();
      }
      if (hasMeid()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(10, getMeid());
      }
      {
        int dataSize = 0;
        for (String element : getAccountCookieList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getAccountCookieList().size();
      }
      if (hasTimeZone()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(12, getTimeZone());
      }
      if (hasSecurityToken()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeFixed64Size(13, getSecurityToken());
      }
      if (hasVersion()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(14, getVersion());
      }
      {
        int dataSize = 0;
        for (String element : getOtaCertList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getOtaCertList().size();
      }
      if (hasSerialNumber()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(16, getSerialNumber());
      }
      if (hasEsn()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(17, getEsn());
      }
      if (hasDeviceConfiguration()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeMessageSize(18, getDeviceConfiguration());
      }
      {
        int dataSize = 0;
        for (String element : getMacAddrTypeList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 2 * getMacAddrTypeList().size();
      }
      if (hasFragment()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(20, getFragment());
      }
      if (hasUserName()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(21, getUserName());
      }
      if (hasUserSerialNumber()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(22, getUserSerialNumber());
      }
      cachedSize = size;
      return size;
    }

    @Override
    public AndroidCheckinRequest mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            setImei(input.readString());
            break;
          }
          case 16: {
            setId(input.readInt64());
            break;
          }
          case 26: {
            setDigest(input.readString());
            break;
          }
          case 34: {
            AndroidCheckinProto value = new AndroidCheckinProto();
            input.readMessage(value);
            setCheckin(value);
            break;
          }
          case 42: {
            setDesiredBuild(input.readString());
            break;
          }
          case 50: {
            setLocale(input.readString());
            break;
          }
          case 56: {
            setLoggingId(input.readInt64());
            break;
          }
          case 66: {
            setMarketCheckin(input.readString());
            break;
          }
          case 74: {
            addMacAddr(input.readString());
            break;
          }
          case 82: {
            setMeid(input.readString());
            break;
          }
          case 90: {
            addAccountCookie(input.readString());
            break;
          }
          case 98: {
            setTimeZone(input.readString());
            break;
          }
          case 105: {
            setSecurityToken(input.readFixed64());
            break;
          }
          case 112: {
            setVersion(input.readInt32());
            break;
          }
          case 122: {
            addOtaCert(input.readString());
            break;
          }
          case 130: {
            setSerialNumber(input.readString());
            break;
          }
          case 138: {
            setEsn(input.readString());
            break;
          }
          case 146: {
            DeviceConfigurationProto value = new DeviceConfigurationProto();
            input.readMessage(value);
            setDeviceConfiguration(value);
            break;
          }
          case 154: {
            addMacAddrType(input.readString());
            break;
          }
          case 160: {
            setFragment(input.readInt32());
            break;
          }
          case 170: {
            setUserName(input.readString());
            break;
          }
          case 176: {
            setUserSerialNumber(input.readInt32());
            break;
          }
        }
      }
    }

    public static AndroidCheckinRequest parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (AndroidCheckinRequest) (new AndroidCheckinRequest().mergeFrom(data));
    }

    public static AndroidCheckinRequest parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new AndroidCheckinRequest().mergeFrom(input);
    }

  }

  public static final class AndroidCheckinProto extends
      com.google.protobuf.micro.MessageMicro {
    public AndroidCheckinProto() {}

    // optional .AndroidBuildProto build = 1;
    public static final int BUILD_FIELD_NUMBER = 1;
    private boolean hasBuild;
    private AndroidBuildProto build_ = null;
    public boolean hasBuild() { return hasBuild; }
    public AndroidBuildProto getBuild() { return build_; }
    public AndroidCheckinProto setBuild(AndroidBuildProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      hasBuild = true;
      build_ = value;
      return this;
    }
    public AndroidCheckinProto clearBuild() {
      hasBuild = false;
      build_ = null;
      return this;
    }

    // optional int64 lastCheckinMsec = 2;
    public static final int LASTCHECKINMSEC_FIELD_NUMBER = 2;
    private boolean hasLastCheckinMsec;
    private long lastCheckinMsec_ = 0L;
    public long getLastCheckinMsec() { return lastCheckinMsec_; }
    public boolean hasLastCheckinMsec() { return hasLastCheckinMsec; }
    public AndroidCheckinProto setLastCheckinMsec(long value) {
      hasLastCheckinMsec = true;
      lastCheckinMsec_ = value;
      return this;
    }
    public AndroidCheckinProto clearLastCheckinMsec() {
      hasLastCheckinMsec = false;
      lastCheckinMsec_ = 0L;
      return this;
    }

    // repeated .AndroidEventProto event = 3;
    public static final int EVENT_FIELD_NUMBER = 3;
    private java.util.List<AndroidEventProto> event_ =
      java.util.Collections.emptyList();
    public java.util.List<AndroidEventProto> getEventList() {
      return event_;
    }
    public int getEventCount() { return event_.size(); }
    public AndroidEventProto getEvent(int index) {
      return event_.get(index);
    }
    public AndroidCheckinProto setEvent(int index, AndroidEventProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      event_.set(index, value);
      return this;
    }
    public AndroidCheckinProto addEvent(AndroidEventProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      if (event_.isEmpty()) {
        event_ = new java.util.ArrayList<AndroidEventProto>();
      }
      event_.add(value);
      return this;
    }
    public AndroidCheckinProto clearEvent() {
      event_ = java.util.Collections.emptyList();
      return this;
    }

    // repeated .AndroidStatisticProto stat = 4;
    public static final int STAT_FIELD_NUMBER = 4;
    private java.util.List<AndroidStatisticProto> stat_ =
      java.util.Collections.emptyList();
    public java.util.List<AndroidStatisticProto> getStatList() {
      return stat_;
    }
    public int getStatCount() { return stat_.size(); }
    public AndroidStatisticProto getStat(int index) {
      return stat_.get(index);
    }
    public AndroidCheckinProto setStat(int index, AndroidStatisticProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      stat_.set(index, value);
      return this;
    }
    public AndroidCheckinProto addStat(AndroidStatisticProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      if (stat_.isEmpty()) {
        stat_ = new java.util.ArrayList<AndroidStatisticProto>();
      }
      stat_.add(value);
      return this;
    }
    public AndroidCheckinProto clearStat() {
      stat_ = java.util.Collections.emptyList();
      return this;
    }

    // repeated string requestedGroup = 5;
    public static final int REQUESTEDGROUP_FIELD_NUMBER = 5;
    private java.util.List<String> requestedGroup_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getRequestedGroupList() {
      return requestedGroup_;
    }
    public int getRequestedGroupCount() { return requestedGroup_.size(); }
    public String getRequestedGroup(int index) {
      return requestedGroup_.get(index);
    }
    public AndroidCheckinProto setRequestedGroup(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  requestedGroup_.set(index, value);
      return this;
    }
    public AndroidCheckinProto addRequestedGroup(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (requestedGroup_.isEmpty()) {
        requestedGroup_ = new java.util.ArrayList<String>();
      }
      requestedGroup_.add(value);
      return this;
    }
    public AndroidCheckinProto clearRequestedGroup() {
      requestedGroup_ = java.util.Collections.emptyList();
      return this;
    }

    // optional string cellOperator = 6;
    public static final int CELLOPERATOR_FIELD_NUMBER = 6;
    private boolean hasCellOperator;
    private String cellOperator_ = "";
    public String getCellOperator() { return cellOperator_; }
    public boolean hasCellOperator() { return hasCellOperator; }
    public AndroidCheckinProto setCellOperator(String value) {
      hasCellOperator = true;
      cellOperator_ = value;
      return this;
    }
    public AndroidCheckinProto clearCellOperator() {
      hasCellOperator = false;
      cellOperator_ = "";
      return this;
    }

    // optional string simOperator = 7;
    public static final int SIMOPERATOR_FIELD_NUMBER = 7;
    private boolean hasSimOperator;
    private String simOperator_ = "";
    public String getSimOperator() { return simOperator_; }
    public boolean hasSimOperator() { return hasSimOperator; }
    public AndroidCheckinProto setSimOperator(String value) {
      hasSimOperator = true;
      simOperator_ = value;
      return this;
    }
    public AndroidCheckinProto clearSimOperator() {
      hasSimOperator = false;
      simOperator_ = "";
      return this;
    }

    // optional string roaming = 8;
    public static final int ROAMING_FIELD_NUMBER = 8;
    private boolean hasRoaming;
    private String roaming_ = "";
    public String getRoaming() { return roaming_; }
    public boolean hasRoaming() { return hasRoaming; }
    public AndroidCheckinProto setRoaming(String value) {
      hasRoaming = true;
      roaming_ = value;
      return this;
    }
    public AndroidCheckinProto clearRoaming() {
      hasRoaming = false;
      roaming_ = "";
      return this;
    }

    // optional int32 userNumber = 9;
    public static final int USERNUMBER_FIELD_NUMBER = 9;
    private boolean hasUserNumber;
    private int userNumber_ = 0;
    public int getUserNumber() { return userNumber_; }
    public boolean hasUserNumber() { return hasUserNumber; }
    public AndroidCheckinProto setUserNumber(int value) {
      hasUserNumber = true;
      userNumber_ = value;
      return this;
    }
    public AndroidCheckinProto clearUserNumber() {
      hasUserNumber = false;
      userNumber_ = 0;
      return this;
    }

    public final AndroidCheckinProto clear() {
      clearBuild();
      clearLastCheckinMsec();
      clearEvent();
      clearStat();
      clearRequestedGroup();
      clearCellOperator();
      clearSimOperator();
      clearRoaming();
      clearUserNumber();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasBuild()) {
        output.writeMessage(1, getBuild());
      }
      if (hasLastCheckinMsec()) {
        output.writeInt64(2, getLastCheckinMsec());
      }
      for (AndroidEventProto element : getEventList()) {
        output.writeMessage(3, element);
      }
      for (AndroidStatisticProto element : getStatList()) {
        output.writeMessage(4, element);
      }
      for (String element : getRequestedGroupList()) {
        output.writeString(5, element);
      }
      if (hasCellOperator()) {
        output.writeString(6, getCellOperator());
      }
      if (hasSimOperator()) {
        output.writeString(7, getSimOperator());
      }
      if (hasRoaming()) {
        output.writeString(8, getRoaming());
      }
      if (hasUserNumber()) {
        output.writeInt32(9, getUserNumber());
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasBuild()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeMessageSize(1, getBuild());
      }
      if (hasLastCheckinMsec()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt64Size(2, getLastCheckinMsec());
      }
      for (AndroidEventProto element : getEventList()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeMessageSize(3, element);
      }
      for (AndroidStatisticProto element : getStatList()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeMessageSize(4, element);
      }
      {
        int dataSize = 0;
        for (String element : getRequestedGroupList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getRequestedGroupList().size();
      }
      if (hasCellOperator()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(6, getCellOperator());
      }
      if (hasSimOperator()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(7, getSimOperator());
      }
      if (hasRoaming()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(8, getRoaming());
      }
      if (hasUserNumber()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(9, getUserNumber());
      }
      cachedSize = size;
      return size;
    }

    @Override
    public AndroidCheckinProto mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            AndroidBuildProto value = new AndroidBuildProto();
            input.readMessage(value);
            setBuild(value);
            break;
          }
          case 16: {
            setLastCheckinMsec(input.readInt64());
            break;
          }
          case 26: {
            AndroidEventProto value = new AndroidEventProto();
            input.readMessage(value);
            addEvent(value);
            break;
          }
          case 34: {
            AndroidStatisticProto value = new AndroidStatisticProto();
            input.readMessage(value);
            addStat(value);
            break;
          }
          case 42: {
            addRequestedGroup(input.readString());
            break;
          }
          case 50: {
            setCellOperator(input.readString());
            break;
          }
          case 58: {
            setSimOperator(input.readString());
            break;
          }
          case 66: {
            setRoaming(input.readString());
            break;
          }
          case 72: {
            setUserNumber(input.readInt32());
            break;
          }
        }
      }
    }

    public static AndroidCheckinProto parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (AndroidCheckinProto) (new AndroidCheckinProto().mergeFrom(data));
    }

    public static AndroidCheckinProto parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new AndroidCheckinProto().mergeFrom(input);
    }

  }

  public static final class DeviceConfigurationProto extends
      com.google.protobuf.micro.MessageMicro {
    public DeviceConfigurationProto() {}

    // optional int32 touchScreen = 1;
    public static final int TOUCHSCREEN_FIELD_NUMBER = 1;
    private boolean hasTouchScreen;
    private int touchScreen_ = 0;
    public int getTouchScreen() { return touchScreen_; }
    public boolean hasTouchScreen() { return hasTouchScreen; }
    public DeviceConfigurationProto setTouchScreen(int value) {
      hasTouchScreen = true;
      touchScreen_ = value;
      return this;
    }
    public DeviceConfigurationProto clearTouchScreen() {
      hasTouchScreen = false;
      touchScreen_ = 0;
      return this;
    }

    // optional int32 keyboard = 2;
    public static final int KEYBOARD_FIELD_NUMBER = 2;
    private boolean hasKeyboard;
    private int keyboard_ = 0;
    public int getKeyboard() { return keyboard_; }
    public boolean hasKeyboard() { return hasKeyboard; }
    public DeviceConfigurationProto setKeyboard(int value) {
      hasKeyboard = true;
      keyboard_ = value;
      return this;
    }
    public DeviceConfigurationProto clearKeyboard() {
      hasKeyboard = false;
      keyboard_ = 0;
      return this;
    }

    // optional int32 navigation = 3;
    public static final int NAVIGATION_FIELD_NUMBER = 3;
    private boolean hasNavigation;
    private int navigation_ = 0;
    public int getNavigation() { return navigation_; }
    public boolean hasNavigation() { return hasNavigation; }
    public DeviceConfigurationProto setNavigation(int value) {
      hasNavigation = true;
      navigation_ = value;
      return this;
    }
    public DeviceConfigurationProto clearNavigation() {
      hasNavigation = false;
      navigation_ = 0;
      return this;
    }

    // optional int32 screenLayout = 4;
    public static final int SCREENLAYOUT_FIELD_NUMBER = 4;
    private boolean hasScreenLayout;
    private int screenLayout_ = 0;
    public int getScreenLayout() { return screenLayout_; }
    public boolean hasScreenLayout() { return hasScreenLayout; }
    public DeviceConfigurationProto setScreenLayout(int value) {
      hasScreenLayout = true;
      screenLayout_ = value;
      return this;
    }
    public DeviceConfigurationProto clearScreenLayout() {
      hasScreenLayout = false;
      screenLayout_ = 0;
      return this;
    }

    // optional bool hasHardKeyboard = 5;
    public static final int HASHARDKEYBOARD_FIELD_NUMBER = 5;
    private boolean hasHasHardKeyboard;
    private boolean hasHardKeyboard_ = false;
    public boolean getHasHardKeyboard() { return hasHardKeyboard_; }
    public boolean hasHasHardKeyboard() { return hasHasHardKeyboard; }
    public DeviceConfigurationProto setHasHardKeyboard(boolean value) {
      hasHasHardKeyboard = true;
      hasHardKeyboard_ = value;
      return this;
    }
    public DeviceConfigurationProto clearHasHardKeyboard() {
      hasHasHardKeyboard = false;
      hasHardKeyboard_ = false;
      return this;
    }

    // optional bool hasFiveWayNavigation = 6;
    public static final int HASFIVEWAYNAVIGATION_FIELD_NUMBER = 6;
    private boolean hasHasFiveWayNavigation;
    private boolean hasFiveWayNavigation_ = false;
    public boolean getHasFiveWayNavigation() { return hasFiveWayNavigation_; }
    public boolean hasHasFiveWayNavigation() { return hasHasFiveWayNavigation; }
    public DeviceConfigurationProto setHasFiveWayNavigation(boolean value) {
      hasHasFiveWayNavigation = true;
      hasFiveWayNavigation_ = value;
      return this;
    }
    public DeviceConfigurationProto clearHasFiveWayNavigation() {
      hasHasFiveWayNavigation = false;
      hasFiveWayNavigation_ = false;
      return this;
    }

    // optional int32 screenDensity = 7;
    public static final int SCREENDENSITY_FIELD_NUMBER = 7;
    private boolean hasScreenDensity;
    private int screenDensity_ = 0;
    public int getScreenDensity() { return screenDensity_; }
    public boolean hasScreenDensity() { return hasScreenDensity; }
    public DeviceConfigurationProto setScreenDensity(int value) {
      hasScreenDensity = true;
      screenDensity_ = value;
      return this;
    }
    public DeviceConfigurationProto clearScreenDensity() {
      hasScreenDensity = false;
      screenDensity_ = 0;
      return this;
    }

    // optional int32 glEsVersion = 8;
    public static final int GLESVERSION_FIELD_NUMBER = 8;
    private boolean hasGlEsVersion;
    private int glEsVersion_ = 0;
    public int getGlEsVersion() { return glEsVersion_; }
    public boolean hasGlEsVersion() { return hasGlEsVersion; }
    public DeviceConfigurationProto setGlEsVersion(int value) {
      hasGlEsVersion = true;
      glEsVersion_ = value;
      return this;
    }
    public DeviceConfigurationProto clearGlEsVersion() {
      hasGlEsVersion = false;
      glEsVersion_ = 0;
      return this;
    }

    // repeated string systemSharedLibrary = 9;
    public static final int SYSTEMSHAREDLIBRARY_FIELD_NUMBER = 9;
    private java.util.List<String> systemSharedLibrary_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getSystemSharedLibraryList() {
      return systemSharedLibrary_;
    }
    public int getSystemSharedLibraryCount() { return systemSharedLibrary_.size(); }
    public String getSystemSharedLibrary(int index) {
      return systemSharedLibrary_.get(index);
    }
    public DeviceConfigurationProto setSystemSharedLibrary(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  systemSharedLibrary_.set(index, value);
      return this;
    }
    public DeviceConfigurationProto addSystemSharedLibrary(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (systemSharedLibrary_.isEmpty()) {
        systemSharedLibrary_ = new java.util.ArrayList<String>();
      }
      systemSharedLibrary_.add(value);
      return this;
    }
    public DeviceConfigurationProto clearSystemSharedLibrary() {
      systemSharedLibrary_ = java.util.Collections.emptyList();
      return this;
    }

    // repeated string systemAvailableFeature = 10;
    public static final int SYSTEMAVAILABLEFEATURE_FIELD_NUMBER = 10;
    private java.util.List<String> systemAvailableFeature_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getSystemAvailableFeatureList() {
      return systemAvailableFeature_;
    }
    public int getSystemAvailableFeatureCount() { return systemAvailableFeature_.size(); }
    public String getSystemAvailableFeature(int index) {
      return systemAvailableFeature_.get(index);
    }
    public DeviceConfigurationProto setSystemAvailableFeature(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  systemAvailableFeature_.set(index, value);
      return this;
    }
    public DeviceConfigurationProto addSystemAvailableFeature(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (systemAvailableFeature_.isEmpty()) {
        systemAvailableFeature_ = new java.util.ArrayList<String>();
      }
      systemAvailableFeature_.add(value);
      return this;
    }
    public DeviceConfigurationProto clearSystemAvailableFeature() {
      systemAvailableFeature_ = java.util.Collections.emptyList();
      return this;
    }

    // repeated string nativePlatform = 11;
    public static final int NATIVEPLATFORM_FIELD_NUMBER = 11;
    private java.util.List<String> nativePlatform_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getNativePlatformList() {
      return nativePlatform_;
    }
    public int getNativePlatformCount() { return nativePlatform_.size(); }
    public String getNativePlatform(int index) {
      return nativePlatform_.get(index);
    }
    public DeviceConfigurationProto setNativePlatform(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  nativePlatform_.set(index, value);
      return this;
    }
    public DeviceConfigurationProto addNativePlatform(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (nativePlatform_.isEmpty()) {
        nativePlatform_ = new java.util.ArrayList<String>();
      }
      nativePlatform_.add(value);
      return this;
    }
    public DeviceConfigurationProto clearNativePlatform() {
      nativePlatform_ = java.util.Collections.emptyList();
      return this;
    }

    // optional int32 screenWidth = 12;
    public static final int SCREENWIDTH_FIELD_NUMBER = 12;
    private boolean hasScreenWidth;
    private int screenWidth_ = 0;
    public int getScreenWidth() { return screenWidth_; }
    public boolean hasScreenWidth() { return hasScreenWidth; }
    public DeviceConfigurationProto setScreenWidth(int value) {
      hasScreenWidth = true;
      screenWidth_ = value;
      return this;
    }
    public DeviceConfigurationProto clearScreenWidth() {
      hasScreenWidth = false;
      screenWidth_ = 0;
      return this;
    }

    // optional int32 screenHeight = 13;
    public static final int SCREENHEIGHT_FIELD_NUMBER = 13;
    private boolean hasScreenHeight;
    private int screenHeight_ = 0;
    public int getScreenHeight() { return screenHeight_; }
    public boolean hasScreenHeight() { return hasScreenHeight; }
    public DeviceConfigurationProto setScreenHeight(int value) {
      hasScreenHeight = true;
      screenHeight_ = value;
      return this;
    }
    public DeviceConfigurationProto clearScreenHeight() {
      hasScreenHeight = false;
      screenHeight_ = 0;
      return this;
    }

    // repeated string systemSupportedLocale = 14;
    public static final int SYSTEMSUPPORTEDLOCALE_FIELD_NUMBER = 14;
    private java.util.List<String> systemSupportedLocale_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getSystemSupportedLocaleList() {
      return systemSupportedLocale_;
    }
    public int getSystemSupportedLocaleCount() { return systemSupportedLocale_.size(); }
    public String getSystemSupportedLocale(int index) {
      return systemSupportedLocale_.get(index);
    }
    public DeviceConfigurationProto setSystemSupportedLocale(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  systemSupportedLocale_.set(index, value);
      return this;
    }
    public DeviceConfigurationProto addSystemSupportedLocale(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (systemSupportedLocale_.isEmpty()) {
        systemSupportedLocale_ = new java.util.ArrayList<String>();
      }
      systemSupportedLocale_.add(value);
      return this;
    }
    public DeviceConfigurationProto clearSystemSupportedLocale() {
      systemSupportedLocale_ = java.util.Collections.emptyList();
      return this;
    }

    // repeated string glExtension = 15;
    public static final int GLEXTENSION_FIELD_NUMBER = 15;
    private java.util.List<String> glExtension_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getGlExtensionList() {
      return glExtension_;
    }
    public int getGlExtensionCount() { return glExtension_.size(); }
    public String getGlExtension(int index) {
      return glExtension_.get(index);
    }
    public DeviceConfigurationProto setGlExtension(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  glExtension_.set(index, value);
      return this;
    }
    public DeviceConfigurationProto addGlExtension(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (glExtension_.isEmpty()) {
        glExtension_ = new java.util.ArrayList<String>();
      }
      glExtension_.add(value);
      return this;
    }
    public DeviceConfigurationProto clearGlExtension() {
      glExtension_ = java.util.Collections.emptyList();
      return this;
    }

    // optional int32 maxApkDownloadSizeMb = 17 [default = 50];
    public static final int MAXAPKDOWNLOADSIZEMB_FIELD_NUMBER = 17;
    private boolean hasMaxApkDownloadSizeMb;
    private int maxApkDownloadSizeMb_ = 50;
    public int getMaxApkDownloadSizeMb() { return maxApkDownloadSizeMb_; }
    public boolean hasMaxApkDownloadSizeMb() { return hasMaxApkDownloadSizeMb; }
    public DeviceConfigurationProto setMaxApkDownloadSizeMb(int value) {
      hasMaxApkDownloadSizeMb = true;
      maxApkDownloadSizeMb_ = value;
      return this;
    }
    public DeviceConfigurationProto clearMaxApkDownloadSizeMb() {
      hasMaxApkDownloadSizeMb = false;
      maxApkDownloadSizeMb_ = 50;
      return this;
    }

    public final DeviceConfigurationProto clear() {
      clearTouchScreen();
      clearKeyboard();
      clearNavigation();
      clearScreenLayout();
      clearHasHardKeyboard();
      clearHasFiveWayNavigation();
      clearScreenDensity();
      clearGlEsVersion();
      clearSystemSharedLibrary();
      clearSystemAvailableFeature();
      clearNativePlatform();
      clearScreenWidth();
      clearScreenHeight();
      clearSystemSupportedLocale();
      clearGlExtension();
      clearMaxApkDownloadSizeMb();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasTouchScreen()) {
        output.writeInt32(1, getTouchScreen());
      }
      if (hasKeyboard()) {
        output.writeInt32(2, getKeyboard());
      }
      if (hasNavigation()) {
        output.writeInt32(3, getNavigation());
      }
      if (hasScreenLayout()) {
        output.writeInt32(4, getScreenLayout());
      }
      if (hasHasHardKeyboard()) {
        output.writeBool(5, getHasHardKeyboard());
      }
      if (hasHasFiveWayNavigation()) {
        output.writeBool(6, getHasFiveWayNavigation());
      }
      if (hasScreenDensity()) {
        output.writeInt32(7, getScreenDensity());
      }
      if (hasGlEsVersion()) {
        output.writeInt32(8, getGlEsVersion());
      }
      for (String element : getSystemSharedLibraryList()) {
        output.writeString(9, element);
      }
      for (String element : getSystemAvailableFeatureList()) {
        output.writeString(10, element);
      }
      for (String element : getNativePlatformList()) {
        output.writeString(11, element);
      }
      if (hasScreenWidth()) {
        output.writeInt32(12, getScreenWidth());
      }
      if (hasScreenHeight()) {
        output.writeInt32(13, getScreenHeight());
      }
      for (String element : getSystemSupportedLocaleList()) {
        output.writeString(14, element);
      }
      for (String element : getGlExtensionList()) {
        output.writeString(15, element);
      }
      if (hasMaxApkDownloadSizeMb()) {
        output.writeInt32(17, getMaxApkDownloadSizeMb());
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasTouchScreen()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(1, getTouchScreen());
      }
      if (hasKeyboard()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(2, getKeyboard());
      }
      if (hasNavigation()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(3, getNavigation());
      }
      if (hasScreenLayout()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(4, getScreenLayout());
      }
      if (hasHasHardKeyboard()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeBoolSize(5, getHasHardKeyboard());
      }
      if (hasHasFiveWayNavigation()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeBoolSize(6, getHasFiveWayNavigation());
      }
      if (hasScreenDensity()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(7, getScreenDensity());
      }
      if (hasGlEsVersion()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(8, getGlEsVersion());
      }
      {
        int dataSize = 0;
        for (String element : getSystemSharedLibraryList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getSystemSharedLibraryList().size();
      }
      {
        int dataSize = 0;
        for (String element : getSystemAvailableFeatureList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getSystemAvailableFeatureList().size();
      }
      {
        int dataSize = 0;
        for (String element : getNativePlatformList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getNativePlatformList().size();
      }
      if (hasScreenWidth()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(12, getScreenWidth());
      }
      if (hasScreenHeight()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(13, getScreenHeight());
      }
      {
        int dataSize = 0;
        for (String element : getSystemSupportedLocaleList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getSystemSupportedLocaleList().size();
      }
      {
        int dataSize = 0;
        for (String element : getGlExtensionList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getGlExtensionList().size();
      }
      if (hasMaxApkDownloadSizeMb()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(17, getMaxApkDownloadSizeMb());
      }
      cachedSize = size;
      return size;
    }

    @Override
    public DeviceConfigurationProto mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            setTouchScreen(input.readInt32());
            break;
          }
          case 16: {
            setKeyboard(input.readInt32());
            break;
          }
          case 24: {
            setNavigation(input.readInt32());
            break;
          }
          case 32: {
            setScreenLayout(input.readInt32());
            break;
          }
          case 40: {
            setHasHardKeyboard(input.readBool());
            break;
          }
          case 48: {
            setHasFiveWayNavigation(input.readBool());
            break;
          }
          case 56: {
            setScreenDensity(input.readInt32());
            break;
          }
          case 64: {
            setGlEsVersion(input.readInt32());
            break;
          }
          case 74: {
            addSystemSharedLibrary(input.readString());
            break;
          }
          case 82: {
            addSystemAvailableFeature(input.readString());
            break;
          }
          case 90: {
            addNativePlatform(input.readString());
            break;
          }
          case 96: {
            setScreenWidth(input.readInt32());
            break;
          }
          case 104: {
            setScreenHeight(input.readInt32());
            break;
          }
          case 114: {
            addSystemSupportedLocale(input.readString());
            break;
          }
          case 122: {
            addGlExtension(input.readString());
            break;
          }
          case 136: {
            setMaxApkDownloadSizeMb(input.readInt32());
            break;
          }
        }
      }
    }

    public static DeviceConfigurationProto parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (DeviceConfigurationProto) (new DeviceConfigurationProto().mergeFrom(data));
    }

    public static DeviceConfigurationProto parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new DeviceConfigurationProto().mergeFrom(input);
    }

  }

  public static final class AndroidBuildProto extends
      com.google.protobuf.micro.MessageMicro {
    public AndroidBuildProto() {}

    // optional string id = 1;
    public static final int ID_FIELD_NUMBER = 1;
    private boolean hasId;
    private String id_ = "";
    public String getId() { return id_; }
    public boolean hasId() { return hasId; }
    public AndroidBuildProto setId(String value) {
      hasId = true;
      id_ = value;
      return this;
    }
    public AndroidBuildProto clearId() {
      hasId = false;
      id_ = "";
      return this;
    }

    // optional string product = 2;
    public static final int PRODUCT_FIELD_NUMBER = 2;
    private boolean hasProduct;
    private String product_ = "";
    public String getProduct() { return product_; }
    public boolean hasProduct() { return hasProduct; }
    public AndroidBuildProto setProduct(String value) {
      hasProduct = true;
      product_ = value;
      return this;
    }
    public AndroidBuildProto clearProduct() {
      hasProduct = false;
      product_ = "";
      return this;
    }

    // optional string carrier = 3;
    public static final int CARRIER_FIELD_NUMBER = 3;
    private boolean hasCarrier;
    private String carrier_ = "";
    public String getCarrier() { return carrier_; }
    public boolean hasCarrier() { return hasCarrier; }
    public AndroidBuildProto setCarrier(String value) {
      hasCarrier = true;
      carrier_ = value;
      return this;
    }
    public AndroidBuildProto clearCarrier() {
      hasCarrier = false;
      carrier_ = "";
      return this;
    }

    // optional string radio = 4;
    public static final int RADIO_FIELD_NUMBER = 4;
    private boolean hasRadio;
    private String radio_ = "";
    public String getRadio() { return radio_; }
    public boolean hasRadio() { return hasRadio; }
    public AndroidBuildProto setRadio(String value) {
      hasRadio = true;
      radio_ = value;
      return this;
    }
    public AndroidBuildProto clearRadio() {
      hasRadio = false;
      radio_ = "";
      return this;
    }

    // optional string bootloader = 5;
    public static final int BOOTLOADER_FIELD_NUMBER = 5;
    private boolean hasBootloader;
    private String bootloader_ = "";
    public String getBootloader() { return bootloader_; }
    public boolean hasBootloader() { return hasBootloader; }
    public AndroidBuildProto setBootloader(String value) {
      hasBootloader = true;
      bootloader_ = value;
      return this;
    }
    public AndroidBuildProto clearBootloader() {
      hasBootloader = false;
      bootloader_ = "";
      return this;
    }

    // optional string client = 6;
    public static final int CLIENT_FIELD_NUMBER = 6;
    private boolean hasClient;
    private String client_ = "";
    public String getClient() { return client_; }
    public boolean hasClient() { return hasClient; }
    public AndroidBuildProto setClient(String value) {
      hasClient = true;
      client_ = value;
      return this;
    }
    public AndroidBuildProto clearClient() {
      hasClient = false;
      client_ = "";
      return this;
    }

    // optional int64 timestamp = 7;
    public static final int TIMESTAMP_FIELD_NUMBER = 7;
    private boolean hasTimestamp;
    private long timestamp_ = 0L;
    public long getTimestamp() { return timestamp_; }
    public boolean hasTimestamp() { return hasTimestamp; }
    public AndroidBuildProto setTimestamp(long value) {
      hasTimestamp = true;
      timestamp_ = value;
      return this;
    }
    public AndroidBuildProto clearTimestamp() {
      hasTimestamp = false;
      timestamp_ = 0L;
      return this;
    }

    // optional int32 googleServices = 8;
    public static final int GOOGLESERVICES_FIELD_NUMBER = 8;
    private boolean hasGoogleServices;
    private int googleServices_ = 0;
    public int getGoogleServices() { return googleServices_; }
    public boolean hasGoogleServices() { return hasGoogleServices; }
    public AndroidBuildProto setGoogleServices(int value) {
      hasGoogleServices = true;
      googleServices_ = value;
      return this;
    }
    public AndroidBuildProto clearGoogleServices() {
      hasGoogleServices = false;
      googleServices_ = 0;
      return this;
    }

    // optional string device = 9;
    public static final int DEVICE_FIELD_NUMBER = 9;
    private boolean hasDevice;
    private String device_ = "";
    public String getDevice() { return device_; }
    public boolean hasDevice() { return hasDevice; }
    public AndroidBuildProto setDevice(String value) {
      hasDevice = true;
      device_ = value;
      return this;
    }
    public AndroidBuildProto clearDevice() {
      hasDevice = false;
      device_ = "";
      return this;
    }

    // optional int32 sdkVersion = 10;
    public static final int SDKVERSION_FIELD_NUMBER = 10;
    private boolean hasSdkVersion;
    private int sdkVersion_ = 0;
    public int getSdkVersion() { return sdkVersion_; }
    public boolean hasSdkVersion() { return hasSdkVersion; }
    public AndroidBuildProto setSdkVersion(int value) {
      hasSdkVersion = true;
      sdkVersion_ = value;
      return this;
    }
    public AndroidBuildProto clearSdkVersion() {
      hasSdkVersion = false;
      sdkVersion_ = 0;
      return this;
    }

    // optional string model = 11;
    public static final int MODEL_FIELD_NUMBER = 11;
    private boolean hasModel;
    private String model_ = "";
    public String getModel() { return model_; }
    public boolean hasModel() { return hasModel; }
    public AndroidBuildProto setModel(String value) {
      hasModel = true;
      model_ = value;
      return this;
    }
    public AndroidBuildProto clearModel() {
      hasModel = false;
      model_ = "";
      return this;
    }

    // optional string manufacturer = 12;
    public static final int MANUFACTURER_FIELD_NUMBER = 12;
    private boolean hasManufacturer;
    private String manufacturer_ = "";
    public String getManufacturer() { return manufacturer_; }
    public boolean hasManufacturer() { return hasManufacturer; }
    public AndroidBuildProto setManufacturer(String value) {
      hasManufacturer = true;
      manufacturer_ = value;
      return this;
    }
    public AndroidBuildProto clearManufacturer() {
      hasManufacturer = false;
      manufacturer_ = "";
      return this;
    }

    // optional string buildProduct = 13;
    public static final int BUILDPRODUCT_FIELD_NUMBER = 13;
    private boolean hasBuildProduct;
    private String buildProduct_ = "";
    public String getBuildProduct() { return buildProduct_; }
    public boolean hasBuildProduct() { return hasBuildProduct; }
    public AndroidBuildProto setBuildProduct(String value) {
      hasBuildProduct = true;
      buildProduct_ = value;
      return this;
    }
    public AndroidBuildProto clearBuildProduct() {
      hasBuildProduct = false;
      buildProduct_ = "";
      return this;
    }

    // optional bool otaInstalled = 14;
    public static final int OTAINSTALLED_FIELD_NUMBER = 14;
    private boolean hasOtaInstalled;
    private boolean otaInstalled_ = false;
    public boolean getOtaInstalled() { return otaInstalled_; }
    public boolean hasOtaInstalled() { return hasOtaInstalled; }
    public AndroidBuildProto setOtaInstalled(boolean value) {
      hasOtaInstalled = true;
      otaInstalled_ = value;
      return this;
    }
    public AndroidBuildProto clearOtaInstalled() {
      hasOtaInstalled = false;
      otaInstalled_ = false;
      return this;
    }

    public final AndroidBuildProto clear() {
      clearId();
      clearProduct();
      clearCarrier();
      clearRadio();
      clearBootloader();
      clearClient();
      clearTimestamp();
      clearGoogleServices();
      clearDevice();
      clearSdkVersion();
      clearModel();
      clearManufacturer();
      clearBuildProduct();
      clearOtaInstalled();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasId()) {
        output.writeString(1, getId());
      }
      if (hasProduct()) {
        output.writeString(2, getProduct());
      }
      if (hasCarrier()) {
        output.writeString(3, getCarrier());
      }
      if (hasRadio()) {
        output.writeString(4, getRadio());
      }
      if (hasBootloader()) {
        output.writeString(5, getBootloader());
      }
      if (hasClient()) {
        output.writeString(6, getClient());
      }
      if (hasTimestamp()) {
        output.writeInt64(7, getTimestamp());
      }
      if (hasGoogleServices()) {
        output.writeInt32(8, getGoogleServices());
      }
      if (hasDevice()) {
        output.writeString(9, getDevice());
      }
      if (hasSdkVersion()) {
        output.writeInt32(10, getSdkVersion());
      }
      if (hasModel()) {
        output.writeString(11, getModel());
      }
      if (hasManufacturer()) {
        output.writeString(12, getManufacturer());
      }
      if (hasBuildProduct()) {
        output.writeString(13, getBuildProduct());
      }
      if (hasOtaInstalled()) {
        output.writeBool(14, getOtaInstalled());
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasId()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(1, getId());
      }
      if (hasProduct()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(2, getProduct());
      }
      if (hasCarrier()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(3, getCarrier());
      }
      if (hasRadio()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(4, getRadio());
      }
      if (hasBootloader()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(5, getBootloader());
      }
      if (hasClient()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(6, getClient());
      }
      if (hasTimestamp()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt64Size(7, getTimestamp());
      }
      if (hasGoogleServices()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(8, getGoogleServices());
      }
      if (hasDevice()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(9, getDevice());
      }
      if (hasSdkVersion()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(10, getSdkVersion());
      }
      if (hasModel()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(11, getModel());
      }
      if (hasManufacturer()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(12, getManufacturer());
      }
      if (hasBuildProduct()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(13, getBuildProduct());
      }
      if (hasOtaInstalled()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeBoolSize(14, getOtaInstalled());
      }
      cachedSize = size;
      return size;
    }

    @Override
    public AndroidBuildProto mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            setId(input.readString());
            break;
          }
          case 18: {
            setProduct(input.readString());
            break;
          }
          case 26: {
            setCarrier(input.readString());
            break;
          }
          case 34: {
            setRadio(input.readString());
            break;
          }
          case 42: {
            setBootloader(input.readString());
            break;
          }
          case 50: {
            setClient(input.readString());
            break;
          }
          case 56: {
            setTimestamp(input.readInt64());
            break;
          }
          case 64: {
            setGoogleServices(input.readInt32());
            break;
          }
          case 74: {
            setDevice(input.readString());
            break;
          }
          case 80: {
            setSdkVersion(input.readInt32());
            break;
          }
          case 90: {
            setModel(input.readString());
            break;
          }
          case 98: {
            setManufacturer(input.readString());
            break;
          }
          case 106: {
            setBuildProduct(input.readString());
            break;
          }
          case 112: {
            setOtaInstalled(input.readBool());
            break;
          }
        }
      }
    }

    public static AndroidBuildProto parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (AndroidBuildProto) (new AndroidBuildProto().mergeFrom(data));
    }

    public static AndroidBuildProto parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new AndroidBuildProto().mergeFrom(input);
    }

  }

  public static final class AndroidEventProto extends
      com.google.protobuf.micro.MessageMicro {
    public AndroidEventProto() {}

    // optional string tag = 1;
    public static final int TAG_FIELD_NUMBER = 1;
    private boolean hasTag;
    private String tag_ = "";
    public String getTag() { return tag_; }
    public boolean hasTag() { return hasTag; }
    public AndroidEventProto setTag(String value) {
      hasTag = true;
      tag_ = value;
      return this;
    }
    public AndroidEventProto clearTag() {
      hasTag = false;
      tag_ = "";
      return this;
    }

    // optional string value = 2;
    public static final int VALUE_FIELD_NUMBER = 2;
    private boolean hasValue;
    private String value_ = "";
    public String getValue() { return value_; }
    public boolean hasValue() { return hasValue; }
    public AndroidEventProto setValue(String value) {
      hasValue = true;
      value_ = value;
      return this;
    }
    public AndroidEventProto clearValue() {
      hasValue = false;
      value_ = "";
      return this;
    }

    // optional int64 timeMsec = 3;
    public static final int TIMEMSEC_FIELD_NUMBER = 3;
    private boolean hasTimeMsec;
    private long timeMsec_ = 0L;
    public long getTimeMsec() { return timeMsec_; }
    public boolean hasTimeMsec() { return hasTimeMsec; }
    public AndroidEventProto setTimeMsec(long value) {
      hasTimeMsec = true;
      timeMsec_ = value;
      return this;
    }
    public AndroidEventProto clearTimeMsec() {
      hasTimeMsec = false;
      timeMsec_ = 0L;
      return this;
    }

    public final AndroidEventProto clear() {
      clearTag();
      clearValue();
      clearTimeMsec();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasTag()) {
        output.writeString(1, getTag());
      }
      if (hasValue()) {
        output.writeString(2, getValue());
      }
      if (hasTimeMsec()) {
        output.writeInt64(3, getTimeMsec());
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasTag()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(1, getTag());
      }
      if (hasValue()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(2, getValue());
      }
      if (hasTimeMsec()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt64Size(3, getTimeMsec());
      }
      cachedSize = size;
      return size;
    }

    @Override
    public AndroidEventProto mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            setTag(input.readString());
            break;
          }
          case 18: {
            setValue(input.readString());
            break;
          }
          case 24: {
            setTimeMsec(input.readInt64());
            break;
          }
        }
      }
    }

    public static AndroidEventProto parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (AndroidEventProto) (new AndroidEventProto().mergeFrom(data));
    }

    public static AndroidEventProto parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new AndroidEventProto().mergeFrom(input);
    }

  }

  public static final class AndroidStatisticProto extends
      com.google.protobuf.micro.MessageMicro {
    public AndroidStatisticProto() {}

    // optional string tag = 1;
    public static final int TAG_FIELD_NUMBER = 1;
    private boolean hasTag;
    private String tag_ = "";
    public String getTag() { return tag_; }
    public boolean hasTag() { return hasTag; }
    public AndroidStatisticProto setTag(String value) {
      hasTag = true;
      tag_ = value;
      return this;
    }
    public AndroidStatisticProto clearTag() {
      hasTag = false;
      tag_ = "";
      return this;
    }

    // optional int32 count = 2;
    public static final int COUNT_FIELD_NUMBER = 2;
    private boolean hasCount;
    private int count_ = 0;
    public int getCount() { return count_; }
    public boolean hasCount() { return hasCount; }
    public AndroidStatisticProto setCount(int value) {
      hasCount = true;
      count_ = value;
      return this;
    }
    public AndroidStatisticProto clearCount() {
      hasCount = false;
      count_ = 0;
      return this;
    }

    // optional float sum = 3;
    public static final int SUM_FIELD_NUMBER = 3;
    private boolean hasSum;
    private float sum_ = 0F;
    public float getSum() { return sum_; }
    public boolean hasSum() { return hasSum; }
    public AndroidStatisticProto setSum(float value) {
      hasSum = true;
      sum_ = value;
      return this;
    }
    public AndroidStatisticProto clearSum() {
      hasSum = false;
      sum_ = 0F;
      return this;
    }

    public final AndroidStatisticProto clear() {
      clearTag();
      clearCount();
      clearSum();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasTag()) {
        output.writeString(1, getTag());
      }
      if (hasCount()) {
        output.writeInt32(2, getCount());
      }
      if (hasSum()) {
        output.writeFloat(3, getSum());
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasTag()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(1, getTag());
      }
      if (hasCount()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt32Size(2, getCount());
      }
      if (hasSum()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeFloatSize(3, getSum());
      }
      cachedSize = size;
      return size;
    }

    @Override
    public AndroidStatisticProto mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            setTag(input.readString());
            break;
          }
          case 16: {
            setCount(input.readInt32());
            break;
          }
          case 29: {
            setSum(input.readFloat());
            break;
          }
        }
      }
    }

    public static AndroidStatisticProto parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (AndroidStatisticProto) (new AndroidStatisticProto().mergeFrom(data));
    }

    public static AndroidStatisticProto parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new AndroidStatisticProto().mergeFrom(input);
    }

  }

  public static final class AndroidCheckinResponse extends
      com.google.protobuf.micro.MessageMicro {
    public AndroidCheckinResponse() {}

    // optional bool statsOk = 1;
    public static final int STATSOK_FIELD_NUMBER = 1;
    private boolean hasStatsOk;
    private boolean statsOk_ = false;
    public boolean getStatsOk() { return statsOk_; }
    public boolean hasStatsOk() { return hasStatsOk; }
    public AndroidCheckinResponse setStatsOk(boolean value) {
      hasStatsOk = true;
      statsOk_ = value;
      return this;
    }
    public AndroidCheckinResponse clearStatsOk() {
      hasStatsOk = false;
      statsOk_ = false;
      return this;
    }

    // repeated .AndroidIntentProto intent = 2;
    public static final int INTENT_FIELD_NUMBER = 2;
    private java.util.List<AndroidIntentProto> intent_ =
      java.util.Collections.emptyList();
    public java.util.List<AndroidIntentProto> getIntentList() {
      return intent_;
    }
    public int getIntentCount() { return intent_.size(); }
    public AndroidIntentProto getIntent(int index) {
      return intent_.get(index);
    }
    public AndroidCheckinResponse setIntent(int index, AndroidIntentProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      intent_.set(index, value);
      return this;
    }
    public AndroidCheckinResponse addIntent(AndroidIntentProto value) {
      if (value == null) {
        throw new NullPointerException();
      }
      if (intent_.isEmpty()) {
        intent_ = new java.util.ArrayList<AndroidIntentProto>();
      }
      intent_.add(value);
      return this;
    }
    public AndroidCheckinResponse clearIntent() {
      intent_ = java.util.Collections.emptyList();
      return this;
    }

    // optional int64 timeMsec = 3;
    public static final int TIMEMSEC_FIELD_NUMBER = 3;
    private boolean hasTimeMsec;
    private long timeMsec_ = 0L;
    public long getTimeMsec() { return timeMsec_; }
    public boolean hasTimeMsec() { return hasTimeMsec; }
    public AndroidCheckinResponse setTimeMsec(long value) {
      hasTimeMsec = true;
      timeMsec_ = value;
      return this;
    }
    public AndroidCheckinResponse clearTimeMsec() {
      hasTimeMsec = false;
      timeMsec_ = 0L;
      return this;
    }

    // optional string digest = 4;
    public static final int DIGEST_FIELD_NUMBER = 4;
    private boolean hasDigest;
    private String digest_ = "";
    public String getDigest() { return digest_; }
    public boolean hasDigest() { return hasDigest; }
    public AndroidCheckinResponse setDigest(String value) {
      hasDigest = true;
      digest_ = value;
      return this;
    }
    public AndroidCheckinResponse clearDigest() {
      hasDigest = false;
      digest_ = "";
      return this;
    }

    // repeated .GservicesSetting setting = 5;
    public static final int SETTING_FIELD_NUMBER = 5;
    private java.util.List<GservicesSetting> setting_ =
      java.util.Collections.emptyList();
    public java.util.List<GservicesSetting> getSettingList() {
      return setting_;
    }
    public int getSettingCount() { return setting_.size(); }
    public GservicesSetting getSetting(int index) {
      return setting_.get(index);
    }
    public AndroidCheckinResponse setSetting(int index, GservicesSetting value) {
      if (value == null) {
        throw new NullPointerException();
      }
      setting_.set(index, value);
      return this;
    }
    public AndroidCheckinResponse addSetting(GservicesSetting value) {
      if (value == null) {
        throw new NullPointerException();
      }
      if (setting_.isEmpty()) {
        setting_ = new java.util.ArrayList<GservicesSetting>();
      }
      setting_.add(value);
      return this;
    }
    public AndroidCheckinResponse clearSetting() {
      setting_ = java.util.Collections.emptyList();
      return this;
    }

    // optional bool marketOk = 6;
    public static final int MARKETOK_FIELD_NUMBER = 6;
    private boolean hasMarketOk;
    private boolean marketOk_ = false;
    public boolean getMarketOk() { return marketOk_; }
    public boolean hasMarketOk() { return hasMarketOk; }
    public AndroidCheckinResponse setMarketOk(boolean value) {
      hasMarketOk = true;
      marketOk_ = value;
      return this;
    }
    public AndroidCheckinResponse clearMarketOk() {
      hasMarketOk = false;
      marketOk_ = false;
      return this;
    }

    // optional fixed64 androidId = 7;
    public static final int ANDROIDID_FIELD_NUMBER = 7;
    private boolean hasAndroidId;
    private long androidId_ = 0L;
    public long getAndroidId() { return androidId_; }
    public boolean hasAndroidId() { return hasAndroidId; }
    public AndroidCheckinResponse setAndroidId(long value) {
      hasAndroidId = true;
      androidId_ = value;
      return this;
    }
    public AndroidCheckinResponse clearAndroidId() {
      hasAndroidId = false;
      androidId_ = 0L;
      return this;
    }

    // optional fixed64 securityToken = 8;
    public static final int SECURITYTOKEN_FIELD_NUMBER = 8;
    private boolean hasSecurityToken;
    private long securityToken_ = 0L;
    public long getSecurityToken() { return securityToken_; }
    public boolean hasSecurityToken() { return hasSecurityToken; }
    public AndroidCheckinResponse setSecurityToken(long value) {
      hasSecurityToken = true;
      securityToken_ = value;
      return this;
    }
    public AndroidCheckinResponse clearSecurityToken() {
      hasSecurityToken = false;
      securityToken_ = 0L;
      return this;
    }

    // optional bool settingsDiff = 9;
    public static final int SETTINGSDIFF_FIELD_NUMBER = 9;
    private boolean hasSettingsDiff;
    private boolean settingsDiff_ = false;
    public boolean getSettingsDiff() { return settingsDiff_; }
    public boolean hasSettingsDiff() { return hasSettingsDiff; }
    public AndroidCheckinResponse setSettingsDiff(boolean value) {
      hasSettingsDiff = true;
      settingsDiff_ = value;
      return this;
    }
    public AndroidCheckinResponse clearSettingsDiff() {
      hasSettingsDiff = false;
      settingsDiff_ = false;
      return this;
    }

    // repeated string deleteSetting = 10;
    public static final int DELETESETTING_FIELD_NUMBER = 10;
    private java.util.List<String> deleteSetting_ =
      java.util.Collections.emptyList();
    public java.util.List<String> getDeleteSettingList() {
      return deleteSetting_;
    }
    public int getDeleteSettingCount() { return deleteSetting_.size(); }
    public String getDeleteSetting(int index) {
      return deleteSetting_.get(index);
    }
    public AndroidCheckinResponse setDeleteSetting(int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  deleteSetting_.set(index, value);
      return this;
    }
    public AndroidCheckinResponse addDeleteSetting(String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  if (deleteSetting_.isEmpty()) {
        deleteSetting_ = new java.util.ArrayList<String>();
      }
      deleteSetting_.add(value);
      return this;
    }
    public AndroidCheckinResponse clearDeleteSetting() {
      deleteSetting_ = java.util.Collections.emptyList();
      return this;
    }

    // optional string versionInfo = 11;
    public static final int VERSIONINFO_FIELD_NUMBER = 11;
    private boolean hasVersionInfo;
    private String versionInfo_ = "";
    public String getVersionInfo() { return versionInfo_; }
    public boolean hasVersionInfo() { return hasVersionInfo; }
    public AndroidCheckinResponse setVersionInfo(String value) {
      hasVersionInfo = true;
      versionInfo_ = value;
      return this;
    }
    public AndroidCheckinResponse clearVersionInfo() {
      hasVersionInfo = false;
      versionInfo_ = "";
      return this;
    }

    // optional string deviceDataVersionInfo = 12;
    public static final int DEVICEDATAVERSIONINFO_FIELD_NUMBER = 12;
    private boolean hasDeviceDataVersionInfo;
    private String deviceDataVersionInfo_ = "";
    public String getDeviceDataVersionInfo() { return deviceDataVersionInfo_; }
    public boolean hasDeviceDataVersionInfo() { return hasDeviceDataVersionInfo; }
    public AndroidCheckinResponse setDeviceDataVersionInfo(String value) {
      hasDeviceDataVersionInfo = true;
      deviceDataVersionInfo_ = value;
      return this;
    }
    public AndroidCheckinResponse clearDeviceDataVersionInfo() {
      hasDeviceDataVersionInfo = false;
      deviceDataVersionInfo_ = "";
      return this;
    }

    public final AndroidCheckinResponse clear() {
      clearStatsOk();
      clearIntent();
      clearTimeMsec();
      clearDigest();
      clearSetting();
      clearMarketOk();
      clearAndroidId();
      clearSecurityToken();
      clearSettingsDiff();
      clearDeleteSetting();
      clearVersionInfo();
      clearDeviceDataVersionInfo();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasStatsOk()) {
        output.writeBool(1, getStatsOk());
      }
      for (AndroidIntentProto element : getIntentList()) {
        output.writeMessage(2, element);
      }
      if (hasTimeMsec()) {
        output.writeInt64(3, getTimeMsec());
      }
      if (hasDigest()) {
        output.writeString(4, getDigest());
      }
      for (GservicesSetting element : getSettingList()) {
        output.writeMessage(5, element);
      }
      if (hasMarketOk()) {
        output.writeBool(6, getMarketOk());
      }
      if (hasAndroidId()) {
        output.writeFixed64(7, getAndroidId());
      }
      if (hasSecurityToken()) {
        output.writeFixed64(8, getSecurityToken());
      }
      if (hasSettingsDiff()) {
        output.writeBool(9, getSettingsDiff());
      }
      for (String element : getDeleteSettingList()) {
        output.writeString(10, element);
      }
      if (hasVersionInfo()) {
        output.writeString(11, getVersionInfo());
      }
      if (hasDeviceDataVersionInfo()) {
        output.writeString(12, getDeviceDataVersionInfo());
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasStatsOk()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeBoolSize(1, getStatsOk());
      }
      for (AndroidIntentProto element : getIntentList()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeMessageSize(2, element);
      }
      if (hasTimeMsec()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeInt64Size(3, getTimeMsec());
      }
      if (hasDigest()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(4, getDigest());
      }
      for (GservicesSetting element : getSettingList()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeMessageSize(5, element);
      }
      if (hasMarketOk()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeBoolSize(6, getMarketOk());
      }
      if (hasAndroidId()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeFixed64Size(7, getAndroidId());
      }
      if (hasSecurityToken()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeFixed64Size(8, getSecurityToken());
      }
      if (hasSettingsDiff()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeBoolSize(9, getSettingsDiff());
      }
      {
        int dataSize = 0;
        for (String element : getDeleteSettingList()) {
          dataSize += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSizeNoTag(element);
        }
        size += dataSize;
        size += 1 * getDeleteSettingList().size();
      }
      if (hasVersionInfo()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(11, getVersionInfo());
      }
      if (hasDeviceDataVersionInfo()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(12, getDeviceDataVersionInfo());
      }
      cachedSize = size;
      return size;
    }

    @Override
    public AndroidCheckinResponse mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            setStatsOk(input.readBool());
            break;
          }
          case 18: {
            AndroidIntentProto value = new AndroidIntentProto();
            input.readMessage(value);
            addIntent(value);
            break;
          }
          case 24: {
            setTimeMsec(input.readInt64());
            break;
          }
          case 34: {
            setDigest(input.readString());
            break;
          }
          case 42: {
            GservicesSetting value = new GservicesSetting();
            input.readMessage(value);
            addSetting(value);
            break;
          }
          case 48: {
            setMarketOk(input.readBool());
            break;
          }
          case 57: {
            setAndroidId(input.readFixed64());
            break;
          }
          case 65: {
            setSecurityToken(input.readFixed64());
            break;
          }
          case 72: {
            setSettingsDiff(input.readBool());
            break;
          }
          case 82: {
            addDeleteSetting(input.readString());
            break;
          }
          case 90: {
            setVersionInfo(input.readString());
            break;
          }
          case 98: {
            setDeviceDataVersionInfo(input.readString());
            break;
          }
        }
      }
    }

    public static AndroidCheckinResponse parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (AndroidCheckinResponse) (new AndroidCheckinResponse().mergeFrom(data));
    }

    public static AndroidCheckinResponse parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new AndroidCheckinResponse().mergeFrom(input);
    }

  }

  public static final class AndroidIntentProto extends
      com.google.protobuf.micro.MessageMicro {
    public AndroidIntentProto() {}

    public static final class Extra extends
        com.google.protobuf.micro.MessageMicro {
      public Extra() {}

      // optional string name = 6;
      public static final int NAME_FIELD_NUMBER = 6;
      private boolean hasName;
      private String name_ = "";
      public String getName() { return name_; }
      public boolean hasName() { return hasName; }
      public Extra setName(String value) {
        hasName = true;
        name_ = value;
        return this;
      }
      public Extra clearName() {
        hasName = false;
        name_ = "";
        return this;
      }

      // optional string value = 7;
      public static final int VALUE_FIELD_NUMBER = 7;
      private boolean hasValue;
      private String value_ = "";
      public String getValue() { return value_; }
      public boolean hasValue() { return hasValue; }
      public Extra setValue(String value) {
        hasValue = true;
        value_ = value;
        return this;
      }
      public Extra clearValue() {
        hasValue = false;
        value_ = "";
        return this;
      }

      public final Extra clear() {
        clearName();
        clearValue();
        cachedSize = -1;
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      @Override
      public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                          throws java.io.IOException {
        if (hasName()) {
          output.writeString(6, getName());
        }
        if (hasValue()) {
          output.writeString(7, getValue());
        }
      }

      private int cachedSize = -1;
      @Override
      public int getCachedSize() {
        if (cachedSize < 0) {
          // getSerializedSize sets cachedSize
          getSerializedSize();
        }
        return cachedSize;
      }

      @Override
      public int getSerializedSize() {
        int size = 0;
        if (hasName()) {
          size += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSize(6, getName());
        }
        if (hasValue()) {
          size += com.google.protobuf.micro.CodedOutputStreamMicro
            .computeStringSize(7, getValue());
        }
        cachedSize = size;
        return size;
      }

      @Override
      public Extra mergeFrom(
          com.google.protobuf.micro.CodedInputStreamMicro input)
          throws java.io.IOException {
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              return this;
            default: {
              if (!parseUnknownField(input, tag)) {
                return this;
              }
              break;
            }
            case 50: {
              setName(input.readString());
              break;
            }
            case 58: {
              setValue(input.readString());
              break;
            }
          }
        }
      }

      public static Extra parseFrom(byte[] data)
          throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
        return (Extra) (new Extra().mergeFrom(data));
      }

      public static Extra parseFrom(
              com.google.protobuf.micro.CodedInputStreamMicro input)
          throws java.io.IOException {
        return new Extra().mergeFrom(input);
      }

    }

    // optional string action = 1;
    public static final int ACTION_FIELD_NUMBER = 1;
    private boolean hasAction;
    private String action_ = "";
    public String getAction() { return action_; }
    public boolean hasAction() { return hasAction; }
    public AndroidIntentProto setAction(String value) {
      hasAction = true;
      action_ = value;
      return this;
    }
    public AndroidIntentProto clearAction() {
      hasAction = false;
      action_ = "";
      return this;
    }

    // optional string dataUrl = 2;
    public static final int DATAURL_FIELD_NUMBER = 2;
    private boolean hasDataUrl;
    private String dataUrl_ = "";
    public String getDataUrl() { return dataUrl_; }
    public boolean hasDataUrl() { return hasDataUrl; }
    public AndroidIntentProto setDataUrl(String value) {
      hasDataUrl = true;
      dataUrl_ = value;
      return this;
    }
    public AndroidIntentProto clearDataUrl() {
      hasDataUrl = false;
      dataUrl_ = "";
      return this;
    }

    // optional string mimeType = 3;
    public static final int MIMETYPE_FIELD_NUMBER = 3;
    private boolean hasMimeType;
    private String mimeType_ = "";
    public String getMimeType() { return mimeType_; }
    public boolean hasMimeType() { return hasMimeType; }
    public AndroidIntentProto setMimeType(String value) {
      hasMimeType = true;
      mimeType_ = value;
      return this;
    }
    public AndroidIntentProto clearMimeType() {
      hasMimeType = false;
      mimeType_ = "";
      return this;
    }

    // optional string javaClass = 4;
    public static final int JAVACLASS_FIELD_NUMBER = 4;
    private boolean hasJavaClass;
    private String javaClass_ = "";
    public String getJavaClass() { return javaClass_; }
    public boolean hasJavaClass() { return hasJavaClass; }
    public AndroidIntentProto setJavaClass(String value) {
      hasJavaClass = true;
      javaClass_ = value;
      return this;
    }
    public AndroidIntentProto clearJavaClass() {
      hasJavaClass = false;
      javaClass_ = "";
      return this;
    }

    // repeated group Extra = 5 {
    public static final int EXTRA_FIELD_NUMBER = 5;
    private java.util.List<Extra> extra_ =
      java.util.Collections.emptyList();
    public java.util.List<Extra> getExtraList() {
      return extra_;
    }
    public int getExtraCount() { return extra_.size(); }
    public Extra getExtra(int index) {
      return extra_.get(index);
    }
    public AndroidIntentProto setExtra(int index, Extra value) {
      if (value == null) {
        throw new NullPointerException();
      }
      extra_.set(index, value);
      return this;
    }
    public AndroidIntentProto addExtra(Extra value) {
      if (value == null) {
        throw new NullPointerException();
      }
      if (extra_.isEmpty()) {
        extra_ = new java.util.ArrayList<Extra>();
      }
      extra_.add(value);
      return this;
    }
    public AndroidIntentProto clearExtra() {
      extra_ = java.util.Collections.emptyList();
      return this;
    }

    public final AndroidIntentProto clear() {
      clearAction();
      clearDataUrl();
      clearMimeType();
      clearJavaClass();
      clearExtra();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasAction()) {
        output.writeString(1, getAction());
      }
      if (hasDataUrl()) {
        output.writeString(2, getDataUrl());
      }
      if (hasMimeType()) {
        output.writeString(3, getMimeType());
      }
      if (hasJavaClass()) {
        output.writeString(4, getJavaClass());
      }
      for (Extra element : getExtraList()) {
        output.writeGroup(5, element);
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasAction()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(1, getAction());
      }
      if (hasDataUrl()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(2, getDataUrl());
      }
      if (hasMimeType()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(3, getMimeType());
      }
      if (hasJavaClass()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeStringSize(4, getJavaClass());
      }
      for (Extra element : getExtraList()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeGroupSize(5, element);
      }
      cachedSize = size;
      return size;
    }

    @Override
    public AndroidIntentProto mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            setAction(input.readString());
            break;
          }
          case 18: {
            setDataUrl(input.readString());
            break;
          }
          case 26: {
            setMimeType(input.readString());
            break;
          }
          case 34: {
            setJavaClass(input.readString());
            break;
          }
          case 43: {
            Extra value = new Extra();
            input.readGroup(value, 5);
            addExtra(value);
            break;
          }
        }
      }
    }

    public static AndroidIntentProto parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (AndroidIntentProto) (new AndroidIntentProto().mergeFrom(data));
    }

    public static AndroidIntentProto parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new AndroidIntentProto().mergeFrom(input);
    }

  }

  public static final class GservicesSetting extends
      com.google.protobuf.micro.MessageMicro {
    public GservicesSetting() {}

    // optional bytes name = 1;
    public static final int NAME_FIELD_NUMBER = 1;
    private boolean hasName;
    private com.google.protobuf.micro.ByteStringMicro name_ = com.google.protobuf.micro.ByteStringMicro.EMPTY;
    public com.google.protobuf.micro.ByteStringMicro getName() { return name_; }
    public boolean hasName() { return hasName; }
    public GservicesSetting setName(com.google.protobuf.micro.ByteStringMicro value) {
      hasName = true;
      name_ = value;
      return this;
    }
    public GservicesSetting clearName() {
      hasName = false;
      name_ = com.google.protobuf.micro.ByteStringMicro.EMPTY;
      return this;
    }

    // optional bytes value = 2;
    public static final int VALUE_FIELD_NUMBER = 2;
    private boolean hasValue;
    private com.google.protobuf.micro.ByteStringMicro value_ = com.google.protobuf.micro.ByteStringMicro.EMPTY;
    public com.google.protobuf.micro.ByteStringMicro getValue() { return value_; }
    public boolean hasValue() { return hasValue; }
    public GservicesSetting setValue(com.google.protobuf.micro.ByteStringMicro value) {
      hasValue = true;
      value_ = value;
      return this;
    }
    public GservicesSetting clearValue() {
      hasValue = false;
      value_ = com.google.protobuf.micro.ByteStringMicro.EMPTY;
      return this;
    }

    public final GservicesSetting clear() {
      clearName();
      clearValue();
      cachedSize = -1;
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.micro.CodedOutputStreamMicro output)
                        throws java.io.IOException {
      if (hasName()) {
        output.writeBytes(1, getName());
      }
      if (hasValue()) {
        output.writeBytes(2, getValue());
      }
    }

    private int cachedSize = -1;
    @Override
    public int getCachedSize() {
      if (cachedSize < 0) {
        // getSerializedSize sets cachedSize
        getSerializedSize();
      }
      return cachedSize;
    }

    @Override
    public int getSerializedSize() {
      int size = 0;
      if (hasName()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeBytesSize(1, getName());
      }
      if (hasValue()) {
        size += com.google.protobuf.micro.CodedOutputStreamMicro
          .computeBytesSize(2, getValue());
      }
      cachedSize = size;
      return size;
    }

    @Override
    public GservicesSetting mergeFrom(
        com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            setName(input.readBytes());
            break;
          }
          case 18: {
            setValue(input.readBytes());
            break;
          }
        }
      }
    }

    public static GservicesSetting parseFrom(byte[] data)
        throws com.google.protobuf.micro.InvalidProtocolBufferMicroException {
      return (GservicesSetting) (new GservicesSetting().mergeFrom(data));
    }

    public static GservicesSetting parseFrom(
            com.google.protobuf.micro.CodedInputStreamMicro input)
        throws java.io.IOException {
      return new GservicesSetting().mergeFrom(input);
    }

  }

}
