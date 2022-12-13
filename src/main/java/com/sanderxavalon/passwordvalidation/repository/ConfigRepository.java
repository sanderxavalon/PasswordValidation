package com.sanderxavalon.passwordvalidation.repository;

import com.sanderxavalon.passwordvalidation.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConfigRepository extends JpaRepository<Config, Integer>  {

    @Query(value = "select * from config where config_key = :configKey",nativeQuery = true)
    Config findOneByConfigKey(@Param("configKey") String configKey);

}