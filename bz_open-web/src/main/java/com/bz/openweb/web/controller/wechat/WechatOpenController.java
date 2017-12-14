package com.bz.openweb.web.controller.wechat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bz.openweb.web.controller.merchant.MerchantOpenController;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
/**
 * 
 * 作者:唐鹏
 * 创建时间:2017年10月12日上午10:52:39
 * 描述:微信消息开放控制
 * 备注:
 */
@Controller
@RequestMapping(value="/v1/wechat")
public class WechatOpenController {

	private  final Logger logger=LoggerFactory.getLogger(MerchantOpenController.class);

	@Autowired
    private WxMpService wxService;
//    @Autowired
//    private WxMpMessageRouter router;
   
    /**
     * 
     * 作者:唐鹏
     * 创建时间:2017年10月12日上午10:41:51
     * 描述:接收到来自微信服务器的认证消息
     * 备注:
     * @param signature:签名字符串
     * @param timestamp:时间戳
     * @param nonce:标记
     * @param echostr:编码字段
     * @return
     */
    @GetMapping(value="/auth",produces = "text/plain;charset=utf-8")
    public String authGet(
            @RequestParam(name = "signature",
                    required = false) String signature,
            @RequestParam(name = "timestamp",
                    required = false) String timestamp,
            @RequestParam(name = "nonce", required = false) String nonce,
            @RequestParam(name = "echostr", required = false) String echostr) {

        this.logger.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature,
                timestamp, nonce, echostr);

        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        if (this.wxService.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }

        return "非法请求";
    }
    
    /**
     * 
     * 作者:唐鹏
     * 创建时间:2017年10月12日上午10:44:25
     * 描述:
     * 备注:
     * @param requestBody
     * @param signature
     * @param timestamp
     * @param nonce
     * @param encType
     * @param msgSignature
     * @return
     */
    @PostMapping(value="/request",produces = "application/xml; charset=UTF-8")
    public String post(@RequestBody String requestBody,
                       @RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam(name = "encrypt_type",
                               required = false) String encType,
                       @RequestParam(name = "msg_signature",
                               required = false) String msgSignature) {
        this.logger.info(
                "\n接收微信请求：[signature=[{}], encType=[{}], msgSignature=[{}],"
                        + " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                signature, encType, msgSignature, timestamp, nonce, requestBody);

        if (!this.wxService.checkSignature(timestamp, nonce, signature)) {
            throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
        }

        String out = null;
        if (encType == null) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
            WxMpXmlOutMessage outMessage = this.route(inMessage);
            if (outMessage == null) {
                return "";
            }

            out = outMessage.toXml();
        } else if ("aes".equals(encType)) {
            // aes加密的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(
                    requestBody, this.wxService.getWxMpConfigStorage(), timestamp,
                    nonce, msgSignature);
            this.logger.debug("\n消息解密后内容为：\n{} ", inMessage.toString());
            WxMpXmlOutMessage outMessage = this.route(inMessage);
            if (outMessage == null) {
                return "";
            }

            out = outMessage
                    .toEncryptedXml(this.wxService.getWxMpConfigStorage());
        }

        this.logger.debug("\n组装回复信息：{}", out);

        return out;
    }
    /**
     * 
     * 作者:唐鹏
     * 创建时间:2017年10月12日上午10:46:43
     * 描述:发送微信路由消息
     * 备注:
     * @param message:消息封装
     * @return
     */
    private WxMpXmlOutMessage route(WxMpXmlMessage message) {
        try {
           // return this.router.route(message);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        return null;
    }

    /**
     * 
     * 作者:唐鹏
     * 创建时间:2017年10月16日上午10:32:09
     * 描述:商户注册第一张页面
     * 备注:
     * @return
     */
    @GetMapping(value="/registfirst")
    public ModelAndView registfirst(ModelAndView mv) {
    	
    	return mv;
    }
}
