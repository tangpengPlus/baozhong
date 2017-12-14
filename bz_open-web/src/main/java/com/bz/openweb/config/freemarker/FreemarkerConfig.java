package com.bz.openweb.config.freemarker;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bz.openweb.web.tag.encryption.EncryQueryTag;

import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月12日上午11:17:55
 * 描述:freemarker模板标签及常用属性配置
 * 备注:
 */
@Component
public class FreemarkerConfig {

  @Autowired
  private Configuration configuration;
  @Autowired
  private EncryQueryTag encryQueryTag;	
  
  /**
   * 
   * 作者:唐鹏
   * 创建时间:2017年10月12日上午11:18:27
   * 描述:加密标签配置
   * 备注:使用规则:[@encryQuery]parm1.parm2,parm3....[/@encryQuery]
   * @throws TemplateModelException
   */
  @PostConstruct
  public void setSharedVariable() throws TemplateModelException {
    configuration.setSharedVariable("encryQuery", encryQueryTag);
  }

}