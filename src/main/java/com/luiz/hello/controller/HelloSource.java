package com.luiz.hello.controller;

import com.luiz.hello.HelloReq;
import com.luiz.hello.HelloRes;
import com.luiz.hello.HelloServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloSource extends HelloServiceGrpc.HelloServiceImplBase
{
    @Override
    public void hello(HelloReq request, StreamObserver<HelloRes> responseObserver) {
    var response = HelloRes.newBuilder().setMessage(request.getMessage()).build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
    }
}
