package com.sanderxavalon.passwordvalidation.core.config;

import com.sanderxavalon.passwordvalidation.core.config.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config, Integer>  { }
