package com.yejh.dubbo;

import java.io.InputStream;

public interface DubboService {
	public void sendFile(String fileName, InputStream inputstream);
}
