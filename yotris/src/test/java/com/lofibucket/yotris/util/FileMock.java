
package com.lofibucket.yotris.util;

import java.io.File;

public class FileMock extends File {
	public int timesWritten;
	public int timesRead;

	public FileMock(String path) {
		super(path);
		timesWritten = 0;
		timesRead = 0;
	}

}
