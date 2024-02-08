package com.youcode.aftas.core.service.app_service;

import com.youcode.aftas.core.database.model.entity.Fish;
import com.youcode.aftas.core.database.model.dto.response.FishResponse;
import com.youcode.aftas.core.service.app_service.base.CrudVmService;

import java.util.UUID;

public interface FishService extends CrudVmService<Fish, FishResponse, UUID> {

}
