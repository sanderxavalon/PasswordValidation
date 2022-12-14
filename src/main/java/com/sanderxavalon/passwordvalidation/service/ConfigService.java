package com.sanderxavalon.passwordvalidation.service;

import com.sanderxavalon.passwordvalidation.core.common.response.StatusEnum;
import com.sanderxavalon.passwordvalidation.core.config.Observer;
import com.sanderxavalon.passwordvalidation.core.config.Subject;
import com.sanderxavalon.passwordvalidation.core.common.exception.SystemException;
import com.sanderxavalon.passwordvalidation.entity.Config;
import com.sanderxavalon.passwordvalidation.repository.ConfigRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Lazy
@Service
public class ConfigService implements Subject {

    private List<Observer> observers;
    private ConfigRepository configRepository;

    public ConfigService(List<Observer> observers, ConfigRepository configRepository) {
        this.observers = observers;
        this.configRepository = configRepository;
        this.notifyAllObserver();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index > -1) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyAllObserver() {
        List<Config> configs = configRepository.findAll();
        observers.stream().forEach( obs -> obs.update(configs));
    }

    public static Integer getConfigValue(List<Config> configs, String configKey) {
            return configs.stream()
                .filter(config -> config.getConfigKey().equals(configKey))
                .findAny()
                .orElseThrow(() -> new SystemException(StatusEnum.SYSTEM_NO_DEFAULT_VALUE_FOUND))
                .getConfigValue();
    }

    public void updateConfigs(List<Config> configs) {
        configRepository.saveAll(configs);
        this.notifyAllObserver();
    }

    public List<Config> getAllConfigs() {
        return configRepository.findAll();
    }
}
