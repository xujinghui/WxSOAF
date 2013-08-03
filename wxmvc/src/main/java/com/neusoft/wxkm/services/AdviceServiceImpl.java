package com.neusoft.wxkm.services;

import com.neusoft.wxkm.mapper.advice.AdviceMapper;
import com.neusoft.wxkm.model.Advice;
import com.neusoft.wxkm.services.intf.IAdviceService;

public class AdviceServiceImpl implements IAdviceService{

	private AdviceMapper adviceMapper=null;

	public boolean service(String userAlias, String text) {
		Advice advice=new Advice();
		advice.setUserAlias(userAlias);
		advice.setAdviceContent(text); 
		adviceMapper.insert(advice);
		return true;
	}
	public AdviceMapper getAdviceMapper() {
		return adviceMapper;
	}
	public void setAdviceMapper(AdviceMapper adviceMapper) {
		this.adviceMapper = adviceMapper;
	}

}
