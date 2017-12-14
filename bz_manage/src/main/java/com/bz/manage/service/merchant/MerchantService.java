package com.bz.manage.service.merchant;

import java.util.List;
import org.springframework.stereotype.Service;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bz.dao.pojo.upload.UploadFileDetail;
import com.bz.framework.pojo.page.PageBean;
import com.bz.open.core.service.upload.UploadManageOpenService;
@Service
public class MerchantService {

	@Reference(version="1.0.0",interfaceClass=com.bz.open.core.service.upload.UploadManageOpenService.class)
	private UploadManageOpenService uploadManageOpenService;
	
	
	public List<UploadFileDetail> selectListPage(PageBean pb) {
		
		
		return uploadManageOpenService.selectFileList(pb);
	}

}
