// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AutomateOrder.proto

package grpc.automateorder.smartwarehouse;

public interface OrderRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:smartwarehouse.OrderRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string item_name = 1;</code>
   */
  java.lang.String getItemName();
  /**
   * <code>string item_name = 1;</code>
   */
  com.google.protobuf.ByteString
      getItemNameBytes();

  /**
   * <code>int32 quantity = 2;</code>
   */
  int getQuantity();

  /**
   * <code>string customer_name = 3;</code>
   */
  java.lang.String getCustomerName();
  /**
   * <code>string customer_name = 3;</code>
   */
  com.google.protobuf.ByteString
      getCustomerNameBytes();
}
