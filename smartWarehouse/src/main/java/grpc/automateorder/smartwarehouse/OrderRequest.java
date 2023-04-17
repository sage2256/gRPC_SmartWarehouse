// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AutomateOrder.proto

package grpc.automateorder.smartwarehouse;

/**
 * Protobuf type {@code smartwarehouse.OrderRequest}
 */
public  final class OrderRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:smartwarehouse.OrderRequest)
    OrderRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OrderRequest.newBuilder() to construct.
  private OrderRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OrderRequest() {
    itemName_ = "";
    quantity_ = 0;
    customerName_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OrderRequest(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            itemName_ = s;
            break;
          }
          case 16: {

            quantity_ = input.readInt32();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            customerName_ = s;
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
    return grpc.automateorder.smartwarehouse.AutomateOrderServiceImpl.internal_static_smartwarehouse_OrderRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.automateorder.smartwarehouse.AutomateOrderServiceImpl.internal_static_smartwarehouse_OrderRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.automateorder.smartwarehouse.OrderRequest.class, grpc.automateorder.smartwarehouse.OrderRequest.Builder.class);
  }

  public static final int ITEM_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object itemName_;
  /**
   * <code>string item_name = 1;</code>
   */
  public java.lang.String getItemName() {
    java.lang.Object ref = itemName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      itemName_ = s;
      return s;
    }
  }
  /**
   * <code>string item_name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getItemNameBytes() {
    java.lang.Object ref = itemName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      itemName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int QUANTITY_FIELD_NUMBER = 2;
  private int quantity_;
  /**
   * <code>int32 quantity = 2;</code>
   */
  public int getQuantity() {
    return quantity_;
  }

  public static final int CUSTOMER_NAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object customerName_;
  /**
   * <code>string customer_name = 3;</code>
   */
  public java.lang.String getCustomerName() {
    java.lang.Object ref = customerName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      customerName_ = s;
      return s;
    }
  }
  /**
   * <code>string customer_name = 3;</code>
   */
  public com.google.protobuf.ByteString
      getCustomerNameBytes() {
    java.lang.Object ref = customerName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      customerName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getItemNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, itemName_);
    }
    if (quantity_ != 0) {
      output.writeInt32(2, quantity_);
    }
    if (!getCustomerNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, customerName_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getItemNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, itemName_);
    }
    if (quantity_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, quantity_);
    }
    if (!getCustomerNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, customerName_);
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
    if (!(obj instanceof grpc.automateorder.smartwarehouse.OrderRequest)) {
      return super.equals(obj);
    }
    grpc.automateorder.smartwarehouse.OrderRequest other = (grpc.automateorder.smartwarehouse.OrderRequest) obj;

    boolean result = true;
    result = result && getItemName()
        .equals(other.getItemName());
    result = result && (getQuantity()
        == other.getQuantity());
    result = result && getCustomerName()
        .equals(other.getCustomerName());
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
    hash = (37 * hash) + ITEM_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getItemName().hashCode();
    hash = (37 * hash) + QUANTITY_FIELD_NUMBER;
    hash = (53 * hash) + getQuantity();
    hash = (37 * hash) + CUSTOMER_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getCustomerName().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.automateorder.smartwarehouse.OrderRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.automateorder.smartwarehouse.OrderRequest parseFrom(
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
  public static Builder newBuilder(grpc.automateorder.smartwarehouse.OrderRequest prototype) {
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
   * Protobuf type {@code smartwarehouse.OrderRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:smartwarehouse.OrderRequest)
      grpc.automateorder.smartwarehouse.OrderRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.automateorder.smartwarehouse.AutomateOrderServiceImpl.internal_static_smartwarehouse_OrderRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.automateorder.smartwarehouse.AutomateOrderServiceImpl.internal_static_smartwarehouse_OrderRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.automateorder.smartwarehouse.OrderRequest.class, grpc.automateorder.smartwarehouse.OrderRequest.Builder.class);
    }

    // Construct using grpc.automateorder.smartwarehouse.OrderRequest.newBuilder()
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
      itemName_ = "";

      quantity_ = 0;

      customerName_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.automateorder.smartwarehouse.AutomateOrderServiceImpl.internal_static_smartwarehouse_OrderRequest_descriptor;
    }

    @java.lang.Override
    public grpc.automateorder.smartwarehouse.OrderRequest getDefaultInstanceForType() {
      return grpc.automateorder.smartwarehouse.OrderRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.automateorder.smartwarehouse.OrderRequest build() {
      grpc.automateorder.smartwarehouse.OrderRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.automateorder.smartwarehouse.OrderRequest buildPartial() {
      grpc.automateorder.smartwarehouse.OrderRequest result = new grpc.automateorder.smartwarehouse.OrderRequest(this);
      result.itemName_ = itemName_;
      result.quantity_ = quantity_;
      result.customerName_ = customerName_;
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
      if (other instanceof grpc.automateorder.smartwarehouse.OrderRequest) {
        return mergeFrom((grpc.automateorder.smartwarehouse.OrderRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.automateorder.smartwarehouse.OrderRequest other) {
      if (other == grpc.automateorder.smartwarehouse.OrderRequest.getDefaultInstance()) return this;
      if (!other.getItemName().isEmpty()) {
        itemName_ = other.itemName_;
        onChanged();
      }
      if (other.getQuantity() != 0) {
        setQuantity(other.getQuantity());
      }
      if (!other.getCustomerName().isEmpty()) {
        customerName_ = other.customerName_;
        onChanged();
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
      grpc.automateorder.smartwarehouse.OrderRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.automateorder.smartwarehouse.OrderRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object itemName_ = "";
    /**
     * <code>string item_name = 1;</code>
     */
    public java.lang.String getItemName() {
      java.lang.Object ref = itemName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        itemName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string item_name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getItemNameBytes() {
      java.lang.Object ref = itemName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        itemName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string item_name = 1;</code>
     */
    public Builder setItemName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      itemName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string item_name = 1;</code>
     */
    public Builder clearItemName() {
      
      itemName_ = getDefaultInstance().getItemName();
      onChanged();
      return this;
    }
    /**
     * <code>string item_name = 1;</code>
     */
    public Builder setItemNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      itemName_ = value;
      onChanged();
      return this;
    }

    private int quantity_ ;
    /**
     * <code>int32 quantity = 2;</code>
     */
    public int getQuantity() {
      return quantity_;
    }
    /**
     * <code>int32 quantity = 2;</code>
     */
    public Builder setQuantity(int value) {
      
      quantity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 quantity = 2;</code>
     */
    public Builder clearQuantity() {
      
      quantity_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object customerName_ = "";
    /**
     * <code>string customer_name = 3;</code>
     */
    public java.lang.String getCustomerName() {
      java.lang.Object ref = customerName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        customerName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string customer_name = 3;</code>
     */
    public com.google.protobuf.ByteString
        getCustomerNameBytes() {
      java.lang.Object ref = customerName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        customerName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string customer_name = 3;</code>
     */
    public Builder setCustomerName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      customerName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string customer_name = 3;</code>
     */
    public Builder clearCustomerName() {
      
      customerName_ = getDefaultInstance().getCustomerName();
      onChanged();
      return this;
    }
    /**
     * <code>string customer_name = 3;</code>
     */
    public Builder setCustomerNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      customerName_ = value;
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


    // @@protoc_insertion_point(builder_scope:smartwarehouse.OrderRequest)
  }

  // @@protoc_insertion_point(class_scope:smartwarehouse.OrderRequest)
  private static final grpc.automateorder.smartwarehouse.OrderRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.automateorder.smartwarehouse.OrderRequest();
  }

  public static grpc.automateorder.smartwarehouse.OrderRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OrderRequest>
      PARSER = new com.google.protobuf.AbstractParser<OrderRequest>() {
    @java.lang.Override
    public OrderRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OrderRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OrderRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OrderRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.automateorder.smartwarehouse.OrderRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

