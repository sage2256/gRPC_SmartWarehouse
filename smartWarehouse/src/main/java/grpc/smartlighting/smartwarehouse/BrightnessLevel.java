// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SmartLighting.proto

package grpc.smartlighting.smartwarehouse;

/**
 * Protobuf type {@code smartwarehouse.BrightnessLevel}
 */
public  final class BrightnessLevel extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:smartwarehouse.BrightnessLevel)
    BrightnessLevelOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BrightnessLevel.newBuilder() to construct.
  private BrightnessLevel(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BrightnessLevel() {
    level_ = 0F;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private BrightnessLevel(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 13: {

            level_ = input.readFloat();
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.smartlighting.smartwarehouse.MathServiceImpl.internal_static_smartwarehouse_BrightnessLevel_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.smartlighting.smartwarehouse.MathServiceImpl.internal_static_smartwarehouse_BrightnessLevel_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.smartlighting.smartwarehouse.BrightnessLevel.class, grpc.smartlighting.smartwarehouse.BrightnessLevel.Builder.class);
  }

  public static final int LEVEL_FIELD_NUMBER = 1;
  private float level_;
  /**
   * <code>float level = 1;</code>
   */
  public float getLevel() {
    return level_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (level_ != 0F) {
      output.writeFloat(1, level_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (level_ != 0F) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(1, level_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.smartlighting.smartwarehouse.BrightnessLevel)) {
      return super.equals(obj);
    }
    grpc.smartlighting.smartwarehouse.BrightnessLevel other = (grpc.smartlighting.smartwarehouse.BrightnessLevel) obj;

    boolean result = true;
    result = result && (
        java.lang.Float.floatToIntBits(getLevel())
        == java.lang.Float.floatToIntBits(
            other.getLevel()));
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + LEVEL_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getLevel());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.smartlighting.smartwarehouse.BrightnessLevel parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.smartlighting.smartwarehouse.BrightnessLevel prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code smartwarehouse.BrightnessLevel}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:smartwarehouse.BrightnessLevel)
      grpc.smartlighting.smartwarehouse.BrightnessLevelOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.smartlighting.smartwarehouse.MathServiceImpl.internal_static_smartwarehouse_BrightnessLevel_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.smartlighting.smartwarehouse.MathServiceImpl.internal_static_smartwarehouse_BrightnessLevel_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.smartlighting.smartwarehouse.BrightnessLevel.class, grpc.smartlighting.smartwarehouse.BrightnessLevel.Builder.class);
    }

    // Construct using grpc.smartlighting.smartwarehouse.BrightnessLevel.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      level_ = 0F;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.smartlighting.smartwarehouse.MathServiceImpl.internal_static_smartwarehouse_BrightnessLevel_descriptor;
    }

    @java.lang.Override
    public grpc.smartlighting.smartwarehouse.BrightnessLevel getDefaultInstanceForType() {
      return grpc.smartlighting.smartwarehouse.BrightnessLevel.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.smartlighting.smartwarehouse.BrightnessLevel build() {
      grpc.smartlighting.smartwarehouse.BrightnessLevel result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.smartlighting.smartwarehouse.BrightnessLevel buildPartial() {
      grpc.smartlighting.smartwarehouse.BrightnessLevel result = new grpc.smartlighting.smartwarehouse.BrightnessLevel(this);
      result.level_ = level_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.smartlighting.smartwarehouse.BrightnessLevel) {
        return mergeFrom((grpc.smartlighting.smartwarehouse.BrightnessLevel)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.smartlighting.smartwarehouse.BrightnessLevel other) {
      if (other == grpc.smartlighting.smartwarehouse.BrightnessLevel.getDefaultInstance()) return this;
      if (other.getLevel() != 0F) {
        setLevel(other.getLevel());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.smartlighting.smartwarehouse.BrightnessLevel parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.smartlighting.smartwarehouse.BrightnessLevel) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private float level_ ;
    /**
     * <code>float level = 1;</code>
     */
    public float getLevel() {
      return level_;
    }
    /**
     * <code>float level = 1;</code>
     */
    public Builder setLevel(float value) {
      
      level_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>float level = 1;</code>
     */
    public Builder clearLevel() {
      
      level_ = 0F;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:smartwarehouse.BrightnessLevel)
  }

  // @@protoc_insertion_point(class_scope:smartwarehouse.BrightnessLevel)
  private static final grpc.smartlighting.smartwarehouse.BrightnessLevel DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.smartlighting.smartwarehouse.BrightnessLevel();
  }

  public static grpc.smartlighting.smartwarehouse.BrightnessLevel getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BrightnessLevel>
      PARSER = new com.google.protobuf.AbstractParser<BrightnessLevel>() {
    @java.lang.Override
    public BrightnessLevel parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new BrightnessLevel(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BrightnessLevel> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BrightnessLevel> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.smartlighting.smartwarehouse.BrightnessLevel getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
