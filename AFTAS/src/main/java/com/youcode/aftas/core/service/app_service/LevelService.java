package com.youcode.aftas.core.service.app_service;

import com.youcode.aftas.core.database.model.entity.Level;
import com.youcode.aftas.core.database.model.dto.response.LevelResponse;
import com.youcode.aftas.core.service.app_service.base.CrudVmService;

import java.util.UUID;

public interface LevelService extends CrudVmService<Level, LevelResponse, UUID> {
}
