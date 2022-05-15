package vn.edu.fpt.deviceserv.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.fpt.deviceserv.dto.entity.ParamItem;
import vn.edu.fpt.deviceserv.repository.ParamItemRepository;
import vn.edu.fpt.deviceserv.service.ParamItemService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParamItemServiceImpl implements ParamItemService {

    private final ParamItemRepository paramItemRepository;

    @Override
    public void createParamItem(ParamItem paramItem) {
        paramItemRepository.save(paramItem);
    }

    @Override
    public List<ParamItem> listParamItemByType(String type) {
        return paramItemRepository.findAllByType(type);
    }

}
