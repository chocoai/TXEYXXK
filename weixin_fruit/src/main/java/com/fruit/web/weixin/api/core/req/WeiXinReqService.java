package com.fruit.web.weixin.api.core.req;

import java.io.IOException;


import org.jdom.JDOMException;

import com.alibaba.fastjson.JSONObject;
import com.fruit.web.weixin.api.core.annotation.ReqType;
import com.fruit.web.weixin.api.core.handler.WeiXinReqHandler;
import com.fruit.web.weixin.api.core.req.model.WeixinReqConfig;
import com.fruit.web.weixin.api.core.req.model.WeixinReqParam;
import com.fruit.web.weixin.api.core.util.WeiXinReqUtil;
import com.fruit.web.weixin.core.exceptionm.WexinReqException;


/**
 * 获取微信接口的信息
 */
public class WeiXinReqService {

	private static WeiXinReqService weiXinReqUtil = null;

	private WeiXinReqService() {
		try {
			WeiXinReqUtil.initReqConfig("weixi_req.xml");
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * 获取公共的调用处理
	 * @return
	 */
	public static WeiXinReqService getInstance() {
		if (weiXinReqUtil == null) {
			// 同步块，线程安全的创建实例
			synchronized (WeiXinReqService.class) {
				// 再次检查实例是否存在，如果不存在才真正的创建实例
				if (weiXinReqUtil == null) {
					weiXinReqUtil = new WeiXinReqService();
				}
			}
		}
		return weiXinReqUtil;
	}

	/**
	 * 传入请求的参数，获取对应额接口返回信息
	 * @param weixinReqParam
	 * @return
	 * @throws WexinReqException
	 */
	public String doWeinxinReq(WeixinReqParam weixinReqParam)
			throws WexinReqException {
		String strReturnInfo = "";
		if (weixinReqParam.getClass().isAnnotationPresent(ReqType.class)) {
			ReqType reqType = weixinReqParam.getClass().getAnnotation(ReqType.class);
			WeixinReqConfig objConfig = WeiXinReqUtil.getWeixinReqConfig(reqType.value());
			WeiXinReqHandler handler = WeiXinReqUtil.getMappingHander(objConfig.getMappingHandler());
			strReturnInfo = handler.doRequest(weixinReqParam);
		}
		return strReturnInfo;
	}
	
	/**
	 * 返回json对象
	 * @param weixinReqParam
	 * @return
	 * @throws WexinReqException 
	 */
	public JSONObject doWeinxinReqJson(WeixinReqParam weixinReqParam) throws WexinReqException{
		String strResult = this.doWeinxinReq(weixinReqParam);
		JSONObject result = JSONObject.parseObject(strResult);
		return result;
	}

}
