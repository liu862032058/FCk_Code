package com.lyq.service;

import com.lyq.entry.CityInfo;

import java.util.Collection;

public interface BigmapService {

    Long saveToRedis(Collection<CityInfo> cityInfos);
}
