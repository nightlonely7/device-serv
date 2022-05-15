package vn.edu.fpt.deviceserv.service;

import vn.edu.fpt.deviceserv.dto.entity.ParamItem;

import java.util.List;

public interface ParamItemService {
    void createParamItem(ParamItem paramItem);
    List<ParamItem> listParamItemByType(String type);
}
