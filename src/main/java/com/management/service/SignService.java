package com.management.service;

import com.management.entity.rsp.SignRsp;

import java.util.List;

public interface SignService {

    List<SignRsp> selectSignByUser(String uuid);

    Boolean signIn(String uuid, String uUuid, Integer statement, String describe);

    Boolean signOut(String uuid, Integer statement);
}
