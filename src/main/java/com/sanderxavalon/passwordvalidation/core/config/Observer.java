package com.sanderxavalon.passwordvalidation.core.config;

import com.sanderxavalon.passwordvalidation.core.config.entity.Config;
import java.util.List;

public interface Observer {
    void update(List<Config> configs);
}
