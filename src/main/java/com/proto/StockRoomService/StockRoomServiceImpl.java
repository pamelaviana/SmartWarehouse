// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: StockRoomService.proto

package com.proto.StockRoomService;

public final class StockRoomServiceImpl {
  private StockRoomServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_proto_StockRoomService_OrderRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_proto_StockRoomService_OrderRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_proto_StockRoomService_ReadyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_proto_StockRoomService_ReadyResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_proto_StockRoomService_StockSupplyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_proto_StockRoomService_StockSupplyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_proto_StockRoomService_StockSupplyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_proto_StockRoomService_StockSupplyResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_proto_StockRoomService_AlertRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_proto_StockRoomService_AlertRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_proto_StockRoomService_AlertResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_proto_StockRoomService_AlertResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026StockRoomService.proto\022\032com.proto.Stoc" +
      "kRoomService\"3\n\014OrderRequest\022\017\n\007orderid\030" +
      "\001 \001(\t\022\022\n\nclientname\030\002 \001(\t\"$\n\rReadyRespon" +
      "se\022\023\n\013OrderStatus\030\001 \001(\t\"\242\001\n\022StockSupplyR" +
      "equest\022\022\n\ncurrentQty\030\001 \001(\002\022\020\n\010inputQty\030\002" +
      " \001(\002\022K\n\toperation\030\003 \001(\01628.com.proto.Stoc" +
      "kRoomService.StockSupplyRequest.Operatio" +
      "n\"\031\n\tOperation\022\014\n\010ADDITION\020\000\"7\n\023StockSup" +
      "plyResponse\022\016\n\006result\030\001 \001(\002\022\020\n\010mysupply\030" +
      "\002 \001(\t\"7\n\014AlertRequest\022\020\n\010itemname\030\001 \001(\t\022" +
      "\025\n\rminStockLevel\030\002 \001(\005\" \n\rAlertResponse\022" +
      "\017\n\007message\030\001 \001(\t2\320\002\n\020StockRoomService\022c\n" +
      "\nreadyOrder\022(.com.proto.StockRoomService" +
      ".OrderRequest\032).com.proto.StockRoomServi" +
      "ce.ReadyResponse\"\000\022p\n\013stockSupply\022..com." +
      "proto.StockRoomService.StockSupplyReques" +
      "t\032/.com.proto.StockRoomService.StockSupp" +
      "lyResponse\"\000\022e\n\nstockAlert\022(.com.proto.S" +
      "tockRoomService.AlertRequest\032).com.proto" +
      ".StockRoomService.AlertResponse\"\0000\001B4\n\032c" +
      "om.proto.StockRoomServiceB\024StockRoomServ" +
      "iceImplP\001b\006proto3"
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
    internal_static_com_proto_StockRoomService_OrderRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_proto_StockRoomService_OrderRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_proto_StockRoomService_OrderRequest_descriptor,
        new java.lang.String[] { "Orderid", "Clientname", });
    internal_static_com_proto_StockRoomService_ReadyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_proto_StockRoomService_ReadyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_proto_StockRoomService_ReadyResponse_descriptor,
        new java.lang.String[] { "OrderStatus", });
    internal_static_com_proto_StockRoomService_StockSupplyRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_proto_StockRoomService_StockSupplyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_proto_StockRoomService_StockSupplyRequest_descriptor,
        new java.lang.String[] { "CurrentQty", "InputQty", "Operation", });
    internal_static_com_proto_StockRoomService_StockSupplyResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_proto_StockRoomService_StockSupplyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_proto_StockRoomService_StockSupplyResponse_descriptor,
        new java.lang.String[] { "Result", "Mysupply", });
    internal_static_com_proto_StockRoomService_AlertRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_proto_StockRoomService_AlertRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_proto_StockRoomService_AlertRequest_descriptor,
        new java.lang.String[] { "Itemname", "MinStockLevel", });
    internal_static_com_proto_StockRoomService_AlertResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_proto_StockRoomService_AlertResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_proto_StockRoomService_AlertResponse_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}