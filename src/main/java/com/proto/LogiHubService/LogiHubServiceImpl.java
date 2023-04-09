// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: LobHubService.proto

package com.proto.LogiHubService;

public final class LogiHubServiceImpl {
  private LogiHubServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_logi_hub_StatusRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_logi_hub_StatusRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_logi_hub_StatusResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_logi_hub_StatusResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_logi_hub_FailureRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_logi_hub_FailureRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_logi_hub_FailureResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_logi_hub_FailureResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_logi_hub_ReturnRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_logi_hub_ReturnRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_logi_hub_ReturnResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_logi_hub_ReturnResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023LobHubService.proto\022\010logi_hub\"H\n\rStatu" +
      "sRequest\022\017\n\007orderid\030\001 \001(\t\022\022\n\nclientname\030" +
      "\002 \001(\t\022\022\n\nmydelivery\030\003 \001(\t\"\"\n\016StatusRespo" +
      "nse\022\020\n\010Mystatus\030\001 \001(\t\"C\n\016FailureRequest\022" +
      "\017\n\007orderid\030\001 \001(\t\022\020\n\010itemname\030\002 \001(\t\022\016\n\006re" +
      "ason\030\003 \001(\t\"\'\n\017FailureResponse\022\024\n\014confirm" +
      "ation\030\001 \001(\t\"D\n\rReturnRequest\022\017\n\007orderid\030" +
      "\001 \001(\t\022\022\n\nclientname\030\002 \001(\t\022\016\n\006reason\030\003 \001(" +
      "\t\"&\n\016ReturnResponse\022\024\n\014confirmation\030\001 \001(" +
      "\t2\342\001\n\016LogiHubService\022E\n\016DeliveryStatus\022\027" +
      ".logi_hub.StatusRequest\032\030.logi_hub.Statu" +
      "sResponse\"\000\022E\n\014FailureOrder\022\030.logi_hub.F" +
      "ailureRequest\032\031.logi_hub.FailureResponse" +
      "\"\000\022B\n\013ReturnOrder\022\027.logi_hub.ReturnReque" +
      "st\032\030.logi_hub.ReturnResponse\"\000B0\n\030com.pr" +
      "oto.LogiHubServiceB\022LogiHubServiceImplP\001" +
      "b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_logi_hub_StatusRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_logi_hub_StatusRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_logi_hub_StatusRequest_descriptor,
        new java.lang.String[] { "Orderid", "Clientname", "Mydelivery", });
    internal_static_logi_hub_StatusResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_logi_hub_StatusResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_logi_hub_StatusResponse_descriptor,
        new java.lang.String[] { "Mystatus", });
    internal_static_logi_hub_FailureRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_logi_hub_FailureRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_logi_hub_FailureRequest_descriptor,
        new java.lang.String[] { "Orderid", "Itemname", "Reason", });
    internal_static_logi_hub_FailureResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_logi_hub_FailureResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_logi_hub_FailureResponse_descriptor,
        new java.lang.String[] { "Confirmation", });
    internal_static_logi_hub_ReturnRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_logi_hub_ReturnRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_logi_hub_ReturnRequest_descriptor,
        new java.lang.String[] { "Orderid", "Clientname", "Reason", });
    internal_static_logi_hub_ReturnResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_logi_hub_ReturnResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_logi_hub_ReturnResponse_descriptor,
        new java.lang.String[] { "Confirmation", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
