package com.bz.openweb.web.tag.encryption;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import freemarker.core.Environment;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月12日上午11:02:33
 * 描述:加密请求处理(web端)
 * 备注:
 */
@Component
public class EncryQueryTag implements TemplateDirectiveModel {
	private final Logger logger=LoggerFactory.getLogger(EncryQueryTag.class);
	/*web端加密key*/
	@Value("${encryption.webkey}")
	private String webkey;
	@Override
	public void execute(Environment arg0, Map parm, TemplateModel[] arg2, TemplateDirectiveBody parm3)
			throws TemplateException, IOException {
		logger.info("【进入签名标签内置方法】");
		Writer out = arg0.getOut();
		/*获取请求参数*/
		if(parm.get("singStr")!=null) {
			logger.info("【开始生成加密签名串】");
			SimpleScalar  value=(SimpleScalar) parm.get("singStr");
			if(StringUtils.isNotEmpty(value.getAsString())) {
			  out.write(DigestUtils.md5DigestAsHex((value.getAsString()+webkey).getBytes()));
			}else {
				out.write("签名错误");
			}
		}else {
			out.write("签名错误");
		}
	}

}
