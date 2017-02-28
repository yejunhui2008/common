package com.yejh.dubbo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Service;

@Service
public class DubboServiceImpl implements DubboService {

	@Override
	public void sendFile(String fileName, InputStream ins) {
		OutputStream os;
		try {
			os = new FileOutputStream(new File("E:accept.log"));
			int bytesRead = 0;
			byte[] buffer = new byte[1024];
			while ((bytesRead = ins.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			ins.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
